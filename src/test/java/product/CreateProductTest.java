package product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateProdpom;
import pom.HomePage;
import pom.LoginPage;

@Listeners(generic_utilities.ListenerImplementation.class)
public class CreateProductTest extends BaseClass{

	@Test(groups= {"smoketest","regressiontest"})
	public void createProductTest() throws Throwable {
		
		
		HomePage hp=new HomePage(driver);
		hp.product();
		CreateProdpom ob=new CreateProdpom(driver);
		ob.plusImage();
		
		Java_utility jlib=new Java_utility();
		int rNum = jlib.randomNumber();
		Excel_Utility elib=new Excel_Utility();
		String data=elib.getExcelData("Product",1,1)+rNum;
		ob.productNmae(data);
		JavascriptExecutor j=(JavascriptExecutor) driver;
		int y = ob.scrollAction();
		j.executeScript("window.scrollBy(0,"+y+")");
		Thread.sleep(1000);
	
		String actData = ob.validate();
		Assert.assertEquals(actData, data);
		Thread.sleep(2000);
		WebElement lg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.moveToElement(driver, lg);
	
  	}

}
