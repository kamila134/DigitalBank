package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class Wikipedia {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.wikipedia.org");
        Thread.sleep(2000);

        //16.25.1:
        WebElement spanishArticles = driver.findElement(By.xpath("//small[contains(text(), '1.935.000')]/.."));
        System.out.println(spanishArticles.getAttribute("title"));

        //My code for 16.23.3:
//        WebElement frNum = driver.findElement(By.xpath("//nav[@class='central-featured']/div[@class='central-featured-lang lang6']//small"));
//        System.out.println(frNum.getText());

        //Sezims code for 16.23.3:
//        WebElement centralFeaturedLang = driver.findElement(By.xpath("//div[@class='central-featured']//div[contains(@class, 'lang6')]"));
//        WebElement frenchArticles = centralFeaturedLang.findElement(By.xpath(".//a[1]"));
//        System.out.println("Number of French articles: " + frenchArticles.getText());

        //16.24:
//        WebElement chineseArticles = driver.findElement(By.xpath("//div[@lang='it']/following-sibling::div//strong"));
//        WebElement numOfChineseArticles = chineseArticles.findElement(By.xpath("./following-sibling::small"));
//        System.out.println("Language: " + chineseArticles.getText());
//        System.out.println("Number: " + numOfChineseArticles.getText());
//        System.out.println();
//
//        WebElement deutschArticles = driver.findElement(By.xpath("//div[@lang='it']/preceding-sibling::div[2]//small"));
//        System.out.println("Number of Deutsch articles: " + deutschArticles.getText());
    }
}
