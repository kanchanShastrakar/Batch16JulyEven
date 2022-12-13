package neoStoxBase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;


public class Listener extends BaseNew implements ITestListener //inbuild
{

public void onTestFailure(ITestResult result)
{
	 String tcName = result.getName();
	Reporter.log("TC "+tcName+" failed please try again...", true);
	try {
		UtilityNew.screenshot(driver, tcName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//yala original driver pahije manhun apan Listener la extends kela BaseNew(yaat original driver ahe)
}

	public void onTestSuccess(ITestResult result)
{
	Reporter.log("TC "+result.getName()+" success...", true);
}

	public void onTestSkipped(ITestResult result)
{
	Reporter.log("TC "+result.getName()+" is skipped please check...", true);
}
}
