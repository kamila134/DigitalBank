package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class USdollarsTable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.x-rates.com/table/?from=USD&amount=1");
        Map<String,String> currencyMap = new LinkedHashMap<>();
        for (int i = 1; i <= 10; i++) {
            String currXpath = "//table[1]/tbody/tr[" + i + "]/td[1]";
            String valXpath = "//table[1]/tbody/tr[" + i + "]/td[2]/a";
            String currency = driver.findElement(By.xpath(currXpath)).getText();
            String value = driver.findElement(By.xpath(valXpath)).getText();
            currencyMap.put(currency,value);
        } System.out.println(currencyMap.toString());

        driver.quit();

    }
}
