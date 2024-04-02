package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.var;

public class UserRolePage {
	
WebDriver driver;
	
	@FindBy(xpath="//label[contains(text(),'ADD NEW')]")
	WebElement addnewBtn;
	
	@FindBy(id="roleTypeStyleId_Manager")
	WebElement managerRadioBtn;
	
	@FindBy(id="roleTypeStyleId_Member")
	WebElement memberRadioBtn;
	
	@FindBy(id="roleName")
	WebElement roleNameTxtBox;
	
	@FindBy(id="roleDescription")
	WebElement roleDescriptionTxtBox;
	
	@FindBy(id="save")
	WebElement saveBtn;
	
	@FindBy(xpath="//i[@title='Delete']")
	WebElement deleteBtn;
	
	@FindBy(xpath="//input[@name='selectedUserRole']")
	WebElement selectedUserChkBox;
	
	@FindBy(xpath="//label[contains(text(),'Search')]")
	WebElement searchTxtBox;
	
	@FindBy(xpath="//select[@class='combobox']")
	WebElement hierarchyLevel;
	
	@FindBy(xpath="//label[contains(text(),'BULK UPDATE')]")
	WebElement bulkUpdateBtn;
	
	
	
	 public UserRolePage(WebDriver driver)
	 {
		 this.driver=driver;
	     PageFactory.initElements(driver,this);
	 }
	 
	 public void clickAddNewBtn()
	 {
		 this.addnewBtn.click();
	 }
	 
	 public void selectManagerRadioBtn()
	 {
		 this.managerRadioBtn.click();
	 }
	 
	 public void selectMemberRadioBtn()
	 {
		 this.memberRadioBtn.click();
	 }
	 
	 public void inputRoleNameTxtBox(String Name)
	 {
		 this.roleNameTxtBox.sendKeys(Name);
	 }
	 
	 public void inputRoleDescrptionTxtBOx(String description)
	 {
		 this.roleDescriptionTxtBox.sendKeys(description);
	 }
	 
	 public void clickOnSaveBtn()
	 {
		 this.saveBtn.click();
	 }
	 
	 public void clickOnDeleteBtn()
	 {
		 this.deleteBtn.click();
	 }
	 
	 public void clickSelectedUserChkBox()
	 {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.selectedUserChkBox);
	 }
	 
	 public void clickSearchTxtBox(String name)
	 {
		 this.searchTxtBox.sendKeys(name);
	 }
	 
	 public String getTextHierarchy()
	 {
		 //return this.hierarchyLevel.getText();
		 //Select hierarchyLevel = new Select(this.hierarchyLevel);
		 //return ((WebElement) hierarchyLevel).getText();
		 
		 Select comboBox = new Select(this.hierarchyLevel);
		 System.out.println(comboBox);
		 String selectedComboValue = comboBox.getFirstSelectedOption().getText();
		 System.out.println("the value is :"+selectedComboValue);
		 return selectedComboValue;
		 
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//String element = driver.findElement(By.xpath("//select[@class='combobox']")).getText();
		//return element;
		
		//return null;
		//return null;
		 
		 //JavascriptExecutor executor = (JavascriptExecutor)driver;
		//return (String) executor.executeScript("arguments[0].click();", this.hierarchyLevel.getText());
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("select_811"));
		String elementText = (String) js.executeScript("return arguments[0].innerText;", element);*/
		//return elementText;
		 
	 }
	 
	 public void setHierarchyLevelChange()
	 {
		//((JavascriptExecutor) driver).executeScript("return document.getElementById('select_899').selectedValue = "+ DIRECT_INDIRECT +);
		 //Select hierarchyLevel = new Select(this.hierarchyLevel);
		 //hierarchyLevel.selectByValue("DIRECT_INDIRECT");
		 this.hierarchyLevel.sendKeys("Members who directly or indirectly report into me");
	 }
	 
	 public void clickBilkUpdateBtn()
	 {
		 this.bulkUpdateBtn.click();
	 }

	 
}