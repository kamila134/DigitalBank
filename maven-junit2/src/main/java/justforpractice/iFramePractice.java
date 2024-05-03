package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class iFramePractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.get("https://practice-automation.com/iframes/");
        driver.get("https://practice-automation.com/iframes/");

        //switching to iframe
        driver.switchTo().frame("frame2");

        WebElement menuBtn = driver.findElement(By.xpath("//button[@aria-label='Menu']"));
        menuBtn.click();

        WebElement h2topics = driver.findElement(By.xpath("//h2[@class = 'MenuModal__Category'][1]"));
        System.out.println(h2topics.getText() + ":");

        for (int i = 1; i < 6; i++) {
            String topicXpath = "//h2[@class = 'MenuModal__Category'][1]/following-sibling::ul/li[" + i + "]//a";
            WebElement topic = driver.findElement(By.xpath(topicXpath));
            System.out.println("\t" + topic.getText());
        }

        WebElement h2sites = driver.findElement(By.xpath("//div[contains(@class,'Right')]//h2[@class = 'MenuModal__Category']"));
        System.out.println(h2sites.getText() + ":");
        for (int i = 1; i < 6; i++) {
            String siteXpath = "//div[contains(@class,'Right')]//h2[@class = 'MenuModal__Category']//following-sibling::ul/li[" + i +"]//a";
            WebElement site = driver.findElement(By.xpath(siteXpath));
            System.out.println("\t" + site.getText());
        } driver.quit();
    }
}
