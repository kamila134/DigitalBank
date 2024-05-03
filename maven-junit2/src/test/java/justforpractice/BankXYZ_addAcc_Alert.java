package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankXYZ_addAcc_Alert {

    @DisplayName("Test correct currency is chosen")
    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        WebElement addCustomerBtn = driver.findElement(By.xpath("//button[@ng-class = 'btnClass1']"));
        addCustomerBtn.click();

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstNameTxtBox.sendKeys("Marry");

        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastNameTxtBox.sendKeys("Poppins");

        WebElement postCodeTxtBox = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        postCodeTxtBox.sendKeys("28996");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.submit();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement homeBtn = driver.findElement(By.xpath("//button[@class='btn home']"));
        homeBtn.click();

        WebElement managerLoginBtn = driver.findElement(By.xpath("//button[@ng-click='manager()']"));
        managerLoginBtn.click();

        WebElement openAccBtn = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openAccBtn.click();

        WebElement customerDropdown = driver.findElement(By.id("userSelect"));
        Select selectCustomer = new Select(customerDropdown);
        selectCustomer.selectByVisibleText("Marry Poppins");

        WebElement currencyDropdown = driver.findElement(By.id("currency"));
        Select selectCurrency = new Select(currencyDropdown);
        selectCurrency.selectByValue("Pound");

        WebElement processBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        processBtn.submit();

        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        homeBtn = driver.findElement(By.xpath("//button[@class='btn home']"));
        homeBtn.click();

        WebElement customerLoginBtn = driver.findElement(By.xpath("//button[@ng-click='customer()']"));
        customerLoginBtn.click();

        WebElement nameDropdown = driver.findElement(By.id("userSelect"));
        Select selectName = new Select(nameDropdown);
        selectName.selectByVisibleText("Marry Poppins");

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
        loginBtn.click();

        WebElement currencyYxyBox = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[3]"));
        assertEquals("Pound",currencyYxyBox.getText());
    }
}
