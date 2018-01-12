package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class MyMedicalHistory extends BaseSetUp{
	

	
	By emailId = By.id("emailET");

	By pin = By.id("pinFirstDigitET");

	By menuBtn = By.className("android.widget.ImageButton");

	By myMedicalHistory = By.xpath("//*[@text='My Medical History']");
	
	By pouchitis = By.xpath("//*[@text='Pouchitis']");
	
	By cholecy = By.xpath("//*[@text='Cholecystectomy']");
	
	By iBDu = By.xpath("//*[@text='IBDU']");
	
	By coronaryBypass = By.xpath("//*[@text='Coronary artery bypass']");
	
	By otherSurgery = By.xpath("//*[@text='Other Surgery']");
	
	By selectDate = By.id("dateTV");
	
	By chooseDate = By.xpath("//*[@text='1']");

	By closeBtn = By.id("closeButtonLayout");
	
	By okBtn = By.id("deleteButtonLayout");
	
	By addNote = By.id("notesET");
	
	By updateCondition = By.id("updateConditionBTN");
	
//	By myCondition = By.id("myExistingConditionLayout");
	
	By availableCondition = By.id("myExistingConditionIV");
	
	By existingCondition = By.id("myExistingConditionLayout");
	
	By deleteMyCondition = By.id("deleteAppointment");
	
	

	public MyMedicalHistory(WebDriver driver) {
		super(driver);
		
	}
	
	
	public MyMedicalHistory addMyMedicalHistory(String userName,String Pass,String conditionName,String Comments){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(emailId);

		driver.findElement(emailId).clear();

		System.out.println("Entering the Email  : " + userName);

		driver.findElement(emailId).sendKeys(userName);

		System.out.println("Entering the Pin  : " + Pass);

		waitForClickabilityOf(pin);

		driver.findElement(pin).sendKeys(Pass);

		System.out.println("Clicking on My Medical History ");

		waitForClickabilityOf(menuBtn);

		driver.findElement(menuBtn).click();

		waitForClickabilityOf(myMedicalHistory);

		driver.findElement(myMedicalHistory).click();

		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();
		
		int elements = driver.findElements(availableCondition).size();

		System.out.println("Currently Available Condition No is : " + elements);

				
		if (conditionName == "Pouchitis") {
			
			System.out.println("Clicking On Pouchitis");
			
			waitForClickabilityOf(pouchitis);

			driver.findElement(pouchitis).click();
			
		} else if (conditionName == "Cholecystectomy") {
			
			System.out.println("Clicking On Cholecystectomy");
			
			waitForClickabilityOf(cholecy);

			driver.findElement(cholecy).click();
			
		} else if (conditionName == "IBDU") {
			
			System.out.println("Clicking On IBDU");
			
			waitForClickabilityOf(iBDu);

			driver.findElement(iBDu).click();
			
		} else if (conditionName == "Coronary artery bypass") {
			
			System.out.println("Clicking On Coronary artery bypass");
			
			waitForClickabilityOf(coronaryBypass);

			driver.findElement(coronaryBypass).click();
			
		}else{
			
			System.out.println("Clicking On Other Surgery");
			
			waitForClickabilityOf(otherSurgery);

			driver.findElement(otherSurgery).click();

		}
		
		System.out.println("Selecting the Date");
		
		waitForClickabilityOf(selectDate);

		driver.findElement(selectDate).click();
		
		waitForClickabilityOf(chooseDate);

		driver.findElement(chooseDate).click();
		
		waitForClickabilityOf(okBtn);

		driver.findElement(okBtn).click();
		
		System.out.println("Adding Some Additional Comments as : "+Comments);
		
		waitForClickabilityOf(addNote);

		driver.findElement(addNote).sendKeys(Comments);
		
		System.out.println("Clicking On Update Condition");
		
		waitForClickabilityOf(updateCondition);

		driver.findElement(updateCondition).click();
		
		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();
				
		int elements1 = driver.findElements(availableCondition).size();

		System.out.println("After Adding Available Condition No is : " + elements1);
		
		if (elements-elements1==4) {
			
			System.out.println("Successfully Added a Medical History");
			
		} else {
			
			System.out.println("Failed to Add a Medical History");

		}
				
		
		return new MyMedicalHistory(driver);
		
	}
	
	public MyMedicalHistory editMyMedicalHistory(String userName,String Pass,String Comments){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(emailId);

		driver.findElement(emailId).clear();

		System.out.println("Entering the Email  : " + userName);

		driver.findElement(emailId).sendKeys(userName);

		System.out.println("Entering the Pin  : " + Pass);

		waitForClickabilityOf(pin);

		driver.findElement(pin).sendKeys(Pass);

		System.out.println("Clicking on My Medications ");

		waitForClickabilityOf(menuBtn);

		driver.findElement(menuBtn).click();

		waitForClickabilityOf(myMedicalHistory);

		driver.findElement(myMedicalHistory).click();

		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();
				
		System.out.println("Clicking on My Existing Condition ");

		waitForClickabilityOf(existingCondition);

		driver.findElement(existingCondition).click();
		
		System.out.println("Editing My Existing Condition ");
			
		waitForClickabilityOf(addNote);
		
		String preComment = driver.findElement(addNote).getText();
		
		System.out.println("Existing Comment is : "+preComment);
		
		driver.findElement(addNote).clear();
		
		System.out.println("Editing Comment is : "+Comments);
		
		driver.findElement(addNote).sendKeys(Comments);
		
		System.out.println("Clicking On Update Condition");
		
		waitForClickabilityOf(updateCondition);

		driver.findElement(updateCondition).click();
		
		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();
		
		if (preComment!=Comments) {
			
			System.out.println("Successfully Edited My Existing Condition ");
			
		} else {
			
			System.out.println("Failed to Edit My Existing Condition ");

		}
	
		return new MyMedicalHistory(driver);
	}
	
	public MyMedicalHistory deleteMyMedicalHistory(String userName,String Pass){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(emailId);

		driver.findElement(emailId).clear();

		System.out.println("Entering the Email  : " + userName);

		driver.findElement(emailId).sendKeys(userName);

		System.out.println("Entering the Pin  : " + Pass);

		waitForClickabilityOf(pin);

		driver.findElement(pin).sendKeys(Pass);

		System.out.println("Clicking on My Medications ");

		waitForClickabilityOf(menuBtn);

		driver.findElement(menuBtn).click();

		waitForClickabilityOf(myMedicalHistory);

		driver.findElement(myMedicalHistory).click();

		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();
		
		int elements = driver.findElements(availableCondition).size();

		System.out.println("My Existing Condition No is : " + elements);
		
		System.out.println("Clicking on My Existing Condition ");

		waitForClickabilityOf(existingCondition);

		driver.findElement(existingCondition).click();
		
		System.out.println("Deleting My Existing Condition ");

		waitForClickabilityOf(deleteMyCondition);

		driver.findElement(deleteMyCondition).click();
		
		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();
		
		int elements1 = driver.findElements(availableCondition).size();

		System.out.println("My Existing Condition No is : " + (elements1-5));
		
		if (elements1-elements==4) {
			
			System.out.println("Successfully Deleted My Existing Condition ");
			
		} else {
			
			System.out.println("Failed to Delete My Existing Condition ");

		}
		
		
		return new MyMedicalHistory(driver);
	}

}
