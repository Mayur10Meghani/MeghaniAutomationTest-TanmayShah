package utility;

import org.openqa.selenium.By;

import baseclass.BaseInit;

public class MyLibrary extends BaseInit{

	public static void signIN(String email, String pwd)
	{
		//driver.findElement(By.linkText(sitedata.getProperty("lnk_logyourselfin_linkText"))).click();
		isElementPresent("lnk_logyourselfin_linkText").click();
		isElementPresent("ip_email_name").sendKeys(email);
		isElementPresent("ip_password_name").sendKeys(pwd);
		isElementPresent("btn_signin_id").click();
	
	}
	
	public static void signOUT()
	{
		isElementPresent("lnk_logoff_linkText").click();
		isElementPresent("lnk_continue_id").click();

	}
	
	public static Object[][] getTestDataFromXLSX(ExcelFileReader data, String sheetName)
	{
		int rows = data.totalRow(sheetName);
		int cols = data.totalColumn(sheetName);
		
		Object[][] myData = new Object[rows-1][cols];
		
		for(int row=1;row<rows;row++)
		{
			for(int col=0;col<cols;col++)
			{
				myData[row-1][col] = data.getData(sheetName, row, col);
			}
		}
		
		return myData;
	}
	

	public static boolean checkTestSuiteForExecution(ExcelFileReader data, String sheetName, String tsName)
	{
				
		int rows = data.totalRow(sheetName);  //3  -- 0,1,2
		
		for(int row=1;row<rows;row++)
		{
			String testsuite = data.getData(sheetName, row, 0);
			
			if(testsuite.equalsIgnoreCase(tsName))
			{
				String exeMode = data.getData(sheetName, row, 2);
				
				if(exeMode.equalsIgnoreCase("Y"))
					
					return true;
				else
					return false;
			}
		}
		return false;
		
		
	}
	
	public static boolean checkTestCaseForExecution(ExcelFileReader data, String sheetName, String tcName)
	{
				
		int rows = data.totalRow(sheetName);
		
		for(int row=1;row<rows;row++)
		{
			String testcase = data.getData(sheetName, row, 0);
			
			if(testcase.equalsIgnoreCase(tcName))
			{
				String exeMode = data.getData(sheetName, row, 2);
				
				if(exeMode.equalsIgnoreCase("Y"))
					
					return true;
				else
					return false;
			}
		}
		return false;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
