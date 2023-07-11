package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class ChecktestNG {
	
	@Test(priority=0,dependsOnMethods="welcome")
	public void wish()
	{
		Reporter.log("hello",true);
	}
	
	@Test(priority=-2,dependsOnMethods="wish")
	public void welcome() {

		Reporter.log("welcome to project",true);
	
	}
	
	@Test(priority=-3)
	public void serve()
	{
		Reporter.log("foodie",true);
	}

}
