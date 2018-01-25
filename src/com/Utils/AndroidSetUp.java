package com.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidSetUp {
	@SuppressWarnings("rawtypes")
	protected static AndroidDriver driver;

	String appPackagename = "nhs.ibd.com.nhsibd";

	// String activityName =
	// "nhs.ibd.com.nhsibd.Features.Login.FreshLogin.FreshLoginActivity";

	String activityName = "nhs.ibd.com.nhsibd.Features.Login.FreshLogin.FreshLoginActivity";
	
	String apkPath = "/Users/goni/Documents/Automation/IDBAppiumTest/apps/MyIDBCare.apk";

	// String appiumServiceUrl;
	//
	// AppiumDriverLocalService appiumService;
	//
	// AppiumServiceBuilder builder;

	@SuppressWarnings("rawtypes")
	protected void prepareAndStartAppium(String DeviceName, String UDID, String PlatformVersion)
			throws MalformedURLException {
		// protected void prepareAndStartAppium() throws MalformedURLException {
		//
		// builder = new AppiumServiceBuilder();
		//
		// builder.withIPAddress(Url);
		//
		// builder.withCapabilities(capabilities);
		//
		// builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		//
		// builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		// driver = new AndroidDriver(new URL("http://"+Url), capabilities);

		// System.out.println("Starting the Appium Server ");
		//
		// appiumService = AppiumDriverLocalService.buildService(builder);
		//
		// appiumService.start();
		//
		// appiumServiceUrl = appiumService.getUrl().toString();
		//
		// System.out.println("Appium Server Address Url : -
		// "+appiumServiceUrl);
		//
		//
		// System.out.println("Starting the Appium Server ");
		//
		// appiumService = AppiumDriverLocalService.buildDefaultService();
		//
		// appiumService.start();
		//
		// appiumServiceUrl = appiumService.getUrl().toString();
		//
		// System.out.println("Appium Server Address Url : -
		// "+appiumServiceUrl);
		//

		DesiredCapabilities capabilities = new DesiredCapabilities();

		System.out.println("===============================================");

		System.out.println("Setting Up the Device Configuaration ");

		// capabilities.setCapability("appium-version", "1.7.1");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("platformVersion", PlatformVersion);

		// capabilities.setCapability("platformVersion", "4.4.4");

		// capabilities.setCapability("deviceName", "emulator-5554");
		//
		// capabilities.setCapability("udid", "emulator-5554");
		//
		capabilities.setCapability("deviceName", DeviceName);

		capabilities.setCapability("udid", UDID);

		capabilities.setCapability("app", apkPath);

		// capabilities.setCapability("appPackage", "nhs.ibd.com.nhsibd");

		capabilities.setCapability("appPackage", appPackagename);

		// capabilities.setCapability("appActivity",
		// "nhs.ibd.com.nhsibd.Features.Login.FreshLogin.FreshLoginActivity");

		capabilities.setCapability("appActivity", activityName);
		
//		capabilities.setCapability("noResetValue", "false");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}
	
	protected void installApp(){
		
		System.out.println("Installing the Application ");
		
		driver.installApp(apkPath);
		
		System.out.println("Successfully Installed the Application ");
		
	}
	
	protected void uninstallApp(){
		
		System.out.println("Uninstalling the Application the Application");
		
		driver.removeApp(appPackagename);
		
		System.out.println("Successfully Uninstalled the Application");
		
		System.out.println("       ");
		
		System.out.println("===============================================");
		
	}

	protected void gotoHome() {
		
		System.out.println("Going Back to Home");

		driver.pressKeyCode(AndroidKeyCode.BACK);

		driver.pressKeyCode(AndroidKeyCode.HOME);
	}

	protected void openTheApp() {
	
		
		System.out.println("Opening the App Again to Check the Changed Password");

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("appPackage", appPackagename);

		caps.setCapability("appActivity", activityName);

	}
	
	
	protected void swipeRightToLeft(){
		

		
	
	}

	//
	// protected void startAppiumServer(){
	//
	// System.out.println("Starting the Appium Server ");
	//
	// appiumService = AppiumDriverLocalService.buildDefaultService();
	//
	// appiumService.start();
	//
	// appiumServiceUrl = appiumService.getUrl().toString();
	//
	// System.out.println("Appium Server Address Url : - "+appiumServiceUrl);
	//
	//
	//
	// }
	//
	// protected void stopAppiumServer(){
	//
	// System.out.println("Stoping the Appium Server ");
	//
	// appiumService.stop();
	//
	// }

}
