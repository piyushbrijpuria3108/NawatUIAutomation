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

public class AuditActionsPage extends SeleniumAction {
	
	protected WebDriver driver;
	// Constructor to initialize elements using the provided WebDriver
	public AuditActionsPage(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}
	
//	xpaths for Audit Actions
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableAuditActionsPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by username']")
	WebElement searchIconAuditActions;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[2]//button/span[3]")
	WebElement clickSearchIcon;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIcon;
	
	@FindBy(xpath="//*[@id[contains(., 'core-gx-ag-grid-header-filter-button_cmp_cmp-home_home')]]/div/button/span[3]")
	WebElement clickFilterIconAuditActions;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and contains(text(), 'Username')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//span[contains(@class, 'mat-mdc-select-placeholder') and contains(text(), 'Select username')]")
	private WebElement FilterEnterName;
	
	@FindBy(xpath="//*[@id[contains(., 'mat-option-')]]/span/ngx-mat-select-search/div/input")
	WebElement FilterSearch;
	
	@FindBy(xpath="//span[contains(@class, 'ng-star-inserted') and contains(text(), 'Company.admin')]")
	WebElement FilterSelectValue;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButton;
	
	@FindBy(xpath="//div[contains(text(), 'Audit actions')]")
	private WebElement ValidateAuditActionsModuleName;
	
	@FindBy(xpath="//*[@id=\"appCont\"]/cmp-root/app-home/bntv-page/div/div/mat-sidenav-container/mat-sidenav-content/div/div/div/gxtb-preview-template-builder/div/div[1]/div/list-io/div[1]/bntv-gx-ag-grid/div/bntv-gx-ag-grid-list/div/ag-grid-angular/div/div[2]/div[2]/div[3]/div[1]/div/div[2]/div/div/div[1]/div[2]/div")
	WebElement ValidateAuditActionsSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateAuditActionsFilterData;
	
//	Method for Key Management
	
	public void matchAuditActionsPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 13;

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
		for (WebElement component : tableAuditActionsPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌ Audit Actions columns do not match.");
	}
	
	public void searchIconAuditActions() throws InterruptedException, IOException {

//		searchIconAuditActions.sendKeys("company");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 14); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);

		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconAuditActions);
		searchIconAuditActions.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconAuditActions.sendKeys(Keys.ENTER);
		String Text = searchIconAuditActions.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched User Name is " + Text);
		closeSearchIcon.click();
	}
	
	public void clickFilterIconAuditActions() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconAuditActions);
		clickFilterIconAuditActions.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButton.click();
		Thread.sleep(2000);
		filterclickName.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterName.click();
		FilterSearch.sendKeys("company.admin");
		System.out.println("entered text in filter");
		FilterSelectValue.click();
		Thread.sleep(2000);
		FilterApplyButton.click();
		Thread.sleep(2000);
		
	}
	
//	Assertion Methods for Audit Actions page
	
	public String ValidateAuditActionsModuleName() {
		
		waitForElementToBeVisible(ValidateAuditActionsModuleName);
		return ValidateAuditActionsModuleName.getText();
	}
	
  public String ValidateAuditActionsSearchData() {
		
		waitForElementToBeVisible(ValidateAuditActionsSearchData);
		return ValidateAuditActionsSearchData.getText();
	}
  
  public String ValidateAuditActionsFilterData() {
		
		waitForElementToBeVisible(ValidateAuditActionsFilterData);
		return ValidateAuditActionsFilterData.getText();
	}
}
