package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPom {
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement plusimg;
	
	@FindBy(name="campaignname")
	private WebElement nametxtbx;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement valid;
	
	public WebElement getValid() {
		return valid;
	}

	//constructors
	public CreateCampPom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//getters
	public WebElement getPlusimg() {
		return plusimg;
	}

	public WebElement getNametxtbx() {
		return nametxtbx;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	//logic
	public void clickOnPlusImg() {
		plusimg.click();
		
	}
	
	public void cmpName(String name)
	{
		nametxtbx.sendKeys(name);
	}
	
	public void clickOnSave() {
		savebtn.click();
	}
	
	public String validate() {
		return valid.getText();
	}
	
	
	
	

}
