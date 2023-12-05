package Pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideNavigationMenuPage {
	
	WebDriver driver;
	@FindBy(id = "arrow-top")
	WebElement sideNavigationBtn;
	
	@FindBy(xpath= "//a[contains(text(),'Organization')]")
	WebElement organizationBtn;
	
	@FindBy(xpath = "//li[contains(text(),'Data Aggregation')]")
	WebElement dataAggregationBtn;
	
	@FindBy(xpath ="//ul[@id='menu-content']/li[2]/a/span")
	WebElement closeOrganizationTab;
	
	@FindBy(xpath = "//li[contains(text(),'User Domain')]")
	WebElement userDomainBtn;
	

	@FindBy(xpath = "//a[contains(text(),'Activities')]")
	WebElement activitiesBtn;
	
	@FindBy(xpath="//li[contains(text(),'Activities On System')]")
	WebElement aosBtn;
	
	@FindBy(xpath="//div[@class='slimScrollBar']")
	public
	WebElement locator;
	
	 public SideNavigationMenuPage(WebDriver driver)
	    {
	 
	        this.driver=driver;
	        PageFactory.initElements(driver,this); 
	             
	}
	@FindBy(xpath ="//a[contains(text(),'Activities')]")
	WebElement activityTab;
	
	@FindBy(xpath ="//li[contains(text(),'Work Profiles')]")
	WebElement workProfilesTab;
	/*
	 * public SideNavigationMenuPage(WebDriver driver) {
	 * 
	 * this.driver=driver; PageFactory.initElements(driver,this);
	 * 
	 * }
	 */

	
	public void clickSideNavigationBtn()
	{
		this.sideNavigationBtn.click();
	}
	
	public void clickorganizationBtn()
	{
		this.organizationBtn.click();
	}
	
	public void clickDataAggregationBtn()
	{
		this.dataAggregationBtn.click();
	}
	
	public void clickUserDomainBtn() throws InterruptedException
	{
		this.userDomainBtn.click();
		Thread.sleep(2000);
	}
	
	public void clickAOSBtn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(aosBtn));
		this.aosBtn.click();
	}
	
	public void clickActivitiesBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Business Hierarchy')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		this.activitiesBtn.click();
	}
	
	public void scrollElementToView(WebElement locator)
		{
			JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
	 
			jsexecutour.executeScript("arguments[0].scrollIntoView(true);", locator);
		}

	public void clickActivityTab()
	{
		this.activityTab.click();
	}
	public void clickWorkProfilestab()
	{
		this.workProfilesTab.click();
	}
	public void ClickOnOrganizationBtnToClose()
	{
		this.closeOrganizationTab.click();
		 
	}


}
