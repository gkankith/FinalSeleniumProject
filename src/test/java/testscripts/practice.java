package testscripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		FileInputStream fis=new FileInputStream("src/test/resources/excel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Wish");
		
		for(int i=0;i<allLinks.size();i++)
		{
			Row r = s.getRow(0);
			Cell c = r.getCell(0);
			c.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		FileOutputStream fos=new FileOutputStream("src/test/resources/excel.xlsx");
		wb.write(fos);
		wb.close();
	}

}
