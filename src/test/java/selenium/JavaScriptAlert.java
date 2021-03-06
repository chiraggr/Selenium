package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptAlert {
	  WebDriver driver;
		
		@BeforeClass
		public void setUp() {
			//for Mac OS
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/drivers/geckodriver");
			// For Window OS
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			

		}

		@Test
		public void verifyNumberOfNavigationMenus() throws InterruptedException {
				driver.get("file:///Users/bsingh5/Desktop/SeleniumPractices/javaScriptAlert.html");
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("html/body/button")).click();
				
				Thread.sleep(2000);
				
				String text = driver.switchTo().alert().getText();
				
				System.out.println(text);
				
				Assert.assertEquals(text, "Press a button!");
				
				driver.switchTo().alert().dismiss();
		}

		@AfterClass
		public void endTest() {
			//driver.close();
		}
}
