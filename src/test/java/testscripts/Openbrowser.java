package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Openbrowser {

public static void main(String[] args) throws IOException {
	
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	FileInputStream fis=new FileInputStream("src/test/resources/commondata.properties");
	Properties p=new Properties();
	p.load(fis);
	String url=p.getProperty("url");
	String username=p.getProperty("username");
	String password=p.getProperty("password");
	
	driver.get(url);
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.name("pwd")).sendKeys(password);
	driver.findElement(By.id("loginButton")).click();
}
}
