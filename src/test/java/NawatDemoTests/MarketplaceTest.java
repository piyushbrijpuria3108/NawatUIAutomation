package NawatDemoTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSetup;
import pages.MarketplacePage;
import pages.SideMenuBar;

public class MarketplaceTest {
	
	
	public class NawatFunctionalTest extends BaseSetup {

		private SideMenuBar sideMenuBar;
		private MarketplacePage marketplacepage;

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
		marketplacepage = new MarketplacePage(driver);
		marketplacepage.searchIconMarketplace();
	}
	
	@Test(priority = 3)
	public void ValidateMarketplaceModuleName() throws InterruptedException {
		marketplacepage = new MarketplacePage(driver);
	//assertion get text Module
			String actual =marketplacepage.ValidateMarketplaceModuleName().trim();
			String expected ="Marketplace";
			System.out.println("Actual value -"+actual);
			System.out.println("Expected value -"+expected);
			Assert.assertEquals(actual, expected);
	 
}
	@Test(priority = 4)
	public void ValidateMarketplaceData() throws InterruptedException {
		marketplacepage = new MarketplacePage(driver);
	//assertion get text Module
			String actual =marketplacepage.ValidateMarketplaceData().trim();
			String expected ="Object 1-P";
			System.out.println("Actual value -"+actual);
			System.out.println("Expected value -"+expected);
			Assert.assertEquals(actual, expected);
	 
}

	@Test(priority = 5)
	public void clickFilterMarketplace() throws InterruptedException {
		marketplacepage = new MarketplacePage(driver);
		marketplacepage.clickFilterMarketplace();
	}

	}
}