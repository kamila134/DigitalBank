package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWaits {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

//        WebElement changingText = driver.findElement(By.id("h2"));
//        System.out.println(changingText.getText());
//
//        WebElement changingTxtBtn = driver.findElement(By.id("populate-text"));
//        changingTxtBtn.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("h2"),"Selenium Webdriver"));
//        System.out.println(changingText.getText());

//      Last part ////////////////////

        WebElement checkBoxBtn = driver.findElement(By.id("checkbox"));
        checkBoxBtn.click();


        WebElement checkBox = driver.findElement(By.id("ch"));
        boolean isChecked = checkBox.isSelected();
        System.out.println(isChecked);
        wait.until(ExpectedConditions.elementSelectionStateToBe(By.id("ch"),true));
        System.out.println(checkBox.isSelected());

        System.out.println("DONE");
        driver.quit();
//        WebElement displayBtn = driver.findElement(By.id("display-other-button"));
//        displayBtn.click();
//        WebElement hiddenEnabledBtn = driver.findElement(By.id("hidden"));
//        System.out.println(hiddenEnabledBtn.getText() + "-----");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
//        System.out.println(hiddenEnabledBtn.getText());
//        System.out.println(hiddenEnabledBtn.getAttribute("id"));
//
//        WebElement enableBtn = driver.findElement(By.id("enable-button"));
//        enableBtn.click();
//
//        WebElement clickableBtn = driver.findElement(By.id("disable"));
//        wait.until(ExpectedConditions.elementToBeClickable(clickableBtn));
//        System.out.println(clickableBtn.getText());
//        System.out.println(clickableBtn.getAttribute("id"));



    }
}
