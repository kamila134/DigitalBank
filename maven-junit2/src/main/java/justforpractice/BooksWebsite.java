package justforpractice;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BooksWebsite {
    public static void main(String[] args) throws InterruptedException {
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new SafariDriver();
        driver.get("https://automationbookstore.dev/");

        Thread.sleep(4000);
        WebElement searchBarTxtBox = driver.findElement(By.id("searchBar"));
        searchBarTxtBox.sendKeys("Test Automation");
        Thread.sleep(3000);

        searchBarTxtBox.clear();
        Thread.sleep(1000);
        searchBarTxtBox.sendKeys("Cucumber");
        Thread.sleep(3000);

        searchBarTxtBox.clear();
        Thread.sleep(1000);
        searchBarTxtBox.sendKeys("Java");
        Thread.sleep(3000);

        searchBarTxtBox.clear();
        Thread.sleep(1000);
        searchBarTxtBox.sendKeys("Test");

    }
}
