package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class MySymptoms extends BaseSetUp{
	
	
	By emailId = By.id("emailET");

	By pin = By.id("pinFirstDigitET");

	By menuBtn = By.className("android.widget.ImageButton");

	By mySymptoms = By.xpath("//android.widget.TextView[@text='My Symptoms']");

	By continueBtn = By.id("nhs.ibd.com.nhsibd:id/continueToFormBTN");
	
	By errorMsg = By.xpath("//android.widget.TextView[@text='Sorry, something went wrong']");
		
	By changePin = By.id("nhs.ibd.com.nhsibd:id/changePinTV");
	
	By oldPin = By.id("nhs.ibd.com.nhsibd:id/oldPinFirstDigitET");
	

	public MySymptoms(WebDriver driver) {
		super(driver);
		
	}
	
	public MySymptoms updateMySymptoms(String userName,String password){
		

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
		
        waitForClickabilityOf(mySymptoms);

		driver.findElement(mySymptoms).click();
		
        waitForClickabilityOf(continueBtn);

		driver.findElement(continueBtn).click();
		
		// I need to add rest of the code here
		
		driver.findElement(continueBtn).click();
		
		
		
		
		return new MySymptoms(driver);
		
	}

}
