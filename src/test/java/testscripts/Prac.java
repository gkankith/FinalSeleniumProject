package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prac {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis=new FileInputStream("src/test/resources/testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://amazon.in");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for(int i=0;i<allLinks.size();i++)
		{
			String url = allLinks.get(i).getAttribute("href");
			int lastrow=wb.getSheet("Sheet2").getLastRowNum();
			
				wb.getSheet("Sheet2").getRow(i).getCell(0).setCellValue(url);
	
			
		}
		FileOutputStream fos=new FileOutputStream("src/test/resources/testscript1.xlsx");
		wb.write(fos);
		wb.close();
	
		
	}

}
