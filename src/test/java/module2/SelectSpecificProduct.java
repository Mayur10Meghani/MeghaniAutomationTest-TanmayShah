package module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.MyLibrary;

public class SelectSpecificProduct extends ParentModule2{

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
	public void testSelectSpecificProduct()
	{
		driver.get(sitedata.getProperty("url"));
		
		driver.findElement(By.linkText("Headphones")).click();
		
		List<WebElement> productLinks = driver.findElements(By.xpath("//*[@class='productListingData']/tbody/tr/td[2]/a"));
		List<WebElement> productBuyNow = driver.findElements(By.xpath("//*[@class='productListingData']/tbody/tr/td[4]/span/a"));

		int totalProducts = productLinks.size();
		int totalBuyNowButtons = productBuyNow.size();

		logs.info("Total Number of Products is->"+totalProducts);
		logs.info("Total Number of BuyNow button is->"+totalBuyNowButtons);

		
		for(int count=0;count<totalProducts;count++)
		{
			String prodText = productLinks.get(count).getText();
			
			if(prodText.equalsIgnoreCase("Sony MDR XB450"))
			{
				productBuyNow.get(count).click();
				break;
			}
		}
	
	}
}
