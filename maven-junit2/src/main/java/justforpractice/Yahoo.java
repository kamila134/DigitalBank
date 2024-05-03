package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class Yahoo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://finance.yahoo.com");

        WebElement signInBtn = driver.findElement(By.xpath("//span[contains(text(),'Sign')]/.."));
        System.out.println(signInBtn.getAttribute("id"));

        Thread.sleep(2000);

        WebElement contactUsBtn = driver.findElement(By.xpath("//a[@title='My Portfolio']/../following-sibling::li[8]/a"));
        System.out.println(contactUsBtn.getAttribute("title"));
    }
}
