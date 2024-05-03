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

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JS_onlineShopping_sorting {
    static WebDriver driver;
    static Set<String> titlesSet = new HashSet<>();
    static JavascriptExecutor js;
    static String firstItemTitle;
    static String lastItemTitle;
    static String lastItemPrice;
    static String firstItemPrice;
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
        sortItems("position");
        assertEquals("Cassius Sparring Tank",firstItemTitle);
        assertEquals("Erikssen CoolTech™ Fitness Tank",lastItemTitle);
        assertEquals("$18.00",firstItemPrice);
        assertEquals("$29.00",lastItemPrice);

        sortItems("name");
        assertEquals("Abominable Hoodie",firstItemTitle);
        assertEquals("$69.00",firstItemPrice);
        assertEquals("Chaz Kangeroo Hoodie",lastItemTitle);
        assertEquals("$52.00",lastItemPrice);

        sortItems("price");
        assertEquals("Cassius Sparring Tank",firstItemTitle);
        assertEquals("Sinbad Fitness Tank",lastItemTitle);
        assertEquals("$18.00",firstItemPrice);
        assertEquals("$29.00",lastItemPrice);


    }

    @Test
    public  void testPage2 () throws InterruptedException {
        clickNextPage();
        sortItems("position");
        assertEquals("Strike Endurance Tee",firstItemTitle);
        assertEquals("$39.00",firstItemPrice);
        assertEquals("Gobi HeatTec® Tee",lastItemTitle);
        assertEquals("$29.00",lastItemPrice);

        sortItems("name");
        assertEquals("Deion Long-Sleeve EverCool™ Tee",firstItemTitle);
        assertEquals("$39.00",firstItemPrice);
        assertEquals("Kenobi Trail Jacket",lastItemTitle);
        assertEquals("$47.00",lastItemPrice);

        sortItems("price");
        assertEquals("Sparta Gym Tank",firstItemTitle);
        assertEquals("$29.00",firstItemPrice);
        assertEquals("Deion Long-Sleeve EverCool™ Tee",lastItemTitle);
        assertEquals("$39.00",lastItemPrice);

    }

    @Test
    public  void testPage3 () throws InterruptedException {
        clickNextPage();
        sortItems("position");
        assertEquals("Proteus Fitness Jackshirt",firstItemTitle);
        assertEquals("$45.00",firstItemPrice);
        assertEquals("Marco Lightweight Active Hoodie",lastItemTitle);
        assertEquals("$74.00",lastItemPrice);

        sortItems("name");
        assertEquals("Lando Gym Jacket",firstItemTitle);
        assertEquals("$99.00",firstItemPrice);
        assertEquals("Ryker LumaTech™ Tee (Crew-neck)",lastItemTitle);
        assertEquals("$32.00",lastItemPrice);

        sortItems("price");
        assertEquals("Beaumont Summit Kit",firstItemTitle);
        assertEquals("$42.00",firstItemPrice);
        assertEquals("Typhon Performance Fleece-lined Jacket",lastItemTitle);
        assertEquals("$60.00",lastItemPrice);

    }

    @Test
    public  void testPage4 () throws InterruptedException {
        clickNextPage();
        sortItems("position");
        assertEquals("Ajax Full-Zip Sweatshirt ",firstItemTitle);
        assertEquals("$69.00",firstItemPrice);
        assertEquals("Chaz Kangeroo Hoodie",lastItemTitle);
        assertEquals("$52.00",lastItemPrice);

        sortItems("name");
        assertEquals("Ryker LumaTech™ Tee (V-neck)",firstItemTitle);
        assertEquals("$28.00",firstItemPrice);
        assertEquals("Zoltan Gym Tee",lastItemTitle);
        assertEquals("$29.00",lastItemPrice);

        sortItems("price");
        assertEquals("Frankie  Sweatshirt",firstItemTitle);
        assertEquals("$60.00",firstItemPrice);
        assertEquals("Lando Gym Jacket",lastItemTitle);
        assertEquals("$99.00",lastItemPrice);

    }

    public static void sortItems(String sortedBy){
        WebElement sorterDropdown = driver.findElement(By.xpath("//main[@id='maincontent']/div[3]/div/div[3]//select[@id='sorter']"));
        Select selectSorter = new Select(sorterDropdown);
        switch (sortedBy) {
            case "position":
                selectSorter.selectByValue("position");
                break;
            case "name":
                selectSorter.selectByValue("name");
                break;
            case "price":
                selectSorter.selectByValue("price");
                break;
        } getFirstAndLastItems();
    }

    public static void getFirstAndLastItems(){
        WebElement firstProduct = driver.findElement(By.xpath("//li[1]//img[@class='product-image-photo']"));
        WebElement lastProduct = driver.findElement(By.xpath("//li[12]//img[@class='product-image-photo']"));
        firstItemTitle = firstProduct.getAttribute("alt");
        lastItemTitle = lastProduct.getAttribute("alt");

        WebElement firstProductPrice = firstProduct.findElement(By.xpath("./../../../following-sibling::div//span[contains(@id,'product-price')]/span"));
        WebElement lastProductPrice = lastProduct.findElement(By.xpath("./../../../following-sibling::div//span[contains(@id,'product-price')]/span"));
        firstItemPrice = firstProductPrice.getText();
        lastItemPrice = lastProductPrice.getText();
    }

    public static void clickNextPage() throws InterruptedException {
        WebElement nextPageLink = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[5]/div[2]//a[@title='Next']"));
        js.executeScript("arguments[0].scrollIntoView()",nextPageLink);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click()", nextPageLink);
    }
}
