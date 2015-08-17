import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;


public class LowesApp {

	AndroidDriver dr;
	@Test 
	public void  login() throws MalformedURLException, InterruptedException{
	
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		File app = new File("C:\\Users\\Endurance Grp\\AppData\\Local\\Android\\sdk\\build-tools\\19.1.0\\2644896.com.lowes.android.apk");
		//capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1.1"); 
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("deviceName","25ae97ff");
		capabilities.setCapability("platformName","Android");
	 
	   
	   capabilities.setCapability("appPackage", "com.lowes.android");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","controller.util.LaunchActivity"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	   dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	
	WebElement but =  dr.findElement(By.id("com.lowes.android:id/store_locator_search"));
	but.sendKeys("95126");
	dr.hideKeyboard();
	//dr.findElement(By.id("com.lowes.android:id/store_locator_search")).sendKeys(Keys.ENTER);
	   dr.sendKeyEvent(AndroidKeyCode.ENTER);
	   Thread.sleep(1000);
	List<WebElement> tex = dr.findElements(By.id("com.lowes.android:id/store_name"));
	
	System.out.println(tex.size());
	for(WebElement text1 : tex){
		System.err.println(text1.getText());
	}
	
	WebElement cl = tex.get(0);
	cl.click();
	Thread.sleep(1000);
	//System.out.println(cl.isSelected());
	dr.findElement(By.id("com.lowes.android:id/btn_set_as_my_store")).click();
	
	//WebElement links = dr.findElement(By.tagName("index"));	
	//System.out.println(links.get(2));
	//int s = dr.findElementsByAndroidUIAutomator("UiSelector().index(0)").size();
	Thread.sleep(1000);
	WebElement sub =dr.findElementByAndroidUIAutomator("UiSelector().index(0)");
	System.out.println(sub.getTagName());
	//System.out.println(s);
	
	WebElement sear = dr.findElementByAndroidUIAutomator("UiSelector().text(\"Search Lowe's\")");
	sear.click();
	sear.sendKeys("camera");
	dr.sendKeyEvent(AndroidKeyCode.ENTER);
	
	
	int num =dr.findElements(By.className("android.widget.CheckBox")).size();
	List<WebElement> checkbox = dr.findElements(By.className("android.widget.CheckBox"));
	System.out.println(checkbox.get(0).getAttribute("checked"));
	checkbox.get(0).click();
	System.out.println(num);
	
	dr.findElement(By.id("com.lowes.android:id/products_filter_button")).click();
	List<WebElement> butt = dr.findElements(By.id("com.lowes.android:id/arrow"));
	//for(WebElement buttons : butt){
		//System.out.println(buttons.getText());
		System.out.println(butt.get(1));
		butt.get(1).click();
	//}
	WebElement star = dr.findElementByAndroidUIAutomator("UiSelector().text(\"4  or more stars (1)\")");
		star.click();
		
	dr.findElement(By.id("com.lowes.android:id/ok_button")).click();	
	dr.findElementByAndroidUIAutomator("UiSelector().text(\"Nest Cam Digital Wireless Indoor Only Security Camera with Night Vision\")").click();
	Thread.sleep(1000);
	String subbu = dr.findElement(By.id("com.lowes.android:id/productName")).getText();
	System.out.println(subbu);
	MobileElement toolbar = dr.scrollTo("Product Information");
	toolbar.swipe(SwipeElementDirection.DOWN, 0);
	
	
	
	
	
	String mod = dr.findElement(By.id("com.lowes.android:id/productItemAndModel")).getText();
	String d = mod.substring(22, mod.length());
	System.out.println(d);
	

	
	WebElement serr = dr.findElement(By.id("com.lowes.android:id/menu_search"));
	serr.click();
	Thread.sleep(2000);
	
	dr.findElement(By.id("com.lowes.android:id/action_bar_search_auto_complete")).sendKeys(d);

	dr.sendKeyEvent(AndroidKeyCode.ENTER);
	
	String subbu1 = dr.findElement(By.id("com.lowes.android:id/productName")).getText();
	System.out.println(subbu1);
	
	if(subbu.equals(subbu1)){
		System.out.println("Test pass");
	}
		else{
			System.out.println("Test Fail");
		}
	}
	
		
	@AfterTest
	public void end(){
		if(dr!=null)
			dr.quit();
	}

}
