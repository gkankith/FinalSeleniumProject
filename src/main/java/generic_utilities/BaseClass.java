package generic_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;


public class BaseClass {
	public  WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups= {"smoketest","regressiontest"})
	public void beforeSuite()
	{
		Reporter.log("database connection",true);
		
	}
	
	
	@BeforeTest(groups= {"smoketest","regressiontest"})
	public void beoreTest() {
		Reporter.log("parallel execution",true);
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoketest","regressiontest"})
	public void beforeClass() throws Throwable
	{
		Reporter.log("launching browser",true);
		
		File_Utility flib=new File_Utility();
		String BROWSER = flib.getPropertyData("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		sdriver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod(groups= {"smoketest","regressiontest"})
	public void beforeMethod() throws Throwable
	{
		Reporter.log("login to application",true);
		File_Utility flib=new File_Utility();
		String url=flib.getPropertyData("url");
		String un=flib.getPropertyData("username");
		String pwd=flib.getPropertyData("password");
		driver.get(url);
		LoginPage login=new LoginPage(driver);
		login.loginToApp(un, pwd);
		
	}
	
	@AfterMethod(groups= {"smoketest","regressiontest"})
	public void afterMethod()
	{
		Reporter.log("logout of application",true);
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups= {"smoketest","regressiontest"})
	public void afterClass()
	{
		Reporter.log("closing browser",true);
		driver.quit();
	}
	

	@AfterTest(groups= {"smoketest","regressiontest"})
	public void afterTest() {
		Reporter.log("parallel execution done",true);
	}
	
	@AfterSuite(groups= {"smoketest","regressiontest"})
	public void afterSuite()
	{
		Reporter.log("database close",true);
	}
	

}
