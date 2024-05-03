package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JS_onlineShopping {
    static WebDriver driver;
    static Set<String> titlesSet = new HashSet<>();
    static JavascriptExecutor js;
    static int itemsCount;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;

        js.executeScript("window.location='https://magento.softwaretestingboard.com/'");

        WebElement signInBtn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        js.executeScript("arguments[0].click()", signInBtn);

        WebElement emailTxtBox = driver.findElement(By.id("email"));
        emailTxtBox.sendKeys("monicabe@yahoo.com");

        WebElement pwTxtBox1 = driver.findElement(By.id("pass"));;
        pwTxtBox1.sendKeys("Mon!ca11");

        WebElement loginBtn = driver.findElement(By.id("send2"));
        loginBtn.submit();

        WebElement menSection = driver.findElement(By.id("ui-id-5"));
        Actions action = new Actions(driver);
        action.moveToElement(menSection).perform();
        WebElement topsSection = driver.findElement(By.id("ui-id-17"));
        js.executeScript("arguments[0].click()", topsSection);
    }

    @Test
    public  void testPage1 () throws InterruptedException {
        checkingProductSet();
        assertEquals(12, titlesSet.size());

    }

    @Test
    public  void testPage2 () throws InterruptedException {
        checkingProductSet();
        assertEquals(24, titlesSet.size());
    }

    @Test
    public  void testPage3 () throws InterruptedException {
        checkingProductSet();
        assertEquals(36, titlesSet.size());
    }

    @Test
    public  void testPage4 () throws InterruptedException {
        checkingProductSet();
        assertEquals(48,titlesSet.size());
    }

    public static void checkingProductSet() throws InterruptedException{
        for (int i = 1; i < 13; i++) {
            String productXpath = "//li[" + i + "]//img[@class='product-image-photo']";
            WebElement product = driver.findElement(By.xpath(productXpath));
            titlesSet.add(product.getAttribute("alt"));
        }
        if (titlesSet.size() < 37) {
            WebElement nextPageLink = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[5]/div[2]//a[@title='Next']"));
            js.executeScript("arguments[0].scrollIntoView()",nextPageLink);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click()", nextPageLink);
        }
    }
}
