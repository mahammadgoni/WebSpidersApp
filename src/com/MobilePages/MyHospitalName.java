package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.BaseSetup.BaseSetUp;

public class MyHospitalName extends BaseSetUp{
	
	By emailId = By.id("emailET");

	By pin = By.id("pinFirstDigitET");

	By menuBtn = By.className("android.widget.ImageButton");

	By myHospital = By.xpath("//android.widget.TextView[@text='My Hospital']");

	By myProfile = By.xpath("//android.widget.TextView[@text='My Profile']");

	By hospitalAddress = By.xpath("//android.widget.TextView[@text='Address']");

	By closeBtn = By.xpath("//android.widget.TextView[@text='CLOSE']");

	By clickOnHospital = By.id("userHospitalNameTV");

	By okBtn = By.id("deleteButtonLayout");

	By searchHospital = By.id("searchHospitalACTV");

	By selectHospital = By.id("nameTV");

	By newHospitalName = By.id("userHospitalTV");

	public MyHospitalName(WebDriver driver) {
		super(driver);
	}

	public MyHospitalName myHospital(String userName, String password, String HospitalName) {

			// Enter user Name

			System.out.println("Entering the Email  :" + userName);
			
			waitForClickabilityOf(emailId);

			driver.findElement(emailId).clear();

			driver.findElement(emailId).sendKeys(userName);

			// Enter pin no
			
			System.out.println("Entering the Pin  :"+password);
			
			waitForClickabilityOf(pin);

			driver.findElement(pin).sendKeys(password);
			
			String Hospital = driver.findElement(newHospitalName).getText();
			
			System.out.println("Existing User Hospital Name : "+Hospital);

			// Click on Menu Btn
			
			System.out.println("Clicking on Menu Btn");	
			
			waitForClickabilityOf(menuBtn);

			driver.findElement(menuBtn).click();

			// Click on My Hospital
			
			System.out.println("Clicking on My Hospital");	
			
			waitForClickabilityOf(myHospital);

			driver.findElement(myHospital).click();

			// Click on Hospital Address
			
			System.out.println("Clicking on Hospital Address");	
			
			waitForClickabilityOf(hospitalAddress);

			driver.findElement(hospitalAddress).click();

			// Click on Menu Btn
			
			waitForClickabilityOf(menuBtn);

			driver.findElement(menuBtn).click();

			// Click on My Profile
				
			waitForClickabilityOf(myProfile);

			driver.findElement(myProfile).click();

			// Click on Close Btn
			
			System.out.println("Clicking on Close Btn");	
			
			waitForClickabilityOf(closeBtn);

			driver.findElement(closeBtn).click();

			// Click on User Hospital
			
			System.out.println("Clicking on User Hospital");	
			
			waitForClickabilityOf(clickOnHospital);

			driver.findElement(clickOnHospital).click();

			// Click on Ok Btn
			
			System.out.println("Clicking on Ok Btn");	
			
			waitForClickabilityOf(okBtn);

			driver.findElement(okBtn).click();

			// Click on Search Hospital
			
			System.out.println("Searching the Hospital Name ");
			
			waitForClickabilityOf(searchHospital);

			driver.findElement(searchHospital).sendKeys(HospitalName);

			// Click on Select Hospital
			
			System.out.println("Clicking on Select Hospital");	
			
			waitForClickabilityOf(selectHospital);

			driver.findElement(selectHospital).click();

			// Enter Pin No
			
			System.out.println("Entering the Pin  :"+password);
			
			waitForClickabilityOf(pin);

			driver.findElement(pin).sendKeys(password);

			// New Hospital Name

			String  newHospital = driver.findElement(newHospitalName).getText();
			
			
			
			if (Hospital !=newHospital) {
				
				System.out.println("New User Hospital Name : "+newHospital);
			
				System.out.println("Successfully Changed User Hospital Name");
				
			} else {
				
				System.out.println("Failed to Change User Hospital Name");

			}

		return new MyHospitalName(driver);
	}

}

	
