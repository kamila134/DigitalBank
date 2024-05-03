package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.utils.DBUtils;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import co.wedevx.digitalbank.automation.ui.models.AccountDetails;
import co.wedevx.digitalbank.automation.ui.models.AccountUpdate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.pages.UpdateProfilePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAccountSteps {

    WebDriver driver = Driver.getDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    UpdateProfilePage updateProfilePage = new UpdateProfilePage(driver);

    List<Map<String,Object>> nextValList = new ArrayList<>();

//    @Given("the user is on the login page")
//    public void the_user_is_on_the_login_page() {
//        driver.get("https://dbank-qa.wedevx.co/bank/login");
//
//    }

    @When("the user registers a new account as follows:")
    public void the_user_registers_a_new_account(List<Map<String,String>> accountDetailsList) throws InterruptedException {

        Map<String,String> firstAccount = accountDetailsList.get(0);
        registrationPage.registerUser(accountDetailsList);
    }

    @Then("a new account is created")
    public void a_new_account_is_created() {
        WebElement successMessage = driver.findElement(By.xpath("//span[text()='Success']"));
        System.out.println(successMessage.getText());
        assertEquals("Success", successMessage.getText());

    }

    // updating profile:

//    @Given("the user is signed in as {string} and {string}")
//    public void the_user_is_signed_in(String email, String password) {
//        driver.get("https://dbank-qa.wedevx.co/bank/login");
//        WebElement usernameTxtBox = driver.findElement(By.id("username"));
//        usernameTxtBox.clear();
//        usernameTxtBox.sendKeys(email);
//
//        WebElement pwTxtBox = driver.findElement(By.id("password"));
//        pwTxtBox.clear();
//        pwTxtBox.sendKeys(password);
//
//        WebElement signInBtn = driver.findElement(By.id("submit"));
//        signInBtn.submit();
//    }

    @When("a user updates the profile as follows:")
    public void a_user_updates_the_profile_as_follows(List<AccountUpdate> accountUpdateList) {
        AccountUpdate firstAccount = accountUpdateList.get(0);

        updateProfilePage.update_Profile(firstAccount.getTitle(), firstAccount.getFirstName(), firstAccount.getLastName(), firstAccount.getAddress(), firstAccount.getLocality(),
                firstAccount.getRegion(), firstAccount.getCountry(), firstAccount.getPostalCode(),
                firstAccount.getHomePhone());
    }
    @Then("the profile is updated")
    public void the_profile_is_updated() {
        WebElement successMsgTxtBox = driver.findElement(By.xpath("//span[text()='Success']"));
        WebElement successMsgTxtBox2 = successMsgTxtBox.findElement(By.xpath("./following-sibling::span"));
        assertEquals("Success Profile Updated Successfully.",successMsgTxtBox.getText() + " " + successMsgTxtBox2.getText());
    }

    @Given("the user {string} doesn't exist in the DB")
    public void theUserDoes_not_Exist(String email) {
        DBUtils.runSQLDeleteQuery("DELETE from user_profile WHERE email_address = '" + email + "';");
        DBUtils.runSQLDeleteQuery("DELETE from users WHERE username = '" + email + "';");

        nextValList = DBUtils.runSQLSelectQuery("select * from hibernate_sequence");

    }

    @And("the following info should be saved in the DB:")
    public void theFollowingInfoShouldBeSavedInTheDB(List<Map<String,String>> expectedResultsList) {
        Map<String,String> expectedResultsMap = expectedResultsList.get(0);
        String queryUsers = String.format("select * from users where username = '%s'", expectedResultsMap.get("email"));
        String queryUserProfile = String.format("select * from user_profile where email_address = '%s'", expectedResultsMap.get("email"));

        List<Map<String,Object>> actualInfoUsersList = DBUtils.runSQLSelectQuery(queryUsers);
        List<Map<String,Object>> actualInfoUserProfileList  = DBUtils.runSQLSelectQuery(queryUserProfile);

        assertEquals(1, actualInfoUsersList.size(), "registration generated unexpected number of users");
        assertEquals(1, actualInfoUserProfileList.size(), "registration generated unexpected number of user profiles");

        Map<String,Object> actualInfoUsersMap = actualInfoUsersList.get(0);
        Map<String,Object> actualInfoUserProfileMap = actualInfoUserProfileList.get(0);

        assertEquals(expectedResultsMap.get("title"),actualInfoUserProfileMap.get("title"), "registration generated wrong title");
        assertEquals(expectedResultsMap.get("firstName"),actualInfoUserProfileMap.get("first_name"), "registration generated wrong firstName");
        assertEquals(expectedResultsMap.get("lastName"),actualInfoUserProfileMap.get("last_name"), "registration generated wrong lastName");
        assertEquals(expectedResultsMap.get("gender"),actualInfoUserProfileMap.get("gender"), "registration generated wrong gender");
//        assertEquals(expectedResultsMap.get("dateOfBirth"),actualInfoUserProfileMap.get("dob"), "registration generated wrong dob");
        assertEquals(expectedResultsMap.get("ssn"),actualInfoUserProfileMap.get("ssn"), "registration generated wrong ssn");
        assertEquals(expectedResultsMap.get("email"),actualInfoUserProfileMap.get("email_address"), "registration generated wrong email");
        assertEquals(expectedResultsMap.get("address"),actualInfoUserProfileMap.get("address"), "registration generated wrong address");
        assertEquals(expectedResultsMap.get("locality"),actualInfoUserProfileMap.get("locality"), "registration generated wrong locality");
        assertEquals(expectedResultsMap.get("region"),actualInfoUserProfileMap.get("region"), "registration generated wrong region");
        assertEquals(expectedResultsMap.get("postalCode"),actualInfoUserProfileMap.get("postal_code"), "registration generated wrong postalCode");
        assertEquals(expectedResultsMap.get("country"),actualInfoUserProfileMap.get("country"), "registration generated wrong country");
        assertEquals(expectedResultsMap.get("homePhone"),actualInfoUserProfileMap.get("home_phone"), "registration generated wrong homePhone");

        assertEquals(Boolean.parseBoolean(expectedResultsMap.get("accountNonExpired")), actualInfoUsersMap.get("account_non_expired"), "accountNonExpired mismatch upon registration");
        assertEquals(Boolean.parseBoolean(expectedResultsMap.get("accountNonLocked")), actualInfoUsersMap.get("account_non_locked"), "accountNonLocked mismatch upon registration");
        assertEquals(Boolean.parseBoolean(expectedResultsMap.get("credentialsNonExpired")), actualInfoUsersMap.get("credentials_non_expired"), "credentialsNonExpired mismatch upon registration");
        assertEquals(expectedResultsMap.get("enabled"), String.valueOf(actualInfoUsersMap.get("enabled")), "account enabled mismatch upon registration");
        assertEquals(expectedResultsMap.get("email"), actualInfoUsersMap.get("username"), "email mismatch upon registration");

        long nextVal = (long) nextValList.get(0).get("next_val");
        assertEquals(nextVal,actualInfoUsersMap.get("id"), "users id mismatch upon registration");
        assertEquals(++nextVal,actualInfoUserProfileMap.get("id"), "user profile id mismatch upon registration");

    }
}

















