package generic_utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImplementation implements ITestListener {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;


	public void onTestStart(ITestResult result) {
		//step 3: create test method during test execution
		reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		//step 4: log the pass method
		test.log(Status.PASS,result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {

		//step 5: log the failed method
		String methodName = result.getMethod().getMethodName();
		Webdriver_Utility wlib=new Webdriver_Utility();
		try 
		{
			wlib.takeScreenShot(BaseClass.sdriver, methodName);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		//step 6: log the skipped method
		test.log(Status.SKIP,result.getMethod().getMethodName());
		
	}

	public void onStart(ITestContext context) {
		//step 1: extent report configuration
		Date d=new Date();
		System.out.println(d);
		d.toString().replace(":","-").replace(" ","*");
		
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(new File("ExtentReport.html"));
		htmlReport.config().setDocumentTitle("vtiger report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Automation testing");
		
		//step2: Attach report and sysytem configuration
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("OS","windows 10");
		reports.setSystemInfo("Environment","automation");
		reports.setSystemInfo("url","http://localhost:8888/ ");
		reports.setSystemInfo("Repotername","Ankith");
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
	}

}
