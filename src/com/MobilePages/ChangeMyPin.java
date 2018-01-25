package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;



public class ChangeMyPin extends BaseSetUp{
	
	

	By emailId = By.id("emailET");

	By pin = By.id("pinFirstDigitET");

	By menuBtn = By.className("android.widget.ImageButton");

	By myProfile = By.xpath("//android.widget.TextView[@text='My Profile']");

	By closeBtn = By.xpath("//android.widget.TextView[@text='CLOSE']");
		
	By changePin = By.id("nhs.ibd.com.nhsibd:id/changePinTV");
	
	By oldPin = By.id("nhs.ibd.com.nhsibd:id/oldPinFirstDigitET");
	
	By newPin = By.id("nhs.ibd.com.nhsibd:id/newPinFirstDigitET");
	
	By repeatNewPin = By.id("nhs.ibd.com.nhsibd:id/repeatPinFirstDigitET");
	
	By dashboard = By.xpath("//*[@text ='Dashboard']");
	
	By menu = By.id("Apps");

	By searchBar = By.id("com.android.launcher3:id/search_box_container");
	
	By myIBDCare = By.xpath("//android.widget.TextView[@content-desc='My IBD Care']");
	
	By app_6 = By.xpath("//*[@bounds='[48,288][294,581]']");
		
	By app_5 = By.xpath("//android.widget.TextView[@text='My IBD Care']");
	
	By app_4 = By.xpath("//android.widget.TextView[@text='My IBD Care']");
		

	public ChangeMyPin(WebDriver driver) {
		super(driver);
		
	}
		
	@SuppressWarnings("rawtypes")
	public ChangeMyPin chnageMyPin(String userName, String password,String newPassword,String PlatformVersion){
		

			// Enter user Name

			System.out.println("Entering the Email  :" + userName);
			
	        waitForClickabilityOf(emailId);

			driver.findElement(emailId).clear();

			driver.findElement(emailId).sendKeys(userName);

			// Enter pin no
			
			System.out.println("Entering the Pin  :"+password);
			
	        waitForClickabilityOf(pin);

			driver.findElement(pin).sendKeys(password);

			// Click on Menu Btn
			
			System.out.println("Clicking on Menu Btn");	
			
	        waitForClickabilityOf(menuBtn);

			driver.findElement(menuBtn).click();

			// Click on My Profile
			
			System.out.println("Clicking on My Profile");	
			
	        waitForClickabilityOf(myProfile);

			driver.findElement(myProfile).click();

			// Click on Close Btn
			
			System.out.println("Clicking on Close Btn");	
			
	        waitForClickabilityOf(closeBtn);

			driver.findElement(closeBtn).click();

			// Click on Change My Pin
			
			System.out.println("Clicking on Change My Pin");	
			
	        waitForClickabilityOf(changePin);

			driver.findElement(changePin).click();

//			Enter Old Pin No
			
			System.out.println("Entering Old Pin  :"+password);
			
			System.out.println("Entering New Pin  :"+newPassword);
			
			System.out.println("Repeating New Pin  :"+newPassword);
			
	        waitForClickabilityOf(oldPin);

			driver.findElement(oldPin).sendKeys(password+newPassword+newPassword);
			
			System.out.println("Going Back to Home");
			
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
					
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
					
			System.out.println("Clicking on Menu Button");

			driver.findElement(menu).click();
			
			System.out.println("Opening the App to Verify the New Pin");
			
			if (PlatformVersion == "6.0") {
				
//				This code is for Android 6
				
				driver.findElement(searchBar).sendKeys("My IBD Care");
				
				driver.findElement(app_6).click();
				
				waitForClickabilityOf(pin);

				driver.findElement(pin).sendKeys(newPassword);
				
				boolean Dashboard = driver.findElement(dashboard).isDisplayed();
				
				if ( Dashboard == true) {
					
					System.out.println("Successfully Logged in with new Pin ");
					
				} else {
					
					System.out.println("Failed to Login with new Pin");
					
				}
				
			}else if (PlatformVersion == "5.0.0") {
				
//				This code is for Android 5
				
				driver.findElement(searchBar).sendKeys("My IBD Care");
				
				swipeRightToLeft();
				
				driver.findElement(app_5).click();
				
				waitForClickabilityOf(pin);

				driver.findElement(pin).sendKeys(newPassword);
				
				boolean Dashboard = driver.findElement(dashboard).isDisplayed();
				
				if ( Dashboard == true) {
					
					System.out.println("Successfully Logged in with new Pin ");
					
				} else {
					
					System.out.println("Failed to Login with new Pin");
					
				}
				
			}else {
				
//				This code is for Android 4
				
				driver.findElement(searchBar).sendKeys("My IBD Care");
				
				swipeRightToLeft();
				
				swipeLeftToRight();
				
				scrollPageUp();
				
//              Need to add Swipe code here 
				
				driver.findElement(app_4).click();
				
				waitForClickabilityOf(pin);

				driver.findElement(pin).sendKeys(newPassword);
				
				boolean Dashboard = driver.findElement(dashboard).isDisplayed();
				
				if ( Dashboard == true) {
					
					System.out.println("Successfully Logged in with new Pin ");
					
				} else {
					
					System.out.println("Failed to Login with new Pin");
					
				}
				
			}
		
		return new ChangeMyPin(driver);
		
		
	}

	
	

}
