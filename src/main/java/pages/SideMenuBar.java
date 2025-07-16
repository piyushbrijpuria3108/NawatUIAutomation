package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.SeleniumAction;

public class SideMenuBar extends SeleniumAction {

	protected WebDriver driver;
	SeleniumAction action;

	// Constructor to initialize elements using the provided WebDriver
	public SideMenuBar(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}

	// Side Toggle button xpath

	@FindBy(xpath = "//*[@id=\"application-toolbar\"]/template-toolbar/div/div[1]/bntv-mat-button/div/button/span[3]")
	private WebElement sideToggleButton;

	// Side menu xpaths
	
	@FindBy(xpath="//label[contains(text(), 'Marketplace')]")
	WebElement marketPlace;

	@FindBy(xpath = "//label[contains(text(),'Organization units')]")
	private WebElement sideMenuorganisationUnits;

	@FindBy(xpath = "//label[normalize-space()='Projects']")
	private WebElement sideMenuProjects;
	
	@FindBy(xpath="//app-root//app-template_cloudsingularity//mat-sidenav-container//mat-sidenav[1]//sidenav-item/div[9]/div[1]/div/div[1]/label")
	WebElement sideResourecsCompute;
	
	@FindBy(xpath="//label[contains(@class, 'rex-font-header-4') and contains(@class, 'overflow-ellipsis') and contains(text(), 'Virtual machines')]")
	WebElement virtualMachine;
	
	@FindBy(xpath="//div[contains(@class, 'sadeNav-menu-item-category')]//label[contains(text(), 'Kubernetes')]")
	WebElement kubernetes;
	
	@FindBy(xpath="//app-root//app-template_cloudsingularity//mat-sidenav-container//mat-sidenav[1]//sidenav-item/div[9]/div[2]/div/div[1]/label")
    WebElement sideResourcesStorage;
	
	@FindBy(xpath="//div[contains(@class, 'sadeNav-menu-item-text')]//label[contains(text(), 'Object storage')]")
	WebElement objectStorage;
	
	@FindBy(xpath="//app-root//app-template_cloudsingularity//mat-sidenav-container//mat-sidenav[1]//sidenav-item/div[9]/div[3]/div/div[1]/label")
	WebElement sideResourcesDatabase;
	
	@FindBy(xpath="//div[contains(@class, 'sadeNav-menu-item-category')]//label[contains(text(), 'SQL')]")
	WebElement sql;
	
	@FindBy(xpath="//label[contains(@class, 'rex-font-header-4') and contains(@class, 'overflow-ellipsis') and contains(text(), 'Configuration')]")
	WebElement ConfigurationNodepool;
	
	@FindBy(xpath="//*[@id[contains(., 'core-tab_Associated_buckets_cmp_cmp-home_home')]]/span")
	WebElement ConfigurationAssociatedBucket;
	
	@FindBy(xpath="//*[@id[contains(., 'core-tab_Secrets_cmp_cmp-home_home')]]/span")
	WebElement ConfigurationSecret;
	
	@FindBy(xpath="//*[@id=\"core-tab_Persistent_volumes_cmp_cmp-home_home\"]/span")
	WebElement ConfigurationPersistentVolumes;
	
	@FindBy(xpath = "//label[contains(@class, 'rex-font-header-4') and normalize-space(text())='Dev toolkit']")
	WebElement DevToolKitTemplate;
	
	@FindBy(xpath= "//*[@id=\"core-tab_My_workspaces_cmp_ai-service_studio-list\"]/span")
	WebElement DevToolKitWorkspace;
	
	@FindBy(xpath="//*[@id=\"core-tab_Shared_with_me_cmp_ai-service_studio-list\"]")
	WebElement DevToolKitShared;

	
	@FindBy(xpath="//app-root//app-template_cloudsingularity//mat-sidenav-container//mat-sidenav[1]//sidenav-item/div[15]/div[1]/div/div[1]/label")
	WebElement KeyManagement;
	
	@FindBy(xpath="//app-root//app-template_cloudsingularity//mat-sidenav-container//mat-sidenav[1]//sidenav-item/div[15]/div[2]/div/div[1]/label")
	WebElement AuditActions;
	
	@FindBy(xpath="//app-root//app-template_cloudsingularity//mat-sidenav-container//mat-sidenav[1]//sidenav-item/div[17]/div/div")
	WebElement Users;
	
	// Side menu methods

	public void clicksideOrgUnit() {

		waitForElementToBeClickable(sideMenuorganisationUnits);
		sideMenuorganisationUnits.click();

	}

	public void clicksideMenuProject() {

		waitForElementToBeClickable(sideMenuProjects);
		sideMenuProjects.click();
	}

	public void clickToggle() {
		// TODO Auto-generated method stub
		waitForElementToBeClickable(sideToggleButton);
		sideToggleButton.click();
	}
	
	public void sideResourecsCompute() {
		// TODO Auto-generated method stub
		waitForElementToBeClickable(sideResourecsCompute);
		sideResourecsCompute.click();
	}
	
	public void virtualMachine() {
		// TODO Auto-generated method stub
		waitForElementToBeClickable(virtualMachine);
		virtualMachine.click();
	}
	
	public void kubernetes() {
		SeleniumAction.scrollDown(driver, 1000);
        waitForElementToBeClickable(kubernetes);
		kubernetes.click();
	}
	
	public void sideResourcesStorage() throws InterruptedException {
		// TODO Auto-generated method stub
		SeleniumAction.scrollDown(driver, 1500);
		waitForElementToBeClickable(sideResourcesStorage);
		sideResourcesStorage.click();
	}
	
	public void objectStorage() {
		// TODO Auto-generated method stub
		waitForElementToBeClickable(objectStorage);
		objectStorage.click();
	}
	
	public void sideResourcesDatabase() throws InterruptedException {
		// TODO Auto-generated method stub
		SeleniumAction.scrollDown(driver, 1800);
		waitForElementToBeClickable(sideResourcesDatabase);
		sideResourcesDatabase.click();
	}
	
	public void sql() {
		// TODO Auto-generated method stub
		waitForElementToBeClickable(sql);
		sql.click();
	}
	
	public void ConfigurationNodepool() {
		waitForElementToBeClickable(ConfigurationNodepool);
		ConfigurationNodepool.click();
	}
	
	public void ConfigurationAssociatedBucket() {
		waitForElementToBeClickable(ConfigurationAssociatedBucket);
		ConfigurationAssociatedBucket.click();
	}
	
	public void ConfigurationSecret() {
		waitForElementToBeClickable(ConfigurationSecret);
		ConfigurationSecret.click();
	}
	
	public void ConfigurationPersistentVolumes() {
		waitForElementToBeClickable(ConfigurationPersistentVolumes);
		ConfigurationPersistentVolumes.click();
	}
	
	public void DevToolKitTemplate() {
		waitForElementToBeClickable(DevToolKitTemplate);
		DevToolKitTemplate.click();
	}
	
	public void DevToolKitWorkspace() {
		waitForElementToBeClickable(DevToolKitWorkspace);
		DevToolKitWorkspace.click();
	}

	public void DevToolKitShared() {
		waitForElementToBeClickable(DevToolKitShared);
		DevToolKitShared.click();
	}
	
	public void marketPlace() {
		waitForElementToBeClickable(marketPlace);
		marketPlace.click();
	}
	
	public void KeyManagement() {
		waitForElementToBeClickable(KeyManagement);
		KeyManagement.click();
	}
	
	public void AuditActions() {
		waitForElementToBeClickable(AuditActions);
		SeleniumAction.scrollDown(driver, 2500);
		AuditActions.click();	
	}
	
	public void Users() {
		waitForElementToBeClickable(Users);
		SeleniumAction.scrollDown(driver, 2500);
		Users.click();	
	}

}
