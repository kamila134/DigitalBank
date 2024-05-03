package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class PageLoadTimeout {

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
    }

    //Set time out for 10 seconds to meet expectations and avoid errors
   // Set time out for 1 millisecond to throw the error

    @Test
    public void  test1 (){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.nasdaq.com/market-activity/stocks/tsla/real-time");
//        driver.get("https://demo-project.wedevx.co/");
        System.out.println("case 1");
        driver.quit();
    }

    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        System.out.println("case 2");
        driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.MILLISECONDS);
        driver.get("https://www.nasdaq.com/solutions/listings/list-your-company");

    }
}
