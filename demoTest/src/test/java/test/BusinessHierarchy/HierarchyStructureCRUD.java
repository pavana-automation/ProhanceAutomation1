package test.BusinessHierarchy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessHierarchy;
import Pages.SideNavigationMenuPage;
import Pages.UsersPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;

public class HierarchyStructureCRUD extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	BusinessHierarchy hierarchy = new BusinessHierarchy(BaseTest.driver);
	Listeners listeners = new Listeners();

	
	@Test
	public void hierarchyStructureCRUD() throws InterruptedException {
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		hierarchy.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on BUSINESS HIERARCHY");
		hierarchy.clickBusinessHierarchy();
		Thread.sleep(1000);
		listeners.testStepDescription("Step 4: Click on HIERARCHY STRUCTURE");
		hierarchy.clickHierarchyStructure();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 5: Click on Add New ");
		hierarchy.clickAddNewBtn();
		listeners.testStepDescription("Step 6: Fill the title");
		hierarchy.clickTitle("automation_1");
		listeners.testStepDescription("Step 7: Fill the description");
		hierarchy.clickDescription("auomation_1 description");
		listeners.testStepDescription("Step 8: Click on Active");
		hierarchy.clickActive();
		listeners.testStepDescription("Step 9: Click on SAVE btn");
		hierarchy.clickSaveBtn();
		listeners.testStepDescription("Step 10: Compare the Add Success message");
		boolean checkAdd = hierarchy.clickAddMsg();
		Assert.assertTrue(checkAdd);
		listeners.testStepDescription("Step 11: Click on Modify");
		hierarchy.clickModify();
		listeners.testStepDescription("Step 12: Fill the description");
		hierarchy.clickDescription("auomation_1 description modiyf");
		listeners.testStepDescription("Step 13: Click on Inactive");
		hierarchy.clickInactive();
		listeners.testStepDescription("Step 14: Click on Save");
		hierarchy.clickSaveBtn();
		listeners.testStepDescription("Step 15: Compare the Modify Success message");
		boolean checkMod = hierarchy.clickModifyMsg();
		Assert.assertTrue(checkMod);
		listeners.testStepDescription("Step 16: Click on Delete icon");
		hierarchy.clickDelete();
		listeners.testStepDescription("Step 17: Click on Yes btn");
		hierarchy.clickYesBtn();
		listeners.testStepDescription("Step 15: Compare the Delete Success message");
		boolean checkDel  = hierarchy.clickDeleteMsg();
		Assert.assertTrue(checkDel);
	}

}
