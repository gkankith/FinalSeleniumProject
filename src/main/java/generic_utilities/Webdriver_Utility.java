package generic_utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {
	
	public void maximizeScreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void switchWindow(WebDriver driver, String etitle)
	{
		Set<String> allWh = driver.getWindowHandles();
		Iterator<String> it=allWh.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String atitle=driver.getTitle();
			
			if(atitle.contains(etitle))
			{
				break;
			}
		}
	}
	
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
   public void fluentTimeout(WebDriver driver,WebElement element, int pollingTime)
   {
	   FluentWait wait=new FluentWait(driver);
	   wait.pollingEvery(Duration.ofSeconds(20));
	   wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   
   public void switchToAlertAndAccept(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   
   public void switchToAlertAndDismiss(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   
   public void switchToFrame(WebDriver driver,int index)
   {
	   driver.switchTo().frame(index);
   }
   
   public void switchToFrame(WebDriver driver,String id_name_attribute)
   {
	   driver.switchTo().frame(id_name_attribute);
   }
   
   public void select(WebElement element,int index)
   {
	   Select sel=new Select(element);
	   sel.selectByIndex(index);
   }
   
   public void select(WebElement element, String text)
   {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(text);
   }
   
   public void moveToElement(WebDriver driver, WebElement element)
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(element).perform();
   }
   
   public void rightClick(WebDriver driver, WebElement element)
   {
	   Actions a=new Actions(driver);
	   a.contextClick(element).perform();
   }
   
   public void moveByOffset(WebDriver driver, int x, int y)
   {
	   Actions a=new Actions(driver);
	   a.moveByOffset(x, y).click().perform();
   }
   
   public void refresh(WebDriver driver)
   {
	   driver.navigate().refresh();
   }
   
   public void forward(WebDriver driver)
   {
	   driver.navigate().forward();
   }
   
   public void reverse(WebDriver driver)
   {
	   driver.navigate().back();
   }
   
  public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException
  {
	  TakesScreenshot ts=(TakesScreenshot) driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File("./Screenshots/"+screenshotName+".png");
	  FileUtils.copyFile(src, dest);
	 return  dest.getAbsolutePath();
	  
	  
   }
 
  

	
}

