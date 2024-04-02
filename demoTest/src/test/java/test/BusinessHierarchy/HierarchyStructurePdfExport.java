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

public class HierarchyStructurePdfExport extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	BusinessHierarchy hierarchy = new BusinessHierarchy(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> hierarchList = new ArrayList();
	List<String> hierarchExcelList = new ArrayList();
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);

	
	@Test
	public void hierarchyStructurePdfExport() throws InterruptedException, EncryptedDocumentException, IOException {
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
		listeners.testStepDescription("Step 5: Click on Pdf export");
		hierarchy.clickPdfExport();
		listeners.testStepDescription("Step 4: Get the list from pdf");
		String actualPdfList = excel.gethierarchyPDF();
		listeners.testStepDescription("Step 18: Compare the list from web and pdf are equal");
		for (int i = 0; i < hierarchList.size(); i++) {
			String data = hierarchList.get(i);
			boolean checkPdf = actualPdfList.contains(data);
			Assert.assertTrue(checkPdf);
		}
	}

}
