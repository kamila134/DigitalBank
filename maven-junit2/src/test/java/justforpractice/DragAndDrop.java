package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    @Test
    public void testDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-automation.com/gestures/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action = new Actions(driver);
        driver.manage().window().fullscreen();

        WebElement draggingImage = driver.findElement(By.id("dragMe"));
//        action.clickAndHold(draggingImage).moveByOffset(100, 0).release().perform();
//        action.dragAndDropBy(draggingImage, -1000, 0).perform();
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://practice-automation.com/gestures/");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Actions action = new Actions(driver);
//        driver.manage().window().fullscreen();
//
//        //17.12.2:
//        WebElement movingBox = driver.findElement(By.id("moveMeHeader"));
        WebElement secondBox = driver.findElement(By.id("div2"));
        action.dragAndDrop(draggingImage, secondBox).perform();
//
//        //17.12.3:
//        WebElement draggingImage = driver.findElement(By.id("dragMe"));
//        WebElement secondBox = driver.findElement(By.id("div2"));
//        action.dragAndDropBy(draggingImage, 100,0).perform();

    }
}
