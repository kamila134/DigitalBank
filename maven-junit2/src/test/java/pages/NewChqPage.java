package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewChqPage {

    private WebDriver driver;
    public NewChqPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="checking-menu")
    private WebElement checkingMenuBtn;

    @FindBy(id="new-checking-menu-item")
    private WebElement newCheckingMenuBtn;

    @FindBy(id="Standard Checking")
    private WebElement standardAccTypeRadioBtn;

    @FindBy(id="Interest Checking")
    private WebElement interestAccTypeRadioBtn;

    @FindBy(id="Individual")
    private WebElement individualOwnershipTypeRadioBtn;

    @FindBy(id="Joint")
    private WebElement jointOwnershipTypeRadioBtn;

    @FindBy(id="name")
    private WebElement accNameTxtBox;

    @FindBy(id="openingBalance")
    private WebElement depositTxtBox;

    @FindBy(id="newCheckingSubmit")
    private WebElement newCheckingSubmitBtn;

    //action methods

    public void openCheckingAccount(String accountType, String ownershipType, String accountName, double depositAmount) {
        checkingMenuBtn.click();
        newCheckingMenuBtn.click();
        if (accountType.equals("Standard Checking")) {
            standardAccTypeRadioBtn.click();
        } else if (accountType.equals("Interest Checking")) {
            interestAccTypeRadioBtn.click();
        }
        if (ownershipType.equals("Individual")){
            individualOwnershipTypeRadioBtn.click();
        } else if(ownershipType.equals("Joint")){
            jointOwnershipTypeRadioBtn.click();
        }
        accNameTxtBox.sendKeys(accountName);
        depositTxtBox.sendKeys(String.valueOf(depositAmount));

        newCheckingSubmitBtn.submit();

    }

}
