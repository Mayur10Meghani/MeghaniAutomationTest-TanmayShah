package module1;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import baseclass.BaseInit;
import utility.MyLibrary;

public class ParentModule1 extends BaseInit{

	@BeforeSuite
	public void checkTestSuiteExecution() throws Exception
	{
		
		startUP();
		boolean output = MyLibrary.checkTestSuiteForExecution(testsuites, "TestSuites", "Module1");
	
		if(!output)
		{
			throw new SkipException("Execution mode of the test suite Module1 is set to NO");
		}
	
	}
	
}
