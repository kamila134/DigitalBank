package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormPractice {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebDriverWait explWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement firstNameTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
        firstNameTxtBox.sendKeys("Monica");

        WebElement lastNameTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname")));
        lastNameTxtBox.sendKeys("Belucci");

        WebElement emailTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        emailTxtBox.sendKeys("monica_bmnmmm@yahoo.com");

        WebElement pwTxtBox1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        pwTxtBox1.sendKeys("Mon!ca11");

        WebElement pwTxtBox2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-confirmation")));
        pwTxtBox2.sendKeys("Mon!ca11");

        WebElement createAccBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@title,'Create')]")));
        String firstNameStr = firstNameTxtBox.getAttribute("value");
        String lastNameStr = lastNameTxtBox.getAttribute("value");
        String emailStr = emailTxtBox.getAttribute("value");
        System.out.println(firstNameStr + " " + lastNameStr + " " + emailStr);

        try {
            createAccBtn.submit();

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            driver.quit();
        }

        WebElement editBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Edit']")));
        editBtn.click();

        firstNameTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
        firstNameTxtBox.clear();
        firstNameTxtBox.sendKeys("Marissa");

        WebElement saveBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Save']")));
        firstNameStr = firstNameTxtBox.getAttribute("value");

        saveBtn.submit();

        WebElement actualResultTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='box box-information']/div[1]/p[1]")));
        String expectedResult = firstNameStr + " " + lastNameStr + "\n" + emailStr;
        System.out.println("lol");
        assertEquals(expectedResult, actualResultTxtBox.getText(), "Results didn't match");
        driver.quit();
    }
}
