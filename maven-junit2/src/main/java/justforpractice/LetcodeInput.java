package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class LetcodeInput {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://letcode.in/edit");

        Thread.sleep(4000);

        WebElement fullNameTxtBox = driver.findElement(By.id("fullName"));
        fullNameTxtBox.sendKeys("Jackie Chan");
        Thread.sleep(2000);

        WebElement secondInputTxtBox = driver.findElement(By.id("join"));
        secondInputTxtBox.clear();
        Thread.sleep(2000);
        secondInputTxtBox.sendKeys("New Text");



    }
}
