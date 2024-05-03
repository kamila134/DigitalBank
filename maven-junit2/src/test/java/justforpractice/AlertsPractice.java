package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AlertsPractice {

    @Test
    public void testPopUps() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://practice-automation.com/popups/");

        WebElement alertBtn = driver.findElement(By.id("alert"));
        alertBtn.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Hi there, pal!",alert.getText());
        alert.accept();

        WebElement confirmBtn = driver.findElement(By.id("confirm"));
        confirmBtn.click();
        Thread.sleep(2000);

        alert = driver.switchTo().alert();
        alert.accept();
        WebElement confirmationMessage = driver.findElement(By.id("confirmResult"));
        assertEquals("OK it is!", confirmationMessage.getText().trim());

        confirmBtn.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        confirmationMessage = driver.findElement(By.id("confirmResult"));
        assertEquals("Cancel it is!", confirmationMessage.getText().trim());

        WebElement promptBtn = driver.findElement(By.id("prompt"));
        promptBtn.click();

        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String name = "laura";
        alert.sendKeys(name);
        alert.accept();

        WebElement promptResult = driver.findElement(By.id("promptResult"));
        assertEquals("Nice to meet you, " + name + "!", promptResult.getText());

        promptBtn.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        promptResult = driver.findElement(By.id("promptResult"));
        assertEquals("Fine, be that way...", promptResult.getText().trim());

    }
}
