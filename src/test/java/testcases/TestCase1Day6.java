package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1Day6 {
	
	@AfterTest
	public void closingDBConnection()
	{
		
		System.out.println("@After Test = closing DB Connection");
	}
	
	@BeforeTest
	public void creatingDBConnection()
	{
		
		System.out.println("@Before Test = creating DB Connection");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("@After Method = closing the browser");
	}
	
	
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println("@Before Method = launching browser");
		
	}
	
	
	@Test(priority=2, groups="bvt")
	public void doLogin()
	{
		
		System.out.println("Executing Login Test");
		
	}
	
	@Test(priority=1, groups="bvt")
	public void doUserReg()
	{
		System.out.println("Executing User Registration Test");
	}

}
