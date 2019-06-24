package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase4ToTestListenerDay6 {


	
	@Test(groups={"bvt", "func"})
	public void validateTitleTestt()
	{
		
			
		
		String expected_title = "Gmail.com";
		String actual_title = "Yahoo.com";
		
			Assert.assertEquals(expected_title, actual_title);
			
			
		
				
			
	
			
		
		
		
	
	}}



