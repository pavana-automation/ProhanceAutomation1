package test.BusinessHierarchy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessHierarchy;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class HierarchyStructureClear extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	BusinessHierarchy hierarchy = new BusinessHierarchy(BaseTest.driver);
	Listeners listeners = new Listeners();

	
	@Test
	public void hierarchyStructureClear() throws InterruptedException {
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		hierarchy.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on BUSINESS HIERARCHY");
		hierarchy.clickBusinessHierarchy();
		Thread.sleep(1000);
		listeners.testStepDescription("Step 3: Click on HIERARCHY STRUCTURE");
		hierarchy.clickHierarchyStructure();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 3: Click on modify");
		hierarchy.clickModifyForClear();
		listeners.testStepDescription("Step 3: Click on Clear btn");
		hierarchy.clickClear();
		
	}


}
