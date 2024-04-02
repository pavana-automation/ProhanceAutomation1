package test.BusinessHierarchy;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.BusinessHierarchy;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class HierarchyMappingBulkUploadCURD extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	BusinessHierarchy hierarchy = new BusinessHierarchy(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();

	
	@Test
	public void hierarchyMappingBulkUploadCURD() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver6688();
		//listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		//listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		hierarchy.scrollSideNavigationBar();
		//listeners.testStepDescription("Step 3: Click on BUSINESS HIERARCHY");
		hierarchy.clickBusinessHierarchy();
		Thread.sleep(1000);
		//listeners.testStepDescription("Step 3: Click on HIERARCHY STRUCTURE");
		hierarchy.clickHierarchyMapping();
		driver.switchTo().frame("contentFrame");
		hierarchy.clickBulkupload();
		Thread.sleep(1000);
		hierarchy.clickTemplateWithData();
		hierarchy.clickClickHereBtn();
		excel.getHierarchyMappingAddModifyAndDelete();
		hierarchy.clickChooseFileBtn(excel.getRecentFilePath());
	}

}
