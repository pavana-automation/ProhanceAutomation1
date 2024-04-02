package test;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.UsersPage;
import Pages.loginPage;
import utilities.ReadXLSdata;

public class UsersLoggedinUsersByDotNetVersion extends BaseTest{

	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	UsersPage users = new UsersPage(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	Set<String> getLicence = null;
	Set<String> getexcelLicence = null;
	
	@Test
	public void usersLoggedinUsersByDotNetVersion () throws InterruptedException, EncryptedDocumentException, IOException {
		driver = initializeDriver3333();
		// listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		 //listeners.testStepDescription("Step 2: Click on SideNavigationMenuBar");
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		 //listeners.testStepDescription("Step 3: Click on USERS");
		users.clickUsersBtn();
		// listeners.testStepDescription("Step 4: Click on Users");
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		 //listeners.testStepDescription("Step 5: Click on MORE ACTIONS");
		users.clickMOREACTIONBtn();
		users.clickLoggedUsers();
		users.clickDashboardVies();
		users.clickClientFilter();
		users.selectSlientByActivity("By Dot Net Version");
		users.clickFetchBtn();
		users.clickDotnet();
		users.getByHearbeat();
		users.clickByHeartbeatexcel();
		
	}

}
