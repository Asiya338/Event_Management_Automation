package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class WaitUtils 
{
	public static void waitForThreeSeconds(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	}
}
