package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

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
	
	By checkInbox = By.id("Check Any Inbox!");
	
	By gotoInbox = By.id("GO!");
	
	By webUrl = By.id("com.android.browser:id/url");
	
	By srch = By.id("Search");
	
	By googleSrch = By.id("Google Search");
	
	By openSite = By.xpath("//android.view.View[@content-desc='Mailinator https://mailinator.com']");
	
	By clickOnResetMail = By.xpath("(//android.view.View[@content-desc='NHS Welcome email'])[1]");
	
	By getNewPass = By.xpath("//android.view.View[contains(@content-desc,'To login to MyCare IBD app')]");
	

	@SuppressWarnings("rawtypes")
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
			
//			waitForClickabilityOf(password);
			
			boolean enterPin = driver.findElement(password).isDisplayed();
			
//			boolean completeBtn = driver.findElement(completeReg).isDisplayed();
			
//			System.out.println(enterPin);
			
			if (enterPin  == true) {
				
				System.out.println("Going Back to Home");
				
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
				
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
				
				System.out.println("Clicking on Menu Button");

				driver.findElement(menu).click();
				
				System.out.println("Opening the Browser");
						
				driver.findElement(searchBar).sendKeys("Browser");
						
				driver.findElement(app).click();
				
				System.out.println("Opening the Website");
				
				waitForClickabilityOf(webUrl);

				driver.findElement(webUrl).clear();
				
				driver.findElement(webUrl).sendKeys("https://mailinator.com");
				
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
							
				System.out.println("Opening the Inbox : "+EmailId);
				
				waitForClickabilityOf(checkInbox);

				driver.findElement(checkInbox).sendKeys(EmailId);
				
				waitForClickabilityOf(gotoInbox);

				driver.findElement(gotoInbox).click();
				
				System.out.println("Clicking on Reset Mail to get the PIN");
				
				waitForClickabilityOf(clickOnResetMail);

				driver.findElement(clickOnResetMail).click();
				
//				waitForClickabilityOf(getNewPass);
				
				waitForVisibilityOf(getNewPass);
				
				// Set to "getAttribute("contentDescription")" to get the whole text

				String Pass = driver.findElement(getNewPass).getAttribute("contentDescription");
				
				System.out.println(Pass);
								
				String fPass = "";
									
				for (char c : Pass.toCharArray()) {
					
					if (Character.isDigit(c)) {
						
						fPass = fPass + Character.getNumericValue(c);
												
					}
					
	     		}
							
				
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
				
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
							
				System.out.println("Clicking on Menu Button");

				driver.findElement(menu).click();
				
				System.out.println("Opening the App to Verify the New Pin");
						
				driver.findElement(searchBar).sendKeys("My IBD Care");
						
				driver.findElement(app).click();
				
				System.out.println("Entering Your Email ");

				waitForClickabilityOf(emailId);

				driver.findElement(emailId).clear();

				driver.findElement(emailId).sendKeys(EmailId);

				waitForClickabilityOf(password);

				driver.findElement(password).sendKeys(fPass);
				
				System.out.println("Successfully Created the Account");
				
		
				
				
			} else {
				
				System.out.println("Failed to Create the Account");
								
		
			}
	

		return new CreateAccountPage(driver);

	}

}
