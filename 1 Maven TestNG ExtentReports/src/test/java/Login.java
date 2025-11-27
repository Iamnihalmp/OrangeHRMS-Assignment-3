import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Login extends reporter {
  @Test
  public void f() throws WebDriverException, IOException {
	  logger=extent.startTest("Test case:login");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  List<WebElement>dashboard=driver.findElements(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
	  try {
		 if(!dashboard.isEmpty()) {
			 assertTrue(true);
			 logger.log(LogStatus.PASS, "Login test passed");
			 extent.endTest(logger);
			 
		 }
		 else {
			 takeScreenshot();
			 logger.log(LogStatus.FAIL, "Login test failed");
			 extent.endTest(logger);
			 assertTrue(false);
			 
			 
		 }
	  }catch(AssertionError e)
	  {
		  throw e;
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new EdgeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
