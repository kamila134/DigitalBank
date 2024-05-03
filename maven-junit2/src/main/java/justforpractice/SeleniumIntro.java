package justforpractice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumIntro {
    public static void main(String[] args) throws  InterruptedException{
      //System.setProperty("webdriver.chrome.driver", "/Users/kamilaakisheva/Downloads/chromedriver_mac64/chromedriver");
        //Azat's:  "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
       WebDriverManager.chromedriver().setup();
     //   WebDriverManager.firefoxdriver().setup();
       // WebDriver driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //driver.get("https://www.nasdaq.com/market-activity/stocks/tsla/real-time");
        driver.get("https://www.nasdaq.com/solutions/listings/list-your-company");


//        driver.get("https://demo-project.wedevx.co/");

        Thread.sleep(2000);
//        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[contains(@id,'name')]"));
//        firstNameTxtBox.sendKeys("Kate");
//
//        Thread.sleep(1000);
//        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
//        lastNameTxtBox.sendKeys("Solla");

        driver.quit();


    }
}
