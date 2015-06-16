package AppiumDemo.WebViewTest;

import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.URL;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Hello world!
 *
 */
public class OpenWeb 
{
	public IOSDriver driver;
    
	@Before
	public void setUp() throws Exception {
		// set up appium
		// 获得工程路径，绝对路径
		File appDir = new File("/Users/Shared/Jenkins/Home/jobs/iOS4Web/workspace/ios-webview-app-master/build/Release-iphonesimulator");
		//File appDir = new File("/Users/tingbaozhao/tmp");
		File app = new File(appDir, "WebViewApp.app");
		if (!app.exists()) {
			throw new RuntimeException(app.getAbsolutePath()
					+ " is not exists !");
		}
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, "7.1");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPhone Simulator");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	
	@Test
    public void goUrlTest(){
    	WebElement urlUIATextField = driver.findElementByAccessibilityId("urlFieldTest");
    	urlUIATextField.sendKeys("www.baidu.com");
    	WebElement goButton = driver.findElementByAccessibilityId("Go");
    	goButton.click();
    	Set<String> handlers = driver.getContextHandles();
    	System.out.println("context size:"+handlers.size());
    	for(String handlerName:handlers){
    		System.out.println("handler: "+ handlerName);
    	}
    }
}
