package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyboardPractice {

    @Test
    public void testKeyboard() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebElement formsTab = driver.findElement(By.id("panel2bh-header"));
        formsTab.click();

        WebElement practiceFormTab = driver.findElement(By.id("practiceForm_page"));
        Thread.sleep(3000);
        practiceFormTab.click();

        WebElement firstNameTxtBox = driver.findElement(By.id("firstName"));
        Actions action = new Actions(driver);

        action.sendKeys(firstNameTxtBox,"Jennifer")
                .keyDown(Keys.COMMAND).sendKeys("a")
                .keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).sendKeys("xyz")
                .sendKeys(Keys.TAB)
                .keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys("@wedevx.com").sendKeys(Keys.ENTER).perform();

        WebElement phoneTxtBox = driver.findElement(By.id("userMobile"));
        assertEquals("true",phoneTxtBox.getAttribute("aria-invalid"));
        WebElement subjectTxtBox = driver.findElement(By.id("subjectsContainer"));
        assertTrue(subjectTxtBox.getAttribute("aria-invalid").equals("true"));
    }
}
