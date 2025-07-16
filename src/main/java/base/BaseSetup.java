package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import utils.ExtentListener;

@Listeners(ExtentListener.class)

public class BaseSetup {
	public static WebDriver driver;
	public Logger logger = LogManager.getLogger();
	Properties prop = new Properties();

	@BeforeClass
	public void setup() throws InterruptedException {
		try {
			FileInputStream fis = new FileInputStream("src\\main\\resources\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browser = prop.getProperty("browser", "chrome");
		boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless", "false"));

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (isHeadless) {
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
			}
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if (isHeadless) {
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
			}
			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			if (isHeadless) {
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
			}
			driver = new EdgeDriver(options);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
		logger.info("Opened browser and navigated to URL");
		Login();
	}

	public void Login() throws InterruptedException {
		driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath("//*[@name=\"password\"]"))
				.sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
		Thread.sleep(5000);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			driver.quit();
			logger.info("Browser closed");
		}
	}

	// Capture screenshot when test fails
	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			String testCaseName = result.getName();
			captureScreenshot(testCaseName); // Capture screenshot when test case fails
		}
	}

	public void captureScreenshot(String testCaseName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + testCaseName + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
			logger.info("Screenshot captured: " + destination);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Failed to capture screenshot", e);
		}
	}
}
