package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

public class TestUtils extends TestBase{
	
	
	public static String fileName;
	public static void captureScreenshot() throws IOException
	{
		
		Date d = new Date();
		fileName = "screenshot" + d.toString().replaceAll(":", "_").replace(" ", "_") + ".jpg";
		
		System.out.println(fileName);

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //to create file
		
		/*FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + 
		"\\test-output\\html\\"+fileName)); //to copy file
*/		
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") +
				"\\target\\surefire-reports\\html\\"+fileName));
		
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") +
				"\\target\\surefire-reports\\"+fileName));
	}

	
	public static Object[][] getData(String sheetName) throws IOException
	{
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName) ;
		
		/*OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);*/
		
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

	
}
