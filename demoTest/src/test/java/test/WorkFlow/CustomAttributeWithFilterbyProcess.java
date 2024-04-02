package test.WorkFlow;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.loginPage;
import WorkFlowPage.CustomAttributeBulkUploadPages;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class CustomAttributeWithFilterbyProcess extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	CustomAttributeBulkUploadPages custom = new CustomAttributeBulkUploadPages(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> processList = null;
	List<String> processExcelList = null;

	@Test
	public void customAttributeWithDuplicateName() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver6688();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
		listeners.testStepDescription("Step 2: Click on Work Flow");
		custom.clickWorkFlowBtn();
		Thread.sleep(1000);
		custom.switchTabs();
		listeners.testStepDescription("Step 3: Click on Side Navigation bar");
		nav.clickWorkFlowSideNavigationArrow();
		listeners.testStepDescription("Step 4: Scroll down the navigation");
		custom.scrollSideNavigationBar();
		listeners.testStepDescription("Step 5: Click on Administartion ");
		custom.clickAdministrationBtn();
		Thread.sleep(1000);
		listeners.testStepDescription("Step 6: Click on Custom Attribute");
		custom.clickCustomAttribute();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 7: Click on Filte By Process and select some process");
		custom.selectFilterByProcess("###Process_01");
		listeners.testStepDescription("Step 8: Get the process list from web");
		processList = custom.GetUserArrtribute();
		listeners.testStepDescription("Step 9: Click on Bulk Upload");
		custom.clickBulkUpload();
		listeners.testStepDescription("Step 10: Click on Template with existing Custom Attributes");
		custom.clickTempWithData();
		listeners.testStepDescription("Step 11: Click on Click here btn");
		custom.clickClickHereBtn();
		listeners.testStepDescription("Step 12: Get custom attribute list from excel");
		processExcelList = excel.getFilterByProcess();
		listeners.testStepDescription("Step 13:Compare the process list from web and excel both are same or not");
		for (int i = 0; i < processList.size(); i++) {
			String data = processList.get(i);
			
			boolean check =processExcelList.contains(data);
			Assert.assertTrue(check);
		}
		
}

}
