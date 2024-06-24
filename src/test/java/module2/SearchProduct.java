package module2;

import org.openqa.selenium.Keys;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.MyLibrary;

public class SearchProduct extends ParentModule2{

	@BeforeTest
	public void checkTestCaseExecution()
	{
		boolean output = MyLibrary.checkTestCaseForExecution(module2, "TestCases", this.getClass().getSimpleName());

		if(!output)
		{
			throw new SkipException("Execution mode of the test case "+this.getClass().getSimpleName()+" is set to NO");
		}
	
	}
	
	@Test
	public void testSearchProduct() throws InterruptedException
	{
		driver.get(sitedata.getProperty("url"));
		isElementPresent("ip_keywords_name").sendKeys("sony");
		Thread.sleep(1000);
		isElementPresent("ip_keywords_name").sendKeys(Keys.ENTER);
	}
}
