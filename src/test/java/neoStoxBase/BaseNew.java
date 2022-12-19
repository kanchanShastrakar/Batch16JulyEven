package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class BaseNew 
{
	protected static WebDriver driver;//webdriver unique karai sathi static kela i.e ekach copy duplicate tayar nai honar (this we write for not getting nullpointer exception)
	public void launchBrowser() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver= new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get(UtilityNew.readDataFromPropertyFile("url"));
		Reporter.log("launching Browser", true);
		Thread.sleep(1000);
	}

}
