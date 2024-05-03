package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class iFramePractice_2iFrames {

    @Test
    public void testIFrames() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://practice-automation.com/iframes/'");
//        driver.get("");

        //switching to iframe
        driver.switchTo().frame(0);

        WebElement footerLegal = driver.findElement(By.xpath("//h4[@aria-label='Legal']"));
        js.executeScript("arguments[0].scrollIntoView()",footerLegal);

        System.out.println(footerLegal.getText() + ":");
        for (int i = 1; i <= 7; i++) {
            String topicXpath = "./following-sibling::ul/li[" + i + "]//a";
            WebElement topic = footerLegal.findElement(By.xpath(topicXpath));
            System.out.println("\t" + topic.getText());
        }

        WebElement footerSites = driver.findElement(By.xpath("//h4[@aria-label='Our Sites']"));
        System.out.println(footerSites.getText() + ":");
        for (int i = 1; i <= 13; i++) {
            String topicXpath = "./following-sibling::ul/li[" + i + "]//a";
            WebElement topic = footerSites.findElement(By.xpath(topicXpath));
            System.out.println("\t" + topic.getText());
        }

        WebElement footerJoinUs = driver.findElement(By.xpath("//h4[@aria-label='Join Us']"));
        System.out.println(footerJoinUs.getText() + ":");
        for (int i = 1; i <= 7; i++) {
            String topicXpath = "./following-sibling::ul/li[" + i + "]//a";
            WebElement topic = footerJoinUs.findElement(By.xpath(topicXpath));
            System.out.println("\t" + topic.getText());
        }

        //switch back to the parent page
        driver.switchTo().parentFrame();
        //switch to the 2nd frame
        driver.switchTo().frame(1);

        WebElement downloadsBtn = driver.findElement(By.xpath("//a[@href='/downloads']"));
        js.executeScript("arguments[0].click()", downloadsBtn);

        WebElement seleniumGridVersion = driver.findElement(By.xpath("//p[contains(text(),'Grid')]/preceding-sibling::p/a"));
        js.executeScript("arguments[0].scrollIntoView()",seleniumGridVersion);

        assertEquals("4.18.1", seleniumGridVersion.getText());

        driver.quit();
    }
}
