package baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utility.ExcelFileReader;

/*
1. Initialize and load the properties file
2. Launch the browser window
3. Maximize the browser window
4. Define Timeunit
5. Define Logger
6. ExtentReport implementation
7. Create isElementPresent method
*/

public class BaseInit {

	public static WebDriver driver;
	public static Properties sitedata;
	public static Logger logs;
	public static ExcelFileReader testsuites;
	public static ExcelFileReader module1;
	public static ExcelFileReader module2;

	
	public void startUP() throws Exception
	{
		
		logs = Logger.getLogger("devpinoyLogger");
		
		logs.info("Properties file will be loading");

		sitedata = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/java/propertiesdata/WebSiteData.properties");
		sitedata.load(fi);
		
		logs.info("Properties file loaded successfully");

		logs.info("Browser will be launching");

		String browserVal = sitedata.getProperty("browser");
		
		if(browserVal.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			logs.info("Chrome Browser launched");

		}
		else if(browserVal.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			logs.info("Firefox Browser launched");


		}
		else if(browserVal.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			logs.info("Edge Browser launched");


		}
		else if(browserVal.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
			logs.info("safari Browser launched");

		}
		else
		{
			System.out.println("There is no browser defined in the properties file");
			logs.info("There is no browser defined in the properties file");

		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		logs.info("Window has been maximized and timunit has been defined");
		
		testsuites = new ExcelFileReader("./src/test/java/files/TestSuites.xlsx");
		module1 = new ExcelFileReader("./src/test/java/files/Module1.xlsx");
		module2 = new ExcelFileReader("./src/test/java/files/Module2.xlsx");
		
		
		
				
	}
	
	public static WebElement isElementPresent(String propKey)
	{
		try
		{
			if(propKey.contains("xpath"))
			{
				return driver.findElement(By.xpath(sitedata.getProperty(propKey)));
			}
			else if(propKey.contains("id"))
			{
				return driver.findElement(By.id(sitedata.getProperty(propKey)));
			}
			else if(propKey.contains("name"))
			{
				return driver.findElement(By.name(sitedata.getProperty(propKey)));
			}
			else if(propKey.contains("linkText"))
			{
				return driver.findElement(By.linkText(sitedata.getProperty(propKey)));
			}
			else if(propKey.contains("tagName"))
			{
				return driver.findElement(By.tagName(sitedata.getProperty(propKey)));
			}
			else
			{
				logs.info("Key not found in the properties file");
			}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
}
