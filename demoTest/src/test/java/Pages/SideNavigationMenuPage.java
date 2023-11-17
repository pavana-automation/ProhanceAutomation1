package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideNavigationMenuPage {
	
	@FindBy(id = "arrow-top")
	WebElement sideNavigationBtn;
	
	@FindBy(xpath= "//li[contains(text(),'Organization')]")
	WebElement organizationBtn;
	
	@FindBy(xpath = "//li[contains(text(),'Data Aggregation')]")
	WebElement dataAggregationBtn;
	
	@FindBy(xpath = "//li[contains(text(),'User Domain')]")
	WebElement userDomainBtn;
	
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
	
	public void clickUserDomainBtn()
	{
		this.userDomainBtn.click();
	}
	
	

}
