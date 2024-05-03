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

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCart {
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
        WebElement fleeceJacketSize = fleeceJacket.findElement(By.xpath(".//div[@aria-label='L']"));
        fleeceJacketSize.click();
        WebElement fleeceJacketColor = fleeceJacket.findElement(By.xpath(".//div[@aria-label='Black']"));
        fleeceJacketColor.click();
        WebElement addToCart1 = fleeceJacket.findElement(By.xpath(".//button[@type='submit']"));
        addToCart1.submit();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']/div/div")));
        assertTrue(successMessage.getText().contains("You added"), "#1 Success message isn't displayed");

        WebElement cartItems = driver.findElement(By.xpath("//span[@class='counter-number']"));
        assertEquals("1",cartItems.getText(), "#1 Cart wasn't updated");

        WebElement hyperionJacket = driver.findElement(By.xpath("//a[contains(@href,'hyperion')]/.."));
        action.moveToElement(hyperionJacket).perform();
        WebElement hyperioJacketSize = hyperionJacket.findElement(By.xpath(".//div[@aria-label='XS']"));
        hyperioJacketSize.click();
        WebElement hyperionJacketColor = hyperionJacket.findElement(By.xpath(".//div[@aria-label='Green']"));
        hyperionJacketColor.click();
        WebElement addToCart2 = hyperionJacket.findElement(By.xpath(".//button[@type='submit']"));
        addToCart2.submit();

        successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']/div/div")));
        assertTrue(successMessage.getText().contains("You added"), "#2 Success message isn't displayed");

        boolean cartUpdated = wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='counter-number']"),"2"));
        assertTrue(cartUpdated);

        cartItems.click();

        WebElement totalItemNum = driver.findElement(By.xpath("//div[@class='items-total']/span"));
        assertEquals("2", totalItemNum.getText());
    }
}
