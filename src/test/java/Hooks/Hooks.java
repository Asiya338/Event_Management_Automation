package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import setup.DriverSetup;
import utils.ScreenshotUtil;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverSetup.getDriver();
        driver.manage().window().maximize();
        System.out.println(">>> Setup: Browser is initialized");
    }

    
    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario)
    {
    		if(scenario.isFailed())
    		{
    			String scenarioName = scenario.getName().replaceAll(" " , "_");
    			ScreenshotUtil.captureScreenshot(driver, scenarioName);
    		}
    }
    
    
    @After
    public void tearDown() {
        DriverSetup.quitDriver();
        System.out.println(">>> Teardown: Browser is closed");
    }
}

