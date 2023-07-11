package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement untxt;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement pwdtxt;
	
	@FindBy(id="submitButton")
	private WebElement lgbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUntxt() {
		return untxt;
	}

	public WebElement getPwdtxt() {
		return pwdtxt;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	public void loginToApp(String username, String password)
	{
		untxt.sendKeys(username);
		pwdtxt.sendKeys(password);
		lgbtn.click();
	}

}
