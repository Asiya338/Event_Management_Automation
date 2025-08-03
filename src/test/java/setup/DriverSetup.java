package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class DriverSetup {

    private static WebDriver driver;
    private static ConfigReader configReader = new ConfigReader();

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserName = configReader.getBrowserName();

            if (browserName == null || browserName.trim().isEmpty()) {
                throw new RuntimeException("Browser name is not specified in config.properties.");
            }

           try {
                String driverPath = configReader.getDriverPath();
                File driverFile = new File(driverPath);

                if (!driverFile.exists()) {
                    throw new RuntimeException("ChromeDriver executable not found at: " + driverFile.getAbsolutePath());
                }

                //System.setProperty(configReader.getDriverName(), driverPath);
                System.setProperty("webdriver.chrome.driver" , "./chromedriver.exe");
                /*ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");*/

                driver = new ChromeDriver();
            } 
           catch(Exception e) {
                //throw new RuntimeException("Unsupported browser specified in config: " + browserName);
            		e.printStackTrace();
            	}
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
