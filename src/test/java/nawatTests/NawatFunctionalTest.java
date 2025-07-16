package nawatTests;

import java.io.IOException;

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

public class NawatFunctionalTest extends BaseSetup {

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
	
// ********************************For Marketplace UIs********************************

	@Test(priority = 2)
	public void searchIconMarketplace() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		sideMenuBar.marketPlace();
		marketplacePage = new MarketplacePage(driver);
		marketplacePage.searchIconMarketplace();
	}
	
	@Test(priority = 3)
	public void ValidateMarketplaceModuleName() throws InterruptedException {
		marketplacePage = new MarketplacePage(driver);
	//assertion get text Module
			String actual =marketplacePage.ValidateMarketplaceModuleName().trim();
			String expected ="Marketplace";
			System.out.println("Actual value -"+actual);
			System.out.println("Expected value -"+expected);
			Assert.assertEquals(actual, expected);
	 
}
	@Test(priority = 4)
	public void ValidateMarketplaceData() throws InterruptedException {
		marketplacePage = new MarketplacePage(driver);
	//assertion get text Module
			String actual =marketplacePage.ValidateMarketplaceData().trim();
			String expected ="Data Archiving";
			System.out.println("Actual value -"+actual);
			System.out.println("Expected value -"+expected);
			Assert.assertEquals(actual, expected);
	 
}

	@Test(priority = 5)
	public void clickFilterMarketplace() throws InterruptedException {
		marketplacePage = new MarketplacePage(driver);
		marketplacePage.clickFilterMarketplace();
	}

//	***************************************For OU UIs**********************************************
	
	@Test(priority = 6)
	public void validateOrgUnitIconNavigation() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		Thread.sleep(3000);
		sideMenuBar.clickToggle();
		sideMenuBar.clicksideOrgUnit();
		System.out.println("clicked on clicksideOrgUnit");

	}
	
	@Test(priority = 7)
	public void ValidateOUModuleName() throws InterruptedException {
		organizationUnitPage=new OrganizationUnitPage(driver);
		//assertion get text Module
				String actual =organizationUnitPage.ValidateOUModuleName().trim();
				String expected ="Organization units";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 8)
	public void validateOrgUnitColumns() throws InterruptedException {
		organizationUnitPage = new OrganizationUnitPage(driver);
		organizationUnitPage.matchOuColumns();

	}

	@Test(priority = 9)
	public void validateSearchOrgUnitFunctionality() throws InterruptedException, IOException {
		organizationUnitPage = new OrganizationUnitPage(driver);
		organizationUnitPage.searchOrgUnit();
	}
	
	@Test(priority = 10)
	public void ValidateOUSearchData() throws InterruptedException {
		organizationUnitPage=new OrganizationUnitPage(driver);
		//assertion get text Module
				String actual =organizationUnitPage.ValidateOUSearchData().trim();
				String expected ="AutomationOrgUnit";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 11)
	public void clickFilterIconOU() throws InterruptedException {
		organizationUnitPage = new OrganizationUnitPage(driver);
		organizationUnitPage.clickFilterIconOU();
	}
	
	@Test(priority = 12)
	public void ValidateOUFilterData() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		organizationUnitPage=new OrganizationUnitPage(driver);
		
		//assertion get text Module
				String actual =organizationUnitPage.ValidateOUFilterData().trim();
				String expected ="Name = AutomationOrgUnit";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

//   *****************************************For Projects UI********************************************
	
	@Test(priority = 13)
	public void validateProjectIconNavigation() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		sideMenuBar.clickToggle();
		sideMenuBar.clicksideMenuProject();
		System.out.println("clicked on clickside project");

	}
	
	@Test(priority = 14)
	public void ValidateProjectModuleName() throws InterruptedException {
		projectPage=new ProjectPage(driver);
		//assertion get text Module
				String actual =projectPage.ValidateProjectModuleName().trim();
				String expected ="Projects";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -" +expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 15)
	public void validateProjectColumns() throws InterruptedException {
		projectPage = new ProjectPage(driver);
		Thread.sleep(3000);
		projectPage.matchProjectPageColumns();

	}

	@Test(priority = 16)
	public void validateSearchProject() throws InterruptedException, IOException {
		projectPage = new ProjectPage(driver);
		projectPage.searchProject();
	}

	@Test(priority = 17)
	public void ValidateProjectSearchData() throws InterruptedException {
		projectPage=new ProjectPage(driver);
		//assertion get text Module
				String actual =projectPage.ValidateProjectSearchData().trim();
				String expected ="automationProject";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -" +expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 18)
	public void validateFilterByProjectName() throws InterruptedException {
		projectPage = new ProjectPage(driver);
		projectPage.clickFilterIconOnProjectPage();
	}
	
	@Test(priority = 19)
	public void ValidateProjectFilterData() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		projectPage=new ProjectPage(driver);
		//assertion get text Module
				String actual =projectPage.ValidateProjectFilterData().trim();
				String expected ="Name = AutomationProject";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -" + expected);
				Assert.assertEquals(actual, expected);
	}
	
//	***************************************************For Virtual Machine UI*********************************************

	@Test(priority = 20)
	public void searchIcon() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		sideMenuBar.clickToggle();
		sideMenuBar.sideResourecsCompute();
		resourcesVMPage = new ResourcesVMPage(driver);
		sideMenuBar.virtualMachine();
	}

	@Test(priority = 21)
	public void ValidateVMModuleName() throws InterruptedException {
		resourcesVMPage=new ResourcesVMPage(driver);
		//assertion get text Module
				String actual =resourcesVMPage.ValidateVMModuleName().trim();
				String expected ="Virtual machine";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 22)
	public void matchVMPageColumns() throws InterruptedException {	
		resourcesVMPage = new ResourcesVMPage(driver);
		Thread.sleep(3000);
		resourcesVMPage.matchVMPageColumns();
	}
	
	@Test(priority = 23)
	public void searchVM() throws InterruptedException, IOException {	
		resourcesVMPage = new ResourcesVMPage(driver);
		resourcesVMPage.searchVM();
	}
	
	@Test(priority = 24)
	public void ValidateVMSearchData() throws InterruptedException {
		resourcesVMPage=new ResourcesVMPage(driver);
		//assertion get text Module
				String actual =resourcesVMPage.ValidateVMSearchData().trim();
				String expected ="test-access";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 25)
	public void clickFilterIconOnVMPage() throws InterruptedException {
		resourcesVMPage = new ResourcesVMPage(driver);
		resourcesVMPage.clickFilterIconOnVMPage();
	}
	
	@Test(priority = 26)
	public void ValidateVMFilterData() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		resourcesVMPage=new ResourcesVMPage(driver);
		//assertion get text Module
				String actual =resourcesVMPage.ValidateVMFilterData().trim();
				String expected ="Name = test-access";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//	***************************************************For Kubernetes UI*********************************************

	@Test(priority = 27)
	public void searchIconKubernetes() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		resourcesKubernetesPage = new ResourcesKubernetesPage(driver);
	    sideMenuBar.clickToggle();
		sideMenuBar.kubernetes();
	}	
	
	@Test(priority = 28)
	public void ValidateKubernetesModuleName() throws InterruptedException {
		resourcesKubernetesPage=new ResourcesKubernetesPage(driver);
		//assertion get text Module
				String actual =resourcesKubernetesPage.ValidateKubernetesModuleName().trim();
				String expected ="Kubernetes";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 29)
	public void matchKubernetesPageColumns() throws InterruptedException {
		resourcesKubernetesPage = new ResourcesKubernetesPage(driver);
		Thread.sleep(3000);
		resourcesKubernetesPage.matchKubernetesPageColumns();	
	}
	
	@Test(priority = 30)
	public void searchKubernetes() throws InterruptedException, IOException {
		resourcesKubernetesPage = new ResourcesKubernetesPage(driver);
		resourcesKubernetesPage.searchKubernetes();
	}
	
	@Test(priority = 31)
	public void ValidateKubernetesSearchData() throws InterruptedException {
		resourcesKubernetesPage=new ResourcesKubernetesPage(driver);
		//assertion get text Module
				String actual =resourcesKubernetesPage.ValidateKubernetesSearchData().trim();
				String expected ="kubernetes-001";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 32)
	public void clickFilterIconKubernetes() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		resourcesKubernetesPage = new ResourcesKubernetesPage(driver);
		resourcesKubernetesPage.clickFilterIconOnKubernetesPage();
	}
	
	@Test(priority = 33)
	public void ValidateKubernetesFilterData() throws InterruptedException {
		resourcesKubernetesPage=new ResourcesKubernetesPage(driver);
		//assertion get text Module
				String actual =resourcesKubernetesPage.ValidateKubernetesFilterData().trim();
				String expected ="Cluster name = kubernetes-001";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//	***************************************************For Object Storage UI*********************************************

	@Test(priority = 34)
	public void searchIconStorage() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		resourcesObjectStoragePage = new ResourcesObjectStoragePage(driver);
	    sideMenuBar.clickToggle();
		sideMenuBar.sideResourcesStorage();
		sideMenuBar.objectStorage();
	}
	
	@Test(priority = 35)
	public void ValidateObjectStorageModuleName() throws InterruptedException {
		resourcesObjectStoragePage=new ResourcesObjectStoragePage(driver);
		//assertion get text Module
				String actual =resourcesObjectStoragePage.ValidateObjectStorageModuleName().trim();
				String expected ="Object storage";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 36)
	public void matchStoragePageColumns() throws InterruptedException {
		resourcesObjectStoragePage = new ResourcesObjectStoragePage(driver);
		Thread.sleep(3000);
		resourcesObjectStoragePage.matchStoragePageColumns();
	}

	@Test(priority = 37)
	public void searchStorage() throws InterruptedException, IOException {
		resourcesObjectStoragePage = new ResourcesObjectStoragePage(driver);
		resourcesObjectStoragePage.searchStorage();
	}
	
	@Test(priority = 38)
	public void ValidateObjectStorageSearchData() throws InterruptedException {
		resourcesObjectStoragePage=new ResourcesObjectStoragePage(driver);
		//assertion get text Module
				String actual =resourcesObjectStoragePage.ValidateObjectStorageSearchData().trim();
				String expected ="vco01-bucket-001";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 39)
	public void clickFilterIconStorage() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		resourcesObjectStoragePage = new ResourcesObjectStoragePage(driver);
		resourcesObjectStoragePage.clickFilterIconStorage();
	}
	
	@Test(priority = 40)
	public void ValidateObjectStorageFilterData() throws InterruptedException {
		resourcesObjectStoragePage=new ResourcesObjectStoragePage(driver);
		//assertion get text Module
				String actual =resourcesObjectStoragePage.ValidateObjectStorageFilterData().trim();
				String expected ="Name = vco01-bucket-001";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//	***************************************************For SQL UI*********************************************

	@Test(priority = 41)
	public void searchIconSql() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		resourcesSqlPage = new ResourcesSqlPage(driver);
	    sideMenuBar.clickToggle();
		sideMenuBar.sideResourcesDatabase();
		sideMenuBar.sql();
	}

	@Test(priority = 42)
	public void ValidateSqlModuleName() throws InterruptedException {
		resourcesSqlPage=new ResourcesSqlPage(driver);
		//assertion get text Module
				String actual =resourcesSqlPage.ValidateSqlModuleName().trim();
				String expected ="SQL";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 43)
	public void matchSqlPageColumns() throws InterruptedException {
		resourcesSqlPage = new ResourcesSqlPage(driver);
        Thread.sleep(3000);
		resourcesSqlPage.matchSqlPageColumns();
	}

	@Test(priority = 44)
	public void searchSql() throws InterruptedException, IOException {
		resourcesSqlPage = new ResourcesSqlPage(driver);
		resourcesSqlPage.searchSql();
	}
	
	@Test(priority = 45)
	public void ValidateSqlSearchData() throws InterruptedException {
		resourcesSqlPage=new ResourcesSqlPage(driver);
		//assertion get text Module
				String actual =resourcesSqlPage.ValidateSqlSearchData().trim();
				String expected ="vco01-sql-001";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 46)
	public void clickFilterIconSql() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		resourcesSqlPage = new ResourcesSqlPage(driver);
		resourcesSqlPage.clickFilterIconSql();
	}
	
	@Test(priority = 47)
	public void ValidateSqlFilterData() throws InterruptedException {
		resourcesSqlPage=new ResourcesSqlPage(driver);
		//assertion get text Module
				String actual =resourcesSqlPage.ValidateSqlFilterData().trim();
				String expected ="Name = vco01-sql-001";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//	***************************************************For DevToolKit UI*********************************************

	@Test(priority = 48)
	public void validateDevToolKitIconNavigation() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		devToolKitPage=new DevToolKitPage(driver);
		sideMenuBar.clickToggle();
		sideMenuBar.DevToolKitTemplate();
	}
	
	@Test(priority = 49)
	public void ValidateDevtoolkitModuleName() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		//assertion get text Module
				String actual =devToolKitPage.ValidateDevtoolkitModuleName().trim();
				String expected ="Dev toolkit";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

//	***************************************************For DevToolKit(Template) UI*********************************************

	@Test(priority = 50)
	public void searchIconTemplate() throws InterruptedException, IOException {
		 devToolKitPage = new DevToolKitPage(driver);
		 devToolKitPage.searchIconTemplate();
	}
	
	@Test(priority = 51)
	public void ValidateTemplateSearchData() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		//assertion get text Module
				String actual =devToolKitPage.ValidateTemplateSearchData().trim();
				String expected ="Data";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 52)
	public void clickFilterTemplate() throws InterruptedException {
		devToolKitPage = new DevToolKitPage(driver);
		devToolKitPage.clickFilterTemplate();
	}	
		
	@Test(priority = 53)
	public void ValidateTemplateFilterData() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		//assertion get text Module
				String actual =devToolKitPage.ValidateTemplateFilterData().trim();
				String expected ="Name = Data";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

//	***************************************************For DevToolKit(WorkSpace) UI*********************************************

	@Test(priority = 54)
	public void searchIconWorkspace() throws InterruptedException, IOException {
		sideMenuBar.DevToolKitWorkspace();
		devToolKitPage = new DevToolKitPage(driver);
		devToolKitPage.searchIconWorkspace();
	}
	
	@Test(priority = 55)
	public void ValidateWorkspaceSearchData() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		//assertion get text Module
				String actual =devToolKitPage.ValidateWorkspaceSearchData().trim();
				String expected ="workspa-01";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 56)
	public void matchWorkspacePageColumns() throws InterruptedException {
		devToolKitPage = new DevToolKitPage(driver);
		devToolKitPage.matchWorkspacePageColumns();
	}
	
	@Test(priority = 57)
	public void clickFilterIconWorkspace() throws InterruptedException {
		devToolKitPage = new DevToolKitPage(driver);
		devToolKitPage.clickFilterIconWorkspace();
	}	

	@Test(priority = 58)
	public void ValidateWorkspaceFilterData() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		//assertion get text Module
				String actual =devToolKitPage.ValidateWorkspaceFilterData().trim();
				String expected ="Name = workspa-01";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//	***************************************************For DevToolKit(Shared) UI*********************************************

	@Test(priority = 59)
	public void searchIconShared() throws InterruptedException, IOException {
		sideMenuBar.DevToolKitShared();
		devToolKitPage = new DevToolKitPage(driver);
		devToolKitPage.searchIconShared();
	}
	
	@Test(priority = 60)
	public void ValidateSharedSearchData() throws InterruptedException {
		devToolKitPage=new DevToolKitPage(driver);
		//assertion get text Module
				String actual =devToolKitPage.ValidateSharedSearchData().trim();
				String expected ="vs-code-pool";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 61)
	public void matchSharedPageColumns() throws InterruptedException {
		devToolKitPage = new DevToolKitPage(driver);
		devToolKitPage.matchSharedPageColumns();
	}
	
//	***************************************************For Nodepool UI*********************************************

	@Test(priority = 62)
	public void ValidateConfigurationNavigation() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		sideMenuBar.clickToggle();
		sideMenuBar.ConfigurationNodepool();
		configurationPage = new ConfigurationPage(driver);
	} 
	
	@Test(priority = 63)
	public void ValidateConfigurationModuleName() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidateConfigurationModuleName().trim();
				String expected ="Configuration";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 64)
	public void matchNodepoolPageColumns() throws InterruptedException {
		configurationPage = new ConfigurationPage(driver);
        Thread.sleep(3000);
		configurationPage.matchNodepoolPageColumns();
	}

	@Test(priority = 65)
	public void searchNodepool() throws InterruptedException, IOException {
		configurationPage = new ConfigurationPage(driver);
		configurationPage.searchIconNodepool();
	}
	
	@Test(priority = 66)
	public void ValidateNodepoolSearchData() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidateNodepoolSearchData().trim();
				String expected ="gputesitnnfds";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 67)
	public void clickFilterIconNodepool() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		configurationPage = new ConfigurationPage(driver);
		configurationPage.clickFilterIconNodepool();
	}
	
	@Test(priority = 68)
	public void ValidateNodepoolFilterData() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidateNodepoolFilterData().trim();
				String expected ="Name = gputesitnnfds";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//	***************************************************For Associates Buckets UI*********************************************

	@Test(priority = 69)
	public void searchIconAssocaitedBucketPage() throws InterruptedException, IOException {
		sideMenuBar.ConfigurationAssociatedBucket();
		configurationPage = new ConfigurationPage(driver);
		configurationPage.searchIconAssocaitedBucketPage();
	}
	
	@Test(priority = 70)
	public void ValidateAssociatedBucketSearchData() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidateAssociatedBucketSearchData().trim();
				String expected ="vco01-nmj";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
				
	@Test(priority = 71)
	public void matchABPageColumns() throws InterruptedException {
		configurationPage = new ConfigurationPage(driver);
        Thread.sleep(3000);
		configurationPage.matchABPageColumns();
	}

	@Test(priority = 72)
	public void clickFilterIconAssociatedBucket() throws InterruptedException {
		configurationPage = new ConfigurationPage(driver);
		configurationPage.clickFilterIconAssociatedBucket();
	}
	
	@Test(priority = 73)
	public void ValidateAssociatedBucketFilterData() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidateAssociatedBucketFilterData().trim();
				String expected ="Name = vco01-nmj";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//	***************************************************For Secrets UI*********************************************
	
	@Test(priority = 74)
	public void searchIconsecrets() throws InterruptedException, IOException {
		sideMenuBar.ConfigurationSecret();
		configurationPage = new ConfigurationPage(driver);
		configurationPage.searchIconsecrets();
	}
	
	@Test(priority = 75)
	public void ValidateSecretSearchData() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidateSecretSearchData().trim();
				String expected ="wdwd";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 76)
	public void matchSecretsPageColumns() throws InterruptedException {
		configurationPage = new ConfigurationPage(driver);
        Thread.sleep(3000);
		configurationPage.matchSecretsPageColumns();
	}

	@Test(priority = 77)
	public void clickFilterIconSecrets() throws InterruptedException {
		configurationPage = new ConfigurationPage(driver);
		configurationPage.clickFilterIconSecrets();
	}

	@Test(priority = 78)
	public void ValidateSecretFilterData() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidateSecretFilterData().trim();
				String expected ="Name = secret1";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//*****************************************************For Persistent Volumes UI*********************************************

	@Test(priority = 79)
	public void searchIconPersistentVolumes() throws InterruptedException, IOException {
		sideMenuBar.ConfigurationPersistentVolumes();
		configurationPage = new ConfigurationPage(driver);
		configurationPage.searchIconPersistentVolumes();
	}
	
	@Test(priority = 80)
	public void ValidatePersistentVolumesSearchData() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidatePersistentVolumesSearchData().trim();
				String expected ="vco01-wrk-vs-code-pool-pvc";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 81)
	public void matchPersistentVolumnsPageColumns() throws InterruptedException {
		configurationPage = new ConfigurationPage(driver);
		configurationPage.matchPersistentVolumnsPageColumns();
	}

	@Test(priority = 82)
	public void clickFilterIconPersistentVolumes() throws InterruptedException {
		configurationPage = new ConfigurationPage(driver);
		configurationPage.clickFilterIconPersistentVolumes();
	}	
	
	@Test(priority = 83)
	public void ValidatePersistentVolumesFilterData() throws InterruptedException {
		configurationPage=new ConfigurationPage(driver);
		//assertion get text Module
				String actual =configurationPage.ValidatePersistentVolumesFilterData().trim();
				String expected ="Name = vco01-wrk-vs-code-pool-pvc";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

//*****************************************************For Key Management UI*********************************************

	@Test(priority = 84)
	public void searchIconKeyManagement() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		sideMenuBar.clickToggle();
		sideMenuBar.KeyManagement();
		keyManagementPage = new KeyManagementPage(driver);
	}
	
	@Test(priority = 85)
	public void ValidateKeyManagementModuleName() throws InterruptedException {
		keyManagementPage=new KeyManagementPage(driver);
		//assertion get text Module
				String actual =keyManagementPage.ValidateKeyManagementModuleName().trim();
				String expected ="Key management";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 86)
	public void matchKeyManagementPageColumns() throws InterruptedException {
		keyManagementPage = new KeyManagementPage(driver);
        Thread.sleep(3000);
		keyManagementPage.matchKeyManagementPageColumns();
	}

	@Test(priority = 87)
	public void searchKeyManagement() throws InterruptedException, IOException {
		keyManagementPage = new KeyManagementPage(driver);
		keyManagementPage.searchIconKeyManagement();
	}
	
	@Test(priority = 88)
	public void ValidateKeyManagementSearchData() throws InterruptedException {
		keyManagementPage=new KeyManagementPage(driver);
		//assertion get text Module
				String actual =keyManagementPage.ValidateKeyManagementSearchData().trim();
				String expected ="NewSSH-01";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 89)
	public void clickFilterIconKeyManagement() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		keyManagementPage = new KeyManagementPage(driver);
		keyManagementPage.clickFilterIconKeyManagement();
	}
	
	@Test(priority = 90)
	public void ValidateKeyManagementFilterData() throws InterruptedException {
		keyManagementPage=new KeyManagementPage(driver);
		//assertion get text Module
				String actual =keyManagementPage.ValidateKeyManagementFilterData().trim();
				String expected ="Name = NewSSH-01";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//*****************************************************For Audit Actions UI*********************************************

	@Test(priority = 91)
	public void searchIconAuditActions() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		sideMenuBar.clickToggle();
		sideMenuBar.AuditActions();
		auditActionsPage = new AuditActionsPage(driver);
	}
	
	@Test(priority = 92)
	public void ValidateAuditActionsModuleName() throws InterruptedException {
		auditActionsPage=new AuditActionsPage(driver);
		//assertion get text Module
				String actual =auditActionsPage.ValidateAuditActionsModuleName().trim();
				String expected ="Audit actions";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 93)
	public void matchAuditActionsPageColumns() throws InterruptedException {
		auditActionsPage = new AuditActionsPage(driver);
        Thread.sleep(3000);
		auditActionsPage.matchAuditActionsPageColumns();
	}

	@Test(priority = 94)
	public void searchAuditActions() throws InterruptedException, IOException {
		auditActionsPage = new AuditActionsPage(driver);
		auditActionsPage.searchIconAuditActions();
	}
	
	@Test(priority = 95)
	public void ValidateAuditActionsSearchData() throws InterruptedException {
		auditActionsPage=new AuditActionsPage(driver);
		//assertion get text Module
				String actual =auditActionsPage.ValidateAuditActionsSearchData().trim();
				String expected ="company.admin";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 96)
	public void clickFilterIconAuditActions() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		auditActionsPage = new AuditActionsPage(driver);
		auditActionsPage.clickFilterIconAuditActions();
	}
	
	@Test(priority = 97)
	public void ValidateAuditActionsFilterData() throws InterruptedException {
		auditActionsPage=new AuditActionsPage(driver);
		//assertion get text Module
				String actual =auditActionsPage.ValidateAuditActionsFilterData().trim();
				String expected ="Username = Company.admin";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
//*****************************************************For Users UI*********************************************
	
	@Test(priority = 98)
	public void searchUsers() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		usersPage = new UsersPage(driver);
		sideMenuBar.clickToggle();
		sideMenuBar.Users();
		
	}
		@Test(priority = 99)
		public void ValidateUsersModuleName() throws InterruptedException {
			usersPage = new UsersPage(driver);
		//assertion get text Module
				String actual =usersPage.ValidateUsersModuleName().trim();
				String expected ="Users";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
		 
	}

	@Test(priority = 101)
	public void matchUsersPageColumns() throws InterruptedException {
		usersPage = new UsersPage(driver);
        Thread.sleep(3000);
		usersPage.matchUsersPageColumns();
	}
  
	@Test(priority = 102)
	public void searchIconusers() throws InterruptedException, IOException {
		usersPage = new UsersPage(driver);
		usersPage.searchUsers();
		
	}
	
	@Test(priority = 103)
	public void ValidateUsersSearchData() throws InterruptedException {
		usersPage = new UsersPage(driver);
		
		//assertion get text Module
		String actual =usersPage.ValidateUsersSearchData().trim();
		String expected ="neteja";
		System.out.println("Actual value -"+actual);
		System.out.println("Expected value -"+expected);
		Assert.assertEquals(actual, expected);
		
	}

	@Test(priority = 104)
	public void clickFilterIconUsers() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		usersPage = new UsersPage(driver);
		usersPage.clickFilterIconUsers();
	}
	
	@Test(priority = 105)
	public void ValidateUsersFilterData() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		usersPage = new UsersPage(driver);
		
		//assertion get text Module
				String actual =usersPage.ValidateUsersFilterData().trim();
				String expected ="Name = neteja";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
}