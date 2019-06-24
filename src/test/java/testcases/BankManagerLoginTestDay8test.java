package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;


public class BankManagerLoginTestDay8test extends TestBase {
	
	
	
	@Test
	public void loginAsBankManager()
	{
		click("BMLBtn_css");
		
		
		//Assert.assertTrue(isElementPresent("AddCustBtn_css"),"Element not found");
		
		Assert.assertTrue(isElementPresent("AddCustBtn_css"), "Element not found");
	
	
	}

	
}
