package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class LocateByLink {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        Thread.sleep(3000);

        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();

        Thread.sleep(4000);

        WebElement createAcc = driver.findElement(By.partialLinkText("Create"));
        createAcc.click();
    }
}
