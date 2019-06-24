package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase2Day6 {
	
	/*WebDriver driver;
	
	public boolean isElementpresent(String locator)
	{
	try{
		
		driver.findElement(By.xpath(locator));
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	}
*/	
	
	@Test(groups={"bvt", "func"})
	public void validateTitleTest()
	{
		
			//try{
		
		String expected_title = "Gmail.com";
		String actual_title = "Y.com";
		
		/*if(expected_title.equals(actual_title))
		{
			System.out.println("test case pass");
		}
		else
		{
			System.out.println("test case fail");
		}*/
		//Assert.assertTrue(isElementpresent("ajdhjd"));
		Assert.assertEquals(expected_title, actual_title);
		
			/*}catch(Throwable t)
			{*/
				
			
		//Throwable is super class of error and exception
			
		
		
	//System.out.println("test case failed");
		
		
		//Reporter.log("capture screenshot");
		
		//Assert.fail(t.getMessage() + " captured");
			//}
	
	}}
	//}
	/*@Test
	public void validateAssert()
	{
		System.setProperty("WebDriver.gecko.driver", "F://eclipse-java-neon-3-win32-x86_64//chromedriver_win32//geckodriver.exe");
       		WebDriver driver = new FirefoxDriver();
       	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.navigate().to("http://gmail.com");
*/		

	//}
	
	

//}
