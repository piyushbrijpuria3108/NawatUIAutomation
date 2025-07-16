package base;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.SeleniumAction;

public class NavigateToApplication extends SeleniumAction {

	WebDriver driver;
	WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(NavigateToApplication.class);

	// Constructor to initialize elements and WebDriverWait
	public NavigateToApplication(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 10-second wait
		PageFactory.initElements(driver, this);
		log.info("NavigateToApplication initialized");
		System.out.println("NavigateToApplication initialized");
	}

	// Side Menu Icon
	@FindBy(xpath = "//img[contains(@class, 'menu-image')]")
	private WebElement sideMenuIcon;

	// Search Icon
	@FindBy(xpath = "//em[contains(@class, 'icon-menu-config')]")
	private WebElement searchIcon;

	// Search Box
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBox;

	// Search Result
	@FindBy(xpath = "//span[contains(@class, 'grouping-advance-custom-label')]")
	private WebElement searchResult;
	@FindBy(xpath = "//span[@class='db_cardheading header-title']")
	List<WebElement> getList;

	// Combined method to perform all actions
	public void navigateToApplication(String searchText) throws InterruptedException {
		// Click the side menu icon
		waitForElementToBeClickable(sideMenuIcon);
		sideMenuIcon.click();
		log.info("Clicked on Side Menu Icon");
		System.out.println("Clicked on Side Menu Icon");

		// Click the search icon
		waitForElementToBeClickable(searchIcon);
		searchIcon.click();
		log.info("Clicked on Search Icon");
		System.out.println("Clicked on Search Icon");

		// Enter text in the search box
		waitForElementToBeClickable(searchBox);
		searchBox.sendKeys(searchText);
		log.info("Entered text in Search Box: " + searchText);
		System.out.println("Entered text in Search Box: " + searchText);
		
		// Click the search result
		waitForElementToBeClickable(searchResult);
		searchResult.click();
		log.info("Clicked on Search Result");
		System.out.println("Clicked on Search Result");
	}
}
