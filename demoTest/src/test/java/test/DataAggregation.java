
package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Pages.DataAggregationPage;
import Pages.SideNavigationMenuPage;
import Pages.loginPage;

public class DataAggregation extends BaseTest {

	WebDriver driver;
	loginPage loginPage = new loginPage(BaseTest.driver);

	SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);

	DataAggregationPage aggregation = new DataAggregationPage(BaseTest.driver);
	Listeners listeners = new Listeners();

	@Test(retryAnalyzer = Pages.RetryAnalyzer.class)
	public void aggregationForSingleType() throws InterruptedException, StaleElementReferenceException {
		driver = initializeDriver3333();
		listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("adminaish_1", "1");
		listeners.testStepDescription("Step 2: Open Side NavigationMenuBar");
		nav.clickSideNavigationBtn();
		listeners.testStepDescription("Step 3: Open Data Aggregation");
		nav.clickDataAggregationBtn();
		
		driver.switchTo().frame("contentFrame");
		aggregation.clickMonthArrow();
		listeners.testStepDescription("Step 4: Select particular date");
		aggregation.clickDateChkBoxChkBox();
		listeners.testStepDescription("Step 5: Select anyone type of aggregation ");
		aggregation.clickTypeChkBox();
		listeners.testStepDescription("Step 6: Click aggregation for all users");
		aggregation.clickAggregationForAllUsers();
		listeners.testStepDescription("Step 7: Click RUN Button");
		aggregation.clickRunAggregation();
		listeners.testStepDescription("Step 8: Go to Audit Logs page");
		aggregation.clickAuditLogBtn();
		listeners.testStepDescription("Step 9:Click Fetch Button");
		aggregation.clickFetchBtn();
		
		listeners.testStepDescription("Step 10: Check starting and completeing of aggregation");
		
		aggregation.getAggregationStarted();
		
		listeners.testStepDescription("Step 11: Aggregation for Single Date and Single Type Completed Sucessfully");
	}

}

