package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utilities.BaseClass;

public class Asserts {
	
	@Test
	public void HardAssert() {
		
		System.out.println("hello1");
		System.out.println("welcome");
		String s="RadheRadhe";
		String k="radheradhe";
		Assert.assertEquals(s,k);
		System.out.println("check");
	}
	
	@Test
	public void method2() {
		System.out.println("done");
		Assert.assertEquals(true, true);
	}

}
