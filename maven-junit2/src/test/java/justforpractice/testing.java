package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testing {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co");
        Thread.sleep(2000);

        WebElement webTablesOption = driver.findElement(By.id("webTables_page"));
        webTablesOption.click();

        Thread.sleep(2000);

        WebElement firstColumnHeader = driver.findElement(By.xpath("//table/thead/tr/th[2]"));
        assertEquals("Dessert (100g serving)", firstColumnHeader.getText());
    }
}
