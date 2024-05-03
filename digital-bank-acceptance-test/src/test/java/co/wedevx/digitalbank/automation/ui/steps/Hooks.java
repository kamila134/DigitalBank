package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import co.wedevx.digitalbank.automation.ui.utils.DBUtils;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.*;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;

public class Hooks {

    @BeforeAll
    public static void establishConnectionToDB(){
        DBUtils.establishSQLConnection();
    }

    @Before
    public void beforeEach(){
        DBUtils.establishSQLConnection();
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank.registration.url"));
    }

    @Before("@Login")
    public void beforeLogin(){
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank.login.url"));
    }

    @After
    public void afterEachCloseDriver(Scenario scenario){
        Driver.takeScreenshot(scenario);
        Driver.closeDriver();
    }

    @AfterAll
    public static void closeConnectionToDB(){
        DBUtils.closeConnection();
    }


}
