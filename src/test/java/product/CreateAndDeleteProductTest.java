package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateDeleteProdPom;
import pom.HomePage;
import pom.LoginPage;

public class CreateAndDeleteProductTest extends BaseClass {

	@Test
	public void createAndDeleteProductTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		hp.product();
		CreateDeleteProdPom ob=new CreateDeleteProdPom(driver);
		ob.clickOnPlus();

		Java_utility jlib=new Java_utility();
		int rNum = jlib.randomNumber();
		Excel_Utility elib=new Excel_Utility();
		String data=elib.getExcelDataByDataFormatter("Product",1,1)+rNum;
		System.out.println(data);
		ob.productNmae(data);
		Thread.sleep(1000);
		ob.saveButton();
		
		ob.clickOnProdImg();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//a[text()='"+data+"']/../../td[1]")).click();
		ob.clickOnDelete();
		
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.switchToAlertAndAccept(driver);
		Thread.sleep(2000);
		ob.clickOnSignoutImg();


	}

}
