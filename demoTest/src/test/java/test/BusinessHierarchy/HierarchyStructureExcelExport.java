package test.BusinessHierarchy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessHierarchy;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class HierarchyStructureExcelExport extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	BusinessHierarchy hierarchy = new BusinessHierarchy(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> hierarchList = new ArrayList();
	List<String> hierarchExcelList = new ArrayList();
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);

	
	@Test
	public void hierarchyStructureExcelExport() throws InterruptedException, EncryptedDocumentException, IOException {
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
		listeners.testStepDescription("Step 4: Get the list from web");
		hierarchList = hierarchy.getHierarchyList();
		listeners.testStepDescription("Step 5: Click on Excel export");
		hierarchy.clickExcelExport();
		listeners.testStepDescription("Step 6: Get the list from excel");
		hierarchExcelList = excel.getHierarchyExcel();
		listeners.testStepDescription("Step 7: Compare the list from web and excel are same");
		boolean check = hierarchList.equals(hierarchExcelList);
		System.out.println(check);
		Assert.assertTrue(check);
	}

}
