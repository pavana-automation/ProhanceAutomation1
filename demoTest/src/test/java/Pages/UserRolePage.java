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
	
	@FindBy(xpath="//table[@id=\"tab_table\"]/tbody/tr[2]")
	WebElement rolePermissionBtn;
	
	@FindBy(xpath="//i[@title='Modify']")
	WebElement modifyBtn;
	
	@FindBy(xpath="//table[@id='CommonDataTableId']/tbody/tr/td[5]")
	WebElement roleTypeData;
	
	@FindBy(id="workTime")
	WebElement workTimeChkBox;
	
	@FindBy(id="workTimeLi")
	WebElement workTimeModuleBtn;
	
	
	
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
		 Select comboBox = new Select(this.hierarchyLevel);
		 System.out.println(comboBox);
		 String selectedComboValue = comboBox.getFirstSelectedOption().getText();
		 System.out.println("the value is :"+selectedComboValue);
		 return selectedComboValue;
		 
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
	 
	 public void clickRolePermissionBtn()
	 {
		 this.rolePermissionBtn.click();
	 }
	 
	 public void clickModifyBtn()
	 {
		 this.modifyBtn.click();
	 }
	 
	 public String getRoleTypeData()
	 {
		 return this.roleTypeData.getText();
	 }
	 
	 public void selectModule()
	 {
		 if(this.workTimeChkBox.isEnabled())
		 {
			 this.workTimeChkBox.click();
			 driver.findElement(By.id("module_1")).click();
			 driver.findElement(By.id("module_100")).click();
			 driver.findElement(By.id("module_96")).click();
		 }
		 else
		 {
			 this.workTimeChkBox.click();
			 this.workTimeChkBox.click();
			 driver.findElement(By.id("module_1")).click();
			 driver.findElement(By.id("module_100")).click();
			 driver.findElement(By.id("module_96")).click();
		 }
	 }
	 
	 public void selectWorkTimeModule()
	 {
		 this.workTimeModuleBtn.click();
	 }
	 
}