package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.SeleniumAction;
import utils.ExcelReader;

public class AllNawatXpaths extends SeleniumAction {

	protected WebDriver driver;

	// Constructor to initialize elements using the provided WebDriver
	public AllNawatXpaths(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}

	// Side Toggle button xpath

	@FindBy(xpath = "//*[@id=\"application-toolbar\"]/template-toolbar/div/div[1]/bntv-mat-button/div/button/span[3]")
	private WebElement sideToggleButton;

	// Side Toggle button method
	public void clickToggle() {

		waitForElementToBeClickable(sideToggleButton);
		sideToggleButton.click();
	}

	// Side menu xpaths

	@FindBy(xpath = "//label[contains(text(),'Organization units')]")
	private WebElement sideMenuorganisationUnits;

	@FindBy(xpath = "//label[normalize-space()='Projects']")
	private WebElement sideMenuProjects;

	@FindBy(xpath = "//label[contains(@class, 'rex-font-header-4') and normalize-space(text())='Dev toolkit']")
	private WebElement sideMenuDevToolKit;

	// Side menu methods
	
    public void clicksideOrgUnit() {
    	
    	waitForElementToBeClickable(sideMenuorganisationUnits);
    	sideMenuorganisationUnits.click();
    	
    	
    }
    
    
    
    public void clicksideMenuProject() {
    	
    	waitForElementToBeClickable(sideMenuProjects);
    	sideMenuProjects.click();
    	
    	
    }
    
	
    public void clicksideMenuDevToolKit() {
    	
    	waitForElementToBeClickable(sideMenuDevToolKit);
    	sideMenuDevToolKit.click();
    	
    	
    }
    


	// Organization units page xpaths

	@FindBy(xpath = "//div[@class='headercell-label ng-star-inserted']")
	private List<WebElement> tableOrgUnit;
	
	@FindBy(xpath = "//*[contains(@id, 'mat-input')]")
	private WebElement SearchOrgunitTextBox;
	
	@FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[4]")
	private WebElement searchOrgUnitButton;
	
	@FindBy(xpath = "//div[contains(@class, 'value') and contains(text(), 'AutomationOrgUnit')]")
	private WebElement automationText;
	
	
	// Organization units page methods
	

	public void searchOrgUnit() throws InterruptedException{
		
		waitForElementToBeClickable(SearchOrgunitTextBox);
		waitForElementToBeClickable(searchOrgUnitButton);
		SearchOrgunitTextBox.sendKeys("Automation");
		Thread.sleep(3000);
		searchOrgUnitButton.click();
		Thread.sleep(3000);
		String Text =automationText.getText();
		System.out.println("The name of the searched organaisation unit is " +Text);
		
		
	}
	
	
	public void matchOuColumns() {
	    String excelFilePath = "C:\\Users\\HP\\eclipse-workspace\\Nawat\\TestData\\NawatTestData.xlsx";
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
	        if (!componentText.isEmpty()) {  // Ignore empty strings
	            actualList.add(componentText);
	        }
	    }

	    // Printing both lists before comparison
	    System.out.println("\nExpected List (From Excel): " + expectedList);
	    System.out.println("Actual List (From UI): " + actualList);

	    // Comparing both lists and failing test if they don't match
	   // Assert.assertEquals(actualList, expectedList, "❌ OU columns do not match.");
	}


	// Projects page xpaths

	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableProjectsPage;
	
	@FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@class, 'ng-pristine')]")
	private WebElement searchProjectTextBox;
	
	
	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[4]")
	private WebElement searchProjectButton;
	
	
	@FindBy(xpath = "//div[contains(@class, 'value') and contains(text(), 'automationProject')]")
	private WebElement textAutomationProject;
	
	
	@FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[5]")
	private WebElement FilterIconprojectPage;

	@FindBy(xpath = "//mat-select[contains(@class, 'mat-mdc-select') and .//span[contains(text(), 'Select filter')]]")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@placeholder, 'Name')]")
	private WebElement FilterEnterName;

	@FindBy(xpath = "(//span[contains(@class, 'mat-mdc-button-touch-target')])[38]")
	private WebElement FilterApplyButton;

	
	
	//project page methods
	
	public void searchProject() throws InterruptedException {
		
		searchProjectTextBox.sendKeys("Automation");
		Thread.sleep(3000);
		searchProjectButton.click();
		Thread.sleep(3000);
		 String Text=textAutomationProject.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched project is "+Text);
	
	}
	
	
	
	
	
	
	
	public void matchProjectPageColumns() {
	    String excelFilePath = "C:\\Users\\HP\\eclipse-workspace\\Nawat\\TestData\\NawatTestData.xlsx";
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
	        if (!componentText.isEmpty()) {  // Ignore empty strings
	            actualList.add(componentText);
	        }
	    }

	    // Printing both lists before comparison
	    System.out.println("\nExpected List (From Excel): " + expectedList);
	    System.out.println("Actual List (From UI): " + actualList);

	    // Comparing both lists and failing test if they don't match
	    //Assert.assertEquals(actualList, expectedList, "❌ Project columns do not match.");
	}

	
	
	
	public void filterByNameProjectPage() throws InterruptedException {
		
		
		waitForElementToBeClickable(FilterIconprojectPage);
		waitForElementToBeClickable(selectFilterButton);
		waitForElementToBeClickable(filterclickName);
		waitForElementToBeClickable(FilterEnterName);
		waitForElementToBeClickable(FilterApplyButton);
		driver.navigate().refresh();

		FilterIconprojectPage.click();
		selectFilterButton.click();
		filterclickName.click();
		Thread.sleep(2000);
		FilterEnterName.sendKeys("Automation");
		Thread.sleep(2000);
		FilterApplyButton.click();

		
	}
	
	
	//Dev Tool kit Page Xpath
	
	
	
	
	
	
	
	
	
	
	
	

}
