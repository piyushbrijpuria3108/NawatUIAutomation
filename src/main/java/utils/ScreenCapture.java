package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture {
	/**
	 * Captures a screenshot of the current browser window
	 * 
	 * @param driver   WebDriver instance
	 * @param filePath Path where the screenshot should be saved
	 * @throws IOException if there's an error saving the screenshot
	 */
	public static void captureScreenshot(WebDriver driver, String filePath) throws IOException {
		if (driver == null) {
			throw new IllegalArgumentException("WebDriver cannot be null");
		}
		if (filePath == null || filePath.trim().isEmpty()) {
			throw new IllegalArgumentException("File path cannot be null or empty");
		}

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(filePath));
	}
}
