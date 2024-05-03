package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class practiceForm16_15 {
    public static void main(String[] args) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");

        Thread.sleep(4000);

        //Opening the "forms" tab
        WebElement formsTab = driver.findElement(By.id("panel2bh-header"));
        formsTab.click();

        Thread.sleep(1000);

        //Opening the "Practice form" tab
        WebElement practiceFormTab = driver.findElement(By.id("practiceForm_page"));
        practiceFormTab.click();

        Thread.sleep(1000);

        //Filling out the First Name box
        WebElement firstNameTxtBox = driver.findElement(By.id("firstName"));
        firstNameTxtBox.sendKeys("Jennifer");
        Thread.sleep(1000);

        //Filling out Last Name box
        WebElement lastNameTxtBox = driver.findElement(By.id("lastName"));
        lastNameTxtBox.sendKeys("Laurens");
        Thread.sleep(1000);

        //Filling out email box
        WebElement emailTxtBox = driver.findElement(By.id("userEmail"));
        emailTxtBox.sendKeys("jen_lau@yahoo.com");
        Thread.sleep(1000);

        //Filling out Phone Number box
        WebElement phoneTxtBox = driver.findElement(By.id("userMobile"));
        phoneTxtBox.sendKeys("+1-555-666-3434");
        Thread.sleep(1000);

        //Filling out Subject box
        WebElement subjectsTxtBox = driver.findElement(By.id("subjectsContainer"));
        subjectsTxtBox.sendKeys("Drama, Physics, Math 106");
        Thread.sleep(1000);

        //Need to find ID below
        //Filling out Current address box
        WebElement currentAddressTxtBox = driver.findElement(By.id("currentAddress"));
        currentAddressTxtBox.sendKeys("123 Hollywood ave");


    }
}
