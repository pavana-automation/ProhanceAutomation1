package test.Users;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.UsersPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class UsersBulkUploadForInactiveUsers extends BaseTest {
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	UsersPage users = new UsersPage(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();

	@Test
	public void bulkUploadforInactiveUsers() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		listeners.testStepDescription("Step 3: Click on USERS");
		users.clickUsersBtn();
		listeners.testStepDescription("Step 4: Click on Users");
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		listeners.testStepDescription("Step 5: Click on MORE ACTIONS");
		users.clickMOREACTIONBtn();
		listeners.testStepDescription("Step 6: Click on Bulk Upload");
		users.clickBulkUploadBtn();
		listeners.testStepDescription("Step 7: Click on Inactive Users");
		users.selectTemplateDropDown("Inactive Users");
		listeners.testStepDescription("Step 8: Click on OR condition");
		users.selectUserConditione("OR");
		listeners.testStepDescription("Step 9: Click on Blocked Users");
		users.selectUserStatus("Blocked Users");
		listeners.testStepDescription("Step 10: Click on Click Here button");
		users.clickHereBtn();
		listeners.testStepDescription("Step 9: Fill the excel for ADD,MODIFy nad DELETE");
		excel.getInactiveUsers();
		listeners.testStepDescription("Step 10: Click on upload");
		// Thread.sleep(4000);
		users.clickChooseFileForInactiveBtn(excel.getRecentFilePath());
		boolean check = users.getMsg();
		Assert.assertTrue(check);

	}
	

}
