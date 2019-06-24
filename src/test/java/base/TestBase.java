package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utilities.ExcelReader;



public class TestBase {
	
	/*
	 * WebDriver
	 * Logs
	 * Properties
	 * DB
	 * Mail
	 * Excel
	 * Screenshots
	 * Reports
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static WebElement dropDown;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static WebDriverWait wait;
	
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx");
	//public static MonitoringMail mail = new MonitoringMail();
	
	
	
	
	@BeforeSuite
	public void setUp()
	{
		if(driver == null)
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				OR.load(fis);
				log.debug("OR properties file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    try {
				fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				config.load(fis);
				log.debug("Config properties file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    if (config.getProperty("browser").equals("firefox"))
		    {
		    	driver = new FirefoxDriver();
		    	log.debug("Firefox Launched");
		    }
		    else if (config.getProperty("browser").equals("chrome"))
		    {
		    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir"+ "\\src\\test\\resources\\executables\\chromedriver.exe"));
		    	driver = new ChromeDriver();
		    	log.debug("chrome launched");
		    }
		    
		    else if (config.getProperty("browser").equals("chrome"))
		    {
		    	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir" + "\\src\\test\\resources\\executables\\IEDriverServer.exe"));
	            driver = new InternetExplorerDriver();	
	            log.debug("IE launched");
		    }
		    
		    driver.get(config.getProperty("testsiteurl1"));
		    
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("Iwait")), TimeUnit.SECONDS);
	
            wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("Ewait")));
		
	}

	public static void type(String locator, String value)
	{
		try{
		if(locator.endsWith("_xpath"))
		{
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
		else if (locator.endsWith("_css"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys((value));
		}
		else if (locator.endsWith("_id"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
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
	
	public static void select(String locator, String value)
	{
		try{
		if(locator.endsWith("_xpath"))
		{
			dropDown=driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		else if (locator.endsWith("_css"))
		{
			dropDown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		else if (locator.endsWith("_id"))
		{
			dropDown=driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		Select select = new Select(dropDown);
		select.selectByVisibleText(value);
		

		log.debug("Navigated to : " + locator + "and value entered : " + OR.getProperty(value));
		}catch (Throwable t)
		{
			log.debug(t.getMessage());
		}
	}

	public static boolean isElementVisible(String locator, String value)
	{
		try{
			
		
		if (locator.endsWith("_css"))
		{
			dropDown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
			Select select = new Select(dropDown);
			select.selectByVisibleText(value);
		}
		else if (locator.endsWith("xpath"))
		{
			dropDown=driver.findElement(By.xpath(OR.getProperty(locator)));
			Select select = new Select(dropDown);
			select.selectByVisibleText(value);
		}
		else if (locator.endsWith("id"))
		{
			dropDown=driver.findElement(By.id(OR.getProperty(locator)));
			Select select = new Select(dropDown);
			select.selectByVisibleText(value);
		}
		log.debug("Finding presence of element" + locator);
		return true;
		}
		
		catch (Throwable t){
			log.debug("Error while finding element----"+locator+ t.getMessage());
			return false;
		}
			
		}
		
	
	
	public static boolean isElementPresent(String locator)
	{
		try
		{
		if(locator.endsWith("_xpath"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator)));

		}
		else if (locator.endsWith("_css"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator)));

		}
		else if (locator.endsWith("_id"))
		{
			driver.findElement(By.id(OR.getProperty(locator)));

		}
		
		
		log.debug("Finding Presence of Element : " + locator);
		return true;
	}
	
		
		catch (Throwable t) {
		log.debug("Error while finding element : " + locator+ "---"+ t.getMessage() );
		return false;

	}
	}

	
	@AfterSuite
	public void tearDown()
	{
		//driver.quit();
		//log.debug("Test Successfully executed !!!");
	}

}
