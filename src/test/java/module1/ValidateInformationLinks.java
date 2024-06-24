package module1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.MyLibrary;

public class ValidateInformationLinks extends ParentModule1{

	@BeforeTest
	public void checkTestCaseExecution()
	{
		boolean output = MyLibrary.checkTestCaseForExecution(module1, "TestCases", this.getClass().getSimpleName());

		if(!output)
		{
			throw new SkipException("Execution mode of the test case "+this.getClass().getSimpleName()+" is set to NO");
		}
	
	}
	
	@Test
	public void testValidateInformationLinks() throws InterruptedException
	{
		driver.get(sitedata.getProperty("url"));
		
		WebElement informationDIV = isElementPresent("div_information_xpath");
		List<WebElement> infoElements = informationDIV.findElements(By.tagName("a"));
		int infoSize = infoElements.size();
		
		
		for(int count=0;count<infoSize;count++)
		{
			infoElements.get(count).click();
			Thread.sleep(1000);
			logs.info(driver.getTitle()+"->"+driver.getCurrentUrl());
			driver.navigate().back();
			informationDIV = isElementPresent("div_information_xpath");
			infoElements = informationDIV.findElements(By.tagName("a"));
		}
		
	}
}
