
package UserRoles;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.AOSPage;
import Pages.RandomStringGeneration;
import Pages.SideNavigationMenuPage;
import Pages.UserDomainPage;
import Pages.UserRolePage;
import Pages.loginPage;
import test.BaseTest;
import test.Listeners;
import java.util.Iterator;

public class UserRolesModifyManagerDontAllowUserToExportDataXLS extends BaseTest{
	
	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	AOSPage aos = new AOSPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	Listeners listeners = new Listeners();
	UserRolePage userRole = new UserRolePage(BaseTest.driver);
	
	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	//@Test
	public void userRolesModifyManagerDontAllowUserToExportDataXLS() throws InterruptedException
	{
		driver=initializeDriver6688();

		loginPage.clickLogin("pavana","1");

		sidenavPage.clickSideNavigationBtn();
		sidenavPage.ClickOnUserRoleBtn();
		
		driver.switchTo().frame("contentFrame");
		
		userRole.clickSearchTxtBox("pavManagerTesting");

		userRole.clickModifyBtn();
		
		//userRole.checkallowEmailExportChkBoxIsEnabled();
		
		driver.findElement(By.id("allowExcelExport")).click();
		
		/*if(driver.findElement(By.id("allowExcelExport")).isSelected())
		{
			driver.findElement(By.id("allowExcelExport")).click();
		}*/
		
		userRole.clickOnSaveBtn();
		
		driver=initializeDriver3333();

		loginPage.clickLogin("managerp","1");
		Set<String> url = driver.getWindowHandles();
		System.out.println("the  url is :"+url);
		
		
		userRole.clickOnDrillDownBtn();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator it=handles.iterator();
		String parentwindow=(String) it.next();							
		System.out.print("parent id"+parentwindow);
		String childwindow=(String) it.next();
		System.out.print("child id"+childwindow);
		driver.switchTo().window(childwindow);
		driver.manage().window().maximize();
		userRole.exportexcelBtnToBeDisabled();
		

	}

}
