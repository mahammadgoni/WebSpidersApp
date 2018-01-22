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
	
	By app = By.xpath("//*[@bounds='[48,288][294,581]']");
	
	By contBtn = By.id("android:id/button1");
	
	By checkInbox = By.id("Check Any Inbox!");
	
	By gotoInbox = By.id("GO!");
	
	By webUrl = By.id("com.android.browser:id/url");
	
	By srch = By.id("Search");
	
	By googleSrch = By.id("Google Search");
	
	By openSite = By.xpath("//android.view.View[@content-desc='Mailinator https://mailinator.com']");
	
	By clickOnSummary = By.xpath("//*[contains(@content-desc,'NHS IBD SUMMARY: From')][@instance='44']");
	
	By getAttachMsg = By.xpath("//*[contains(@content-desc,'Medical history attached')]");

	public EmailMySummary(WebDriver driver) {
		super(driver);
		
	}
	
	@SuppressWarnings("rawtypes")
	public EmailMySummary emailMySummary(String userName,String Pass,String summaryEmail){
		
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
				
		driver.findElement(searchBar).sendKeys("Browser");
				
		driver.findElement(app).click();
		
		try {
			waitForClickabilityOf(contBtn);

			driver.findElement(contBtn).click();
			
			driver.findElement(contBtn).click();
			
		} catch (Exception e) {
			
			
		}
		
		System.out.println("Opening the Website");
		
		waitForClickabilityOf(webUrl);

		driver.findElement(webUrl).clear();
		
		driver.findElement(webUrl).sendKeys("https://mailinator.com");
		
		((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
					
		System.out.println("Opening the Inbox : "+summaryEmail);
		
		waitForClickabilityOf(checkInbox);

		driver.findElement(checkInbox).sendKeys(summaryEmail);
		
		waitForClickabilityOf(gotoInbox);

		driver.findElement(gotoInbox).click();
		
		System.out.println("Checking for My IBD Summary Email ");
		
		waitForClickabilityOf(clickOnSummary);

		driver.findElement(clickOnSummary).click();
		
		waitForClickabilityOf(getAttachMsg);

		String AttachedMsg =  driver.findElement(getAttachMsg).getText();
		
		System.out.println(AttachedMsg);
		
		if (AttachedMsg=="Medical history attached.") {
			
			System.out.println("Successfully got the Attachment ");
			
		} else {
			
			System.out.println("Failed to get the Attachment ");

		}
		
		return new EmailMySummary(driver);
		
	}


}
