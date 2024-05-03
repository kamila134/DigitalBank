package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class WindowHandling {

    @Test
    public void testMultipleTabs() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://practice-automation.com/window-operations/'");

        Set<String> allOpenTabIDs = driver.getWindowHandles();
        String currentTabId = driver.getWindowHandle();

        assertEquals(1, allOpenTabIDs.size());

        WebElement newTabBtn = driver.findElement(By.xpath("//button[@onclick='newTab()']"));
        newTabBtn.click();

        Thread.sleep(2000);
        Set<String> allOpenTabIDs2 = driver.getWindowHandles();
        assertEquals(2, allOpenTabIDs2.size());
        WebElement replaceTabBtn = driver.findElement(By.xpath("//button[@onclick='newWindowSelf()']"));
//        js.executeScript("arguments[0].click()",replaceTabBtn);
        Thread.sleep(2000);
        System.out.println(currentTabId);
        System.out.println(driver.getWindowHandle());
//        assertFalse(currentTabId.equals(driver.getWindowHandle()));

        for (String id: allOpenTabIDs2) {
            if (!currentTabId.equals(id)) {
                System.out.println("lol");
                driver.switchTo().window(id);
            }
        }

        Thread.sleep(2000);
        WebElement articleElement = driver.findElement(By.id("post-18533"));
        assertTrue(articleElement.isDisplayed());

    }

}
