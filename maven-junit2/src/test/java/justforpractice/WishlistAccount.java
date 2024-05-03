package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WishlistAccount {

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement signInBtn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signInBtn.click();

        WebElement emailTxtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        emailTxtBox.sendKeys("monicabe@yahoo.com");

        WebElement pwTxtBox1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass")));
        pwTxtBox1.sendKeys("Mon!ca11");

        WebElement loginBtn = driver.findElement(By.id("send2"));
        loginBtn.submit();


        WebElement menSection = driver.findElement(By.id("ui-id-5"));
        Actions action = new Actions(driver);
        action.moveToElement(menSection).perform();
        WebElement topsSection = driver.findElement(By.id("ui-id-17"));
        action.moveToElement(topsSection).perform();
        WebElement jacketsSection = driver.findElement(By.id("ui-id-19"));
        jacketsSection.click();

        WebElement fleeceJacket = driver.findElement(By.xpath("//a[contains(@href,'fleece')]/.."));
        action.moveToElement(fleeceJacket).perform();
        WebElement heartButton = driver.findElement(By.xpath("//a[contains(@href,'fleece')]/..//a[contains(@title,'Wish')]"));
        heartButton.click();

        WebElement wishlistItems = driver.findElement(By.xpath("//div[@id='authenticationPopup']/following-sibling::div//span"));
        assertEquals("1 Item", wishlistItems.getText());

        driver.navigate().back();

        WebElement hyperionJacket = driver.findElement(By.xpath("//a[contains(@href,'hyperion')]/.."));
        action.moveToElement(hyperionJacket).perform();
        WebElement heartButton2 = driver.findElement(By.xpath("//a[contains(@href,'hyperion')]/..//a[contains(@title,'Wish')]"));
        heartButton2.click();

        wishlistItems = driver.findElement(By.xpath("//div[@id='authenticationPopup']/following-sibling::div//span"));
        assertEquals("2 Item(s)", wishlistItems.getText());

    }
}
