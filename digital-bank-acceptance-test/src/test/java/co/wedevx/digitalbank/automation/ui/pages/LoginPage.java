package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "submit")
    private WebElement loginBtn;

    public void logIn() {
        usernameTxtBox.clear();
        passwordTxtBox.clear();
        String existingUsername = RegistrationPage.getUsername();
        String existingPassword = RegistrationPage.getPassword();
        if (existingUsername!= null && existingPassword != null) {
            usernameTxtBox.sendKeys(existingUsername);
            passwordTxtBox.sendKeys(existingPassword);
        } else {
            existingUsername = "Peter101@gmail.com";
            existingPassword = "Peter123!";
            usernameTxtBox.sendKeys(existingUsername);
            passwordTxtBox.sendKeys(existingPassword);
        }
        System.out.println(existingUsername);
        System.out.println(existingPassword);
        loginBtn.submit();
    }


}
