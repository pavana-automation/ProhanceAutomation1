package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BusinessHierarchy {
	WebDriver driver;
	@FindBy(xpath = "//li/a[contains(text(),\"Business Hierarchy\")]")
	WebElement businessHierarchy;

	@FindBy(xpath = "//li[contains(text(),\"Hierarchy Structure\")]")
	WebElement hierarchyStructure;
	
	@FindBy(xpath = "//li[contains(text(),\"Hierarchy Mapping\")]")
	WebElement hierarchyMapping;
	
	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement addNewBtn;
	
	@FindBy(id = "title")
	WebElement title;
	
	@FindBy(id = "description")
	WebElement description;
	
	@FindBy(id = "activeStatus_true")
	WebElement active;
	
	@FindBy(id = "activeStatus_false")
	WebElement inactive;
	
	@FindBy(xpath = "//div[@class =\"tab-buttons\"]/input[2]")
	WebElement save;
	
	@FindBy(xpath = "//div[@class =\"tab-buttons\"]/input[1]")
	WebElement clear;
	
	@FindBy(xpath = "//td/div[contains(text(),\"automation_1\")]/../../td[1]/a[1]/i")
	WebElement modify;
	
	@FindBy(xpath = "//td/div[contains(text(),\"automation_1\")]/../../td[1]/a[2]/i")
	WebElement delete;
	
	@FindBy(xpath = "//button[contains(text(),'YES')]")
	WebElement yesBtn;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement addMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement modifyMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement deleteMsg;
	
	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td[1]/a[1]/i")
	WebElement modifyForClear;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/a/i/span[contains(text(),\"Active\")]/../../../../td[2]/div")
	List<WebElement> activeList;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]/div")
	List<WebElement> hierarchyList;
	
	@FindBy(xpath = "//img[@src='/prohance/images/excel.png']")
	WebElement excel;
	
	@FindBy(xpath = "//img[@src='/prohance/images/pdf.png']")
	WebElement pdf;
	
	@FindBy(xpath = "//body[@class=\"modal-open\"]/div[4]/div/div/div[2]/div[2]")
	WebElement popupMsg;
	
	@FindBy(xpath = "//a[contains(text(),\"ADVANCED ANALYTICS\")]")
	WebElement analytics;
	
	@FindBy(xpath="//div[@id =\"arrow-top\"]/i")
	WebElement advancedAnaylticsSideNavigationArrow;
	
	@FindBy(xpath="//a/span[contains(text(),\"Work Trends\")]")
	WebElement workTrends;
	
	@FindBy(xpath="//li[contains(text(),\"Business Hierarchy\")]")
	WebElement advancePageHierarchy;
	
	@FindBy(xpath="//select[@id =\"ohTypeId\"]/option")
	List<WebElement> hierarchyStructureList;
	
	@FindBy(xpath="//label[contains(text(),\"BULK UPLOAD\")]")
	WebElement bulkUpload;
	
	@FindBy(id="existingHierarchyTemplet")
	WebElement templateWithData;
	
	@FindBy(xpath="//tr[@id =\"downloadTemplate\"]/td/span[contains(text(),\"Click here\")]")
	WebElement clickHere;
	
	@FindBy(xpath="//table[@id='uploadTable']/tbody/tr[2]/td[2]/div/span/span/span/input[@id=\"ohUserMappingXmlFile\"]")
	WebElement chooseFileBtn;
	
	@FindBy(xpath = "//table[@id=\"uploadTable\"]/tbody/tr[2]/td[2]/div/span/span[2]/input")
	WebElement upload;
	
	public BusinessHierarchy(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void scrollSideNavigationBar() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Business Hierarchy')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	
	public void clickBusinessHierarchy()
	{
		this.businessHierarchy.click();
	}
	
	public void clickHierarchyStructure()
	{
		this.hierarchyStructure.click();
	}
	
	public void clickAddNewBtn()
	{
		this.addNewBtn.click();
	}
	
	public void clickTitle(String title)
	{
		this.title.sendKeys(title);
	}
	
	public void clickDescription(String description)
	{
		this.description.sendKeys(description);
	}
	
	public void clickActive()
	{
		this.active.click();
	}
	
	public void clickSaveBtn()
	{
		this.save.click();
	}
	
	public void clickModify()
	{
		this.modify.click();
	}
	
	public void clickInactive()
	{
		this.inactive.click();
	}
	
	public void clickYesBtn()
	{
		this.yesBtn.click();
	}
	
	public void clickDelete()
	{
		this.delete.click();
	}
	
	
	public boolean clickAddMsg()
	 {
		 String ms = this.addMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "HierarchyStructure:automation_1addedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	public boolean clickModifyMsg()
	 {
		 String ms = this.modifyMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "HierarchyStructure:automation_1modifiedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	public boolean clickDeleteMsg()
	 {
		 String ms = this.deleteMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "HierarchyStructure:automation_1deletedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	public void clickModifyForClear()
	{
		this.modifyForClear.click();
	}
	
	public void clickClear()
	{
		this.clear.click();
	}
	
	public List<String> getHierarchyList() {
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.hierarchyList;
		int len = col.size();
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.hierarchyList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	public void clickExcelExport()
	{
		this.excel.click();
	}
	
	public void clickPdfExport()
	{
		this.pdf.click();
	}
	
	public boolean clickTitleRequiredMsg() throws InterruptedException {
		System.out.println("check");
		Thread.sleep(2000);
		String ms = this.popupMsg.getText();
		System.out.println(this.popupMsg.getText());
		String msg = ms.replaceAll("\\s+", "");
		System.out.println(msg);
		String compareMsg = "Titleisrequiredinformation";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	
	public List<String> getHierarchyActiveList() {
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.activeList;
		int len = col.size();
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.activeList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	public void clickanalytics()
	{
		//this.analytics.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.analytics);
	}
	public void switchTabs() {

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());

	}
	

	public void scrollSideNavigationBarInAdvancedAnalytics() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a/span[contains(text(),'Administration')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	
	public void clickAdvancedAnaylticsSideNavigationArrow()
	{
		this.advancedAnaylticsSideNavigationArrow.click();

	}
	
	public void clickWorkTrends()
	{
		this.workTrends.click();
	}
	
	public void clickAdvancePageHierarchy()
	{
		this.advancePageHierarchy.click();
	}
	
	public List<String> getAdvanceHierarchyList() {
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.hierarchyStructureList;
		int len = col.size();
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.hierarchyStructureList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	public void clickHierarchyMapping()
	{
		this.hierarchyMapping.click();
	}
	
	public void clickBulkupload()
	{
		this.bulkUpload.click();
	}
	
	public void clickTemplateWithData()
	{
		this.templateWithData.click();
	}
	
	public void clickClickHereBtn()
	{
		this.clickHere.click();
	}
	
	public String clickChooseFileBtn(String url) throws InterruptedException {
		System.out.println("enter");
		System.out.println(url);
		WebElement  choose = this.chooseFileBtn;
		choose.sendKeys(url);
		this.upload.click();
		return url; 

	}
}
