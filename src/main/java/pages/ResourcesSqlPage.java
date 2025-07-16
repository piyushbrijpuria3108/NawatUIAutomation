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

public class ResourcesSqlPage extends SeleniumAction {
	
	protected WebDriver driver;
	// Constructor to initialize elements using the provided WebDriver
	public ResourcesSqlPage(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}
	
//	xpaths for SQLs
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableSqlPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconSql;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIcon;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIcon;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconSql;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterName;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButton;
	
	@FindBy(xpath="//div[contains(text(), 'SQL')]")
	private WebElement ValidateSqlModuleName;
	
	@FindBy(xpath="//span[contains(text(), 'vco01-sql-001')]")
	WebElement ValidateSqlSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateSqlFilterData;
	
//	Method for SQLs
	
	public void matchSqlPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 5;

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
		for (WebElement component : tableSqlPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		 Assert.assertEquals(actualList, expectedList, "❌ Sql columns do not match.");
	}
	
	public void searchSql() throws InterruptedException, IOException {

//		searchIconSql.sendKeys("vco01-sql-001");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 5); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);
		
		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconSql);
		searchIconSql.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconSql.sendKeys(Keys.ENTER);
		String Text = searchIconSql.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched SQL is " + Text);
		closeSearchIcon.click();
		
	}
	
   public void clickFilterIconSql() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconSql);
		clickFilterIconSql.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButton.click();
		Thread.sleep(2000);
		filterclickName.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterName.sendKeys("vco01-sql-001");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButton.click();
		Thread.sleep(2000);	
	}
	
//	Assertion Methods
	
	public String ValidateSqlModuleName() {
		
		waitForElementToBeVisible(ValidateSqlModuleName);
		return ValidateSqlModuleName.getText();
	}
	
  public String ValidateSqlSearchData() {
		
		waitForElementToBeVisible(ValidateSqlSearchData);
		return ValidateSqlSearchData.getText();
	}
  
  public String ValidateSqlFilterData() {
		
		waitForElementToBeVisible(ValidateSqlFilterData);
		return ValidateSqlFilterData.getText();
	}
	
}
