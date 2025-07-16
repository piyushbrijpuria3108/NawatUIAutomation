package NawatDemoTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import NawatDemoPages.OrganizationUnitPageDemo;
import base.BaseSetup;
import pages.OrganizationUnitPage;
import pages.SideMenuBar;

public class OrganizationUnitTest  extends BaseSetup {

	private SideMenuBar sideMenuBar;
	private OrganizationUnitPageDemo organizationUnitPageDemo;


	@Test(priority = 1)
	public void validateOrgUnitIconNavigation() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		Thread.sleep(3000);
		sideMenuBar.clickToggle();
		sideMenuBar.clicksideOrgUnit();
		System.out.println("clicked on clicksideOrgUnit");
	}
	
	@Test(priority = 2)
	public void ValidateOUModuleName() throws InterruptedException {
		organizationUnitPageDemo=new OrganizationUnitPageDemo(driver);
		//assertion get text Module
				String actual = organizationUnitPageDemo.ValidateOUModuleName().trim();
				String expected ="Organization units";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void validateOrgUnitColumns() throws InterruptedException {
		organizationUnitPageDemo = new OrganizationUnitPageDemo(driver);
		organizationUnitPageDemo.matchOuColumns();

	}

	@Test(priority = 4)
	public void validateSearchOrgUnitFunctionality() throws InterruptedException, IOException {
		organizationUnitPageDemo = new OrganizationUnitPageDemo(driver);
		organizationUnitPageDemo.searchOrgUnit();
	}
	
	@Test(priority = 5)
	public void ValidateOUSearchData() throws InterruptedException {
		organizationUnitPageDemo=new OrganizationUnitPageDemo(driver);
		//assertion get text Module
				String actual = organizationUnitPageDemo.ValidateOUSearchData();
				String expected ="Crist";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 6)
	public void clickFilterIconOU() throws InterruptedException {
		organizationUnitPageDemo = new OrganizationUnitPageDemo(driver);
		organizationUnitPageDemo.clickFilterIconOU();
	}
	
	@Test(priority = 7)
	public void ValidateOUFilterData() throws InterruptedException {
		sideMenuBar = new SideMenuBar(driver);
		organizationUnitPageDemo=new OrganizationUnitPageDemo(driver);
		
		//assertion get text Module
				String actual = organizationUnitPageDemo.ValidateOUFilterData();
				String expected ="Name = Crist";
				System.out.println("Actual value -"+ actual);
				System.out.println("Expected value -"+ expected);
				Assert.assertEquals(actual, expected);
	}

}
