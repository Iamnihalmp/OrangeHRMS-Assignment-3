import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class griddemo {
	static WebDriver driver;
	static String nodeURL;


	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		nodeURL="http://172.19.3.88:4444/wd/hub";
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("MicrosoftEdge");
		capabilities.setPlatform(Platform.WINDOWS);
		driver=new RemoteWebDriver(new URL(nodeURL),capabilities);
		driver.get("https://demowebshop.tricentis.com");
		driver.findElement(By.linkText("Register")).click();
		System.out.println(driver.getTitle());
		driver.get("https://demowebshop.tricentis.com");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("abddemo@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("newpassword");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(3000);
		driver.quit();
		
				

	}

}
