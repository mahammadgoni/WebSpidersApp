package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class EmailMySummary extends BaseSetUp{
	
	By userId = By.id("emailInputLayout");

	By password = By.id("pinFirstDigitET");
	
	By summaryBtn = By.id("medicalSummaryBTN");
	
	By emailSummaryBtn = By.id("createMedicalSummaryBTN");

	public EmailMySummary(WebDriver driver) {
		super(driver);
		
	}
	
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
		
		return new EmailMySummary(driver);
		
	}


}
