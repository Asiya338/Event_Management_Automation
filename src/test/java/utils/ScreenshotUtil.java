package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private static final String SCREENSHOTS_DIR = System.getProperty("user.dir") + "/screenshots/";

    public static void captureScreenshot(WebDriver driver, String scenarioName)
    {
        createScreenshotsDirectory();   
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = scenarioName + "_"+ timestamp +".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(SCREENSHOTS_DIR + fileName);

        try {
            Files.copy(screenshotFile.toPath(), destinationFile.toPath());
            System.out.println("Screenshot captured: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    private static void createScreenshotsDirectory() {
        File directory = new File(SCREENSHOTS_DIR);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
