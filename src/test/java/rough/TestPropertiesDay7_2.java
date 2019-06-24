package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestPropertiesDay7_2 {
	
	//requirement fo generating logs application and system logs
	
	
	
	
	public static WebDriver driver;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static void click(String locator)
	{
		
		driver.findElement(By.xpath(locator)).click();
	}
	
	public static void type(String locator, String value)
	{
		driver.findElement(By.xpath(locator)).sendKeys(value);
		
	}
	
	public static void main(String[] args) throws IOException {
	
		Properties pro = new Properties();
		
		/*
		 * .Log Files
		 * Log 4j API
		 * Logger
		 * Log4j.properties - XML - Appenders
		 *
		 */
			
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		pro.load(fis);


		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		pro.load(fis);
		
		if (pro.getProperty("browser").equals("firefox"))
			
		{
			driver = new FirefoxDriver();
		}
		else if (pro.getProperty("browser").equals("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "<path of chomedriver>");
			driver = new ChromeDriver();
		}
		else if (pro.getProperty("browser").equals("IE"))
		{
		System.setProperty("Webdriver.IE.driver", "<path of IEDriver>");
		   driver = new InternetExplorerDriver();
		}
		else
		{
			driver = new FirefoxDriver();	
		}
		
		driver.get(pro.getProperty("testsiteurl"));
		log.debug("Navigated to : "+ pro.getProperty("testsiteurl"));
		
		driver.manage().window().maximize();
		log.debug("window maximized");
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt (pro.getProperty("time")), TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(pro.getProperty("username_xpath"))).sendKeys(pro.getProperty("username_value"));
		log.debug(pro.getProperty("username_xpath") + "value entered : "+ pro.getProperty("username_value"));
		
		driver.findElement(By.xpath(pro.getProperty("signinBtn_xpath"))).click();
		
		driver.quit();
		
	}

}
