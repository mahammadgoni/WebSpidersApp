package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class ForgotPassword extends BaseSetUp{
	

	  public ForgotPassword(WebDriver driver) {
		super(driver);
	
	}
	  
		By emailId = By.id("emailET");

		By pin = By.id("pinFirstDigitET");

		By forgotPass = By.id("nhs.ibd.com.nhsibd:id/forgotPinTV");

		By resendBtn = By.id("nhs.ibd.com.nhsibd:id/resendPinBTN");
		
		By menu = By.id("Apps");

		By searchBar = By.id("com.android.launcher3:id/search_box_container");
		
		By app = By.xpath("//*[@bounds='[48,288][294,581]']");

		By inboxName = By.id("inboxfield");
			
		By goBtn = By.xpath("//*[@class='btn btn-dark']");
		
		By oldPin = By.id("nhs.ibd.com.nhsibd:id/oldPinFirstDigitET");
		
		By newPin = By.id("newPinFirstDigitET");
		
		By repeatNewPin = By.id("repeatPinFirstDigitET");
	  
	  


	  public ForgotPassword forgotPassword(String userName) {
		  
//			System.out.println("Entering Your Email ");
//
//			waitForClickabilityOf(emailId);
//
//			driver.findElement(emailId).clear();
//
//			driver.findElement(emailId).sendKeys(userName);
//
//			System.out.println("Entering the Pin  :" + pin);
//
//			waitForClickabilityOf(pin);
//
//			driver.findElement(pin).sendKeys(password);
//			
			System.out.println("Clicking on Forgot your PIN");

			waitForClickabilityOf(forgotPass);

			driver.findElement(forgotPass).click();
			
			// Enter your forgot email
			
			System.out.println("Entering Your Email ");

			waitForClickabilityOf(emailId);

			driver.findElement(emailId).clear();

			driver.findElement(emailId).sendKeys(userName);
			
			System.out.println("Clicking on Resend Button");

			waitForClickabilityOf(resendBtn);

			driver.findElement(resendBtn).click();
			
			boolean resend = driver.findElement(resendBtn).isDisplayed();
			
			if (resend==true) {
				
				System.out.println("Failed to test Forgot Password ");
				
			} else {
				
				System.out.println("Successfully Tested Forgot Password ");

			}
			
//			System.out.println("Going Back to Home");
//			
//
//			driver.navigate().back();
//			
//			driver.navigate().back();
//			
//			System.out.println("Clicking on Menu Button");
//
//			driver.findElement(menu).click();
//			
//			System.out.println("Opening the Browser to get the Pin");
//					
//			driver.findElement(searchBar).sendKeys("Browser");
//					
//			driver.findElement(app).click();
//			
//			driver.get("mailinator.com");
//		  
//		  
//			driver.findElement(searchBar).sendKeys("My IBD Care");
			
		return new ForgotPassword(driver);
		 
		  
	    
	  }
	  
}

	



