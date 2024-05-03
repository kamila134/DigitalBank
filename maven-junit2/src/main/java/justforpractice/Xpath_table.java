package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedHashMap;
import java.util.Map;

public class Xpath_table {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice-automation.com/tables/");
        Map<String,String> productsMap = new LinkedHashMap();

        //first row
        Thread.sleep(3000);
        WebElement orangesTxt = driver.findElement(By.xpath("//td[text()='Oranges']"));
        Thread.sleep(1000);
        WebElement orangesPrice= driver.findElement(By.xpath("//td[text()='$3.99']"));
        productsMap.put(orangesTxt.getText(), orangesPrice.getText());

        //second row
        Thread.sleep(1000);
        WebElement laptopTxt = driver.findElement(By.xpath("//td[text()='Laptop']"));
        Thread.sleep(1000);
        WebElement laptopPrice= driver.findElement(By.xpath("//td[text()='$1200.00']"));
        productsMap.put(laptopTxt.getText(), laptopPrice.getText());

        //third row
        Thread.sleep(1000);
        WebElement marblesTxt = driver.findElement(By.xpath("//td[text()='Marbles']"));
        Thread.sleep(1000);
        WebElement marblesPrice= driver.findElement(By.xpath("//td[text()='$1.25']"));
        productsMap.put(marblesTxt.getText(), marblesPrice.getText());

        System.out.println(productsMap.toString());


        Thread.sleep(1000);
        WebElement chinaName = driver.findElement(By.xpath("//td[text()='China']"));

        Thread.sleep(1000);
        WebElement chinaRank = driver.findElement(By.xpath("//td[text()='2']"));

        Thread.sleep(1000);
        WebElement chinaPopulation = driver.findElement(By.xpath("//td[text()='1,426']"));
        System.out.println(chinaName.getText() + "\nRank - " + chinaRank.getText() + "\nPopulation (million) - " + chinaPopulation.getText());

        Thread.sleep(3000);
        WebElement countryCategory = driver.findElement(By.xpath("//th[2]"));
        countryCategory.click();
        System.out.println(countryCategory.getText());

        Thread.sleep(3000);
        WebElement country1 = driver.findElement(By.xpath("//*[@id=\"tablepress-1\"]/tbody/tr[1]/td[2]"));
        Thread.sleep(1000);
        WebElement country1Rank = driver.findElement(By.xpath("//*[@id=\"tablepress-1\"]/tbody/tr[1]/td[1]"));
        Thread.sleep(1000);
        WebElement country1Population = driver.findElement(By.xpath("//*[@id=\"tablepress-1\"]/tbody/tr[1]/td[3]"));
        System.out.println(country1.getText() + "\nRank - " + country1Rank.getText() + "\nPopulation (million) - " + country1Population.getText());

        WebElement country2 = driver.findElement(By.xpath("//*[@id='tablepress-1']/tbody/tr[2]/td[2]"));
        Thread.sleep(1000);
        WebElement country2Rank = driver.findElement(By.xpath("//*[@id='tablepress-1']/tbody/tr[2]/td[1]"));
        Thread.sleep(1000);
        WebElement country2Population = driver.findElement(By.xpath("//*[@id='tablepress-1']/tbody/tr[2]/td[3]"));
        Thread.sleep(1000);
        System.out.println(country2.getText() + "\nRank - " + country2Rank.getText() + "\nPopulation (million) - " + country2Population.getText());

        Thread.sleep(1000);
        WebElement country3 = driver.findElement(By.xpath("//*[@id='tablepress-1']/tbody/tr[3]/td[2]"));
        Thread.sleep(1000);
        WebElement country3Rank = driver.findElement(By.xpath("//*[@id='tablepress-1']/tbody/tr[3]/td[1]"));
        Thread.sleep(1000);
        WebElement country3Population = driver.findElement(By.xpath("//*[@id='tablepress-1']/tbody/tr[3]/td[3]"));
        Thread.sleep(1000);
        System.out.println(country3.getText() + "\nRank - " + country3Rank.getText() + "\nPopulation (million) - " + country3Population.getText());
    }
}
