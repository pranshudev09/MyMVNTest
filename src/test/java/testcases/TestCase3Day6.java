package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3Day6 {
	
	@Test(priority=2, dependsOnMethods = "doUserReg", groups="func")
	public void doLogin()
	{
		
		System.out.println("Executing Login Test");
		
	}
	
	@Test(priority=1, groups={"bvt", "func"})
	public void doUserReg()
	{
		System.out.println("Executing User Registration Test");
		//Assert.fail("Registration Failed");
	}

	@Test(priority=3)
	public void composeEmail()
	{
		throw new SkipException("Condition not met so skipping");
	}

}
