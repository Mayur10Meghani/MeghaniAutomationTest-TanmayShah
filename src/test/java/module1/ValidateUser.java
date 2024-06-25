package module1;

import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.MyLibrary;

public class ValidateUser extends ParentModule1{

	@BeforeTest
	public void checkTestCaseExecution()
	{
		boolean output = MyLibrary.checkTestCaseForExecution(module1, "TestCases", this.getClass().getSimpleName());

		if(!output)
		{
			throw new SkipException("Execution mode of the test case "+this.getClass().getSimpleName()+" is set to NO");
		}
	//test update...123
		if(output)
		{
			throw new SkipException("Execution mode of the test case "+this.getClass().getSimpleName()+" is set to NO");
		}
	}
	
	
	@Test(dataProvider = "getTestData")
	public void testValidateUser(String email, String pwd)
	{
		driver.get(sitedata.getProperty("url"));
		
		MyLibrary.signIN(email, pwd);
		
		try
		{
		
		WebElement logOffElement = isElementPresent("lnk_logoff_linkText");
		
		if(logOffElement.isDisplayed())
		{
			logs.info("User has been logged in successfully");
			MyLibrary.signOUT();
		}
		}catch(Exception e)
		{
			logs.info("Invalid Email Address or Password");
			
		}
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		return MyLibrary.getTestDataFromXLSX(module1, "ValidateUser");
	}
	
	
	
}
