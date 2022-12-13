package neoStoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBase.BaseNew;
import neoStoxPOM.NeoStoxHomePage;
import neoStoxPOM.NeoStoxLoginPage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSignInPage;
import neoStoxUtility.UtilityNew;

@Listeners(neoStoxBase.Listener.class)
public class ValidateNeoStoxUserName2 extends BaseNew
{
	NeoStoxLoginPage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	
	@BeforeClass
	public void launchNeoStox() throws InterruptedException, IOException
	{
	launchBrowser();//form base class
	login= new NeoStoxLoginPage(driver);
	password= new NeoStoxPasswordPage(driver);
	home= new NeoStoxHomePage(driver);
	signIn=new NeoStoxSignInPage(driver);
	}
	@BeforeMethod
	public void logintoNeoStox() throws EncryptedDocumentException, IOException, InterruptedException 
	{
	signIn.clickOnSignInButton(driver);
	Thread.sleep(1000);
	login.sendMobileNum(driver, UtilityNew.readDataFromPropertyFile("mobileNum"));
	login.clickOnSignInButton(driver);
	UtilityNew.wait(driver, 2000);
	Thread.sleep(2000);
	password.enterPassword(driver, UtilityNew.readDataFromPropertyFile("password"));
	password.clickOnSubmitButton(driver);
	Thread.sleep(1000);
	home.handlePopUp(driver);
	}
	@Test
	 public void validateAccBalance() throws EncryptedDocumentException, IOException
	{
		Assert.assertNotNull(home.getAccBalance(driver), "TC failed unable to fetch account balance");
		Assert.fail();
		//Utility.screenshot(driver, "ACCBalance");
	}
	@Test(priority=-1)
	public void validateUserID() throws IOException
	{
	Assert.assertEquals(home.getActualUserName(driver), UtilityNew.readDataFromPropertyFile("UserName"),"TC is failed Actual and expected User Name are not matching");
	UtilityNew.screenshot(driver, home.getActualUserName(driver));
	}
	@AfterMethod
	public void logOutFromNeoStox()
	{
	home.logOut(driver);
	}
	@AfterClass
	public void closeBrowser()
	{
	Reporter.log("closing browser", true);
	driver.close();
	}
}

//we run only TestClass
//how to run failed TC
//In listerners i will be implementing ITestListener i will be using multiple class onTestFailure,onTestSuccess,onTestSkipped
//whenever TCs failed i will take screenshot
//i m using @listners annotation(@Listeners(neoStoxUtility.Listener.class))
//he class level la zhala xml level la  asa lihaw lagel

//<suite name="Suite">
//<listeners>
//<listener class-name="listener.Listener"/>
//</listeners>
//
//  <test thread-count="5" name="Test">
//    <classes>
//      <class name="listener.Testing2"/>
//      <class name="listener.Testing1"/>
//    </classes>
//  </test> <!-- Test -->
//</suite>




