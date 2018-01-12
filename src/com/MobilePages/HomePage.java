package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.BaseSetup.BaseSetUp;

public class HomePage extends BaseSetUp{
	

	
	public HomePage(WebDriver driver) {
		
		super(driver);
		
	}


	By userId = By.id("emailInputLayout");

	By password = By.id("pinFirstDigitET");
			
	By dashboard = By.xpath("//*[@text ='Dashboard']");
	
	
	public void verifyHomePage(String userName, String pin){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(userId);

		driver.findElement(userId).clear();

		System.out.println("Entering the Email  :" + userName);

		driver.findElement(userId).sendKeys(userName);

		System.out.println("Entering the Pin  :" + pin);

		waitForClickabilityOf(password);

		driver.findElement(password).sendKeys(pin);
		
//		String ActTitle = "Dashboard";
		
		waitForClickabilityOf(dashboard);
		
//		String ExpTitle = driver.findElement(dashboard).getText();
		
		boolean ExpTitle = driver.findElement(dashboard).isDisplayed();
		
//		System.out.println(ExpTitle);
//		
//		Assert.assertEquals(ActTitle, ExpTitle);
		
		
		if (ExpTitle == true) {
			
			System.out.println("Successfully verified Home Page ");
			
		} else {
			
			System.out.println("Failed to Verify Home Page ");

		}		
		
		
		
		
	}

}
