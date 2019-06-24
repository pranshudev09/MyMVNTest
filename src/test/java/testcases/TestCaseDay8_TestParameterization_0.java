package testcases;



	
	

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

	public class TestCaseDay8_TestParameterization_0 {
		
		
		public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\TestData.xlsx");
		public static WebDriver driver;
		
		@BeforeTest
		public void setUp(){
			
			driver = new FirefoxDriver();
			
		}
		
		@AfterTest
		public void tearDown(){
			
			//driver.quit();
			
			
		}
		
		
		
		@DataProvider
		public Object[][] getData(){
			
			String sheetName = "LoginTest";
			int rows = excel.getRowCount(sheetName);
			int cols = excel.getColumnCount(sheetName);
			
			System.out.println(excel.getCellData(sheetName, 0, 2));
			
			System.out.println("Total rows are : "+rows+"---"+"Total cols are : "+cols);
			
			Object[][] data = new Object[rows-1][cols];
			
			
			for(int rowNum=2; rowNum<=rows; rowNum++){
				
				for(int colNum=0; colNum<cols; colNum++){
					
				data[rowNum-2][colNum] =	excel.getCellData(sheetName, colNum, rowNum);
					
				}
				
				
			}
			
		
			
			return data;
		}
		
		
		
		
		
		@Test(dataProvider="getData")
		public void doLogin(String username, String password){
			
			driver.navigate().to("https://gmail.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
			driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(password);
		}

	}


