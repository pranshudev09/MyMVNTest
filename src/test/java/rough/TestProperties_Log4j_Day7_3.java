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


public class TestProperties_Log4j_Day7_3 {
	
	

	
	
		
		//requirement fo generating logs application and system logs
		
	/*
	 * .Log Files
	 * Log 4j API
	 * Logger
	 * Log4j.properties - XML - Appenders
	 *
	 */
		
		public static Properties OR;
		public static Properties config;
		
		public static WebDriver driver;
		
		public static Logger log = Logger.getLogger("devpinoyLogger");
		
		public static boolean isElementPresent(String locator)
		{
			try{
				
			
		driver.findElement(By.xpath(OR.getProperty(locator))).isDisplayed();
		
		return true;
	
			}catch (Exception e)
			{
				return false;
			}
		
		
			
		}
		
		
		public static void type(String locator, String value)
		{
			try{
			if(locator.endsWith("_xpath"))
			{
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(OR.getProperty(value));
			}
			else if (locator.endsWith("_css"))
			{
				driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(OR.getProperty(value));
			}
			else if (locator.endsWith("_id"))
			{
				driver.findElement(By.id(OR.getProperty(locator))).sendKeys(OR.getProperty(value));
			}

			log.debug("Navigated to : " + locator + "and value entered : " + OR.getProperty(value));
			}catch (Throwable t)
			{
				log.debug(t.getMessage());
			}
		}

		
		public static void click(String locator)
		{
			if(locator.endsWith("_xpath"))
			{
				driver.findElement(By.xpath(OR.getProperty(locator))).click();

			}
			else if (locator.endsWith("_css"))
			{
				driver.findElement(By.cssSelector(OR.getProperty(locator))).click();

			}
			else if (locator.endsWith("_id"))
			{
				driver.findElement(By.id(OR.getProperty(locator))).click();

			}

			log.debug("clicked on : " + locator);
		}
		
				
		public static void main(String[] args) throws IOException, Exception {
			
			
		
			 OR = new Properties();
			config = new Properties();
			
			
			
				
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);


			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
			
			if (config.getProperty("browser").equals("firefox"))
				
			{
				driver = new FirefoxDriver();
			}
			else if (config.getProperty("browser").equals("chrome"))
			{
				System.setProperty("Webdriver.chrome.driver", "<path of chomedriver>");
				driver = new ChromeDriver();
			}
			else if (config.getProperty("browser").equals("IE"))
			{
			System.setProperty("Webdriver.IE.driver", "<path of IEDriver>");
			   driver = new InternetExplorerDriver();
			}
			else
			{
				driver = new FirefoxDriver();	
			}
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : "+ config.getProperty("testsiteurl"));
			
			driver.manage().window().maximize();
			log.debug("window maximized");
			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt (config.getProperty("time")), TimeUnit.SECONDS);
			
			
			type("username_xpath", "username_value");
			click("signinBtn_xpath");
			type("password_xpath", "password_value");
			click("loggedinBtn_xpath");
			
			System.out.println(isElementPresent("compose_xpath"));
			
			Thread.sleep(10000);
			
			driver.quit();
			
		}

	}



