package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.SeleniumAction;
import utils.ExcelDataReader;
import utils.ExcelReader;

public class ResourcesObjectStoragePage extends SeleniumAction {
	
	protected WebDriver driver;
	// Constructor to initialize elements using the provided WebDriver
	public ResourcesObjectStoragePage(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}
	
//	xpaths for Object Storage
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableStoragePage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconStorage;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//gxtb-preview-template-builder//bntv-gx-ag-grid-header//bntv-search-box//bntv-mat-button//button/span[3]")
	WebElement clickSearchIcon;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIcon;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconStorage;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterName;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButton;
	
	@FindBy(xpath="//div[contains(text(), 'Object storage')]")
	private WebElement ValidateObjectStorageModuleName;
	
	@FindBy(xpath="//span[contains(text(), 'vco01-bucket-001')]")
	WebElement ValidateObjectStorageSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateObjectStorageFilterData;
	
//	Method for Objects
	
	public void matchStoragePageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 4;

		// Getting data from Excel file and saving in expectedList
		List<String> expectedList = new ArrayList<>();
		try {
			expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
		} catch (IOException e) {
			System.err.println("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}

		// Getting data from UI and saving in actualList
		List<String> actualList = new ArrayList<>();
		for (WebElement component : tableStoragePage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌ Object Storage columns do not match.");
	}
	
	public void searchStorage() throws InterruptedException, IOException {

//		searchIconStorage.sendKeys("vco01-bucket-001");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 4); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);
 
		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconStorage);
		searchIconStorage.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconStorage.sendKeys(Keys.ENTER);
		String Text = searchIconStorage.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Storage is " + Text);
		closeSearchIcon.click();
	}
	
   public void clickFilterIconStorage() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconStorage);
		clickFilterIconStorage.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButton.click();
		Thread.sleep(2000);
		filterclickName.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterName.sendKeys("vco01-bucket-001");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButton.click();
		Thread.sleep(2000);	
	}
	
//	Assertion Methods
	
	public String ValidateObjectStorageModuleName() {
		
		waitForElementToBeVisible(ValidateObjectStorageModuleName);
		return ValidateObjectStorageModuleName.getText();
	}
	
   public String ValidateObjectStorageSearchData() {
		
		waitForElementToBeVisible(ValidateObjectStorageSearchData);
		return ValidateObjectStorageSearchData.getText();
	}
   
   public String ValidateObjectStorageFilterData() {
		
		waitForElementToBeVisible(ValidateObjectStorageFilterData);
		return ValidateObjectStorageFilterData.getText();
	}
	
}
