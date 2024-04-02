package WorkOutput;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkOutputPages {
	WebDriver driver;
	
	
	@FindBy(xpath = "//a[contains(text(),\"WORK OUTPUT\")]")
	WebElement workOutput;
	
	@FindBy(xpath = "//div[@id=\"arrow-top\"]/i")
	WebElement workOutputSideNavigationBar;
	
	@FindBy(xpath = "//span[contains(text(),\"Administration\")]")
	WebElement administration;
	
	@FindBy(xpath = "//li[contains(text(),\"Work Type Definition\")]")
	WebElement workTypeDefinition;
	
	@FindBy(xpath = "//label[contains(text(),\"BULK UPLOAD\")]")
	WebElement bulkUpload;
	
	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement addnew;
	
	@FindBy(id = "dataTemplate")
	WebElement withPrefilledData;
	
	@FindBy(xpath = "//span[contains(text(),\"Click here\")]")
	WebElement clickHereBtn;
	
	@FindBy(xpath = "//td[@id =\"workTypeUpload\"]/table/tbody/tr[1]/td[2]/div/span/span/span/input[@id =\"workTypeXLUpload\"]")
	WebElement chooseFileBtn;
	
	@FindBy(id = "workTypeUploadButton")
	WebElement upload;
	
	public WorkOutputPages(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void switchTabs() {

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());

	}
	
	public void clickWorkOutput()
	{
		this.workOutput.click();
	}
	
	public void clickWorkOutputSideNavigationBar()
	{
		this.workOutputSideNavigationBar.click();
	}
	
	public void clickAdministration()
	{
		this.administration.click();
	}
	
	public void clickWorkTypeDefinition()
	{
		this.workTypeDefinition.click();
	}
	
	public void clickBulkUpload()
	{
		this.bulkUpload.click();
	}

	public void clickAddnew()
	{
		this.addnew.click();
	}
	
	public void clickWithPrefilledData()
	{
		this.withPrefilledData.click();
	}
	
	public void clickClickHereBtn()
	{
		this.clickHereBtn.click();
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
