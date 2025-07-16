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

public class ResourcesKubernetesPage extends SeleniumAction {
	
	protected WebDriver driver;
	// Constructor to initialize elements using the provided WebDriver
	public ResourcesKubernetesPage(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}

//	xpaths for Kubernetes
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableKubernetesPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconKubernetes;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//gxtb-preview-template-builder//bntv-gx-ag-grid-header//bntv-search-box//bntv-mat-button//button/span[3]")
	WebElement clickSearchIcon;
	
	@FindBy(xpath="//*[@id=\"appCont\"]//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIcon;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconKubernetes;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(@class, 'ng-star-inserted') and contains(text(), 'Cluster name')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//input[@placeholder='Cluster name']")
	private WebElement FilterEnterName;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButton;
	
	@FindBy(xpath="//div[contains(text(), 'Kubernetes')]")
	private WebElement ValidateKubernetesModuleName;
	
	@FindBy(xpath="//span[contains(text(), 'kubernetes-001')]")
	WebElement ValidateKubernetesSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateKubernetesFilterData;
	
//	Method for Kubernetes
	public void matchKubernetesPageColumns() {
		String excelFilePath = "C:\\Users\\B-Mac-0002\\eclipse-workspace\\Nawat\\TestData\\NawatColumnTestData.xlsx";
		int colNum = 3;

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
		for (WebElement component : tableKubernetesPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌ Kubernetes columns do not match.");
	}
	
	public void searchKubernetes() throws InterruptedException, IOException {

//		searchIconKubernetes.sendKeys("kubernetes-001");
		String excelFilePath = ".\\src\\main\\resources\\ExcelFile\\NawatSearchTestData.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 3); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);
 
		// Find the search box and enter the value from Excel

	    Thread.sleep(3000);
	    waitForElementToBeClickable(searchIconKubernetes);
	    searchIconKubernetes.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconKubernetes.sendKeys(Keys.ENTER);
		String Text = searchIconKubernetes.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Kubernetes is " + Text);
		closeSearchIcon.click();
	}
	
	public void clickFilterIconOnKubernetesPage() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconKubernetes);
		clickFilterIconKubernetes.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButton.click();
		Thread.sleep(2000);
		filterclickName.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterName.sendKeys("kubernetes-001");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButton.click();
		Thread.sleep(2000);
		
	}
	
//	Assertion Methods
	
	public String ValidateKubernetesModuleName() {
		
		waitForElementToBeVisible(ValidateKubernetesModuleName);
		return ValidateKubernetesModuleName.getText();
	}
	
    public String ValidateKubernetesSearchData() {
		
		waitForElementToBeVisible(ValidateKubernetesSearchData);
		return ValidateKubernetesSearchData.getText();
	}
    
    public String ValidateKubernetesFilterData() {
		
		waitForElementToBeVisible(ValidateKubernetesFilterData);
		return ValidateKubernetesFilterData.getText();
	}
	
}
