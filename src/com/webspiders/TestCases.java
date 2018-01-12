package com.webspiders;

import org.testng.annotations.Test;

import com.Utils.GetScreenShot;
import com.Utils.ScreenRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({GetScreenShot.class})

public class TestCases {

	public static AndroidDriver<AndroidElement> driver;
	//private WebDriver driver;
	
//	TestRecorder ts = new TestRecorder();
	
	ScreenRecorder sr = new ScreenRecorder();
	
	String currentTestMethodName = "";

	
	@BeforeTest (alwaysRun=true)
	public void BaseSetUp(Method method) throws IOException {
		
		currentTestMethodName = method.getName();
		
		ScreenRecorder.StartScreenRecording(currentTestMethodName);
		
//		ts.StartRecord();

		File classPath = new File(System.getProperty("user.dir"));
		
		File appDir = new File(classPath, "/APK");
		
		File app = new File(appDir, "MyIDBCare.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		/*capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 5 - 4.4.4 - API 19 - 1080x1920");
		
		capabilities.setCapability(MobileCapabilityType.UDID, "192.168.56.101:5555");
		
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.4");
		
		//capabilities.setCapability(MobileCapabilityType., "192.168.56.101:5555");
		
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");*/
		
		
		
		capabilities.setCapability("deviceName", "Google Nexus 5 - 4.4.4 - API 19 - 1080x1920");
		
		//capabilities.setCapability("deviceName", "Hol-U19");
		
//		capabilities.setCapability("deviceName", "emulator-5554");
		
		capabilities.setCapability("udid", "192.168.57.101:5555"); //Give Device ID of your mobile phone
		
		//capabilities.setCapability("udid", "IJYHMFAIZT65CAQK");
		
		capabilities.setCapability("platformName", "Android");
		
		capabilities.setCapability("platformVersion", "4.4.4");
		
		capabilities.setCapability("appPackage", "nhs.ibd.com.nhsibd");
		
		capabilities.setCapability("appActivity", "nhs.ibd.com.nhsibd.Features.Login.FreshLogin.FreshLoginActivity");
		
		capabilities.setCapability("noReset", "true");
		
		System.out.println("App installed successfully");
				
		capabilities.setCapability("app", app.getAbsolutePath());
		
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("Successfully Opened the App !");
	}

	@AfterClass (alwaysRun=true)
	public void CloseSetUp() throws ATUTestRecorderException, IOException, InterruptedException {
		
			
		try {
			
			Thread.sleep(5000);
			driver.closeApp();
			
			System.out.println("Logout Success");
			
		} catch (Exception e) {
			
            System.out.println("Logout Failed");
            e.printStackTrace();
			
		}
		
//		String videoDir = "RecordedTest";
//		new File(videoDir).mkdir();
		
		ScreenRecorder.StopScreenRecording(currentTestMethodName, "/RecordedTest", true);
		
//		ts.StopRecord();
		

	}
	
	@Test (priority = 3,alwaysRun = true)
	public void HomePageTest(){
		
		
//		RemoteWebElement dashboard = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.view.View/android.widget.TextView"));
		
		AndroidElement loggedUserName = driver.findElement(By.id("userNameTV"));	
		
	        String ActTitle = "Sk Goni";
			
			String ExpTitle = loggedUserName.getText();
			
			Assert.assertEquals(ExpTitle,ActTitle);
			
			System.out.println(ExpTitle);
			
			if (ExpTitle==ActTitle) {
				
				System.out.println("Home Page Successfuly Loaded !");
				
			} else {
				
				System.out.println("This is not Home Page !");

			}
		
		
	}
	
	@Test (priority= 2,alwaysRun = true)
	public void LoginTest() throws InterruptedException {
		
//		AndroidElement emailId = driver.findElementById("nhs.ibd.com.nhsibd:id/emailInputLayout");
		
		AndroidElement emailId = driver.findElementById("emailInputLayout");
		
		AndroidElement pin1 = driver.findElementById("pinFirstDigitET");
		
//		AndroidElement pin1 = driver.findElementById("nhs.ibd.com.nhsibd:id/pinFirstDigitET");
	
		
		// Entering email Id
		
		System.out.println("Entering user name to field !");
		
		emailId.sendKeys("skmahammad.goni@webspiders.com");
		
		// Entering passwords 
		
		
		if (pin1.isDisplayed()) {
			
			pin1.click();
//			pin1.clear();
			
			System.out.println("Entering password to field !");
			
			pin1.sendKeys("5045");
			
		}
		

//		System.out.println(emailId);		
		System.out.println("Login Successful");
	}
	
	@Test (priority = 1,alwaysRun = true)
	public void CreateAccountTest(/*String fName, String email, String hosNo, String hosName, String phNo*/){
		
		System.out.println("Inside Create Account");
		
//		AndroidElement registerNow = driver.findElementById("registerNowLayout");
		
		AndroidElement registerNow = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/registerNowTV']");
		
		AndroidElement fullName = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/nameET']");
		
		AndroidElement emailId = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/emailET']");
		
		AndroidElement hospitalNo = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/hospitalNumberET']");
		
		AndroidElement phoneNo = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/phoneET']");
		
		AndroidElement addHospital = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/selectedHospitalTV']");
		
		AndroidElement searchHospital = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/searchHospitalACTV']");
		
		AndroidElement chooseHospital = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/nameTV']");
		
		AndroidElement completeReg = driver.findElementByXPath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/registerBTN']");
		
//		AndroidElement fullName = driver.findElementById("nameInputLayout");
//			
//		AndroidElement emailId = driver.findElementById("emailInputLayout");
//		
//		AndroidElement hospitalNo = driver.findElementById("hospitalNumberInputLayout");
//		
//		AndroidElement phoneNo = driver.findElementById("phoneInputLayout");
//		
//		AndroidElement addHospital = driver.findElementById("addHospitalLayout");
//	
//		AndroidElement searchHospital = driver.findElementById("searchHospitalACTV");
//		
//		AndroidElement chooseHospital = driver.findElementById("hospitalsRV");
//	
//		AndroidElement completeReg = driver.findElementById("registerBTN");
		
		
		
		
		// Click on Don't have account
		
//		if (registerNow.isDisplayed()) {
//			
//			System.out.println(registerNow.isDisplayed());
//			
//			registerNow.click();
//			
//			System.out.println("Clicked on Register Now");
//			
//		}
		
		registerNow.click();
		
		System.out.println("Clicked on Register Now");
		
		
		
		
		
		// Entering Full Name
//		if (fullName.isDisplayed()) {
//			
//			System.out.println("Entering full name to field !");
//			
//			fullName.sendKeys("Sk Goni");
//			
//		}
		
		System.out.println("Entering full name to field !");
		
		fullName.sendKeys("Sk Goni");
		
		
		
		
		// Entering Email Id 
		
//		if (emailId.isDisplayed()) {
//			
//			System.out.println("Entering email id to field !");
//			
//			emailId.sendKeys("skmahammad.goni@webspiders.com");
//			
//		}
		
		System.out.println("Entering email id to field !");
		
		emailId.sendKeys("skmahammad.goni@webspiders.com");
		
			
		// Entering Hospital No
		
//		if (hospitalNo.isDisplayed()) {
//			
//			System.out.println("Entering hospital no to field !");
//			
//			hospitalNo.sendKeys("1637");
//			
//		}
			
		System.out.println("Entering hospital no to field !");
		
		hospitalNo.sendKeys("1637");
		
		
		
		// Entering phone No
		
//	    try {
//	    	phoneNo.sendKeys("");
//			
//		} catch (Exception e) {
//			
//		}
	    
	    phoneNo.sendKeys("");
	    
	    // Select Hospital
	    
//	    if (addHospital.isDisplayed()) {
//	    	
//	    	addHospital.click();
//			
//		}
	    
	    addHospital.click();
	       
	    
	    // Search Hospital
//	    if (searchHospital.isDisplayed()) {
//	    	
//	    	System.out.println("Selecting the Hospital !");
//	    	
//	    	searchHospital.sendKeys("Ashford Hospiatl");
//			
//		}
	    
		System.out.println("Selecting the Hospital !");
    	
    	searchHospital.sendKeys("Ashford Hospiatl");
		
	       
	    
	    // Choose the Hospital
	    
//	    if (chooseHospital.isDisplayed()) {
//	    	
//	    	chooseHospital.click();
//			
//		}
    	
    	chooseHospital.click();
	        
	    // Click on Complete Registration 
	    
//	    if (completeReg.isDisplayed()) {
//	    	
//	    	System.out.println("Clicking on Registering Button !");
//	    	
//	    	completeReg.click();
//			
//		}
    	
    	System.out.println("Clicking on Registering Button !");
    	
    	completeReg.click();
	    
		
	}
	
	@Test (priority = 3,alwaysRun = true)
	public void LogoutTest(){
		
		System.out.println("Trying to Logout");
		
	}


}
