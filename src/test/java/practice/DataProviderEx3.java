package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utilities.Excel_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx3 {
	
	@Test(dataProvider = "getData")
	public void login(String uname,String pass) throws Throwable {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("pwd")).sendKeys(pass);
		driver.findElement(By.id("loginButton")).click();
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		Excel_Utility ex=new Excel_Utility();
		Object[][] value = ex.readMultipleData("Sheet1");
		
		return value;
		
	}

}
