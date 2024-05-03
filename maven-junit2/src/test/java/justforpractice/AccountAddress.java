package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountAddress {

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        emailTxtBox.sendKeys("monicab@yahoo.com");

        WebElement pwTxtBox1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        pwTxtBox1.sendKeys("Mon!ca11");

        WebElement pwTxtBox2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-confirmation")));
        pwTxtBox2.sendKeys("Mon!ca11");
        WebElement createAccBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@title,'Create')]")));

        try {
            createAccBtn.submit();

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            driver.quit();
        }


        WebElement addressBookLink = driver.findElement(By.xpath("//a[contains(text(),'Address')]"));
        addressBookLink.click();

        firstNameTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
        lastNameTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname")));
        WebElement phoneTxtBox = driver.findElement(By.id("telephone"));
        phoneTxtBox.sendKeys("+1-777-565-78-43");
        WebElement addressTxtBox = driver.findElement(By.id("street_1"));
        addressTxtBox.sendKeys("Hollywood ave");
        WebElement cityTxtBox = driver.findElement(By.id("city"));
        cityTxtBox.sendKeys("Los-Angeles");
        WebElement stateDrpodown = driver.findElement(By.id("region_id"));
        Select selectState = new Select(stateDrpodown);
        selectState.selectByVisibleText("California");
        WebElement zipTxtBox = driver.findElement(By.id("zip"));
        zipTxtBox.sendKeys("98095");
        WebElement countryDropdown = driver.findElement(By.id("country"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByValue("US");
        WebElement saveButton = driver.findElement(By.xpath("//button[@title='Save Address']"));
        String expectedResult = firstNameTxtBox.getAttribute("value") + " " + lastNameTxtBox.getAttribute("value") +
                "\n" + addressTxtBox.getAttribute("value") + "\n" + cityTxtBox.getAttribute("value") +
                ", " + selectState.getFirstSelectedOption().getText() + ", " + zipTxtBox.getAttribute("value") +
                "\n" + selectCountry.getFirstSelectedOption().getText() + "\nT: " + phoneTxtBox.getAttribute("value");
        saveButton.submit();

        WebElement finalAddressBox = driver.findElement(By.xpath("//address[1]"));
        String actualResult = finalAddressBox.getText();

        assertEquals(expectedResult,actualResult);

    }
}

