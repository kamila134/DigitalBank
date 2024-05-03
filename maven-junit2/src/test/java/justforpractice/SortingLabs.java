package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingLabs {
    static String[] expectedResults;
    static String[] actualResults;
    static WebDriver driver;
    @Test
    public void testingSorting() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NotFoundException.class);


        WebElement usernameTxtBox = driver.findElement(By.id("user-name"));
        WebElement sampleUsername = driver.findElement(By.xpath("//div[@id='login_credentials']"));
        String allUsernames = sampleUsername.getText();
        String[] usrArr = allUsernames.split("\n");
        usernameTxtBox.sendKeys(usrArr[1].trim());

        WebElement passwordTxtBox = driver.findElement(By.id("password"));
        WebElement allPasswords = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='login_password']")));
        String pwTxt = allPasswords.getText().substring(allPasswords.getText().indexOf("\n")).trim();
        passwordTxtBox.sendKeys(pwTxt);

        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        loginBtn.submit();

        WebElement sortingDropdown = driver.findElement(By.xpath("//select"));
        Select selectSorting = new Select(sortingDropdown);

        for (int i = 0; i < 4; i++) {
            selectSorting.selectByIndex(i);
            sortingMethod(selectSorting);
            assertArrayEquals(expectedResults,actualResults, "Arrays don't match");
        }

        driver.quit();

    }
    public static void sortingMethod (Select select){
        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        String sortingType = select.getFirstSelectedOption().getText();
        actualResults = new String[allProducts.size()];
        for (int i = 0; i < allProducts.size(); i++) {
            allProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));
            WebElement productName = allProducts.get(i).findElement(By.xpath("./div[2]//a"));
            actualResults[i] = productName.getText();
        }
        switch (sortingType) {
            case "Name (A to Z)":
                expectedResults = new String[]{"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
                break;
            case "Name (Z to A)":
                expectedResults = new String[]{"Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket","Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack"  };
                break;
            case "Price (low to high)":
                expectedResults = new String[]{"Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt","Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack", "Sauce Labs Fleece Jacket",};
                break;
            case "Price (high to low)":
                expectedResults = new String[]{"Sauce Labs Fleece Jacket","Sauce Labs Backpack","Test.allTheThings() T-Shirt (Red)" , "Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light" , "Sauce Labs Onesie"};
                break;
        }
    }
}
