package testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtils;

public class AddCustomerTestDay8Test extends TestBase{
	
	
		
	@Test(dataProvider="getData")
	public void addCustomer(String fName, String lName, String pCode, String alertMsg)
	{
		
		click("AddCustBtn_css");
		
		type("firstName_css", fName);
		type("lastName_css", lName);
		type("postCode_css", pCode);
		
		click("addedCustBtn_css");
		
		
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertMsg), "User not added successfully");
		
		
		alert.accept();
		
		//Assert.fail("Add customer fail");
		
		click("custBtn_css");
		
		Assert.assertTrue(isElementPresent("firstNameLink_css"),"Element not found");
		
		
		
	}

	
	@DataProvider
	public  Object[][] getData() throws IOException
	{
		return TestUtils.getData("AddCustomerTest");
				
				
		
	}
	
}
