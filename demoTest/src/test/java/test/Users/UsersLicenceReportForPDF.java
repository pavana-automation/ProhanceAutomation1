package test.Users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SideNavigationMenuPage;
import Pages.UsersPage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import utilities.ReadXLSdata;

public class UsersLicenceReportForPDF extends BaseTest{
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
	UsersPage users = new UsersPage(BaseTest.driver);
	ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
	Listeners listeners = new Listeners();
	List<String> getLicence = null;
	Set<String> getexcelLicence = null;
	
	@Test
	public void usersLicenceReportForPDF() throws InterruptedException, EncryptedDocumentException, IOException {
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
		users.clickLicencereport();
		getLicence = users.getLicenceListForPDF();
		users.clickLicencePdfImg();
		String pdfList = excel.getLicenceListPDFData();
		for(int i=0;i<getLicence.size();i++)
	    {
	    	String data = getLicence.get(i);
	    	System.out.println("the value is :" +getLicence.get(i));
	    	Assert.assertTrue(pdfList.contains(data));
	    }
	}

}
