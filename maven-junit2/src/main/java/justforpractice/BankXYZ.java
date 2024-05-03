package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BankXYZ {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");


        Thread.sleep(3000);
        WebElement addCustomerBtn = driver.findElement(By.xpath("//button[@ng-class = 'btnClass1']"));
        addCustomerBtn.click();
        Thread.sleep(1000);
//
//        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
//        firstNameTxtBox.sendKeys("Maria");
//
//        Thread.sleep(1000);
//        WebElement lastNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
//        lastNameTxtBox.sendKeys("09005");
//
//        Thread.sleep(1000);
//        WebElement postCodeTxtBox = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
//        postCodeTxtBox.sendKeys("Buella");
//
//        Thread.sleep(1000);
//        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
//        submitBtn.submit();

        //Going to the "Customers" tab and deleting the customer

        Thread.sleep(1000);
        WebElement customersBtn   = driver.findElement(By.xpath("//button[@ng-class = 'btnClass3']"));
        customersBtn.click();
        Thread.sleep(2000);
        driver.navigate().back();
//
//        Thread.sleep(4000);
//        WebElement deleteBtn = driver.findElement(By.xpath("//table/tbody/tr[5]/td[5]/button"));
//        deleteBtn.click();


//button[@ng-click='deleteCust(cust)']
       // /html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[5]/button
        Thread.sleep(1000);
        WebElement openAcc = driver.findElement(By.xpath("//button[@ng-class='btnClass2']"));
        openAcc.click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();

        Thread.sleep(2000);
        addCustomerBtn.click();
        Thread.sleep(1000);

        WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstNameTxtBox.sendKeys("Maria");

        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        Thread.sleep(2000);
        driver.quit();

//        System.out.println(openAcc.getAttribute("ng-click"));
//


    }
}
