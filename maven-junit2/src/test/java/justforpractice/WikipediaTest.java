package justforpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WikipediaTest {

    @DisplayName("Languages on the right side")
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000);
        List<String> actualLangsRightColumn = new ArrayList<>();
        String langs = "es ja fr zh pt";
        String[] langsArr = langs.split(" ");
        List<String> expectedLangsRightColumn = Arrays.asList(langsArr);

        List<WebElement> allLanguages = driver.findElements(By.xpath("//div[contains(@class,'featured')]"));
        Thread.sleep(2000);
        for (WebElement element: allLanguages) {
            String classAttr = element.getAttribute("class");
            int lastDigit = Integer.parseInt(String.valueOf(classAttr.charAt(classAttr.length()-1)));
            if(lastDigit%2 == 0) {
                actualLangsRightColumn.add(element.getAttribute("lang"));
                Thread.sleep(1000);
            }
        }

        for (int i = 0; i < expectedLangsRightColumn.size(); i++) {
            System.out.println(expectedLangsRightColumn.get(i) + " " + actualLangsRightColumn.get(i));
            assertEquals(expectedLangsRightColumn.get(i),actualLangsRightColumn.get(i));
        }
    }
}
