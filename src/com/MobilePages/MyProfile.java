package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class MyProfile extends BaseSetUp {

	By emailId = By.id("emailET");

	By pin = By.id("pinFirstDigitET");

	By menuBtn = By.className("android.widget.ImageButton");

	By myProfile = By.xpath("//android.widget.TextView[@text='My Profile']");

	By closeBtn = By.xpath("//android.widget.TextView[@text='CLOSE']");

	By nameField = By.id("nameInputLayout");

	By phoneNo = By.id("nhs.ibd.com.nhsibd:id/phoneET");

	By saveBtn = By.id("nhs.ibd.com.nhsibd:id/saveChangesBTN");

	By deleteBtn = By.id("nhs.ibd.com.nhsibd:id/deleteProfileBTN");

//	By changePin = By.id("nhs.ibd.com.nhsibd:id/changePinTV");
//
//	By oldPin = By.id("nhs.ibd.com.nhsibd:id/oldPinFirstDigitET");
//
//	By newPin = By.id("nhs.ibd.com.nhsibd:id/newPinFirstDigitET");
//
//	By repeatNewPin = By.id("nhs.ibd.com.nhsibd:id/repeatPinFirstDigitET");

	public MyProfile(WebDriver driver) {
		super(driver);

	}

	public MyProfile changeMynameAndPhoneNo(String userName, String password, String newName, String newPhoneNo) {

		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(emailId);

		driver.findElement(emailId).clear();

		System.out.println("Entering the Email  : " + userName);

		driver.findElement(emailId).sendKeys(userName);

		System.out.println("Entering the Pin  : " + password);

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
		
		String Name = driver.findElement(nameField).getText();
		
		System.out.println("Existing Account Name : "+Name);

		// Clicking on Name

		System.out.println("Changing the name to :" + newName);

		waitForClickabilityOf(nameField);

		driver.findElement(nameField).clear();

		driver.findElement(nameField).sendKeys(newName);

		// Clicking on Phone No

		System.out.println("Changing the Phone No to :" + newPhoneNo);

		waitForClickabilityOf(phoneNo);

		driver.findElement(phoneNo).clear();

		driver.findElement(phoneNo).sendKeys(newPhoneNo);

		// Clicking on Save Button

		System.out.println("Saving the details");

		waitForClickabilityOf(saveBtn);

		driver.findElement(saveBtn).click();
		
		if (Name!=newName) {
			
			System.out.println("Successfully Changed the Name");
			
		} else {
			
			System.out.println("Failed to change the Name");

		}

		return new MyProfile(driver);

	}

}
