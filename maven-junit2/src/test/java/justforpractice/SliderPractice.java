package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SliderPractice {

    @Test
    public void sliderTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-automation.com/slider/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement currentValue = driver.findElement(By.id("value"));
        System.out.println(currentValue.getText());

        WebElement sliderBtn = driver.findElement(By.id("slideMe"));
        Actions action = new Actions(driver);
        action.clickAndHold(sliderBtn).moveByOffset(-570,20).perform();
        int currentValueNum = Integer.parseInt(currentValue.getText());
        System.out.println(currentValueNum);

        assertTrue(currentValueNum == 0);

        action.dragAndDropBy(sliderBtn,110,20).perform();
        currentValueNum = Integer.parseInt(currentValue.getText());
        assertTrue(currentValueNum == 60);
        action.dragAndDropBy(sliderBtn,0,20).perform();
        currentValueNum = Integer.parseInt(currentValue.getText());
        assertEquals(50, currentValueNum);

//        int xOffset = 100;
//        do {
//            actions.clickAndHold(sliderBtn).moveByOffset(xOffset,20).perform();
//            xOffset-=10;
//            System.out.println(xOffset);
//        } while (currentValueNum > 0);

    }
}
