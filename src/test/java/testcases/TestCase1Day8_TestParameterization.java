package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class TestCase1Day8_TestParameterization {
	
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx");
	
	public static WebDriver driver;
	
	public static Properties config;
	
	public static Properties OR;
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		String sheetName="LoginTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName) ;
		
		OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		
		System.out.println(excel.getCellData(sheetName, 0, 2));
		
		System.out.println("Total rows are : "+rows+ ' ' + "Total columns are : " + cols );
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum=2; rowNum<=rows; rowNum++)
		{
			for (int colNum=0; colNum<cols; colNum++)
			{
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}

			
		/*data[0][0] = excel.getCellData(sheetName, 0, 2);
		data[0][1] = excel.getCellData(sheetName, 1, 2);
		
		data[1][0] = excel.getCellData(sheetName, 0, 3);
		data[1][1] = excel.getCellData(sheetName, 1, 3);
		
		data[2][0]  = excel.getCellData(sheetName, 0, 4);
		data[2][1]  = excel.getCellData(sheetName, 1, 2);
*/		
		//System.out.println("Data : " + data);
		

		
		
			
	@BeforeTest

	
		
	@BeforeMethod
	public void setUp() throws IOException 
	{
		config = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		
		
		
		if (config.getProperty("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
					}
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.get(config.getProperty("testsiteurl"));
		//driver = new FirefoxDriver();

	}
	
	public static void type(String locator, String value) throws IOException
	{
		if (locator.endsWith("_xpath"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
		else if (locator.endsWith("_css"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(OR.getProperty(value));
		}
		else if (locator.endsWith("_id"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(OR.getProperty(value));
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

		
	}
	
	
	
	@Test(dataProvider="getData")
	public static void doLogin(String username, String password) throws IOException
	{
		
		System.out.println(username + "--------" + password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys(username);
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(password);
		
*/		
		type("username_xpath",username);
		click("signinBtn_xpath");
		type("password_xpath",password);
		click("loggedinBtn_xpath");
	}
	
	@AfterTest
	public static void tearDown()
	{
		driver.quit();
	}


}
