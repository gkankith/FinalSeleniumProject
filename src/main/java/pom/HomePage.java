package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(name="Campaigns")
	private WebElement cmplink;
	
	@FindBy(linkText ="Products")
	private WebElement prdlink;
	
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Sign Out")
	private WebElement logoutlink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCmplink() {
		return cmplink;
	}

	public WebElement getPrdlink() {
		return prdlink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	public void campaign()
	{
		cmplink.click();
	}
	
	public void organization()
	{
		orglink.click();
		
	}
	
	public void product()
	{
		prdlink.click();
		
	}
	public void logout()
	{
		logoutlink.click();
		
	}
	

}
