package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign')]")
    private WebElement signUpLink;

    @FindBy(id="title")
    private WebElement titleDropdownTxtBox;

    @FindBy(id="firstName")
    private WebElement firstNameTxtBox;

    @FindBy(id="lastName")
    private WebElement lastNameTxtBox;

    @FindBy(xpath="//input[@value='M']")
    private WebElement maleGenderRadioBtn;

    @FindBy(xpath="//input[@value='F']")
    private WebElement femaleGenderRadioBtn;

    @FindBy(id="dob")
    private WebElement dateOfBirthTxtBox;

    @FindBy(id="ssn")
    private WebElement ssnTxtBox;

    @FindBy(id="emailAddress")
    private WebElement emailAddressTxtBox;

    @FindBy(id="password")
    private WebElement passwordTxtBox;

    @FindBy(id="confirmPassword")
    private WebElement confirmPasswordTxtBox;

    @FindBy(xpath="//button")
    private WebElement nextBtn;

    @FindBy(id="address")
    private WebElement addressTxtBox;

    @FindBy(id="locality")
    private WebElement localityTxtBox;

    @FindBy(id="region")
    private WebElement regionTxtBox;

    @FindBy(id="postalCode")
    private WebElement postalCodeTxtBox;

    @FindBy(id="country")
    private WebElement countryTxtBox;

    @FindBy(id="homePhone")
    private WebElement homePhoneTxtBox;

    @FindBy(xpath="//input[@type='checkbox']/..")
    private WebElement agreeTermsCheckbox;

    @FindBy(xpath="//button")
    private WebElement registerBtn;

    //action methods
    public void registerUser(String firstName, String lastName, char gender, String dateOfBirth, String ssn, String email, String password, String address,
                            String locality, String region, String country, String postalCode, String homePhone) throws InterruptedException {
        signUpLink.click();
        firstNameTxtBox.sendKeys(firstName);
        lastNameTxtBox.sendKeys(lastName);
        if (gender == 'F') {
            femaleGenderRadioBtn.click();
        } else if (gender == 'M') {
            maleGenderRadioBtn.click();
        }
        dateOfBirthTxtBox.sendKeys(dateOfBirth);
        ssnTxtBox.sendKeys(ssn);
        emailAddressTxtBox.sendKeys(email);
        passwordTxtBox.sendKeys(password);
        confirmPasswordTxtBox.sendKeys(password);
        nextBtn.submit();
        addressTxtBox.sendKeys(address);
        localityTxtBox.sendKeys(locality);
        regionTxtBox.sendKeys(region);
        countryTxtBox.sendKeys(country);
        postalCodeTxtBox.sendKeys(postalCode);
        homePhoneTxtBox.sendKeys(homePhone);
        agreeTermsCheckbox.click();
        Thread.sleep(5000);
        registerBtn.submit();
        Thread.sleep(7000);
    }
}
