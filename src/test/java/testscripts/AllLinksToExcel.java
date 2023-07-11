package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinksToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("src\\test\\resources\\testscript1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count=allLinks.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			
			Cell c = wb.getSheet("Sheet1").getRow(0).getCell(0);
			c.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		FileOutputStream fos=new FileOutputStream("src\\test\\resources\\testscript1.xlsx");
		wb.write(fos);
		

}
}
