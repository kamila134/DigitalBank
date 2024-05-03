package justforpractice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormPractice1 {

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

        Thread.sleep(2000);
        WebElement firstNameTxtBox = driver.findElement(By.id("firstname"));
        firstNameTxtBox.sendKeys("Monica");

        Thread.sleep(1000);
        WebElement lastNameTxtBox = driver.findElement(By.id("lastname"));
        lastNameTxtBox.sendKeys("Belucci");

        Thread.sleep(1000);


        WebElement emailTxtBox = driver.findElement(By.name("email"));
        Thread.sleep(2000);
        emailTxtBox.sendKeys("monica_buj@yahoo.com");

        Thread.sleep(1000);
        WebElement pwTxtBox1 = driver.findElement(By.id("password"));
        Thread.sleep(1000);
        pwTxtBox1.sendKeys("Mon!ca11");

        Thread.sleep(1000);
        WebElement pwTxtBox2 = driver.findElement(By.id("password-confirmation"));
        Thread.sleep(1000);
        pwTxtBox2.sendKeys("Mon!ca11");

        Thread.sleep(1000);
        WebElement actualResultTxtBox = null;
        WebElement createAccBtn = driver.findElement(By.xpath("//button[contains(@title,'Create')]"));

        try {
            createAccBtn.submit();
            Thread.sleep(5000);
            actualResultTxtBox = driver.findElement(By.xpath("//div[@class='box box-information']/div[1]/p[1]"));

        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            driver.quit();
        }
        String expectedFullName = firstNameTxtBox.getText() + " " + lastNameTxtBox.getText();
        String expectedResult = expectedFullName + "\n" + emailTxtBox.getText();
        Thread.sleep(2000);
        assertEquals(expectedResult, actualResultTxtBox.getText(), "Results didn't match");
        Thread.sleep(2000);
        driver.quit();

    }
}
