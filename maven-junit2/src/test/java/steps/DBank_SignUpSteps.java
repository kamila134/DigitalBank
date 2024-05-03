package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.AccountDetails;
import models.AccountUpdate;
import models.CheckingAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NewChqPage;
import pages.RegistrationPage;
import pages.UpdateProfilePage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DBank_SignUpSteps {

    WebDriver driver = new ChromeDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    UpdateProfilePage updateProfilePage = new UpdateProfilePage(driver);
    NewChqPage newCheckingPage = new NewChqPage(driver);

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://dbank-qa.wedevx.co/bank/login");
    }

    @When("the user registers a new account as follows:")
    public void the_user_registers_a_new_account(List<AccountDetails> accountDetailsList) throws InterruptedException {
        AccountDetails firstAccount = accountDetailsList.get(0);

        registrationPage.registerUser(firstAccount.getFirstName(), firstAccount.getLastName(), firstAccount.getGender(),
                                        firstAccount.getDateOfBirth(), firstAccount.getSsn(), firstAccount.getEmail(),
                                        firstAccount.getPassword(), firstAccount.getAddress(), firstAccount.getLocality(),
                                        firstAccount.getRegion(), firstAccount.getCountry(), firstAccount.getPostalCode(),
                                        firstAccount.getHomePhone());
    }

    @Then("a new account is created")
    public void a_new_account_is_created() {
        WebElement successMessage = driver.findElement(By.xpath("//span[text()='Success']"));
        System.out.println(successMessage.getText());
        assertEquals("Success", successMessage.getText());

    }

    // updating profile:

    @When("a user updates the profile as follows:")
    public void a_user_updates_the_profile_as_follows(List<AccountUpdate> accountUpdateList) {
        WebElement usernameTxtBox = driver.findElement(By.id("username"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys("Peter101@gmail.com");

        WebElement pwTxtBox = driver.findElement(By.id("password"));
        pwTxtBox.clear();
        pwTxtBox.sendKeys("Peter123!");

        WebElement signInBtn = driver.findElement(By.id("submit"));
        signInBtn.submit();

        AccountUpdate firstAccount = accountUpdateList.get(0);

        updateProfilePage.update_Profile(firstAccount.getFirstName(), firstAccount.getLastName(), firstAccount.getAddress(), firstAccount.getLocality(),
                firstAccount.getRegion(), firstAccount.getCountry(), firstAccount.getPostalCode(),
                firstAccount.getHomePhone());
    }
    @Then("the profile is updated")
    public void the_profile_is_updated() {
        WebElement successMsgTxtBox = driver.findElement(By.xpath("//span[text()='Success']"));
        WebElement successMsgTxtBox2 = successMsgTxtBox.findElement(By.xpath("./following-sibling::span"));
        assertEquals("Success Profile Updated Successfully.",successMsgTxtBox.getText() + " " + successMsgTxtBox2.getText());
    }

    // opening a chq account


    @When("a user opens a new checking account as follows:")
    public void opens_new_chq(List<CheckingAccount> chqAccountList) {
        WebElement usernameTxtBox = driver.findElement(By.id("username"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys("Peter101@gmail.com");

        WebElement pwTxtBox = driver.findElement(By.id("password"));
        pwTxtBox.clear();
        pwTxtBox.sendKeys("Peter123!");

        WebElement signInBtn = driver.findElement(By.id("submit"));
        signInBtn.submit();
        CheckingAccount firstChqAcc = chqAccountList.get(0);
        newCheckingPage.openCheckingAccount(firstChqAcc.getAccountType(),firstChqAcc.getOwnershipType(),firstChqAcc.getAccountName(),firstChqAcc.getInitialDepositAmount());


    }

    @Then("a new checking account {string} is created")
    public void new_chq_created(String newAccountName) {
        List<WebElement> accountNamesList = driver.findElements(By.xpath("//div[@contenteditable='true']"));
        List<String> accountNameTextList = new ArrayList<>();
        for (WebElement accountName: accountNamesList) {
            accountNameTextList.add(accountName.getText());

        }
        assertTrue(accountNameTextList.contains(newAccountName));

    }
}
