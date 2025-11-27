import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;

public class reporter {
	public static ExtentReports extent;
	public static ExtentTest logger;
	static WebDriver driver;
	static int step=1;
	static void takeScreenshot() throws IOException, WebDriverException {
		System.out.println("Taking Screenshot");
		File scrFile;
		scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile, new File("//C:\\Users\\Administrator\\Documents\\Selenium demo\\Exercisemaven\\Screenshots\\test"+step+".jpeg"));		
		step++;
	}
	
  @BeforeSuite
  public void beforeSuite() {
	  extent=new ExtentReports("C:\\Users\\Administrator\\Documents\\Selenium demo\\Exercisemaven\\TestCaseReport\\TestCasereport.html",true);
  }

  @AfterSuite
  public void afterSuite() {
	  extent.flush();
  }

}
