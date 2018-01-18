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
	
//	By newPin = By.id("nhs.ibd.com.nhsibd:id/newPinFirstDigitET");
	
	By newPin = By.xpath("//*[@resource-id='nhs.ibd.com.nhsibd:id/newPinFirstDigitET']");
	
	By repeatNewPin = By.xpath("//*[@resource-id='nhs.ibd.com.nhsibd:id/repeatPinFirstDigitET']");
	
//	By repeatNewPin = By.id("nhs.ibd.com.nhsibd:id/repeatPinFirstDigitET");

	public ChangeMyPin(WebDriver driver) {
		super(driver);
		
	}
		
	public ChangeMyPin chnageMyPin(String userName, String password,String newPassword){
		

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

			// Enter Old Pin No
			
			System.out.println("Entering Old Pin  :"+password);
			
	        waitForClickabilityOf(oldPin);

			driver.findElement(oldPin).sendKeys(password);

			// Enter New Pin No
			
			System.out.println("Entering New Pin  :"+newPassword);
			
	        waitForClickabilityOf(newPin);
	        
//   one more test chnages
	        
			driver.findElement(newPin).sendKeys(newPassword);

			// Enter Repeat New Pin No
			
			System.out.println("Repeat New Pin  :"+newPassword);
			
	        waitForClickabilityOf(repeatNewPin);
			
			driver.findElement(repeatNewPin).sendKeys(newPassword);
		
		return new ChangeMyPin(driver);
		
		
	}

	
	

}
