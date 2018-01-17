package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ForgotPassword extends BaseSetUp{
	

	  public ForgotPassword(WebDriver driver) {
		super(driver);
	
	}
	  
		By emailId = By.id("emailET");

		By pin = By.id("pinFirstDigitET");
		
		By dashboard = By.xpath("//*[@text ='Dashboard']");

		By forgotPass = By.id("nhs.ibd.com.nhsibd:id/forgotPinTV");

		By resendBtn = By.id("nhs.ibd.com.nhsibd:id/resendPinBTN");
		
		By menu = By.id("Apps");

		By searchBar = By.id("com.android.launcher3:id/search_box_container");
		
		By app = By.xpath("//*[@bounds='[48,288][294,581]']");

		By inboxName = By.id("inboxfield");
			
		By goBtn = By.xpath("//*[@class='btn btn-dark']");
		
		By checkInbox = By.id("Check Any Inbox!");
		
		By gotoInbox = By.id("GO!");
		
		By webUrl = By.id("com.android.browser:id/url");
		
		By srch = By.id("Search");
		
		By googleSrch = By.id("Google Search");
		
		By openSite = By.xpath("//android.view.View[@content-desc='Mailinator https://mailinator.com']");
		
		By clickOnResetMail = By.xpath("(//android.view.View[@content-desc='NHS Password reset'])[1]");
		
		By getNewPass = By.xpath("//android.view.View[contains(@content-desc,'Your new PIN is')]");
	  
	  


	  @SuppressWarnings("rawtypes")
	public ForgotPassword forgotPassword(String userName) {
		  
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

			System.out.println("Going Back to Home");
			
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
			
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
			
//
//			driver.navigate().back();
//			
//			driver.navigate().back();
			
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
						
			System.out.println("Opening the Inbox : "+userName);
			
			waitForClickabilityOf(checkInbox);

			driver.findElement(checkInbox).sendKeys(userName);
			
			waitForClickabilityOf(gotoInbox);

			driver.findElement(gotoInbox).click();
			
			System.out.println("Clicking on Reset Mail to get the PIN");
			
			waitForClickabilityOf(clickOnResetMail);

			driver.findElement(clickOnResetMail).click();
			
//			waitForClickabilityOf(getNewPass);
			
			waitForVisibilityOf(getNewPass);
			
			// Set to "getAttribute("contentDescription")" to get the whole text

			String Pass = driver.findElement(getNewPass).getAttribute("contentDescription");
			
			System.out.println(Pass);
			
//			char ch[] = newPass.toCharArray();
			
//			System.out.println(ch.length);
			
//			int newPin = 0;
			
			String fPass = "";
			
//			boolean notFirst = false;
					
			for (char c : Pass.toCharArray()) {
				
				if (Character.isDigit(c)) {
					
					fPass = fPass + Character.getNumericValue(c);
					
//					System.out.print((notFirst? "" : "") + c);
					
//					notFirst = true;
					
				}
				
     		}
						
//			System.out.println(fPass);

// We need to get the password from the Attribute text
			
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
			
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
			
//			driver.navigate().back();
//			
//			driver.navigate().back();
			
			System.out.println("Clicking on Menu Button");

			driver.findElement(menu).click();
			
			System.out.println("Opening the App to Verify the New Pin");
					
			driver.findElement(searchBar).sendKeys("My IBD Care");
					
			driver.findElement(app).click();
			
			System.out.println("Entering Your Email ");

			waitForClickabilityOf(emailId);

			driver.findElement(emailId).clear();

			driver.findElement(emailId).sendKeys(userName);

			waitForClickabilityOf(pin);

			driver.findElement(pin).sendKeys(fPass);
			
			boolean Dashboard = driver.findElement(dashboard).isDisplayed();
			
			if ( Dashboard == true) {
				
				System.out.println("Successfully Logged in with new Pin ");
				
			} else {
				
				System.out.println("Failed to Login with new Pin");
				
			}
			
			
		return new ForgotPassword(driver);
		 
		  
	    
	  }
	  
}

	



