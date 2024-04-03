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

public class WorkStationwithMissingScanField extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;

	@Test
	public void workStationwithMissingScanField() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver6688();
		 listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		 listeners.testStepDescription("Step 2: Click on Work Flow");
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		 listeners.testStepDescription("Step 3: Click on Side Navigation bar");
		nav.clickWorkFlowSideNavigationArrow();
		 listeners.testStepDescription("Step 4: Scroll down the navigation");
		workStation.scrollSideNavigationBar();
		listeners.testStepDescription("Step 5: Click on Administration tab");
		workStation.clickAdministration();
		listeners.testStepDescription("Step 6: Click on WorkStationGroups tab");
		workStation.clickWorkStationGroups();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 7: Click on Addnew button");
		workStation.clickAddNew();
		listeners.testStepDescription("Step 8: Enter the name ");
		workStation.clickName("Auto_test");
		listeners.testStepDescription("Step 9: Enter the scan time ");
		workStation.clickScanTime("");
		listeners.testStepDescription("Step 10: Click on Save button ");
		workStation.clickSAVEBtn();
		listeners.testStepDescription("Step 11: Compare the Popup message ");
		boolean check  =workStation.clickScanRequiredMsg();
		System.out.println(check);
		Assert.assertTrue(check);
	}

}
