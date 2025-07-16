package NawatDemoPages;
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

public class OrganizationUnitPageDemo extends SeleniumAction {

	protected WebDriver driver;

	// Constructor to initialize elements using the provided WebDriver
	public OrganizationUnitPageDemo(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}

	// Organization units page xpaths

	@FindBy(xpath = "//div[@class='headercell-label ng-star-inserted']")
	private List<WebElement> tableOrgUnit;

	@FindBy(xpath = "//*[contains(@id, 'mat-input')]")
	private WebElement SearchOrgunitTextBox;

	@FindBy(xpath = "//div[contains(@class, 'bntv-input-box')]//input")
	private WebElement searchOrgUnitButton;
	
	@FindBy(xpath="/html/body/app-root/app-template/app-template_cloudsingularity/div[1]/div[2]/mat-sidenav-container/mat-sidenav-content/bntv-spa-host/div/div/cmp-root/app-home/bntv-page/div/div/mat-sidenav-container/mat-sidenav-content/div/div/div/gxtb-preview-template-builder/div/div[1]/div/div/gridster/gridster-item/div/list-io/div[1]/bntv-gx-ag-grid/div/bntv-gx-ag-grid-list/div/div/bntv-gx-ag-grid-header/div[1]/div[1]/bntv-search-box/div/div[2]/bntv-mat-button[1]/div/button/span[3]")
	WebElement closeSearchIcon;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconOU;

	@FindBy(xpath = "//div[contains(@class, 'filter')]//bntv-select-box[1]//mat-select")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//mat-option//span[contains(text(), 'Name')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterName;

	@FindBy(xpath = "//*[@id=\"mat-menu-panel-1\"]/div/filter/div/div[3]/bntv-mat-button[2]/div/button/span[4]")
	private WebElement FilterApplyButton;
	
	@FindBy(xpath="//div[contains(text(), 'Organization units')]")
	private WebElement ValidateOUModuleName;
	
	@FindBy(xpath="//div[contains(@class, 'value') and contains(text(), 'Crist')]")
	WebElement ValidateOUSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateOUFilterData;


	// Organization units page methods

	public void searchOrgUnit() throws InterruptedException, IOException {

		waitForElementToBeClickable(SearchOrgunitTextBox);
		waitForElementToBeClickable(searchOrgUnitButton);
		
			String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatSearchTestData.xlsx";
	 
			System.out.println("file : " + excelFilePath);
	 
			// Fetch only the first row from column 1 (0-based index)
			String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 0); // Sheet 0, Column 0, Row 1
	 
			System.out.println("value : " + searchValue);
//	 
			// Find the search box and enter the value from Excel
			waitForElementToBeClickable(SearchOrgunitTextBox);
//			SearchOrgunitTextBox.sendKeys("Crist");
			Thread.sleep(3000);
			searchOrgUnitButton.click();
		    String Text = SearchOrgunitTextBox.getText();
		    Thread.sleep(3000);
		    System.out.println("The name of the searched organization unit is " + Text);
		    closeSearchIcon.click();
	}
	
	public void matchOuColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 0;

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
		for (WebElement component : tableOrgUnit) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);
		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌ OU columns do not match.");
	}
	
	   public void clickFilterIconOU() throws InterruptedException {
			
			waitForElementToBeClickable(clickFilterIconOU);
			clickFilterIconOU.click();
			Thread.sleep(3000);
			System.out.println("clicked on filter icon");
			selectFilterButton.click();
			Thread.sleep(2000);
			filterclickName.click();
			System.out.println("selected name in filter");
			Thread.sleep(2000);
			FilterEnterName.sendKeys("Crist");
			System.out.println("entered text in filter");
			Thread.sleep(2000);
			FilterApplyButton.click();
			Thread.sleep(2000);	
		}
	   
//		Assertion Methods
		
		public String ValidateOUModuleName() {
			
			waitForElementToBeVisible(ValidateOUModuleName);
			return ValidateOUModuleName.getText();
		}
		
	    public String ValidateOUSearchData() {
			
			waitForElementToBeVisible(ValidateOUSearchData);
			return ValidateOUSearchData.getText();
		}
	    
	    public String ValidateOUFilterData() {
			
			waitForElementToBeVisible(ValidateOUFilterData);
			return ValidateOUFilterData.getText();
		}
	}


	
