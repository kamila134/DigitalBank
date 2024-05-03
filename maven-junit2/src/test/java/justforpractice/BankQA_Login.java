package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class BankQA_Login {
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://dbank-qa.wedevx.co/bank/login");
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @DisplayName("Test Positive login")
    @Test
    public void test1() {
        WebElement usernameTxtBox = driver.findElement(By.id("username"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys("alana@gmail.com");

        WebElement pwTxtBox = driver.findElement(By.id("password"));
        pwTxtBox.clear();
        pwTxtBox.sendKeys("Alana11!");

        WebElement rememberMeCheckbox = driver.findElement(By.id("remember-me"));
        rememberMeCheckbox.click();
        assertTrue(rememberMeCheckbox.isSelected());

        WebElement signInBtn = driver.findElement(By.id("submit"));
        signInBtn.submit();

        WebElement welcomeMessage = driver.findElement(By.xpath("//li[@class='active']"));
        assertTrue(welcomeMessage.isDisplayed());
        assertEquals("Welcome Alana", welcomeMessage.getText());

        WebElement userAvatar = driver.findElement(By.xpath("//img[contains(@alt,'Avatar')]"));
        userAvatar.click();

        WebElement logOutBtn = userAvatar.findElement(By.xpath("./../../div/a[3]"));
        logOutBtn.click();

    }

    @DisplayName("Text Negative Login with Incorrect Username")
    @Test
    public void test2() {
        WebElement usernameTxtBox = driver.findElement(By.id("username"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys("alana7@gmail.com");

        WebElement pwTxtBox = driver.findElement(By.id("password"));
        pwTxtBox.clear();
        pwTxtBox.sendKeys("Alana11!");

        WebElement rememberMeCheckbox = driver.findElement(By.id("remember-me"));
        rememberMeCheckbox.click();
        assertTrue(rememberMeCheckbox.isSelected());

        WebElement signInBtn = driver.findElement(By.id("submit"));
        signInBtn.submit();

        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Error']"));
        assertTrue(errorMessage.isDisplayed());
        assertEquals("Error", errorMessage.getText().trim());
    }

    @DisplayName("Text Negative Login with Incorrect Password")
    @Test
    public void test3() {
        WebElement usernameTxtBox = driver.findElement(By.id("username"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys("alana@gmail.com");

        WebElement pwTxtBox = driver.findElement(By.id("password"));
        pwTxtBox.clear();
        pwTxtBox.sendKeys("Alana11!!");

        WebElement rememberMeCheckbox = driver.findElement(By.id("remember-me"));
        rememberMeCheckbox.click();
        assertTrue(rememberMeCheckbox.isSelected());

        WebElement signInBtn = driver.findElement(By.id("submit"));
        signInBtn.submit();

        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Error']"));
        assertTrue(errorMessage.isDisplayed());
        assertEquals("Error", errorMessage.getText().trim());
    }
}
