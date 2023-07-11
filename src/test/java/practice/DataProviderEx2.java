package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx2 {

	@Test(dataProvider = "getData")
	public void login(String uname,String pass) throws Throwable {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("pwd")).sendKeys(pass);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logoutLink")).click();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] obj=new Object[2][2];
		obj[0][0]="admin";
		obj[0][1]="manager";
		
		obj[1][0]="admin";
		obj[1][1]="manager";
		
		return obj;
		
	}
}
