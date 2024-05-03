package justforpractice;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class LocateBy {
    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new SafariDriver();
        driver.get("https://demo-project.wedevx.co");
        Thread.sleep(5000);
        WebElement radioBtn = driver.findElement(By.id("radioButton_page"));
        radioBtn.click();
        WebElement yesBtn = driver.findElement(By.id("yesRadio"));
        yesBtn.click();
        WebElement imprBtn = driver.findElement(By.id("impressiveRadio"));
        imprBtn.click();
        ///////////////////////////////////////////////////////////////////
        Thread.sleep(50000);
        WebElement checkBox = driver.findElement(By.id("checkBox_page"));
        checkBox.click();
        WebElement child1 = driver.findElement(By.id("child1"));
        WebElement child2 = driver.findElement(By.id("child2"));
        child1.click();
        child2.click();
        child1.click();
        ///////////////////////////////////////////////////////////////////
        WebElement webTables = driver.findElement(By.id("webTables_page"));
        webTables.click();
        WebElement eclair = driver.findElement(By.id("enhanced-table-checkbox-2"));
        WebElement cupcake = driver.findElement(By.id("enhanced-table-checkbox-3"));
        WebElement marshmallow = driver.findElement(By.id("enhanced-table-checkbox-4"));
        eclair.click();
        cupcake.click();
        marshmallow.click();
        WebElement nextPage = driver.findElement(By.xpath("//button[@aria-label='Go to next page']"));
        nextPage.click();
        Thread.sleep(3000);
        WebElement lollipop = driver.findElement(By.id("enhanced-table-checkbox-3"));
        WebElement nougat = driver.findElement(By.id("enhanced-table-checkbox-1"));
        lollipop.click();
        nougat.click();






        //id="radioButton_page"
    }
}
