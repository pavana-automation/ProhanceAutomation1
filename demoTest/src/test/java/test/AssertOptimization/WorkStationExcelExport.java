package test.AssertOptimization;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AssertOptimizationPage.WorkStationGroupsPages;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class WorkStationExcelExport extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> workStartionList = null;
	List<String> workstationExcelList = null;

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void workStationGroups() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver6688();
		 //listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		// listeners.testStepDescription("Step 2: Click on Work Flow");
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		// listeners.testStepDescription("Step 3: Click on Side Navigation bar");
		nav.clickWorkFlowSideNavigationArrow();
		// listeners.testStepDescription("Step 4: Scroll down the navigation");
		workStation.scrollSideNavigationBar();
		 //listeners.testStepDescription("Step 5: Click on Administration tab");
		workStation.clickAdministration();
		// listeners.testStepDescription("Step 6: Click on WorkStationGroups tab");
		workStation.clickWorkStationGroups();
		driver.switchTo().frame("contentFrame");
		workStartionList = workStation.getWorkStationList();
		workStation.clickWorkStationExcel();
		workstationExcelList = excel.getWorkStationExcel();
		boolean check = workStartionList.equals(workstationExcelList);
		System.out.println(check);
		Assert.assertTrue(check);

	}

}
