package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoverPractice {

    @Test
    public void  HoverOverTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-automation.com/hover/");

        WebElement hoverTextBox = driver.findElement(By.xpath("//h3"));
        Actions action = new Actions(driver);

        assertEquals("Mouse over me",hoverTextBox.getText(), "Initial text doesn't match");

        action.moveToElement(hoverTextBox).perform();
        assertEquals("You did it!",hoverTextBox.getText(), "New text doesn't match");





    }
}
