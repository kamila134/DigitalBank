
package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class LocateByXpath_MakeAppt {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new SafariDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        Thread.sleep(2000);

        WebElement makeApptBtn = driver.findElement(By.xpath("//a[@href='./profile.php#login']"));
        makeApptBtn.click();

        Thread.sleep(1000);
        WebElement usernameDemo = driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        String usernameDemoStr = usernameDemo.getAttribute("value");

        Thread.sleep(1000);
        WebElement pwDemo = driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']"));
        String pwDemoStr = pwDemo.getAttribute("value");


        Thread.sleep(1000);
        WebElement usernameReal = driver.findElement(By.xpath("//input[@name='username']"));
        usernameReal.sendKeys(usernameDemoStr);

        Thread.sleep(1000);
        WebElement pwReal = driver.findElement(By.xpath("//input[@name='password']"));
        pwReal.sendKeys(pwDemoStr);

        Thread.sleep(1000);
        WebElement loginBtn = driver.findElement(By.xpath("//button"));
        loginBtn.submit();

        Thread.sleep(2000);
        WebElement applyCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        applyCheckBox.click();

        Thread.sleep(1000);
        WebElement medicaidRadioBtn = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicaidRadioBtn.click();

        Thread.sleep(1000);
        WebElement dateTxtBox = driver.findElement(By.name("visit_date"));
        dateTxtBox.sendKeys("01/03/2024");

        Thread.sleep(1000);
        WebElement commentxTxtBox = driver.findElement(By.xpath("//textarea"));
        commentxTxtBox.sendKeys("Some comments");

        Thread.sleep(1000);
        WebElement bookApptBurn = driver.findElement(By.xpath("//button"));
        bookApptBurn.submit();

        //Getting texts from the confirmation page

        Thread.sleep(2000);
        WebElement facilityTxt = driver.findElement(By.xpath("//label[@for='facility']"));

        Thread.sleep(1000);
        WebElement facilityOption = driver.findElement(By.id("facility"));
        System.out.println(facilityTxt.getText() + ":  " + facilityOption.getText());
        System.out.println();


        Thread.sleep(1000);
        WebElement readmTxt = driver.findElement(By.xpath("//label[@for='hospital_readmission']"));

        Thread.sleep(1000);
        WebElement readmOption = driver.findElement(By.id("hospital_readmission"));
        System.out.println(readmTxt.getText() + ":  " + readmOption.getText());
        System.out.println();

        Thread.sleep(1000);
        WebElement healthcareTxt = driver.findElement(By.xpath("//label[@for='program']"));

        Thread.sleep(1000);
        WebElement healthcareOption = driver.findElement(By.id("program"));
        System.out.println(healthcareTxt.getText() + ":  " + healthcareOption.getText());
        System.out.println();

        Thread.sleep(1000);
        WebElement dateTxt = driver.findElement(By.xpath("//label[@for='visit_date']"));

        Thread.sleep(1000);
        WebElement dateOption = driver.findElement(By.id("visit_date"));
        System.out.println(dateTxt.getText() + ":  " + dateOption.getText());
        System.out.println();











    }
}
