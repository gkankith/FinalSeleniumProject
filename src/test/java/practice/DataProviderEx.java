package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateOrgnPom;
import pom.HomePage;

public class DataProviderEx extends BaseClass{
	
	@Test(dataProvider = "getData")
	public void check(String name,String phone,String email) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.organization();
		CreateOrgnPom c=new CreateOrgnPom(driver);
		c.clickPlusImg();
		c.orgDetails(name, phone, email);
		c.clickOnSave();
		Thread.sleep(2000);
		c.moveToLogout();
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Java_utility jlib=new Java_utility();
		int rNum = jlib.randomNumber();
		Object[][] obj =new Object[3][3];
		obj[0][0]="AAA"+rNum;
		obj[0][1]="8765544";
		obj[0][2]="radheradhe@mail.com";
		
		obj[1][0]="BBB"+rNum;
		obj[1][1]="8765544";
		obj[1][2]="radheradhe@mail.com";
		
		obj[2][0]="CCC"+rNum;
		obj[2][1]="8765544";
		obj[2][2]="radheradhe@mail.com";
		
		return obj;
		
	}

}
