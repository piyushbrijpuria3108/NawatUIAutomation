package NawatDemoPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.SeleniumAction;

public class MarketplacePage extends SeleniumAction {

	protected WebDriver driver;

	// Constructor to initialize elements using the provided WebDriver
	public MarketplacePage(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}	
	
//  xpaths for MarketPlace
	
	@FindBy(xpath= "//*[@id=\"mat-input-0\"]")
	WebElement searchIconMarketplace;
	
	@FindBy(xpath="//input[@placeholder='Search for offerings...']")
	WebElement clickSearchIconMarketplace;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//custom-marketplace-home//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIconMarketplace;
	
	@FindBy(xpath="//button[contains(@class, 'mat-mdc-icon-button') and contains(@class, 'hide-text')]")
	WebElement clickFilterMarketplace;

	@FindBy(xpath = "//div[@class='mdc-notched-outline__leading']")
	private WebElement filterClickValue;
	
	@FindBy(xpath = "//mat-option[contains(@id, 'mat-option-')][1]")
	private WebElement FilterEnterName;

	@FindBy(xpath = "//*[@id=\"mat-menu-panel-0\"]/div/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButton;
	
	@FindBy(xpath="//div[contains(@class, 'text-ellipsis') and contains(text(), 'Marketplace')]")
	WebElement ValidateMarketplaceModuleName;
	
	@FindBy(xpath="//div[contains(@id, 'appCont')]//mat-sidenav-content//div[2]/div[2]/div/div[2]/div[1]/div[2]/div[1]")
	WebElement ValidateMarketplaceData;

//	Method for Marketplace
	
	public void searchIconMarketplace() throws InterruptedException {

		searchIconMarketplace.sendKeys("data");
		Thread.sleep(3000);
		searchIconMarketplace.sendKeys(Keys.ENTER);
		String Text = searchIconMarketplace.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Value is " + Text);
		closeSearchIconMarketplace.click();
		
	}
	
   public void clickFilterMarketplace() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterMarketplace);
		clickFilterMarketplace.click();
		System.out.println("clicked on filter icon");
		filterClickValue.click();
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterEnterName.click();
		System.out.println("selected name in filter");
		FilterApplyButton.click();
		Thread.sleep(2000);	
		
	}
   
//	Assertion Methods
   
   public String ValidateMarketplaceModuleName() {
		
		waitForElementToBeVisible(ValidateMarketplaceModuleName);
		return ValidateMarketplaceModuleName.getText();
	}
   
   public String ValidateMarketplaceData() {
		
		waitForElementToBeVisible(ValidateMarketplaceData);
		return ValidateMarketplaceData.getText();
	}
}
