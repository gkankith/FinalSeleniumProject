package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_utility;
import generic_utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateCampPom;
import pom.CreateProdpom;
import pom.HomePage;
import pom.LoginPage;

public class CreateCampaignTest extends BaseClass {

	@Test(groups="smoketest")
	public void createCampaignTest() throws InterruptedException, Throwable {
	
		WebElement more = driver.findElement(By.linkText("More"));
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.moveToElement(driver,more);
		HomePage hp=new HomePage(driver);
		hp.campaign();
		CreateCampPom camp=new CreateCampPom(driver);
		camp.clickOnPlusImg();

		Java_utility jlib=new Java_utility();
		int ranNum = jlib.randomNumber();
		Excel_Utility elib=new Excel_Utility();
		String data1=elib.getExcelDataByDataFormatter("Organization",0,0)+ranNum;
		camp.cmpName(data1);
		camp.clickOnSave();
		
		//String data2=driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		//System.out.println(data2+" "+data1);
		String actData = camp.validate();
		Assert.assertEquals(actData, data1);
		
		Thread.sleep(2000);
		WebElement lg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.moveToElement(driver, lg);

	}
	}
	
	


