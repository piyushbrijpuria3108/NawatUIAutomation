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

public class HomePage extends SeleniumAction {
	
	protected WebDriver driver;

	    // Constructor to initialize elements using the provided WebDriver
	    public HomePage(WebDriver driver) {
	        super(driver); // Call the parent class constructor
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize PageFactory
	    }
    	     
	    @FindBy(xpath = "//*[@id=\"application-toolbar\"]/template-toolbar/div/div[1]/bntv-mat-button/div/button/span[3]")
	    private WebElement sideToggleButton ;
	    
	    @FindBy(xpath = "//label[contains(text(),'Organization units')]")
	    private WebElement sideMenuorganisationUnits ;
	    
	    public void clickToggle() {
	    	
	    	waitForElementToBeClickable(sideToggleButton);
	    	
	    	sideToggleButton.click();
	    	
	    	
	    }
	    
	    
	    
	    public void clicksideOrgUnit() {
	    	
	    	waitForElementToBeClickable(sideMenuorganisationUnits);
	    	sideMenuorganisationUnits.click();
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    @FindBy(xpath = "//*[@id=\"application-toolbar\"]/template-toolbar/div/div[1]/div/div/bntv-breadcrumb/div/div/div/div/div")
	    private WebElement HomeText ;
	    
	    

	    @FindBy(xpath = "//*[@id=\"marginBottom\"]/div/bntv-card-layout/div/div/div[1]/div[1]/div/span")
	    private WebElement categories ;
	    
	    @FindBy(xpath = "//div[@class='headercell-label ng-star-inserted']")
	    private List<WebElement> tableOrgUnit ;
	    
	    
	    
	    
@SuppressWarnings("unused")
public void matchCloumn() {
	
//	js.executeScript("window.scrollBy(900, 20);");
//	 js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
	
	 List<String> webTexts = new ArrayList<>();
	 
     // Extract text from each element and print it
     for (WebElement element : tableOrgUnit) {
    	 
//         String text = element.getText().trim();
         System.out.println("1 : " +  element.getText());
//         System.out.println("Web Element Text: " + text);
//         webTexts.add(text);
     }
	
	
	
	
	
	
	
	
}






public void fetchAndPrintRuleConfigurationComponents() {
	// Explicit wait to ensure the elements are visible
	//wait.until(ExpectedConditions.visibilityOfAllElements(tableOrgUnit));

	String excelFilePath = "C:\\Users\\HP\\eclipse-workspace\\Nawat\\TestData\\NawatTestData.xlsx";
	int colNum = 1;
	//getting data from excel file and saving in expected list
	
	List<String> expectedList = new ArrayList<>();
	try {
		expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
	} catch (IOException e) {
		e.printStackTrace();
	}

	List<String> actualList = new ArrayList<>();

	// Iterate through the list and print each element's text
	System.out.println("Components of the grid:");
	for (WebElement component : tableOrgUnit) {
		String componentText = component.getText().trim();
		System.out.println("- " + componentText);
	}
	System.out.println("actualList : " + actualList);
	System.out.println("expectedList : " + expectedList);

	if (actualList.equals(expectedList)) {
		System.out.println("ou coloumns match");
	} else {
		System.out.println("ou coloumns do not match");
	}
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












	    
	    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
