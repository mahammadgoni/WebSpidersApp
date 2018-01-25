package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class EmailMySummary extends BaseSetUp{
	
	By userId = By.id("emailInputLayout");

	By password = By.id("pinFirstDigitET");
	
	By summaryBtn = By.id("medicalSummaryBTN");
	
	By emailSummaryBtn = By.id("createMedicalSummaryBTN");
	
	By menu = By.id("Apps");
	
	By searchBar  = By.id("com.android.launcher3:id/search_box_container");
	
	By browser_6 = By.xpath("//android.widget.TextView[@content-desc='Browser']");
	
	By browser_5 = By.xpath("//android.widget.TextView[@content-desc='Chrome']");
	
	By browser_4 = By.xpath("//android.widget.TextView[@text='Chrome']");
	
	By app = By.xpath("//*[@bounds='[48,288][294,581]']");
		
	By contBtn = By.id("android:id/button1");
	
	By checkInbox_6 = By.xpath("//*[@content-desc='Mailinator']/android.view.View[2]/android.widget.EditText");
	
	By checkInbox_5 = By.id("inboxfield");
	
	By checkInbox_4 = By.xpath("//*[@text='Check Any Inbox!']");
	
//	By gotoInbox = By.id("GO!");
	
	By gotoInbox = By.xpath("//*[@text='GO!']");
	
//	By webUrl = By.id("com.android.browser:id/url");
	
	By urlBar = By.id("com.android.chrome:id/url_bar");
	
//	By srch = By.id("Search");
//	
//	By googleSrch = By.id("Google Search");
	
	By clickOnSummary_6 = By.xpath("//*[contains(@content-desc,'NHS IBD SUMMARY: From')][@instance='44']");
//	
	By clickOnSummary_5 = By.xpath("//*[@text='FROM'][@instance='54']");
		
	By clickOnSummary_4 = By.xpath("//*[contains(@text,'NHS IBD SUMMARY: From')][@instance='56']");
	
//	By getAttachMsg = By.xpath("//*[contains(@content-desc,'Medical history')]");
	
//	By getAttachMsg = By.id("Medical history attached.");
	
	By getAttachMsg = By.xpath("//*[@text='Summary IBD QUESTIONNAIRE']");
	

	public EmailMySummary(WebDriver driver) {
		super(driver);
		
	}
	
	@SuppressWarnings("rawtypes")
	public EmailMySummary emailMySummary(String userName,String Pass,String summaryEmail,String PlatformVersion){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(userId);

		driver.findElement(userId).clear();

		System.out.println("Entering the Email  :" + userName);

		driver.findElement(userId).sendKeys(userName);

		System.out.println("Entering the Pin  :" + Pass);

		waitForClickabilityOf(password);

		driver.findElement(password).sendKeys(Pass);
		
		System.out.println("Clicking On Email My Medical Summary Btn  ");

		waitForClickabilityOf(summaryBtn);

		driver.findElement(summaryBtn).click();
		
		waitForClickabilityOf(userId);

		driver.findElement(userId).clear();

		System.out.println("Entering the Email  :" + summaryEmail);

		driver.findElement(userId).sendKeys(summaryEmail);
		
		System.out.println("Clicking On Email My Medical Summary Btn  ");

		waitForClickabilityOf(emailSummaryBtn);

		driver.findElement(emailSummaryBtn).click();
		
		System.out.println("Going Back to Home");
		
		((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
		
		((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);
		
		System.out.println("Clicking on Menu Button");

		driver.findElement(menu).click();
		
		System.out.println("Opening the Browser");
		
//		Here i need to add the code for version compatibility(Android 4.4.4 - Android 5.0)
		
		if (PlatformVersion == "6.0") {
			
//			This code is for Android 6
			
			driver.findElement(searchBar).sendKeys("Chrome");
			
			driver.findElement(app).click();
			
			try {
				
				waitForClickabilityOf(contBtn);

				driver.findElement(contBtn).click();
				
				driver.findElement(contBtn).click();
				
			} catch (Exception e) {
				
				
			}
			
			System.out.println("Opening the Website");
			
			waitForClickabilityOf(urlBar);

			driver.findElement(urlBar).clear();
			
			driver.findElement(urlBar).sendKeys("https://mailinator.com");
			
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
						
			System.out.println("Opening the Inbox : "+summaryEmail);
			
			waitForClickabilityOf(checkInbox_6);

			driver.findElement(checkInbox_6).sendKeys(summaryEmail);
			
			waitForClickabilityOf(gotoInbox);

			driver.findElement(gotoInbox).click();
			
			System.out.println("Checking for My IBD Summary Email ");
			
			waitForClickabilityOf(clickOnSummary_6);

			driver.findElement(clickOnSummary_6).click();
			
			waitForClickabilityOf(getAttachMsg);

			boolean AttachedMsg =  driver.findElement(getAttachMsg).isDisplayed();
			
			System.out.println("Attachement Message is visible :"+AttachedMsg);
			
			if (AttachedMsg=true) {
				
				System.out.println("Successfully got the Attachment ");
				
			} else {
				
				System.out.println("Failed to get the Attachment ");

			}
			
		}else if(PlatformVersion == "5.0.0") {
			
//			This code is for Android 5
			
			waitForClickabilityOf(browser_5);

			driver.findElement(browser_5).click();
			
			try {
				
				waitForClickabilityOf(contBtn);

				driver.findElement(contBtn).click();
				
				driver.findElement(contBtn).click();
				
			} catch (Exception e) {
				
				
			}
			
			System.out.println("Opening the Website");
			
			waitForClickabilityOf(urlBar);

			driver.findElement(urlBar).clear();
			
			driver.findElement(urlBar).sendKeys("https://mailinator.com");
			
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
						
			System.out.println("Opening the Inbox : "+summaryEmail);
			
			waitForClickabilityOf(checkInbox_5);

			driver.findElement(checkInbox_5).sendKeys(summaryEmail);
			
			waitForClickabilityOf(gotoInbox);

			driver.findElement(gotoInbox).click();
			
			System.out.println("Checking for My IBD Summary Email ");
			
			waitForClickabilityOf(clickOnSummary_5);

			driver.findElement(clickOnSummary_5).click();
			
			waitForClickabilityOf(getAttachMsg);

			boolean AttachedMsg =  driver.findElement(getAttachMsg).isDisplayed();
			
			System.out.println("Attachement Message is visible :"+AttachedMsg);
			
			if (AttachedMsg=true) {
				
				System.out.println("Successfully got the Attachment ");
				
			} else {
				
				System.out.println("Failed to get the Attachment ");

			}
			
		}else {
			
//			This code is for Android 4
			
			waitForClickabilityOf(browser_4);

			driver.findElement(browser_4).click();
			
			try {
				
				waitForClickabilityOf(contBtn);

				driver.findElement(contBtn).click();
				
				driver.findElement(contBtn).click();
				
			} catch (Exception e) {
				
				
			}
			
			System.out.println("Opening the Website");
			
			waitForClickabilityOf(urlBar);

			driver.findElement(urlBar).clear();
			
			driver.findElement(urlBar).sendKeys("https://mailinator.com");
			
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
						
			System.out.println("Opening the Inbox : "+summaryEmail);
			
			waitForClickabilityOf(checkInbox_4);

			driver.findElement(checkInbox_4).sendKeys(summaryEmail);
			
			waitForClickabilityOf(gotoInbox);

			driver.findElement(gotoInbox).click();
			
			System.out.println("Checking for My IBD Summary Email ");
			
			waitForClickabilityOf(clickOnSummary_4);

			driver.findElement(clickOnSummary_4).click();
			
			waitForClickabilityOf(getAttachMsg);

			boolean AttachedMsg =  driver.findElement(getAttachMsg).isDisplayed();
			
			System.out.println("Attachement Message is visible :"+AttachedMsg);
			
			if (AttachedMsg=true) {
				
				System.out.println("Successfully got the Attachment ");
				
			} else {
				
				System.out.println("Failed to get the Attachment ");

			}
			
		}
		
		return new EmailMySummary(driver);
		
	}


}
