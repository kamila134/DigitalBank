package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TablesTest {

    @DisplayName("Postal Codes containing 8")
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list");
        Thread.sleep(2000);
        List<WebElement> postCodesContaining8 = driver.findElements(By.xpath("//table/tbody//td[4]//span[contains(text(),'8')]"));
        Thread.sleep(1000);
        assertTrue(postCodesContaining8.size() == 1, "Size of the list is incorrect");


        for (WebElement element: postCodesContaining8) {
            WebElement nameElement = element.findElement(By.xpath("./../../td[1]"));
            Thread.sleep(1000);
            System.out.println(nameElement.getText());
            assertEquals("Ron",nameElement.getText(), "Name doesn't match");
        }

        driver.quit();
    }
}
