
package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class SeleniumAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumAction.class);
	private static final int DEFAULT_TIMEOUT = 10;
	private static final int PAGE_LOAD_TIMEOUT = 30;
	private static final String PROPERTIES_FILE = "src\\main\\resources\\config.properties";
	private static int timeoutInSeconds;

	protected final WebDriver driver;
	protected final JavascriptExecutor js;
	protected final Actions actions;
	protected final WebDriverWait wait;

	public SeleniumAction(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	}

	static {
		try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
			Properties properties = new Properties();
			properties.load(fis);
			timeoutInSeconds = Integer.parseInt(properties.getProperty("wait", "30"));
			System.out.println("Timeout from properties file is: " + timeoutInSeconds);
		} catch (Exception e) {
			timeoutInSeconds = 30; // Default value if loading fails
			System.err.println("Failed to load timeout from properties file: " + e.getMessage());
		}
	}

	// Navigation Methods
	public void navigateTo(String url) {
		try {
			driver.get(url);
			waitForPageLoad();
			LOGGER.debug("Navigated to URL: {}", url);
		} catch (Exception e) {
			LOGGER.error("Failed to navigate to URL: {}", url, e);
			throw new RuntimeException("Navigation failed: " + e.getMessage());
		}
	}

	// JavaScript Operations
	public void scrollToElement(WebElement element) {
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			LOGGER.debug("Scrolled to element");
		} catch (Exception e) {
			LOGGER.error("Failed to scroll to element", e);
			throw new RuntimeException("Scroll failed: " + e.getMessage());
		}
	}

	public void scrollToBottom() {
		executeJavaScript("window.scrollTo(500, document.body.scrollHeight)");
	}

	public void scrollToTop() {
		executeJavaScript("window.scrollTo(0, 0)");
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
		LOGGER.debug("Switched to default content");
	}

	// Window Operations
	public void switchToNewWindow() {
		try {
			String currentWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			handles.stream().filter(handle -> !handle.equals(currentWindow)).findFirst()
					.ifPresent(handle -> driver.switchTo().window(handle));
			LOGGER.debug("Switched to new window");
		} catch (Exception e) {
			LOGGER.error("Failed to switch to new window", e);
			throw new RuntimeException("Window switch failed: " + e.getMessage());
		}
	}

	// Alert Operations
	public void handleAlert(boolean accept) {
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			if (accept) {
				alert.accept();
				LOGGER.debug("Alert accepted");
			} else {
				alert.dismiss();
				LOGGER.debug("Alert dismissed");
			}
		} catch (Exception e) {
			LOGGER.error("Failed to handle alert", e);
			throw new RuntimeException("Alert handling failed: " + e.getMessage());
		}
	}

	protected void waitForPageLoad() {
		try {
			WebDriverWait pageLoadWait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
			pageLoadWait.until(webDriver -> executeJavaScript("return document.readyState").equals("complete"));
			LOGGER.debug("Page loaded completely");
		} catch (Exception e) {
			LOGGER.error("Page load timeout", e);
			throw new RuntimeException("Page load timeout: " + e.getMessage());
		}
	}

	// Utility Methods
	protected Object executeJavaScript(String script, Object... args) {
		try {
			return js.executeScript(script, args);
		} catch (Exception e) {
			LOGGER.error("Failed to execute JavaScript", e);
			throw new RuntimeException("JavaScript execution failed: " + e.getMessage());
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Custom wait methods1
	public void waitForElementToBeClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("");
			Thread.sleep(4000); // Optional: Consider replacing with explicit waiting for better practice
			System.out.println("Element is clickable: " + element);
		} catch (Exception e) {
			System.out
					.println("Error: Element not clickable within " + timeoutInSeconds + " seconds. " + e.getMessage());
		}
	}

	// Custom wait methods2
	public void waitForElementToBeVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("");
			Thread.sleep(4000); // Optional: Consider replacing with explicit waiting for better practice
			System.out.println("Element is visible: " + element);
		} catch (Exception e) {
			System.out.println("Error: Element not visible within " + timeoutInSeconds + " seconds. " + e.getMessage());
		}
	}

	// Custom wait methods2
	public void waitForVisibilityOfAllElements(List<WebElement> elements) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			System.out.println("");
			Thread.sleep(4000); // Optional: Consider replacing with explicit waiting for better practice
			System.out.println("All elements are visible: " + elements);
		} catch (Exception e) {
			System.out.println("Error: Not all elements became visible within " + timeoutInSeconds + " seconds. "
					+ e.getMessage());
		}
	}
	
	public static void waitForPageToLoad(WebDriver driver) {
        long endTime = System.currentTimeMillis() + (timeoutInSeconds * 1000);
        
        while (System.currentTimeMillis() < endTime) {
            String readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
            if ("complete".equals(readyState)) {
                break;
            }
        }
    }
	public static void scrollDown(WebDriver driver, int pixels) {
        // Cast the WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Execute JavaScript to scroll down the page by the given pixel value
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }
 
}
