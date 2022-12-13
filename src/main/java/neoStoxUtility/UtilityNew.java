package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew 
{ 
public static String readDataFromPropertyFile(String key) throws IOException
{
	Properties prop=new Properties();
	FileInputStream myFile=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\16JUL_A_EVEN\\NeoStox.properties");
	prop.load(myFile);
	String value = prop.getProperty(key);
	Reporter.log("Reading "+key+" from property file",true);
	return value;	
}
public static void screenshot(WebDriver driver,String screenShotName) throws IOException
{
	wait(driver,500);
	File Src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 
	File dest = new File("D:\\Selenium\\Screenshot\\"+screenShotName+".png");
	FileHandler.copy(Src,dest);
	Reporter.log("taking screenshot", true);
}
//for scrolling
public static void scrollIntoview(WebDriver driver,WebElement element)
{
	wait(driver,500);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	Reporter.log("Scrolling into view", true);

}
//for wait
public static void wait(WebDriver driver,int waitTime)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
	Reporter.log(" Waiting for" +waitTime+ "ms",true);
}

}
