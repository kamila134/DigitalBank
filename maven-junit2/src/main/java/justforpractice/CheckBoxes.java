package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://test.rubywatir.com/checkboxes.php");
//        driver.manage().window().fullscreen();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> checkboxList = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            String checkboxXpath = "//input[" + i + "]";
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkboxXpath)));
            checkboxList.add(checkbox);
        }

        for (WebElement checkboxElement: checkboxList) {
            System.out.println(checkboxElement.getAttribute("value"));
            System.out.println("\tSelected? " + checkboxElement.isSelected());
            System.out.println("\tEnabled? " + checkboxElement.isEnabled());
            System.out.println("===================");

            if (checkboxElement.getAttribute("value").endsWith("all")) {
                checkboxElement.click();
            }
            System.out.println("\tSelected? " + checkboxElement.isSelected());
            System.out.println("\tEnabled? " + checkboxElement.isEnabled());
            System.out.println();
        }
        driver.quit();
    }
}
