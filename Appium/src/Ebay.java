import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Ebay {
	
		@Test
		public void subbu() throws InterruptedException{
			
			Thread.sleep(1000);
			
			driver.findElement(By.className("android.widget.TextView")).sendKeys("Camera");
			driver.findElement(By.id("android:id/search_go_btn")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String items = driver.findElement(By.id("android:id/action_bar_title")).getText();
			System.out.println(items);
			//driver.findElement(By.id("com.ebay.mobile:id/image")).click();
		}
		static WebDriver driver;

		@BeforeClass
		public static void setUp() throws MalformedURLException{
			//Set up desired capabilities and pass the Android app-activity and app-package to Appium
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//File app = new File("C:\\Users\\Endurance Grp\\AppData\\Local\\Android\\sdk\\build-tools\\19.1.0\\com.ebay.mobile-2.9.0.25-70-minAPI17.apk");
			capabilities.setCapability("BROWSER_NAME", "Android");
			capabilities.setCapability("VERSION", "5.1.1"); 
			//capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("deviceName","25ae97ff");
			capabilities.setCapability("platformName","Android");
		 
		   
		   capabilities.setCapability("appPackage", "com.ebay.mobile");
		// This package name of your app (you can get it from apk info app)
			capabilities.setCapability("appActivity","com.ebay.mobile.activities.eBay"); // This is Launcher activity of your app (you can get it from apk info app)
		//Create RemoteWebDriver instance and connect to the Appium server
		 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}

		@AfterClass
		public static void teardown() throws InterruptedException{
			//close the app
			Thread.sleep(100000);
			//driver.quit();
		}
		
		
		
	

}
