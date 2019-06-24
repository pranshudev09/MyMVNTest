package testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtils;

public class OpenAccountTestDay8Test extends TestBase{
	
	
		
	@Test(dataProvider="getData")
	public void addCustomer(String customer, String currency, String alertMsg)
	{
		
			click("openAccBtn_css");	
			
			select("custName_css", customer);
			select("currency_css", currency);
			click("processBtn_css");
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertMsg),"Alert not available");
		
		alert.accept();
		
		click("home_css");
		
		click("custLoginBtn_css");
		
		//click("nameSelect_css");
		
		Assert.assertTrue(isElementVisible("nameSelect_css", customer), "element not present");
		
		//Assert.fail("OPen account fail");
		
		
	}

	
	@DataProvider
	public  Object[][] getData() throws IOException
	{
		return TestUtils.getData("OpenAccountTest");
				
				
		
	}
	
}
