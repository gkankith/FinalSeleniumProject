package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utilities.File_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderPrac {
	
	@Test(dataProvider="getdata")
	public void login(String uname,String pass,String url) throws Throwable {
		
		System.out.println(uname+" "+pass+" "+url);
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("pwd")).sendKeys(pass);
		driver.findElement(By.id("loginButton")).click();*/
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable{
		
		FileInputStream fis=new FileInputStream("src/test/resources/testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow=wb.getSheet("Sheet1").getLastRowNum()+1;
		int lastcell=wb.getSheet("Sheet1").getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
		
	}
	
	
		
		
		
	

}
