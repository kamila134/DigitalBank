package steps;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;


import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class Bank_UpdateProfileSteps {

    static String firstNameValidationTxt;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();

    }
    WebDriver driver = new ChromeDriver();

//    @After
//    public void afterHook(){
//        driver.quit();
//    }

    @Given("the user is on the dbank's login page")
    public void the_user_is_on_the_dbank_s_login_page() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://dbank-qa.wedevx.co/bank/login");

    }
    @Given("the user signs in with an existing account under {string} email and {string} password")
    public void the_user_signs_in_with_an_existing_account_under_email_and_password(String email, String password) {
        WebElement usernameTxtBox = driver.findElement(By.id("username"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys(email);

        WebElement pwTxtBox = driver.findElement(By.id("password"));
        pwTxtBox.clear();
        pwTxtBox.sendKeys(password);

        WebElement signInBtn = driver.findElement(By.id("submit"));
        signInBtn.submit();


    }
    @Given("the user is on their bank account page")
    public void the_user_is_on_their_bank_account_page() {
        String expectedCurrentUrl = "https://dbank-qa.wedevx.co/bank/home";
        assertEquals(expectedCurrentUrl,driver.getCurrentUrl(),"Submit btn didn't take to " + expectedCurrentUrl);
    }

    @Given("sees the green {string} message")
    public void sees_the_green_message(String welcomeMessage) {
        WebElement actualWelcomeMessageTxtBox = driver.findElement(By.xpath("//li[@class='active']"));
        assertTrue(actualWelcomeMessageTxtBox.isDisplayed());
        assertEquals(welcomeMessage, actualWelcomeMessageTxtBox.getText());
    }

    //=================================================================================================
    //testing password update - negative #1

    @When("the user clicks on their Avatar button")
    public void the_user_clicks_on_their_avatar_button() {
        WebElement userAvatar = driver.findElement(By.xpath("//img[contains(@alt,'Avatar')]"));
        WebElement dropdownMenu = userAvatar.findElement(By.xpath("./..//../div"));
        assertFalse(dropdownMenu.isDisplayed());
        userAvatar.click();
    }
    @Then("a dropdown menu opens under the Avatar")
    public void a_dropdown_menu_opens_under_the_avatar() {
        WebElement dropdownMenu = driver.findElement(By.xpath("//img[contains(@alt,'Avatar')]/..//../div"));
        assertTrue(dropdownMenu.isDisplayed());
    }
    @When("the user clicks on the My Profile button")
    public void the_user_clicks_on_the_button() {
//        if (buttonName.equals("My Profile")) {
            WebElement myProfileBtn = driver.findElement(By.xpath("//img[contains(@alt,'Avatar')]/../../div/a[1]"));
            myProfileBtn.click();
        //}

    }
    @Then("the user's profile page opens with the following details:")
    public void the_user_s_profile_page_opens_with_the_following_details(List<Map<String,String>> dataTable) {
//        String expectedUrl = "https://dbank-qa.wedevx.co/bank/user/profile";
//        assertEquals(expectedUrl,driver.getCurrentUrl(),"My Profile btn didn't take to " + expectedUrl);

        WebElement titleDropdown = driver.findElement(By.id("title"));
        Select selectTitle = new Select(titleDropdown);
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement homePhone = driver.findElement(By.id("homePhone"));
        WebElement mobilePhone = driver.findElement(By.id("mobilePhone"));
        WebElement workPhone = driver.findElement(By.id("workPhone"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement locality = driver.findElement(By.id("locality"));
        WebElement region = driver.findElement(By.id("region"));
        WebElement postalCode = driver.findElement(By.id("postalCode"));
        WebElement country = driver.findElement(By.id("country"));

        for (Map<String,String> mapEntry: dataTable) {
            assertEquals(mapEntry.get("title"), selectTitle.getFirstSelectedOption().getText());
            assertEquals(mapEntry.get("firstName"), firstName.getAttribute("value"),"firstName don't match");
            assertEquals(mapEntry.get("lastName"), lastName.getAttribute("value"),"lastName don't match");
            assertEquals(mapEntry.get("homePhone"), homePhone.getAttribute("value"),"homePhone don't match");
            assertTrue(mobilePhone.getAttribute("value").isEmpty());
            assertTrue(workPhone.getAttribute("value").isEmpty());
//            assertEquals(mapEntry.get("mobilePhone"), mobilePhone.getAttribute("value"),"mobilePhone don't match");
//            assertEquals(mapEntry.get("workPhone"), workPhone.getAttribute("value"),"workPhone don't match");
            assertEquals(mapEntry.get("address"), address.getAttribute("value"),"address don't match");
            assertEquals(mapEntry.get("locality"), locality.getAttribute("value"),"locality don't match");
            assertEquals(mapEntry.get("region"), region.getAttribute("value"),"region don't match");
            assertEquals(mapEntry.get("postalCode"), postalCode.getAttribute("value"),"postalCode don't match");
            assertEquals(mapEntry.get("country"), country.getAttribute("value"),"country don't match");
        }

    }
    @When("the user makes the following changes:")
    public void the_user_makes_the_following_changes(io.cucumber.datatable.DataTable dataTable) {
        WebElement mobilePhone = driver.findElement(By.id("mobilePhone"));
        mobilePhone.sendKeys("888-999-1324");
        WebElement locality = driver.findElement(By.id("locality"));
        locality.clear();
        locality.sendKeys("New York");
    }
    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) throws InterruptedException {
        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='card-footer']/button[@type='submit']"));
        Thread.sleep(5000);
        submitBtn.submit();
        Thread.sleep(5000);

    }
    @Then("the green {string} message is displayed")
    public void the_green_message_is_displayed(String successMessage) {
        WebElement successMsgTxtBox = driver.findElement(By.xpath("//span[text()='Success']"));
        WebElement successMsgTxtBox2 = successMsgTxtBox.findElement(By.xpath("./following-sibling::span"));
        assertEquals(successMessage,successMsgTxtBox.getText() + " " + successMsgTxtBox2.getText());
    }
    @Then("the user's profile is updated as follows:")
    public void the_user_s_profile_is_updated_as_follows(io.cucumber.datatable.DataTable dataTable) {
        WebElement mobilePhone = driver.findElement(By.id("mobilePhone"));
        WebElement locality = driver.findElement(By.id("locality"));
        String expectedMobilePhone = dataTable.cell(1,4);
        String actualMobilePhone = mobilePhone.getAttribute("value");
        assertEquals(expectedMobilePhone,actualMobilePhone);
        String expectedlocality = dataTable.cell(1,7);
        String actuallocality = locality.getAttribute("value");
        assertEquals(expectedlocality,actuallocality);
    }

    @When("the user leaves the First Name textbox blank")
    public void the_user_leaves_the_first_name_textbox_blank() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.clear();
        firstNameValidationTxt = firstName.getAttribute("validationMessage");
        System.out.println(firstNameValidationTxt);

    }

    @Then("the {string} alert pops up")
    public void the_alert_pops_up(String expectedAlertText) {
//        Alert alert = driver.switchTo().alert();
//        String actualResult = alert.getText();
        assertEquals(expectedAlertText,firstNameValidationTxt);
    }

    @When("the user reloads the page")
    public void the_user_reloads_the_page() {
        driver.navigate().refresh();
    }
    @Then("the new information should not be saved")
    public void the_new_information_should_not_be_saved() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        assertEquals("Alana", firstName.getAttribute("value"),"firstName don't match");
    }


    //////////

    @When("the user selects and clicks on the {string} button")
    public void the_user_selects_and_clicks_on_the_button(String string) {
        WebElement changePw = driver.findElement(By.xpath("//img[contains(@alt,'Avatar')]/../../div/a[2]"));
        changePw.click();
    }

    @Then("the Password Management page opens")
    public void the_password_management_page_opens() {
        String expectedURL = "https://dbank-qa.wedevx.co/bank/user/password";
        assertEquals(expectedURL,driver.getCurrentUrl());
    }

    @When("the user enters their current password {string}")
    public void the_user_enters_their_current_password(String currentPassword) {
        WebElement currentPw = driver.findElement(By.id("currentPassword"));
        currentPw.sendKeys(currentPassword);
    }

    @When("the user enters the new password {string} in both fields")
    public void the_user_enters_the_new_password(String newPassword) {
        WebElement newPw = driver.findElement(By.id("newPassword"));
        newPw.sendKeys(newPassword);
        WebElement confirmNewPw = driver.findElement(By.id("confirmPassword"));
        confirmNewPw.sendKeys(newPassword);
        System.out.println(newPassword);
    }

    @When("the user enters a new valid password {string} in the first field")
    public void the_user_enters_the_new_password_in_the_first_field(String newPassword) {
        WebElement newPw = driver.findElement(By.id("newPassword"));
        newPw.sendKeys(newPassword);
        System.out.println(newPassword);
    }

    @When("the user enters a different valid password {string} in the second field")
    public void the_user_enters_the_new_password_in_the_second_field(String differentNewPassword) {
        WebElement confirmNewPw = driver.findElement(By.id("confirmPassword"));
        confirmNewPw.sendKeys(differentNewPassword);
        System.out.println(differentNewPassword);
    }

    @When("the new password {string} has at least {int} characters, {int} uppercase, {int} lowercase, and {int} digit")
    public void the_user_enters_the_new_password_with_at_least_characters_one_uppercase_one_lowercase_digits_and_special_character_in_both_fields(String newPassword, Integer pwLength, Integer numOfUppercase, Integer numOfLowercase, Integer numOfDigits) {
        assertTrue(newPassword.length()>= pwLength);
        int uppercase = 0;
        int lowercase = 0;
        int digits = 0;
        for (int i = 0; i < newPassword.length(); i++) {
            char currentChar = newPassword.charAt(i);
            if (Character.toUpperCase(currentChar) == currentChar && Character.isLetter(currentChar)){
                uppercase++;
            } else if (Character.toLowerCase(currentChar) == currentChar && Character.isLetter(currentChar)){
                lowercase++;
            } else if (Character.isDigit(currentChar)) {
                digits++;
            }
        }
        assertTrue(uppercase >= 1);
        assertTrue(lowercase >= 1);
        assertTrue(digits >= 1);
    }

    @When("the user clicks on the Update Password button")
    public void clicks_on_the_update_password_button() {
        WebElement updPwBtn = driver.findElement(By.id("payment-button"));
        updPwBtn.submit();
    }

    @When("the user loges out of their account")
    public void the_user_loges_out_of_their_account() {
        WebElement userAvatar = driver.findElement(By.xpath("//img[contains(@alt,'Avatar')]"));
        WebElement dropdownMenu = userAvatar.findElement(By.xpath("./..//../div"));
        assertFalse(dropdownMenu.isDisplayed());
        userAvatar.click();
        WebElement logOut = driver.findElement(By.xpath("//img[contains(@alt,'Avatar')]/../../div/a[3]"));
        logOut.click();
    }

    @When("tries to sign in with the new password {string} under the {string} email")
    public void signs_in_with_the_new_password(String newPassword, String email) {
        WebElement usernameTxtBox = driver.findElement(By.id("username"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys(email);

        WebElement pwTxtBox = driver.findElement(By.id("password"));
        pwTxtBox.clear();
        pwTxtBox.sendKeys(newPassword);

        WebElement signInBtn = driver.findElement(By.id("submit"));
        signInBtn.submit();
    }

    @When("the new password {string} doesn't have at least {int} characters, {int} uppercase, {int} lowercase, or {int} digit")
    public void new_password_is_invalid(String newPassword, Integer pwLength, Integer numOfUppercase, Integer numOfLowercase, Integer numOfDigits) {
        boolean isValid = false;
        int uppercase = 0;
        int lowercase = 0;
        int digits = 0;
        for (int i = 0; i < newPassword.length(); i++) {
            char currentChar = newPassword.charAt(i);
            if (Character.toUpperCase(currentChar) == currentChar && Character.isLetter(currentChar)){
                uppercase++;
            } else if (Character.toLowerCase(currentChar) == currentChar && Character.isLetter(currentChar)){
                lowercase++;
            } else if (Character.isDigit(currentChar)) {
                digits++;
            }
        }

        if (uppercase >= 1 && lowercase >= 1
            && digits >= 1 && newPassword.length() >= pwLength) {
            isValid = true;
        }

        assertFalse(isValid);
    }

    @Then("a {string} pop-up is displayed")
    public void match_the_format_popup(String validationMessage) {
        WebElement newPwTxtBox = driver.findElement(By.id("newPassword"));
        assertEquals(validationMessage,newPwTxtBox.getAttribute("validationMessage"));
    }

    @Then("a {string} message is displayed")
    public void match_the_passwords_popup(String validationMessage) {
        WebElement confirmNewPw = driver.findElement(By.id("confirmPassword"));
        assertEquals(validationMessage,confirmNewPw.getAttribute("validationMessage"));
    }

    @Then("an {string} error message is displayed")
    public void the_error_message_is_displayed(String errorMessage) {
        WebElement errorMsgTxtBox = driver.findElement(By.xpath("//span[text()='Error']"));
        WebElement errorMsgTxtBox2 = errorMsgTxtBox.findElement(By.xpath("./.."));
        assertEquals(errorMessage,errorMsgTxtBox.getText() + " " + errorMsgTxtBox2.getText());
    }

    //=================================================================================================
    //testing opening a new checking account
    
    @When("the user clicks on the {string} tab")
    public void the_user_clicks_on_the_tab(String checkingTab) {
        WebElement checkingTabBtn = driver.findElement(By.id("checking-menu"));
        checkingTabBtn.click();
    }
    @When("clicks on the {string} button")
    public void clicks_on_the_button(String buttonName) {
        if (buttonName.contains("New")) {
            WebElement newCheckingBtn = driver.findElement(By.id("new-checking-menu-item"));
            newCheckingBtn.click();
        } else if (buttonName.contains("View")) {
            WebElement viewCheckingBtn = driver.findElement(By.id("view-checking-menu-item"));
            viewCheckingBtn.click();
        }

    }

    @Then("the {string} page opens")
    public void the_page_opens(String expectedPageTitle) {
        if (expectedPageTitle.contains("Create")) {
            String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";
            assertEquals(expectedUrl,driver.getCurrentUrl(),"New Checking Btn didn't take to " + expectedUrl);
        } else if (expectedPageTitle.contains("View")) {
            String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-view";
            assertEquals(expectedUrl,driver.getCurrentUrl(),"View Checking Btn didn't take to " + expectedUrl);
        }

        WebElement actualPageTitle = driver.findElement(By.id("page-title"));
        assertEquals(expectedPageTitle,actualPageTitle.getText());
    }
    @When("the user does not select the Account Type")
    public void the_user_does_not_select_the_account_type() {
        
    }
    @When("the user selects the {string} Account Ownership")
    public void the_user_selects_the_account_ownership(String ownershipType) {
        WebElement ownershipTypeRadioBtn = driver.findElement(By.id(ownershipType));
        ownershipTypeRadioBtn.click();
    }
    @When("enters the {string} Account Name")
    public void enters_the_account_name(String accountName) {
        WebElement accountNameTxtBox = driver.findElement(By.id("name"));
        accountNameTxtBox.sendKeys(accountName);
    }
    @When("enters the {string} Initial Deposit Amount")
    public void enters_the_initial_deposit_amount(String depositAmount) {
        WebElement accountNameTxtBox = driver.findElement(By.id("openingBalance"));
        accountNameTxtBox.sendKeys(depositAmount);
    }

    @When("tries to submit by clicking on the {string} button")
    public void clicks_on_the_submit_button(String string) {
        WebElement newCheckingSubmitBtn = driver.findElement(By.id("newCheckingSubmit"));
        newCheckingSubmitBtn.click();
    }

    @Then("a {string} message in the {string} field pops-up")
    public void a_message_pops_up(String expectedPopupMessage, String fieldName) {
        if (fieldName.equals("Account Type")) {
            WebElement accountTypePopup = driver.findElement(By.id("Standard Checking"));
            assertEquals(expectedPopupMessage,accountTypePopup.getAttribute("validationMessage"), "Account Type alerts don't match");
        } else if (fieldName.equals("Account Ownership")) {
            WebElement ownershipTypePopup = driver.findElement(By.id("Individual"));
            assertEquals(expectedPopupMessage,ownershipTypePopup.getAttribute("validationMessage"), "Ownership Type alerts don't match");
        } else if (fieldName.equals("Account Name")) {
            WebElement accountNameTxtBox = driver.findElement(By.id("name"));
            assertEquals(expectedPopupMessage,accountNameTxtBox.getAttribute("validationMessage"), "Account Name alerts don't match");
        }
    }

    @When("the user checks the {string} page")
    public void the_user_checks_the_page(String string) {
        WebElement checkingTabBtn = driver.findElement(By.id("checking-menu"));
        checkingTabBtn.click();
        WebElement viewCheckingBtn = driver.findElement(By.id("view-checking-menu-item"));
        viewCheckingBtn.click();
    }

    @Then("a {string} alert opens")
    public void a_alert_opens(String expectedAlertMessage) throws InterruptedException {
        Thread.sleep(4000);
//        Alert alert = driver.switchTo().alert();
//        assertEquals(expectedAlertMessage, alert.getText());
        WebElement headerAlert = driver.findElement(By.xpath("//h5"));
        assertEquals("No Accounts", headerAlert.getText().trim(), "Header alert isn't found");

        WebElement noAccountsAlert = driver.findElement(By.xpath("//h5/../following-sibling::div/p"));
        assertEquals(expectedAlertMessage, noAccountsAlert.getText(), "Text alert isn't found");
    }

    //Opening a checking account - Negative case #2 - No ownership type

    @When("the user selects the {string} Account Type")
    public void the_user_selects_the_account_type(String accountType) {
        WebElement accountTypeRadioBtn = driver.findElement(By.id(accountType));
        accountTypeRadioBtn.click();
    }
    @When("the user does not select the Account Ownership")
    public void the_user_does_not_select_the_account_ownership() {

    }

    //Opening a checking account - Negative case #2 - No account name

    @When("does not enter any Account Name")
    public void the_user_does_not_enter_the_account_name() {

    }

    //Opening a checking account - Negative case #2 - Long account name

    @When("enters an invalid Account Name with more than 256 characters")
    public void enters_long_account_name() throws InterruptedException {
        WebElement accountNameTxtBox = driver.findElement(By.id("name"));
        String longAccName = "a";
        for (int i = 1; i <=260; i++) {
            longAccName+="a";
        }
        accountNameTxtBox.sendKeys(longAccName);
        Thread.sleep(2000);
        String actualAccName = accountNameTxtBox.getAttribute("value");
        System.out.println(actualAccName.length() + " " + actualAccName);
    }
}
