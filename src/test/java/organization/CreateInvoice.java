package organization;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class CreateInvoice {

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("More")).sendKeys(Keys.CONTROL+"ac");
		driver.findElement(By.name("Invoice")).click();
		driver.findElement(By.xpath("//img[@title='Create Invoice...']")).click();
		driver.findElement(By.name("subject")).sendKeys("selenium");
		driver.findElement(By.id("customerno")).sendKeys("8222612678");
		
		/*int y=driver.findElement(By.xpath("//b[text()='Address Information']")).getLocation().getY();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript(Window.scr*/
		
		driver.findElement(By.name("bill_street")).sendKeys("qspiders,btm2nd stage,bengaluru");
		driver.findElement(By.name("ship_street")).sendKeys("testyantra soft solutions,katriguppe,bengaluru");
		
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
