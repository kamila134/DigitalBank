package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class Modals16_17 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new SafariDriver();
        driver.get("https://practice-automation.com/modals/");
        Thread.sleep(3000);

        WebElement simpleModalBtn = driver.findElement(By.className("popmake-1318"));
        simpleModalBtn.click();
        Thread.sleep(3000);

        WebElement titleTxt = driver.findElement(By.id("simpleModal"));
        System.out.println("Title: " + titleTxt.getText());




    }
}
//pum-trigger