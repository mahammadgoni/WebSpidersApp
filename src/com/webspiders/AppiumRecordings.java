package com.webspiders;


	
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;
	import java.net.MalformedURLException;
	import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class AppiumRecordings {

	  @SuppressWarnings("rawtypes")
	private AndroidDriver driver;

	  @SuppressWarnings("rawtypes")
	@BeforeTest
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//	    desiredCapabilities.setCapability("deviceName", "Google Nexus 5 - 4.4.4 - API 19 - 1080x1920");
//	    desiredCapabilities.setCapability("udid", "192.168.57.101:5555");
	    
	    desiredCapabilities.setCapability("deviceName", "Nexus5");
	    desiredCapabilities.setCapability("udid", "emulator-5554");
	    
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "4.4.4");
	    desiredCapabilities.setCapability("appPackage", "nhs.ibd.com.nhsibd");
	    desiredCapabilities.setCapability("appActivity", "nhs.ibd.com.nhsibd.Features.Login.FreshLogin.FreshLoginActivity");
	    desiredCapabilities.setCapability("noReset", true);

	    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	  @Test (priority = 1)
	  public void NewRegistration(/*String fName, String email, String hosNo, String hosName, String phNo*/) {
		  
	    MobileElement registerNow = (MobileElement) driver.findElementById("nhs.ibd.com.nhsibd:id/registerNowTV");
	    registerNow.click();
	    
	    System.out.println(registerNow);
	    MobileElement fullName = (MobileElement) driver.findElementById("nhs.ibd.com.nhsibd:id/nameET");
	    fullName.sendKeys("Bat Man");
	    MobileElement emailId = (MobileElement) driver.findElementById("nhs.ibd.com.nhsibd:id/emailET");
	    emailId.sendKeys("batman@mailinator.com");
	    MobileElement hospitalNo = (MobileElement) driver.findElementById("nhs.ibd.com.nhsibd:id/hospitalNumberET");
	    hospitalNo.sendKeys("1637");
	    MobileElement phoneNo = (MobileElement) driver.findElement(By.id("nhs.ibd.com.nhsibd:id/phoneET"));
	    phoneNo.sendKeys("09876543210");
	    MobileElement selectHospital = (MobileElement) driver.findElementById("nhs.ibd.com.nhsibd:id/selectedHospitalTV");
	    selectHospital.click();
	    MobileElement searchHospital = (MobileElement) driver.findElementById("nhs.ibd.com.nhsibd:id/searchHospitalACTV");
	    searchHospital.sendKeys("Black");
	    MobileElement chooseHospital = (MobileElement) driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/nameTV']");
	    chooseHospital.click();
	    MobileElement completeReg = (MobileElement) driver.findElementById("nhs.ibd.com.nhsibd:id/registerBTN");
	    completeReg.click();
				    
//try {
//			
//			if (registerNow.isDisplayed()) {
//				
//				System.out.println("Clicking on Register Now");
//				
//				registerNow.click();
//				
//				System.out.println("Clicking on Log you as someone else");
//				
////				notYouLogin.click();
//				
//			}
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//			
//		// Entering Full Name
//		
//		fullName.sendKeys(fName);
//		
//		// Entering Email Id 	
//		
//		emailId.sendKeys(email);
//		
//		// Entering Hospital No
//			
//		hospitalNo.sendKeys(hosNo);
//		
//		// Entering phone No
//		
//	    try {
//	    		    	
//	    	phoneNo.sendKeys(phNo);
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	    // Select Hospital
//	    
//	    selectHospital.click();
//	    
//	    // Search Hospital
//    
//	    searchHospital.sendKeys(hosName);
//	    
//	    // Choose the Hospital
//	    	    
//	    chooseHospital.click();
//	    
//	    // Click on Complete Registration 
//	    
//	    completeReg.click();
//	    
	  }

	  @AfterTest
	  public void tearDown() {
	    driver.quit();
	  }
	  
//	  @Test (priority = 1)
//	  public void NewRegistrationTest(){
//		  
//		  AppiumRecordings ar = new AppiumRecordings();
//		  
//		  ar.NewRegistration("Bat Man", "batman@mailinator.com", "1289", "Black", "09876543210");
//		  
//	  }
	  
	  
	}



