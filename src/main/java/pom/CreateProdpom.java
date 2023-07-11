package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProdpom {
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement plusimg;
	
	@FindBy(xpath="(//input[@value='  Save  '])[2]")
	private WebElement savebtn;
	
	@FindBy(name="productname")
	private WebElement prodname;
	
	@FindBy(xpath="(//input[@name='button' and @title='Save [Alt+S]'])[2]")
	private WebElement scroll;
	
	@FindBy(id="dtlview_Product Name")
	private WebElement valid;
	
	public WebElement getValid() {
		return valid;
	}

	public WebElement getScroll() {
		return scroll;
	}

	public WebElement getProdname() {
		return prodname;
	}

	public CreateProdpom(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getPlusimg() {
		return plusimg;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	//logic
	public void plusImage()
	{
		plusimg.click();
	}
	
	public void clickOnSave()
	{
		savebtn.click();
	}
	public void productNmae(String name)
	{
		prodname.sendKeys(name);
		
	}
	
	public int scrollAction() {
		return scroll.getLocation().getY() ;
		
	}
	public String validate() {
		return valid.getText();
	}
}
