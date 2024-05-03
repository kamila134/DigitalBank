package steps;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.CheckingAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class Bank_NewChqAccSteps {

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();

    }
    WebDriver driver = new ChromeDriver();

    @After
    public void afterHook(){
        driver.quit();
    }

    @Given("the user is logged in under {string} email and {string} password")
    public void the_user_is_logged_in_under_email_and_password(String email, String password) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://dbank-qa.wedevx.co/bank/login");
        WebElement usernameTxtBox = driver.findElement(By.id("username"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys(email);

        WebElement pwTxtBox = driver.findElement(By.id("password"));
        pwTxtBox.clear();
        pwTxtBox.sendKeys(password);

        WebElement signInBtn = driver.findElement(By.id("submit"));
        signInBtn.submit();

        String expectedCurrentUrl = "https://dbank-qa.wedevx.co/bank/home";
        assertEquals(expectedCurrentUrl,driver.getCurrentUrl(),"Submit btn didn't take to " + expectedCurrentUrl);

        WebElement actualWelcomeMessageTxtBox = driver.findElement(By.xpath("//li[@class='active']"));
        assertTrue(actualWelcomeMessageTxtBox.isDisplayed());
        assertEquals("Welcome Alana", actualWelcomeMessageTxtBox.getText());


    }
    @When("the user creates a new checking account with the following info:")
    public void the_user_creates_a_new_checking_account_with_the_following_info(List<CheckingAccount> checkingAccountList) {
        CheckingAccount firstChecking = checkingAccountList.get(0);
        WebElement checkingTabBtn = driver.findElement(By.id("checking-menu"));
        checkingTabBtn.click();

        WebElement newCheckingBtn = driver.findElement(By.id("new-checking-menu-item"));
        newCheckingBtn.click();

        String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";
        assertEquals(expectedUrl,driver.getCurrentUrl(),"New Checking Btn didn't take to " + expectedUrl);

        WebElement accountTypeRadioBtn = driver.findElement(By.id(firstChecking.getAccountType()));
        accountTypeRadioBtn.click();

        WebElement ownershipTypeRadioBtn = driver.findElement(By.id(firstChecking.getOwnershipType()));
        ownershipTypeRadioBtn.click();

        WebElement accountNameTxtBox = driver.findElement(By.id("name"));
        accountNameTxtBox.sendKeys(firstChecking.getAccountName());

        WebElement initialDepositTxtBox = driver.findElement(By.id("openingBalance"));
        initialDepositTxtBox.sendKeys(String.valueOf(firstChecking.getInitialDepositAmount()));

//        WebElement newCheckingSubmitBtn = driver.findElement(By.id("newCheckingSubmit"));
//        newCheckingSubmitBtn.click();


    }
    @Then("a {string} error message is displayed")
    public void a_error_message_is_displayed(String expectedErrorMessage) {
        WebElement actualErrorMessage = driver.findElement(By.id("new-account-error-msg"));
        assertEquals(expectedErrorMessage, actualErrorMessage.getText());
    }
    @Then("a new account {string} was not created")
    public void a_new_account_is_not_created(String newAccountName) {
        WebElement checkingTabBtn = driver.findElement(By.id("checking-menu"));
        checkingTabBtn.click();
        WebElement viewCheckingBtn = driver.findElement(By.id("view-checking-menu-item"));
        viewCheckingBtn.click();

        List<WebElement> accountNamesList = driver.findElements(By.xpath("//div[@contenteditable='true']"));
        for (WebElement accountName: accountNamesList) {
            assertFalse(accountName.getText().equals(newAccountName));
        }
    }

    @When("clicks on the Reset button")
    public void clicks_on_the_reset_button() {
        WebElement resetBtn = driver.findElement(By.id("newCheckingReset"));
        resetBtn.click();
    }
    @Then("the data from all fields is cleared")
    public void the_data_from_all_fields_is_cleared() {
        WebElement accountTypeStandardRadioBtn = driver.findElement(By.id("Standard Checking"));
        WebElement accountTypeInterestRadioBtn = driver.findElement(By.id("Interest Checking"));
        assertFalse(accountTypeStandardRadioBtn.isSelected());
        assertFalse(accountTypeInterestRadioBtn.isSelected());

        WebElement ownershipIndTypeRadioBtn = driver.findElement(By.id("Individual"));
        WebElement ownershipJointTypeRadioBtn = driver.findElement(By.id("Joint"));
        assertFalse(ownershipIndTypeRadioBtn.isSelected());
        assertFalse(ownershipJointTypeRadioBtn.isSelected());

        WebElement accountNameTxtBox = driver.findElement(By.id("name"));
        assertTrue(accountNameTxtBox.getText().isEmpty());

        WebElement initialDepositTxtBox = driver.findElement(By.id("openingBalance"));
        assertTrue(initialDepositTxtBox.getText().isEmpty());

    }

}
