package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDeleteProdPom {
	@FindBy(xpath="//img[@title='Create Product...']") 
	private WebElement plusimg;
	
	@FindBy(name="productname")
	private WebElement prodname;
	
	@FindBy(xpath="(//input[@name='button' and @title='Save [Alt+S]'])[2]")
	private WebElement savebtn;
	
	@FindBy(linkText = "Products")
	private WebElement prodimg;
	
	@FindBy(xpath="(//input[@value='Delete'])[2]")
	private WebElement delete;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutbtn;
	
	public CreateDeleteProdPom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getPlusimg() {
		return plusimg;
	}

	public WebElement getProdname() {
		return prodname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getProdimg() {
		return prodimg;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getSignoutimg() {
		return signoutimg;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	
	//logic
	public void clickOnPlus()
	{
		plusimg.click();
	}
	public void productNmae(String name)
	{
		prodname.sendKeys(name);
	}
	public void saveButton()
	{
		savebtn.click();
	}
	public void clickOnProdImg()
	{
		prodimg.click();
	}
	public void clickOnDelete()
	{
		delete.click();
	}
	public void clickOnSignoutImg()
	{
		signoutimg.click();
		
	}
	public void clickOnSignOutBtn()
	{
		signoutbtn.click();
	}
}
