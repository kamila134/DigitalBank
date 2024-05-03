package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class isSelected {
    @DisplayName("Test isSelected method")
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.jquerymobile.com/1.4.5/checkboxradio-checkbox/");
        driver.manage().window().fullscreen();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        WebElement checkboxBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='checkbox-0 ']")));
//        WebElement checkboxLabelBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='checkbox-0 ']/preceding-sibling::label")));
//        assertFalse(checkboxBtn.isSelected());
//        checkboxLabelBtn.click();
//        assertTrue(checkboxBtn.isSelected());

        WebElement checkboxOne = driver.findElement(By.id("checkbox-v-2a"));
        WebElement checkboxTwo = driver.findElement(By.id("checkbox-v-2b"));
        WebElement checkboxThree = driver.findElement(By.id("checkbox-v-2c"));

        List<WebElement> checkboxList = new ArrayList<>();
        checkboxList.add(checkboxOne);
        checkboxList.add(checkboxTwo);
        checkboxList.add(checkboxThree);

        for (int i = 0; i < checkboxList.size(); i++) {
            WebElement checkboxElement = checkboxList.get(i);
            System.out.println(checkboxElement.getAttribute("id") + " " + checkboxElement.isDisplayed());
            String labelXpath = "//input[@id='" + checkboxElement.getAttribute("id") + "']/preceding-sibling::label";
            WebElement checkboxLabel = driver.findElement(By.xpath(labelXpath));
            if (i%2 != 0) {
                checkboxLabel.click();
            }
            System.out.println(checkboxElement.isSelected());

        }
        driver.quit();
    }
}
