package test.BusinessHierarchy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessHierarchy;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class HierarchyStructureCompareWithAdvancesAnalytics extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	BusinessHierarchy hierarchy = new BusinessHierarchy(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> activeList = new ArrayList();
	List<String> activeListFromAdvance = new ArrayList();
	
	@Test
	public void hierarchyStructureCompareWithAdvancesAnalytics() throws InterruptedException {
		driver = initializeDriver6688();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		hierarchy.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on BUSINESS HIERARCHY");
		hierarchy.clickBusinessHierarchy();
		Thread.sleep(1000);
		listeners.testStepDescription("Step 4: Click on HIERARCHY STRUCTURE");
		hierarchy.clickHierarchyStructure();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 5: Get the active list ");
		activeList = hierarchy.getHierarchyActiveList();
		driver.switchTo().defaultContent();
		listeners.testStepDescription("Step 6: Click on ADVANCE ANALYTICS");
		hierarchy.clickanalytics();
		Thread.sleep(1000);
		hierarchy.switchTabs();
		listeners.testStepDescription("Step 7: Click on Side NavigationBar");
		nav.clickAdvanceSideNavigationArrow();
		listeners.testStepDescription("Step 8: Click on BUSINESS HIERARCHY in Work Trends");
		hierarchy.clickAdvancePageHierarchy();
		listeners.testStepDescription("Step 10: Get the hierarchy list");
		activeListFromAdvance = hierarchy.getAdvanceHierarchyList();
		listeners.testStepDescription("Step 11: Compare list from Business hierarchy abd list Advanced analytics page are same");
		boolean check = activeList.equals(activeListFromAdvance);
		System.out.println(check);
		Assert.assertTrue(check);
	}

}
