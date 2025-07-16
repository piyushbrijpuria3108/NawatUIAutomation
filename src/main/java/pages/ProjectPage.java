 package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.SeleniumAction;
import utils.ExcelDataReader;
import utils.ExcelReader;

public class ProjectPage extends SeleniumAction {

	protected WebDriver driver;

	// Constructor to initialize elements using the provided WebDriver
	public ProjectPage(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}

	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableProjectsPage;

	@FindBy(xpath = "//input[@placeholder='Search by project name']")
	private WebElement searchProjectTextBox;

	@FindBy(xpath = "//div[contains(@id, 'appCont')]//bntv-search-box//bntv-mat-button//button/span[3]")
	private WebElement searchProjectButton;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIcon;

	@FindBy(xpath = "//*[@id='core-gx-ag-grid-header-filter-button_cmp_cmp-home_home']/div/button/span[3]")
	private WebElement FilterIconprojectPage;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(text(), 'Name')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//input[@type='text' and @placeholder='Name']")
	private WebElement FilterEnterName;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButton;
	
	@FindBy(xpath="//div[contains(text(), 'Projects')]")
	private WebElement ValidateProjectModuleName;
	
	@FindBy(xpath="//div[contains(text(), 'automationProject')]")
	WebElement ValidateProjectSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateProjectFilterData;

	// project page methods

	public void searchProject() throws InterruptedException, IOException {
 
		waitForElementToBeClickable(searchProjectTextBox);
		waitForElementToBeClickable(searchProjectButton);
//		searchProjectTextBox.sendKeys("automationProject");
		 
			String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
	 
			System.out.println("file : " + excelFilePath);
	 
			// Fetch only the first row from column 1 (0-based index)
			String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 1); // Sheet 0, Column 0, Row 1
	 
			System.out.println("value : " + searchValue);
	 
			// Find the search box and enter the value from Excel
	
		Thread.sleep(3000);
		waitForElementToBeClickable(searchProjectTextBox);
		searchProjectTextBox.sendKeys(searchValue);
		Thread.sleep(3000);
		searchProjectButton.click();
		String Text = searchProjectTextBox.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched project is " + Text);
		closeSearchIcon.click();

	}

	public void matchProjectPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 1;

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
		for (WebElement component : tableProjectsPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		 Assert.assertEquals(actualList, expectedList, "❌ Project columns do not match.");
	}
	
	
	public void clickFilterIconOnProjectPage() throws InterruptedException {
		
		waitForElementToBeClickable(FilterIconprojectPage);
		FilterIconprojectPage.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButton.click();
		Thread.sleep(2000);
		filterclickName.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterName.sendKeys("AutomationProject");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButton.click();
		Thread.sleep(2000);		
	}
	
//	Assertion Methods
	
	public String ValidateProjectModuleName() {
		
		waitForElementToBeVisible(ValidateProjectModuleName);
		return ValidateProjectModuleName.getText();
	}
	
    public String ValidateProjectSearchData() {
		
		waitForElementToBeVisible(ValidateProjectSearchData);
		return ValidateProjectSearchData.getText();
	}
    
    public String ValidateProjectFilterData() {
		
		waitForElementToBeVisible(ValidateProjectFilterData);
		return ValidateProjectFilterData.getText();
	}
 
}
