package test.WorkOutput;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AssertOptimizationPage.SoftwareDefinitionPage;
import AssertOptimizationPage.WorkStationGroupsPages;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import WorkOutput.WorkOutputPages;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class WorkTypeDefinitionBulkuploadCRUD extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	WorkOutputPages workOutput = new WorkOutputPages(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;

	
	@Test
	public void softwareDefinitationClear() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver6688();
		 //listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		// listeners.testStepDescription("Step 2: Click on Work Flow");
		workOutput.clickWorkOutput();
		Thread.sleep(1000);
		workOutput.switchTabs();
		workOutput.clickWorkOutputSideNavigationBar();
		workOutput.clickAdministration();
		workOutput.clickWorkTypeDefinition();
		driver.switchTo().frame("contentFrame");
		workOutput.clickBulkUpload();
		workOutput.clickWithPrefilledData();
		workOutput.clickClickHereBtn();
		
	}

}
