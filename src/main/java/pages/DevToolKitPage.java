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

public class DevToolKitPage extends SeleniumAction {

	protected WebDriver driver;

	// Constructor to initialize elements using the provided WebDriver
	public DevToolKitPage(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}	
	
//   xpaths for Template
	
	@FindBy(xpath= "//input[@placeholder='Search']")
	WebElement searchIconTemplate;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIconTem;
	
	@FindBy(xpath="//*[@id[contains(., 'mat-tab-content-')]]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIcontemp;
	
	@FindBy(xpath="//*[@id[contains(., 'core-gx-ag-grid-header-filter-button_cmp_ai-service_studio-list')]]/div/button/span[3]")
	WebElement clickFilterTemplate;

	@FindBy(xpath = "//span[text()='Select filter']")
	WebElement selectFilterButtonTemp;

	@FindBy(xpath = "//mat-option[contains(@class, 'mat-mdc-option')]//span[contains(text(), 'Name')]")
	 WebElement filterclickNameTemp;

	@FindBy(xpath ="//span[contains(@class, 'mat-mdc-select-placeholder') and contains(text(), 'Name')]")
	 WebElement FilterEnterNameTemp;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-star-inserted') and contains(text(), 'Template')])[3]")
	private WebElement FilterClick;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	 WebElement FilterApplyButtonTemp;
	
	@FindBy(xpath="//div[contains(text(), 'Dev toolkit')]")
	private WebElement ValidateDevtoolkitModuleName;
	
	@FindBy(xpath="//div[contains(@class, 'card-title') and contains(text(), 'Data')]")
	WebElement ValidateTemplateSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateTemplateFilterData;
	
//	Xpath for kabab Menus
	
	@FindBy(xpath="//bntv-tile-view-list-item[1]//bntv-icon/mat-icon")
	WebElement ValidateTempKababMenuClick;
	
	@FindBy(xpath="//span[contains(text(), 'View')]")
	WebElement ViewOptionClick;
	
	@FindBy(xpath="//div[contains(text(), 'View')]")
	WebElement ValidateViewOption;
	
	@FindBy(xpath="(//span[contains(@class, 'mat-mdc-button-touch-target')])[10]")
	WebElement CloseViewPage;
	
	@FindBy(xpath="//span[contains(text(), 'Edit')]")
	WebElement EditOptionClick;
	
	@FindBy(xpath="//div[contains(text(), 'Edit')]")
	WebElement ValidateEditOption;
	
	@FindBy(xpath="//span[contains(text(), 'Delete')]")
	WebElement DeleteOptionClick;
	
	@FindBy(xpath="//span[contains(text(), 'Are you sure you want to delete this template?')]")
	WebElement ValidateDeleteOption;
	
//	Method for Template
	
	public void searchIconTemplate() throws InterruptedException, IOException {

//		searchIconTemplate.sendKeys("Data");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 6); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);

		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconTemplate);
		searchIconTemplate.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconTemplate.sendKeys(Keys.ENTER);
		String Text = searchIconTemplate.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Template is " + Text);
		closeSearchIcontemp.click();
		
	}
	
   public void clickFilterTemplate() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterTemplate);
		clickFilterTemplate.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButtonTemp.click();
		Thread.sleep(2000);
		filterclickNameTemp.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterNameTemp.click();
		System.out.println("entered text in filter");
		FilterClick.click();
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButtonTemp.click();
		Thread.sleep(2000);	
		
	}
   
   public void ValidateTempKababMenuClick() throws InterruptedException {
		Thread.sleep(3000);
	   ValidateTempKababMenuClick.click();
	}
   
   public boolean ViewOptionClick() throws InterruptedException {
	   waitForElementToBeClickable(ViewOptionClick);
	   ViewOptionClick.click();
      boolean view = CloseViewPage.isDisplayed();
      return view;
 	}
   
   public void EditOptionClick() throws InterruptedException {
		CloseViewPage.click();
		ValidateTempKababMenuClick.click();
	   waitForElementToBeClickable(EditOptionClick);
	   EditOptionClick.click();
	   ValidateEditOption.getText();
 		Thread.sleep(5000);
		CloseViewPage.click();
		ValidateTempKababMenuClick.click();
 	}
   
   public void DeleteOptionClick() throws InterruptedException {
	   waitForElementToBeClickable(DeleteOptionClick);
	   DeleteOptionClick.click();
	   ValidateDeleteOption.getText();
 		Thread.sleep(5000);
		CloseViewPage.click();
 	}
  

//	xpaths for Workspace UI
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableWorkspacePage;
	
	@FindBy(xpath= "//input[@placeholder='Search']")
	WebElement searchIconWorkspace;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIcon;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIcon;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_ai-service_studio-list\"]/div/button/span[3]")
	WebElement clickFilterIconWorkspace;

	@FindBy(xpath = "//span[text()='Select filter']")
	 WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	 WebElement filterclickName;

	@FindBy(xpath = "//input[@placeholder='Name']")
	 WebElement FilterEnterName;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	 WebElement FilterApplyButton;
	
	@FindBy(xpath="//div[text()=' workspa-01 ']")
	WebElement ValidateWorkspaceSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateWorkspaceFilterData;
	
//	Method for Workspace
	
	public void matchWorkspacePageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 6;

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
		for (WebElement component : tableWorkspacePage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌ My Workspace columns do not match.");
	}
	
	public void searchIconWorkspace() throws InterruptedException, IOException {

//		searchIconWorkspace.sendKeys("workspa-01");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 7); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);
		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconWorkspace);
		searchIconWorkspace.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconWorkspace.sendKeys(Keys.ENTER);
		String Text = searchIconWorkspace.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Workspace is " + Text);
		closeSearchIcon.click();
		
	}
	
   public void clickFilterIconWorkspace() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconWorkspace);
		clickFilterIconWorkspace.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButton.click();
		Thread.sleep(2000);
		filterclickName.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterName.sendKeys("workspa-01");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButton.click();
		Thread.sleep(2000);	
		
	}
	
//	xpaths for Shared With Me UI
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableSharedPage;
	
	@FindBy(xpath= "//input[@placeholder='Search']")
	WebElement searchIconShared;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIconShared;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIconShared;
		
	@FindBy(xpath="//div[text()=' vs-code-pool ']")
	WebElement ValidateSharedSearchData;
	
//	Method for Shared With Me
	
	public void matchSharedPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 7;

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
		for (WebElement component : tableSharedPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌ Shared With Me columns do not match.");
	}
	
	public void searchIconShared() throws InterruptedException, IOException {

//		searchIconShared.sendKeys("vs-code-pool");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 8); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);
		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconShared);
		searchIconShared.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconShared.sendKeys(Keys.ENTER);
		String Text = searchIconShared.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Workspace is " + Text);
		closeSearchIcon.click();
		
	}
	
//	Assertion Methods for Template page
	
	public String ValidateDevtoolkitModuleName() {	
		waitForElementToBeVisible(ValidateDevtoolkitModuleName);
		return ValidateDevtoolkitModuleName.getText();
	}
	
    public String ValidateTemplateSearchData() {	
		waitForElementToBeVisible(ValidateTemplateSearchData);
		return ValidateTemplateSearchData.getText();
	}
  
    public String ValidateTemplateFilterData() {
		waitForElementToBeVisible(ValidateTemplateFilterData);
		return ValidateTemplateFilterData.getText();
	}
  
    public String ValidateViewOption() {
		waitForElementToBeVisible(ValidateViewOption);
		return ValidateViewOption.getText();
	}
    
    public String ValidateEditOption() {
		waitForElementToBeVisible(ValidateEditOption);
		return ValidateEditOption.getText();
	}
  
    public String ValidateDeleteOption() {
		waitForElementToBeVisible(ValidateDeleteOption);
		return ValidateDeleteOption.getText();
	}
  

//	Assertion Methods for My Workspace page

    public String ValidateWorkspaceSearchData() {
		
		waitForElementToBeVisible(ValidateWorkspaceSearchData);
		return ValidateWorkspaceSearchData.getText();
	}
  
    public String ValidateWorkspaceFilterData() {
		waitForElementToBeVisible(ValidateWorkspaceFilterData);
		return ValidateWorkspaceFilterData.getText();
	}
  
//	Assertion Methods for Shared With me page

    public String ValidateSharedSearchData() {
		waitForElementToBeVisible(ValidateSharedSearchData);
		return ValidateSharedSearchData.getText();
	}

}
