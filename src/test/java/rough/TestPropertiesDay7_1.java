package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;




public class TestPropertiesDay7_1 {
	
	
	
	public static void main(String[] args) throws IOException{
		
		
		Properties OR = new Properties();
		Properties config = new Properties();
		
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);

		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		
		System.out.println(OR.getProperty("username_xpath"));
		
		System.out.println(config.getProperty("testsiteurl"));
		
	}

}
