package com.webspiders;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleHomeTest {
	
	
	WebDriver driver = null;
	int timeOut = 180;
	int  port = -1;
	
//	GoogleHomeTest(int port){
//		this.port = port;
//	}
	@BeforeTest
	public void openEmulator(int port,String em,String version) throws MalformedURLException, InterruptedException{
		
		this.port = port;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		
		capabilities.setCapability(CapabilityType.VERSION, version);
		
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		
		capabilities.setCapability("udid", em);
		

		capabilities.setCapability("appPackage", "nhs.ibd.com.nhsibd");

		capabilities.setCapability("appActivity", "nhs.ibd.com.nhsibd.Features.Login.FreshLogin.FreshLoginActivity");
		
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:"+this.port+"/wd/hub"),capabilities);
        
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        
        Thread.sleep(50000);
		
	}
	@Test
	public void test(){
		try {
			openEmulator(4723,"192.168.57.101:5555", "6.0");
			
			openEmulator(4723,"emulator-5554", "4.4.4");
			
		} catch (Exception e) {
		
		}
	}
	
	@AfterTest
	public void close(){
		driver.close();
	}


}
