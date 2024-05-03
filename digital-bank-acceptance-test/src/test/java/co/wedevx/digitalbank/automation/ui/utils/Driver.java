package co.wedevx.digitalbank.automation.ui.utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver(){

    }

    public static WebDriver getDriver(){
        if (driver == null) {
            String browser = ConfigReader.getPropertiesValue("digitalbank.browser");
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "headless":
                    ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("disable-extensions");
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("--proxy-server='direct://'");
                    options.addArguments("--proxy-bypass-list=*");
                    options.addArguments("--start-maximized");
                    options.addArguments("--headless");
                    driver=new ChromeDriver(options);
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            //taking screenshot
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            //adding screenshots to report
            scenario.attach(screenshot,"image/png", "screenshot");
            saveScreenshotToFile(screenshot);
        }
    }

    private static void saveScreenshotToFile(byte[] screenshot) {
        String pattern = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        // Use SimpleDateFormat class, create a variable dateFormat with date format needed instead of this comment
        // Below code line will use the variable created above to convert the date into String
        String timestamp = dateFormat.format(new Date());

        // Replace SCREENSHOT_DIRECTORY with desired folder to keep screenshots in
        String Screenshot_Directory = "src/test/resources/Screenshot_Directory";;
        String fileName = Screenshot_Directory + File.separator + "screenshot_" + timestamp + ".png";
        Path filePath = Paths.get(fileName);

        // Below code saves the screenshot as file if the format is correct
        try {
            Files.write(filePath, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}
