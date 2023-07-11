package organization;

import static org.testng.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;
import generic_utilities.Excel_Utility;
import generic_utilities.File_Utility;
import generic_utilities.Java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.CreateOrgnPom;
import pom.HomePage;
import pom.LoginPage;
@Listeners(generic_utilities.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups="regressiontest")
	public void createOrganizationTest() throws InterruptedException, Throwable {
		HomePage hp=new HomePage(driver);
		hp.organization();
		CreateOrgnPom org=new CreateOrgnPom(driver);
		org.clickPlusImg();
		
		Java_utility jlib=new Java_utility();
		int rnum = jlib.randomNumber();
		Excel_Utility elib=new Excel_Utility();
		String data=elib.getExcelData("Organization", 0, 0)+rnum;
		int rnum2 = jlib.randomNumber();
		String phno = elib.getExcelDataByDataFormatter("Organization",1,1)+rnum2;
		int rnum3 = jlib.randomNumber();
		String data2=elib.getExcelData("Organization",2,2)+rnum3;
		
		org.orgDetails(data, phno, data2);
		//Assert.fail();
		org.clickOnSave();
		Thread.sleep(2000);
		
		String actData = org.validate();
		 Assert.assertEquals(actData, data);
		 Thread.sleep(2000);
		  org.moveToLogout();
		
	}

}
