package com.webspiders;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {

	
	public static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appium-version", "1.5.3");
		
		capabilities.setCapability("platformName", "Android");
		
		capabilities.setCapability("platformVersion", "4.4.4");
		
		capabilities.setCapability("deviceName", "Google Nexus 5 - 4.4.4 - API 19 - 1080x1920");
		
		capabilities.setCapability("app", "/Users/goni/Downloads/Apks/app-nhsibd-debug.apk");
		
		capabilities.setCapability("appPackage", "nhs.ibd.com.nhsibd");
		
		capabilities.setCapability("appActivity", "nhs.ibd.com.nhsibd.Features.Login.FreshLogin.FreshLoginActivity");
		
		//driver = new AndroidDriver<MobileElement>(new URL("http://172.22.0.44:4723/wd/hub"), capabilities);
		
		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4444/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		

	}

}
