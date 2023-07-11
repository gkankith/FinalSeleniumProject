package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import pom.CreateCampwiProdPom;
import pom.HomePage;
import pom.LoginPage;

public class CreateCampaignWithProductTest extends BaseClass {

	@Test
	public void createCampaignWithProductTest() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.product();
		CreateCampwiProdPom obj=new CreateCampwiProdPom(driver);
		obj.clickOnCpplus();


		Java_utility jlib=new Java_utility();
		int ranNum = jlib.randomNumber();
		Excel_Utility elib=new Excel_Utility();
		String data1=elib.getExcelDataByDataFormatter("Product",1,1)+ranNum;
		obj.prodNmae(data1);
		obj.clickOnSave1();
		
		WebElement more = driver.findElement(By.linkText("More"));
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.moveToElement(driver, more);
		hp.campaign();
		obj.clickOnCcplus();
		int ranNum1 = jlib.randomNumber();
		String data3=elib.getExcelData("Campaign",0,0)+ranNum1;
		obj.campNmae(data3);
		obj.clickOnSave2();
		wlib.switchWindow(driver, data3);
		
		obj.searchtextbox(data1);
		obj.searchButton();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='"+data1+"']")).click();
		Thread.sleep(1000);
		wlib.switchWindow(driver, data3);
		obj.clickOnSave3();
		

		WebElement lg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(lg).perform();


	



	}

}
