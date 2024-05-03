package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class Modals16_17_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://practice-automation.com/modals/");
        Thread.sleep(3000);

        WebElement simpleModalBtn = driver.findElement(By.className("popmake-674"));
        simpleModalBtn.click();
        Thread.sleep(3000);

        WebElement nameTxtBox = driver.findElement(By.name("g1051-name"));
        nameTxtBox.sendKeys("Roberto Jones");
        Thread.sleep(1000);

        WebElement emailTxtBox = driver.findElement(By.name("g1051-email"));
        emailTxtBox.sendKeys("roberto@gmail.com");
        Thread.sleep(1000);

        WebElement messageTxtBox = driver.findElement(By.name("g1051-message"));
        messageTxtBox.sendKeys("My new request");
        Thread.sleep(1000);

        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitBtn.submit();

        //*[@id=\"contact-form-1051\"]/form/p[1]"


        //
    }
}
