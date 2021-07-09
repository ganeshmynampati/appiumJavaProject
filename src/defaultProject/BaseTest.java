package defaultProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

	public static void main(String args[]) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = null;
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.VERSION, "10.0");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("noReset", "false");
		// cap.setCapability("fullReset", "true");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		List<AndroidElement> prefList=driver.findElements(By.id("android:id/text1"));
		System.out.println("The total number of preference options is "+" "+prefList.size());
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys("hello");
		// --> This is also working and can be used.
		//driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		
		// driver.findElement(By.xpath("//*[@text=\"OK\"]")).click(); --> This is also
		// working and can be used.
		// driver.findElementByXPath("//*[@text=\"OK\"]").click(); --> This is also
		// working and can be used.
		
		//driver.findElementByAndroidUIAutomator("text(\"OK\")").click(); // --> This is also working and can be used.
		

	}

}