package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New1 {
	
	public static WebDriver driver;

	@BeforeTest
	public void setupSuite() {
		
		System.setProperty("WebDriver.gecko.driver", "F://eclipse-java-neon-3-win32-x86_64//chromedriver_win32//geckodriver.exe");
	driver = new FirefoxDriver();
	}
	
	@Test
	public void runn()
	{
		System.out.println("testing ppp");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
