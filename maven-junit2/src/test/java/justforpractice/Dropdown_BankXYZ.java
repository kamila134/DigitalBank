package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dropdown_BankXYZ {

    @Test
    public void testDropdowns() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement customerLoginBtn = driver.findElement(By.xpath("//button[text() = 'Customer Login']"));
        customerLoginBtn.click();

        WebElement nameDropdown = driver.findElement(By.xpath("//select"));
        Select selectName = new Select(nameDropdown);
        selectName.selectByVisibleText("Harry Potter");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        WebElement accountDropdown = driver.findElement(By.xpath("//select"));
        Select selectAcc = new Select(accountDropdown);
        selectAcc.selectByIndex(2);

        WebElement depositBtn = driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
        depositBtn.click();

        WebElement accBalanceBox = driver.findElement(By.xpath("//strong[2]"));
        int accBalance = Integer.parseInt(accBalanceBox.getText());

        WebElement depositAmountTxtBox = driver.findElement(By.xpath("//input"));
        depositAmountTxtBox.sendKeys("500");
        int depositedAmount = Integer.parseInt(depositAmountTxtBox.getAttribute("value"));

        WebElement submitDepositBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitDepositBtn.click();

        WebElement successfulDepositText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='error ng-binding']")));
        WebElement transactionsBtn = driver.findElement(By.xpath("//button[@ng-class='btnClass1']"));
        transactionsBtn.click();

        WebElement amountBox = driver.findElement(By.xpath("//table/tbody//td[2]"));
        int expectedAmount = accBalance + depositedAmount;
        int actualAmount = Integer.parseInt(amountBox.getText());
        System.out.println(expectedAmount + " " + actualAmount);
        assertEquals(expectedAmount,actualAmount);
        driver.quit();
    }
}
