package Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class AOSPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//label[contains(text(),'ADD NEW')]")
	public WebElement addnewBtn;
	
	@FindBy(xpath="//i[@title='Modify']")
	WebElement modifyBtn;
	
	@FindBy(xpath="//i[@title='Delete']")
	WebElement deleteBtn;
	
	@FindBy(id="applicationName")
	WebElement nameTxt;
	
	@FindBy(id="defaultTypecategory")
	WebElement activityTypeDrpDwn;
	
	@FindBy(id="SUBMIT")
	WebElement saveBtn;
	
	@FindBy(id="clear")
	WebElement clearBtn;
	
	@FindBy(id="windowTitle")
	WebElement windowTitleTxt;
	
	@FindBy(id="SUBMIT")
	WebElement signatureSaveBtn;
	
	@FindBy(id="add")
	WebElement signatureAddBtn;
	
	@FindBy(xpath="//*[@id='alertModal']/div/div/div[3]/button")
	WebElement signatureOkBtn;
	
	

	
	 public AOSPage(WebDriver driver)
	 {
		 this.driver=driver;
	     PageFactory.initElements(driver,this);
	 }
	 
	 public void clickAddNewBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(addnewBtn));
		 this.addnewBtn.click();
	 }
	 
	 public void sendApplicationNameTxt(String name)
	 {
		 this.nameTxt.clear();
		 this.nameTxt.sendKeys(name);
	 }
	 
	 public void selectActivityTypeDrpDwn()
	 {
		 Select drpdwn = new Select(activityTypeDrpDwn);
		 drpdwn.selectByVisibleText("Business");
	 }
	 
	 public void clickAddNewSaveBtn()
	 {
		 this.saveBtn.click();
	 }
	 
	 public void clickSignatureOkBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='alertModal']/div/div/div[3]/button")));
		 this.signatureOkBtn.click();
	 }
	 
	 public void sendWindowTitle(String title)
	 {
		 this.windowTitleTxt.sendKeys(title);
	 }
	 
	 public void clickAddTitleBtn()
	 {
		 this.signatureAddBtn.click();
	 }
	 
	 public void clickSaveSignatureBtn()
	 {
		 this.signatureSaveBtn.click();
	 }
	 
	 public void clickModifyBtn()
	 {
		 this.modifyBtn.click();
	 }
	 
	
	
}
