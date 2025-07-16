package nawatTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseSetup;
import pages.AuditActionsPage;
import pages.ConfigurationPage;
import pages.DevToolKitPage;
import pages.KeyManagementPage;
import pages.MarketplacePage;
import pages.OrganizationUnitPage;
import pages.ProjectPage;
import pages.ResourcesKubernetesPage;
import pages.ResourcesObjectStoragePage;
import pages.ResourcesSqlPage;
import pages.ResourcesVMPage;
import pages.SideMenuBar;
import pages.UsersPage;

public class NawatScenariosTest extends BaseSetup {

	private SideMenuBar sideMenuBar;
	private OrganizationUnitPage organizationUnitPage;
	private ProjectPage projectPage;
	private DevToolKitPage devToolKitPage;
	private ConfigurationPage configurationPage;
	private ResourcesVMPage resourcesVMPage;
	private ResourcesKubernetesPage resourcesKubernetesPage;
	private ResourcesObjectStoragePage resourcesObjectStoragePage;
	private ResourcesSqlPage resourcesSqlPage;
	private MarketplacePage marketplacePage;
	private KeyManagementPage keyManagementPage;
	private AuditActionsPage auditActionsPage;
	private UsersPage usersPage;
	
	@Test(priority = 1)
	public void validateHomePage() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		Thread.sleep(3000);
		sideMenuBar.clickToggle();
		System.out.println("clicked on toggle");
	}
//	***************************************For Dev Toolkit UIs**********************************************
 
	@Test(priority = 2)
	public void validateDevToolKitIconNavigation() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		devToolKitPage=new DevToolKitPage(driver);
//		sideMenuBar.clickToggle();
		sideMenuBar.DevToolKitTemplate();	
	}
	
	@Test(priority = 3)
	public void ValidateTempKababMenuClick() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		devToolKitPage.ValidateTempKababMenuClick();	
		Thread.sleep(3000);
		devToolKitPage.ViewOptionClick();

	}
	
	@Test(priority = 4)	
	public void ValidateViewOption() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		boolean view = devToolKitPage.ViewOptionClick();
		Assert.assertTrue(view, "View is not displayed.");

		//assertion get text Module
//		String actual =devToolKitPage.ValidateViewOption().trim();
//		String expected ="View";
//		System.out.println("Actual value -"+ actual);
//		System.out.println("Expected value -"+ expected);
//		Assert.assertEquals(actual, expected);
	}	
	
	@Test(priority = 5)
	public void ValidateEditOption() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		devToolKitPage.EditOptionClick();
		//assertion get text Module
		String actual =devToolKitPage.ValidateEditOption().trim();
		String expected ="Edit";
		System.out.println("Actual value -"+ actual);
		System.out.println("Expected value -"+ expected);
		Assert.assertEquals(actual, expected);
	}
//	
//	@Test(priority = 6)
//	public void ValidateDeleteOption() throws InterruptedException {
//		devToolKitPage=new DevToolKitPage(driver);
//		//assertion get text Module
//		String actual =devToolKitPage.ValidateDeleteOption().trim();
//		String expected ="Are you sure you want to delete this template?";
//		System.out.println("Actual value -"+ actual);
//		System.out.println("Expected value -"+ expected);
//		Assert.assertEquals(actual, expected);
//	}
	
}
