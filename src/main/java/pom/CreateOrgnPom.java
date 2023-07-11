package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgnPom {
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusimg;
	
	@FindBy(name="accountname")
	private WebElement nametxtbx;
	
	@FindBy(id="phone")
	private WebElement phntxtbx;
	
	@FindBy(id="email1")
	private WebElement emailtxtbx;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutbtn;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement valid;
	
	//constructor
	public CreateOrgnPom(WebDriver driver)
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

	public WebElement getPhntxtbx() {
		return phntxtbx;
	}

	public WebElement getEmailtxtbx() {
		return emailtxtbx;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	

	//bussiness logic
	public void clickPlusImg()
	{
		plusimg.click();
	}
	
	public void orgDetails(String name,String phno,String email)
	{
		nametxtbx.sendKeys(name);
		phntxtbx.sendKeys(phno);
		emailtxtbx.sendKeys(email);	
	}
	
	public void clickOnSave() 
	{
		savebtn.click();
	}
	
	public void moveToLogout()
	{
		logoutbtn.click();
	}

	public WebElement getValid() {
		return valid;
	}
	
	public String validate() {
		return valid.getText();
		
	}

}
