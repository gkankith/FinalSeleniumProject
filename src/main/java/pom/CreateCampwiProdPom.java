package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampwiProdPom {
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement cpplusimg;
	
	@FindBy(name="productname")
	private WebElement prodnametxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn1;
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement ccplusimg;
	
	@FindBy(name="campaignname")
	private WebElement cmpnamext;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement savebtn2;
	
	@FindBy(id="search_txt")
	private WebElement srchtxtbx;
	
	@FindBy(name="search")
	private WebElement srchbtn;
	
	
	
	@FindBy(name="button")
	private WebElement savebtn3;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutbtn;
	
	//constructor
	public CreateCampwiProdPom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//getters
	public WebElement getCpplusimg() {
		return cpplusimg;
	}

	public WebElement getProdnametxt() {
		return prodnametxt;
	}

	public WebElement getSavebtn1() {
		return savebtn1;
	}

	public WebElement getCcplusimg() {
		return ccplusimg;
	}

	public WebElement getCmpnamext() {
		return cmpnamext;
	}

	public WebElement getSavebtn2() {
		return savebtn2;
	}

	public WebElement getSrchtxtbx() {
		return srchtxtbx;
	}

	public WebElement getSrchbtn() {
		return srchbtn;
	}

	

	public WebElement getSavebtn3() {
		return savebtn3;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	
	//logic
	public void clickOnCpplus() {
		cpplusimg.click();
		
	}
	public void prodNmae(String name) {
		prodnametxt.sendKeys(name);
		
	}
	public void clickOnSave1() {
		savebtn1.click();
		
	}
	public void clickOnCcplus() {
		ccplusimg.click();
		
	}
	public void campNmae(String name) {
		cmpnamext.sendKeys(name);
		
	}
	public void clickOnSave2() {
		savebtn2.click();
		
	}
	public void searchtextbox(String name) {
		srchtxtbx.sendKeys(name);
		
	}
	public void searchButton() {
		srchbtn.click();
		
	}
	public void clickOnSave3() {
		savebtn3.click();
		
	}
	public void clickOnSignOut() {
		signoutbtn.click();
		
	}
	
	
	
	

}
