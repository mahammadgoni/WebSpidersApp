package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class DeleteMyAccount extends BaseSetUp{
	
	
	By emailId = By.id("emailET");
	
	By pin = By.id("pinFirstDigitET");
		
	By menuBtn = By.className("android.widget.ImageButton");

	By myProfile = By.xpath("//android.widget.TextView[@text='My Profile']");

	By closeBtn = By.xpath("//android.widget.TextView[@text='CLOSE']");
	
	By deleteProfileBtn = By.id("nhs.ibd.com.nhsibd:id/deleteProfileBTN");
	
	By deleteBtn = By.id("nhs.ibd.com.nhsibd:id/deleteButtonLayout");
	
	By cancelBtn = By.id("nhs.ibd.com.nhsibd:id/cancelButtonLayout");
	
	By registerNow = By.id("registerNowLayout");
	
	

	public DeleteMyAccount(WebDriver driver) {
		super(driver);
		
	}
	
	public DeleteMyAccount deleteAccount(String userName, String password){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(emailId);

		driver.findElement(emailId).clear();

		System.out.println("Entering the Email  : " + userName);

		driver.findElement(emailId).sendKeys(userName);

		System.out.println("Entering the Pin  : " + password);

		waitForClickabilityOf(pin);

		driver.findElement(pin).sendKeys(password);

		// Click on Menu Btn

		System.out.println("Clicking on Menu Button");

		waitForClickabilityOf(menuBtn);

		driver.findElement(menuBtn).click();

		// Click on My Profile

		System.out.println("Clicking on My Profile");

		waitForClickabilityOf(myProfile);

		driver.findElement(myProfile).click();

		// Click on Close Btn

		System.out.println("Clicking on Close Button");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();
		
//		Clicking on Delete Profile Button
		
		System.out.println("Clicking on Delete Profile Button");

		waitForClickabilityOf(deleteProfileBtn);

		driver.findElement(deleteProfileBtn).click();
		
		System.out.println("Clicking on Delete Button");

		waitForClickabilityOf(deleteBtn);

		driver.findElement(deleteBtn).click();
		
		boolean text = driver.findElement(registerNow).isDisplayed();
		
		System.out.println(text);
		
		if (text=true) {
			
			System.out.println("Successfully Deleted The Account!");
			
		} else {
			
			System.out.println("Failed to Delete the Account!");

		}
		
		return new DeleteMyAccount(driver);
	}

}
