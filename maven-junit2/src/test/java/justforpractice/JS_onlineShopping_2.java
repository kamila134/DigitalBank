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
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JS_onlineShopping_2 {
    static WebDriver driver;
    static List<String> productList = new ArrayList<>();
    static JavascriptExecutor js;
    static int n = 1;
    static int currentNumPerPage;

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
        assertEquals(12, productList.size(), "p.1 List and expected num didn't match");
        assertEquals(12, currentNumPerPage, "p.1 Num and expected num didn't match");

    }

    @Test
    public  void testPage2 () throws InterruptedException {
        checkingProductSet();
        assertEquals(24, productList.size(),"p.2 List and expected num didn't match");
        assertEquals(24, currentNumPerPage, "p.2 Num and expected num didn't match");
    }

    @Test
    public  void testPage3 () throws InterruptedException {
        checkingProductSet();
        assertEquals(36, productList.size(), "p.3 List and expected num didn't match");
        assertEquals(36, currentNumPerPage, "p.3 Num and expected num didn't match");
    }

    public static void checkingProductSet() throws InterruptedException{
        WebElement numPerPage = driver.findElement(By.xpath("//main[@id='maincontent']/div[3]/div/div[5]//select[@id='limiter']"));
        Select selectNumPerPage = new Select(numPerPage);
        currentNumPerPage = Integer.parseInt(selectNumPerPage.getFirstSelectedOption().getText());

        for (int i = 1; i <= currentNumPerPage; i++) {
            String productXpath = "//li[" + i + "]//img[@class='product-image-photo']";
            WebElement product = driver.findElement(By.xpath(productXpath));
            System.out.println(currentNumPerPage + " " + product.getAttribute("alt"));
            if (!productList.contains(product.getAttribute("alt"))) {
                productList.add(product.getAttribute("alt"));
            }

        }
        if (productList.size() < 25) {
            js.executeScript("arguments[0].scrollIntoView()",numPerPage);
            Thread.sleep(2000);
            selectNumPerPage.selectByIndex(n++);
        }
    }
}
