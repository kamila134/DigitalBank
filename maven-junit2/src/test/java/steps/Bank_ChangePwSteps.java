package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class Bank_ChangePwSteps {

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();

    }
     WebDriver driver = new ChromeDriver();



}
