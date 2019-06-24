package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase2ADay6 {
	
	public static WebDriver driver;
	
	String locator = "asdsdf";
	
	public static boolean isElementPresent(String locator)
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
	
	@BeforeMethod
	public static void openBrowser()
	{
		driver = new FirefoxDriver();
		
		driver.navigate().to("http://gmail.com");
	}
	
		
	
	@Test
	public static void testButton()
	{
		
		//System.out.println("testt");
        //WebElement button = driver.findElement(By.xpath(".//*[@id='identifierId']"));
		//System.out.println(isElementPresent(".//*[@id='identifierNext']/content/span"));
		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("pranshu");
		//button.sendKeys("pranshu");
	}
	

}
