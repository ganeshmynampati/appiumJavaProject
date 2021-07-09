package defaultProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class DragAndDrop {

	public static void main(String args[]) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = null;
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.VERSION, "10.0");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("noReset", "false");
		// cap.setCapability("fullReset", "true"); // Uninstall the app after code
		// execution is completed
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Drag and Drop\"));");
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		WebElement sourceEle = driver
				.findElement(By.xpath("//*[@class='android.widget.RelativeLayout']/child::android.view.View[1]"));
		WebElement destEle = driver
				.findElement(By.xpath("//*[@class='android.widget.RelativeLayout']/child::android.view.View[2]"));
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(sourceEle))).moveTo(element(destEle)).release().perform();

	}

}
