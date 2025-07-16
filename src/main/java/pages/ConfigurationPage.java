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

public class ConfigurationPage extends SeleniumAction {
	
	protected WebDriver driver;

	// Constructor to initialize elements using the provided WebDriver
	public ConfigurationPage(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}
	
//	xpaths for Nodepools
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableNodepoolPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconNodepool;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIcon;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIcon;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconNodepool;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterName;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButton;

	@FindBy(xpath="//div[contains(text(), 'Configuration')]")
	private WebElement ValidateConfigurationModuleName;
	
	@FindBy(xpath="//div[text()=' gputesitnnfds ']")
	WebElement ValidateNodepoolSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateNodepoolFilterData;
	
//	Method for Nodepools
	
	public void matchNodepoolPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 8;

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
		for (WebElement component : tableNodepoolPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
	       Assert.assertEquals(actualList, expectedList, "❌ Nodepool columns do not match.");
	}
	
	public void searchIconNodepool() throws InterruptedException, IOException {

//		searchIconNodepool.sendKeys("gpu");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 9); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);
		
		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconNodepool);
		searchIconNodepool.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconNodepool.sendKeys(Keys.ENTER);
		String Text = searchIconNodepool.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Nodepools is " + Text);
		closeSearchIcon.click();
		
	}
	
   public void clickFilterIconNodepool() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconNodepool);
		clickFilterIconNodepool.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButton.click();
		Thread.sleep(2000);
		filterclickName.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterName.sendKeys("gputesitnnfds");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButton.click();
		Thread.sleep(2000);	
		
	}

//	xpaths for Associated Buckets
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableAssociatedBucketPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconAssocaitedBucketPage;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIconAssociatedBucket;
	
	@FindBy(xpath="//gridster-item//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIconAssociatedBucket;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconAssociatedBucket;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButtonAssociatedBucket;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickNameAssociatedBucket;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterNameAssociatedBucket;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButtonAssociatedBucket;
	
	@FindBy(xpath="//span[contains(text(), 'vco01-nmj')]")
	WebElement ValidateAssociatedBucketSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateAssociatedBucketFilterData;
	
//	Method for Associated Buckets
	
	public void matchABPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 9;

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
		for (WebElement component : tableAssociatedBucketPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		 Assert.assertEquals(actualList, expectedList, "❌ Associated Buckets columns do not match.");
	}
	
	public void searchIconAssocaitedBucketPage() throws InterruptedException, IOException {

//		searchIconAssocaitedBucketPage.sendKeys("vco01");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 10); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);
		
		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconAssocaitedBucketPage);
		searchIconAssocaitedBucketPage.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconAssocaitedBucketPage.sendKeys(Keys.ENTER);
		String Text = searchIconAssocaitedBucketPage.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Associated Bucket is " + Text);
		closeSearchIconAssociatedBucket.click();
		
	}
	
    public void clickFilterIconAssociatedBucket() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconAssociatedBucket);
		clickFilterIconAssociatedBucket.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButtonAssociatedBucket.click();
		Thread.sleep(2000);
		filterclickNameAssociatedBucket.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterNameAssociatedBucket.sendKeys("vco01-nmj");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButtonAssociatedBucket.click();
		Thread.sleep(2000);	
		
	}
	
//	xpaths for Secrets
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableSecretsPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconsecrets;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIconSecrets;
	
	@FindBy(xpath="//gridster-item//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIconSecrets;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconSecrets;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButtonSecrets;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickNameSecrets;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterNameSecrets;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButtonSecrets;
	
	@FindBy(xpath="//div[contains(text(), 'wdwd')]")
	WebElement ValidateSecretSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateSecretFilterData;
	
//	Method for Secrets
	
	public void matchSecretsPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 10;

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
		for (WebElement component : tableSecretsPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌ Secret columns do not match.");
	}
	
	public void searchIconsecrets() throws InterruptedException, IOException {

//		searchIconsecrets.sendKeys("wdwd");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 11); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);

		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconsecrets);
		searchIconsecrets.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconsecrets.sendKeys(Keys.ENTER);
		String Text = searchIconsecrets.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Secrets is " + Text);
		closeSearchIconSecrets.click();
		
	}
	
    public void clickFilterIconSecrets() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconSecrets);
		clickFilterIconSecrets.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButtonSecrets.click();
		Thread.sleep(2000);
		filterclickNameSecrets.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterNameSecrets.sendKeys("secret1");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButtonSecrets.click();
		Thread.sleep(2000);	
		
	}
 
//	xpaths for Persistent Volumes
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tablePersistentVolumesPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconPersistentVolumes;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIconPersistentVolumes;
	
	@FindBy(xpath="//gridster-item//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIconPersistentVolumes;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconPersistentVolumes;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButtonPersistentVolumes;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickNamePersistentVolumes;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterNamePersistentVolumes;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButtonPersistentVolumes;
	
	@FindBy(xpath="//div[contains(text(), 'vco01-wrk-vs-code-pool-pvc')]")
	WebElement ValidatePersistentVolumesSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidatePersistentVolumesFilterData;
	
//	Method for Persistent Volumes
	
	public void matchPersistentVolumnsPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 11;

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
		for (WebElement component : tablePersistentVolumesPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌  Persistent Volumes columns do not match.");
	}
	
	public void searchIconPersistentVolumes() throws InterruptedException, IOException {

//		searchIconPersistentVolumes.sendKeys("code");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 12); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);

		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconPersistentVolumes);
		searchIconPersistentVolumes.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconPersistentVolumes.sendKeys(Keys.ENTER);
		String Text = searchIconPersistentVolumes.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Secrets is " + Text);
		closeSearchIconPersistentVolumes.click();
		
	}
	
    public void clickFilterIconPersistentVolumes() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconPersistentVolumes);
		clickFilterIconPersistentVolumes.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButtonPersistentVolumes.click();
		Thread.sleep(2000);
		filterclickNamePersistentVolumes.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterNamePersistentVolumes.sendKeys("vco01-wrk-vs-code-pool-pvc");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButtonPersistentVolumes.click();
		Thread.sleep(2000);	
		
	}
    
//	Assertion Methods for Nodepool page
	
	public String ValidateConfigurationModuleName() {
		
		waitForElementToBeVisible(ValidateConfigurationModuleName);
		return ValidateConfigurationModuleName.getText();
	}
	
  public String ValidateNodepoolSearchData() {
		
		waitForElementToBeVisible(ValidateNodepoolSearchData);
		return ValidateNodepoolSearchData.getText();
	}
  
  public String ValidateNodepoolFilterData() {
		
		waitForElementToBeVisible(ValidateNodepoolFilterData);
		return ValidateNodepoolFilterData.getText();
	}
  
//	Assertion Methods for Associated Bucket page
  
  public String ValidateAssociatedBucketSearchData() {
		
		waitForElementToBeVisible(ValidateAssociatedBucketSearchData);
		return ValidateAssociatedBucketSearchData.getText();
	}
  
  public String ValidateAssociatedBucketFilterData() {
		
		waitForElementToBeVisible(ValidateAssociatedBucketFilterData);
		return ValidateAssociatedBucketFilterData.getText();
	}
  
//	Assertion Methods for Secret page

  public String ValidateSecretSearchData() {
		
		waitForElementToBeVisible(ValidateSecretSearchData);
		return ValidateSecretSearchData.getText();
	}

  public String ValidateSecretFilterData() {
		
		waitForElementToBeVisible(ValidateSecretFilterData);
		return ValidateSecretFilterData.getText();
	}
  
//	Assertion Methods for Persistent Volumes page

public String ValidatePersistentVolumesSearchData() {
		
		waitForElementToBeVisible(ValidatePersistentVolumesSearchData);
		return ValidatePersistentVolumesSearchData.getText();
	}

public String ValidatePersistentVolumesFilterData() {
		
		waitForElementToBeVisible(ValidatePersistentVolumesFilterData);
		return ValidatePersistentVolumesFilterData.getText();
	}
}
