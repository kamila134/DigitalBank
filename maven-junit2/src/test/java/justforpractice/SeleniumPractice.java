package justforpractice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumPractice {
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() throws InterruptedException{
        driver = new SafariDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#");

        Thread.sleep(2000);
        WebElement managerBtn = driver.findElement(By.xpath("//button[contains(text(),'Manager')]"));
        managerBtn.click();

        Thread.sleep(1000);
        WebElement customersBtn = driver.findElement(By.xpath("//button[3]"));
        customersBtn.click();

        Thread.sleep(2000);
    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @DisplayName("sorting column 1")
    @Test
    public void test1() throws InterruptedException {

        WebElement column1 = driver.findElement(By.xpath("//table/thead//td[1]/a"));
        column1.click();
        Thread.sleep(1000);
        column1.click();

        Thread.sleep(2000);
        WebElement name1 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
        assertEquals("Albus",name1.getText(),"names on row 1 didn't match");
        WebElement name2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]"));
        assertEquals("Harry",name2.getText(),"names on row 2 didn't match");
        WebElement name3 = driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]"));
        assertEquals("Hermoine",name3.getText(),"names on row 3 didn't match");
        WebElement name4 = driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]"));
        assertEquals("Neville", name4.getText(), "names on row 4 didn't match");
        WebElement name5 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]"));
        assertEquals("Ron", name5.getText(), "names on row 5 didn't match");
    }

    @DisplayName("sorting column 2")
    @Test
    public void test2() throws InterruptedException{
        Thread.sleep(1000);
        WebElement column2 = driver.findElement(By.xpath("//table/thead//td[2]/a"));
        column2.click();
        Thread.sleep(1000);
        column2.click();

        Thread.sleep(2000);
        WebElement lastName1 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        assertEquals("Dumbledore", lastName1.getText(), " last names on row 1 didn't match");
        WebElement lastName2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        assertEquals("Granger", lastName2.getText(), " last names on row 2 didn't match");
        WebElement lastName3 = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]"));
        assertEquals("Longbottom", lastName3.getText(), " last names on row 3 didn't match");
        WebElement lastName4 = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        assertEquals("Potter", lastName4.getText(), " last names on row 4 didn't match");
        WebElement lastName5 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        assertEquals("Weasly", lastName5.getText(), " last names on row 5 didn't match");
    }

        @DisplayName("sorting column 3")
        @Test
        public void test3() throws InterruptedException{
            Thread.sleep(1000);
            WebElement column3 = driver.findElement(By.xpath("//table/thead//td[3]/a"));
            column3.click();
            Thread.sleep(1000);
            column3.click();

            Thread.sleep(2000);
            WebElement postCode1 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]"));
            assertEquals("E55555", postCode1.getText(), "post codes on row 1 didn't match");
            WebElement postCode2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
            assertEquals("E55656", postCode2.getText(), "post codes on row 2 didn't match");
            WebElement postCode3 = driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]"));
            assertEquals("E725JB", postCode3.getText(), "post codes on row 3 didn't match");
            WebElement postCode4 = driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]"));
            assertEquals("E859AB", postCode4.getText(), "post codes on row 4 didn't match");
            WebElement postCode5 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[3]"));
            assertEquals("E89898", postCode5.getText(), "post codes on row 5 didn't match");
        }

}
