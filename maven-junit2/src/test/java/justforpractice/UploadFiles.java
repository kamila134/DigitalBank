package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadFiles {

    @Test
    public void testUploadFiles(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://formstone.it/components/upload/demo/");
        driver.manage().window().fullscreen();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[1]")));
        uploadInput.sendKeys("/Users/kamilaakisheva/Desktop/need2.png");

        WebElement fileUploaded = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='file']")));
        assertEquals("need2.png",fileUploaded.getText());

        driver.quit();

    }
}
