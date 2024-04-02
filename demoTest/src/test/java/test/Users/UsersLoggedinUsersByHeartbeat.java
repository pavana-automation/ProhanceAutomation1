package test.Users;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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

public class UsersLoggedinUsersByHeartbeat extends BaseTest {
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	UsersPage users = new UsersPage(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;

	@Test
	public void usersLoggedinUsersByHeartbeat() throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver6688();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish", "1");
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
		listeners.testStepDescription("Step 6: Click on SHOW LOGGEDIN USER");
		users.clickLoggedUsers();
		listeners.testStepDescription("Step 7: Click on DASHBOARD VIEW");
		users.clickDashboardVies();
		listeners.testStepDescription("Step 8: Click on FILTER button");
		users.clickClientFilter();
		listeners.testStepDescription("Step 9: Select By Heartbeat");
		users.selectSlientByActivity("By Heartbeat");
		listeners.testStepDescription("Step 10: Click on FETCH button");
		users.clickFetchBtn();
		listeners.testStepDescription("Step 11: Click on count drill down");
		users.clickCount();
		listeners.testStepDescription("Step 12: Get list from web");
		hostNameList = users.getByHearbeat();
		listeners.testStepDescription("Step 13:Click on excel export");
		users.clickByHeartbeatexcel();
		listeners.testStepDescription("Step 14: Get list from Excel");
		hostNameExcelList = excel.getByHearBeatEcxel();
		listeners.testStepDescription("Step 15: Compare the list from web and excel are equal");
		boolean check = hostNameList.equals(hostNameExcelList);
		// System.out.println(check);
		Assert.assertTrue(check);
		listeners.testStepDescription("Step 16: Click on PDf export");
		users.clickbyHeartbeatPdf();
		listeners.testStepDescription("Step 17: Get list from pdf");
		String actualPdfList = excel.getHostNameListPDFData();
		listeners.testStepDescription("Step 18: Compare the list from web and pdf are equal");
		for (int i = 0; i < hostNameList.size(); i++) {
			String data = hostNameList.get(i);
			System.out.println("the value is :" + data);
			boolean checkPdf = actualPdfList.contains(data);
			Assert.assertTrue(checkPdf);
		}
	}
	
	

}
