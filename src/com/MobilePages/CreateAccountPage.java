package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class CreateAccountPage extends BaseSetUp {

	public CreateAccountPage(WebDriver driver) {
		super(driver);

	}

	By registerNow = By.id("registerNowLayout");
	
	By password = By.id("pinFirstDigitET");

	By fullName = By.id("nameET");

	By emailId = By.id("emailET");

	By hospitalNo = By.id("hospitalNumberET");

	By phoneNo = By.id("phoneET");

	By selectHospital = By.id("selectedHospitalTV");

	By searchHospital = By.id("searchHospitalACTV");

	By chooseHospital = By.id("nameTV");

	By completeReg = By.id("registerBTN");
	
	By menu = By.id("Apps");

	By searchBar = By.id("com.android.launcher3:id/search_box_container");
	
	By app = By.xpath("//*[@bounds='[48,288][294,581]']");
	

	public CreateAccountPage createAccount(String FullName, String EmailId, String HospitalNo, String PhoneNo,String HospitalName) {

	
			// Click on Don't have account

			System.out.println("Clicking on Register Now");
			
			waitForClickabilityOf(registerNow);

			driver.findElement(registerNow).click();

			// Entering Full Name

			System.out.println("Entering the Full Name :" + FullName);
			
			waitForClickabilityOf(fullName);

			driver.findElement(fullName).sendKeys(FullName);

			// Entering Email Id

			System.out.println("Entering the Email :" + EmailId);
			
			waitForClickabilityOf(emailId);

			driver.findElement(emailId).sendKeys(EmailId);

			// Entering Hospital No

			System.out.println("Entering the Hospital No : " + HospitalNo);
			
			waitForClickabilityOf(hospitalNo);

			driver.findElement(hospitalNo).sendKeys(HospitalNo);

			// Entering phone No

			System.out.println("Entering the Phone No : " + PhoneNo);
			
			waitForClickabilityOf(phoneNo);

			driver.findElement(phoneNo).sendKeys(PhoneNo);

			// Select Hospital

			System.out.println("Clicking on Hospital List");
			
			waitForClickabilityOf(selectHospital);

			driver.findElement(selectHospital).click();

			// Search Hospital

			System.out.println("Searching the Hospital Name : " + HospitalName);
			
			waitForClickabilityOf(searchHospital);

			driver.findElement(searchHospital).sendKeys(HospitalName);

			// Choose the Hospital

			System.out.println("Choosing the Hospital");
			
			waitForClickabilityOf(chooseHospital);

			driver.findElement(chooseHospital).click();

			// Click on Complete Registration

			System.out.println("Clicking on Complete Registration Button");
			
			waitForClickabilityOf(completeReg);

			driver.findElement(completeReg).click();
			
			boolean CompleteRegBtn = driver.findElement(completeReg).isDisplayed();
			
			if (CompleteRegBtn  == false) {
				
				System.out.println("Successfully Created the Account");
				
					
//				driver.navigate().back();
//				
//				System.out.println("Clicking on Menu Button");
//
//				driver.findElement(menu).click();
//				
//				System.out.println("Opening the Browser to get the Pin");
//						
//				driver.findElement(searchBar).sendKeys("Browser");
//						
//				driver.findElement(app).click();
//				
//				driver.get("mailinator.com");
				
				
				
			} else {
				
				System.out.println("Failed to Create the Account");
								
		
			}
	

		return new CreateAccountPage(driver);

	}

}
