package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import java.util.concurrent.TimeUnit;

public class JS_test {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // driver.get(url) in js
        js.executeScript("window.location='https://www.etsy.com/'");
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1000)");

        Thread.sleep(2000);
        WebElement helpCenterLink = driver.findElement(By.xpath("//a[contains(text(),'Help Center')]"));
        js.executeScript("arguments[0].scrollIntoView()",helpCenterLink);

        Thread.sleep(2000);
        WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        js.executeScript("arguments[0].scrollIntoView()",signInBtn);

        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid green')", signInBtn);
        js.executeScript("arguments[0].click()", signInBtn);
    }
}
