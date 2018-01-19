package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.BaseSetup.BaseSetUp;

public class MyAppointments extends BaseSetUp{

	public MyAppointments(WebDriver driver) {
		super(driver);
		
	}

	By emailId = By.id("emailET");

	By pin = By.id("pinFirstDigitET");

	By menuBtn = By.className("android.widget.ImageButton");

	By myAppointment = By.xpath("//*[@text='My Appointments']");
	
	By addNewAppointment = By.id("addAppointmentBTN");
	
	By typeOfVisit = By.id("typeOfVisitSpinner");
	
	By idbClinicDoctor = By.xpath("//*[@text='IBD CLINIC DOCTOR']");
	
	By surgicalAppointment = By.xpath("//*[@text='SURGICAL APPOINTMENT']");
	
	By radiology = By.xpath("//*[@text='RADIOLOGY']");
	
	By endoscopy = By.xpath("//*[@text='ENDOSCOPY']");
	
	By bloodTest = By.xpath("//*[@text='BLOOD TEST']");
	
	By other = By.xpath("//*[@text='OTHER']");
	
	By appoName = By.xpath("//*[@resource-id='nhs.ibd.com.nhsibd:id/visitTypeTV'][@instance='6']");
	
	By appoTime = By.xpath("//*[@bounds='[273,554][362,603]']");
	
	By appoDate = By.xpath("//*[@bounds='[63,486][165,607]']");
	
	By appoMonth = By.xpath("//*[@bounds='[55,607][172,672]']");
	
	By selectTimeAndDate = By.id("dateOfVisitSpinner");
	
	By nextMonth = By.id("nhs.ibd.com.nhsibd:id/nextMonthIV");
	
	By selectDate = By.id("calendar");
	
	By selectTime = By.id("selectedTimeTV");
	
//	By selectHour = By.id("");
	
	By setTimeAndDate = By.id("setDateAndTimeBTN");
	
	By clickOnOkBtn = By.id("deleteButtonLayout");
	
	By clickOnCancelBtn = By.id("cancelButtonLayout");
	
	By clickOnAppointment = By.id("pendingOrConfirmedLayout");
	
	By clickOnPastAppointment = By.xpath("//*[@text='PAST']");
	
	By clickOnUpcomingAppointment = By.xpath("//*[@text='UPCOMING']");
	
	By PastAppointment = By.xpath("//*[@bounds='[24,408][1056,657]']");
	
	By UpcomingAppointment = By.xpath("//*[@bounds='[24,423][1056,672]']");
	
	By deleteAppointment = By.xpath("//android.widget.TextView[@content-desc='Delete Appointment']");
	
	By editAppointment = By.id("addAppointmentBTN");

	By closeBtn = By.xpath("//android.widget.TextView[@text='CLOSE']");

	By okBtn = By.id("deleteButtonLayout");
	
	By existingAppo = By.id("nhs.ibd.com.nhsibd:id/rootView");

	
	
	public MyAppointments addNewAppointment(String userName,String pass,String date){
		
		System.out.println("Clicking on  Your Email ");
		
        waitForClickabilityOf(emailId);
		
        driver.findElement(emailId).clear();
        
		System.out.println("Entering the Email  :"+userName);
        
        driver.findElement(emailId).sendKeys(userName);
        
        waitForClickabilityOf(pin);
        
		System.out.println("Entering the Pin  :"+pass);
        
        driver.findElement(pin).sendKeys(pass);
        
		System.out.println("Clicking on My Appointments ");
		
        waitForClickabilityOf(menuBtn);
		
		driver.findElement(menuBtn).click();
		
        waitForClickabilityOf(myAppointment);
		
		driver.findElement(myAppointment).click();
				
		System.out.println("Clicking on Close Button ");
		
        waitForClickabilityOf(closeBtn);
		
		driver.findElement(closeBtn).click();
		
		int elements = (driver.findElements(existingAppo).size() -2);
		
		System.out.println("Existing Appointments Numbers are : "+ elements);
			
		System.out.println("Clicking on Add New Appointment ");
		
        waitForClickabilityOf(addNewAppointment);
		
		driver.findElement(addNewAppointment).click();
		
		System.out.println("Select Your Type of Visit ");
		
        waitForClickabilityOf(typeOfVisit);
		
		driver.findElement(typeOfVisit).click();
		
		System.out.println("Selecting the Visit Type ");
		
        waitForClickabilityOf(bloodTest);
		
		driver.findElement(bloodTest).click();
		
		System.out.println("Select Date and Time ");
		
        waitForClickabilityOf(selectTimeAndDate);
		
		driver.findElement(selectTimeAndDate).click();
		
		System.out.println("Selecting Date "+date);
		
        waitForClickabilityOf(nextMonth);
		
		driver.findElement(nextMonth).click();
		
        waitForClickabilityOf(selectDate);
		
		driver.findElement(selectDate).sendKeys(date);
		
		System.out.println("Selecting Time ");
		
        waitForClickabilityOf(selectTime);
		
		driver.findElement(selectTime).click();
		
        waitForClickabilityOf(clickOnOkBtn);
		
		driver.findElement(clickOnOkBtn).click();
		
        waitForClickabilityOf(setTimeAndDate);
		
		driver.findElement(setTimeAndDate).click();
		
		System.out.println("Adding New Appointment ");
		
        waitForClickabilityOf(addNewAppointment);
		
		driver.findElement(addNewAppointment).click();
		
		int elements1 = (driver.findElements(existingAppo).size()-2);
		
		System.out.println("After Adding Appointments Numbers are : "+ elements1);
		
		if (elements+1==elements1) {
			
			System.out.println("Successfully Added One New Appointment ");
			
		} else {
			
			System.out.println("Failed to Add New Appointment ");

		}
			
		return new MyAppointments(driver);
				
	}
	
	public MyAppointments editAppointment(String userName,String pass){
		
		System.out.println("Clicking on  Your Email ");
		
        waitForClickabilityOf(emailId);
		
        driver.findElement(emailId).clear();
        
		System.out.println("Entering the Email  :"+userName);
        
        driver.findElement(emailId).sendKeys(userName);
        
        waitForClickabilityOf(pin);
        
		System.out.println("Entering the Pin  :"+pass);
        
        driver.findElement(pin).sendKeys(pass);
        
		System.out.println("Clicking on My Appointments ");
		
        waitForClickabilityOf(menuBtn);
		
		driver.findElement(menuBtn).click();
		
        waitForClickabilityOf(myAppointment);
		
		driver.findElement(myAppointment).click();
				
		System.out.println("Clicking on Close Button ");
		
        waitForClickabilityOf(closeBtn);
		
		driver.findElement(closeBtn).click();
		
        waitForClickabilityOf(appoName);
        
        String AppoName = driver.findElement(appoName).getText();
        
//        waitForClickabilityOf(appoDate);
//        
//        String AppoDate = driver.findElement(appoDate).getText();
//        
//        waitForClickabilityOf(appoMonth);
//        
//        String AppoMonth = driver.findElement(appoMonth).getText();
//        
//        waitForClickabilityOf(appoTime);
//        
//        String AppoTime = driver.findElement(appoTime).getText();
        
//        System.out.println("You Have  "+AppoName+" Appointment on "+AppoDate+"-"+AppoMonth+"-2018 at "+AppoTime+" PM");
        
        System.out.println("You have an Upcoming "+AppoName+" Appointment!");
		
		driver.findElement(appoName).click();
		
//		String allDetails = driver.findElement(UpcomingAppointment).getText();
//		
//		System.out.println(allDetails);
		
		System.out.println("Changing Your Type of Visit ");
		
        waitForClickabilityOf(typeOfVisit);
		
		driver.findElement(typeOfVisit).click();
		
		System.out.println("Selecting your new Visit Type ");
		
        waitForClickabilityOf(other);
		
		driver.findElement(other).click();
		
//		System.out.println("Select new Date and Time ");
//		
//        waitForClickabilityOf(selectTimeAndDate);
//		
//		driver.findElement(selectTimeAndDate).click();
//		
//		System.out.println("Selecting Date "+date);
//		
//        waitForClickabilityOf(nextMonth);
//		
//		driver.findElement(nextMonth).click();
//		
//        waitForClickabilityOf(selectDate);
//		
//		driver.findElement(selectDate).sendKeys(date);
//		
//		System.out.println("Selecting new Time ");
//		
//        waitForClickabilityOf(selectTime);
//		
//		driver.findElement(selectTime).click();
//		
////        waitForClickabilityOf(selectTime);
//		
//		driver.findElement(By.id(hour)).click();
//		
//        waitForClickabilityOf(clickOnOkBtn);
//		
//		driver.findElement(clickOnOkBtn).click();
//		
//        waitForClickabilityOf(setTimeAndDate);
//		
//		driver.findElement(setTimeAndDate).click();
		
		System.out.println("Editing Appointment ");
		
        waitForClickabilityOf(editAppointment);
		
		driver.findElement(editAppointment).click();
		        
        waitForVisibilityOf(appoName);
        
        String AppoName1 = driver.findElement(appoName).getText();
        
//        System.out.println(AppoName+"="+AppoName1);
//
//        waitForVisibilityOf(appoDate);
//        
//        String AppoDate1 = driver.findElement(appoDate).getText();
//        
//        waitForVisibilityOf(appoMonth);
//        
//        String AppoMonth1 = driver.findElement(appoMonth).getText();
//                
//        waitForVisibilityOf(appoTime);
//        
//        String AppoTime1 = driver.findElement(appoTime).getText();
        
//        System.out.println("You Have new  "+AppoName1+" Appointment on "+AppoDate+"-"+AppoMonth+"-2018 at "+AppoTime+" PM");
        
        
        if (AppoName1.equals(AppoName)) {
        	
	        System.out.println("You have the same Upcoming "+AppoName1+" Appointment!");
        	
        	System.out.println("Failed to Edit the Appointment ");
			
		} else {
			
	        System.out.println("You have a new Upcoming "+AppoName1+" Appointment!");
			
        	System.out.println("Successfully Edited the Appointment ");

		}
		
		
		
		return new MyAppointments(driver);
		
	}
	
	public MyAppointments deleteAppointment(String userName,String pass){
		
		System.out.println("Clicking on  Your Email ");
		
        waitForClickabilityOf(emailId);

        driver.findElement(emailId).clear();
        
		System.out.println("Entering the Email  :"+userName);
        
        driver.findElement(emailId).sendKeys(userName);
        
		System.out.println("Entering the Pin  :"+pass);
		
        waitForClickabilityOf(pin);
        
        driver.findElement(pin).sendKeys(pass);
        
		System.out.println("Clicking on My Appointments ");
		
        waitForClickabilityOf(menuBtn);
		
		driver.findElement(menuBtn).click();
		
        waitForClickabilityOf(myAppointment);
		
		driver.findElement(myAppointment).click();
		
		System.out.println("Clicking on Close Button ");
		
		driver.findElement(closeBtn).click();
		
		System.out.println("Deleting Appointment from PAST  ");
		
        waitForClickabilityOf(clickOnPastAppointment);
        
		driver.findElement(clickOnPastAppointment).click();
		
		int elements = (driver.findElements(existingAppo).size() -2);
		
		System.out.println("Existing PAST Appointments Numbers are : "+ elements);
		
		if (elements==0) {
			
			System.out.println("Deleting Appointment from UPCOMING");
			
	        waitForClickabilityOf(clickOnUpcomingAppointment);
	        
			driver.findElement(clickOnUpcomingAppointment).click();
			
			int elements1 = (driver.findElements(existingAppo).size() -2);
			
			System.out.println("Existing UPCOMING Appointments Numbers are : "+ elements1);
			
		    waitForClickabilityOf(UpcomingAppointment);
			
			driver.findElement(UpcomingAppointment).click();
			
		    waitForClickabilityOf(deleteAppointment);
			
			driver.findElement(deleteAppointment).click();
			
			int elements2 = (driver.findElements(existingAppo).size() -2);
			
			System.out.println("After Deleting UPCOMING Appointments Numbers are : "+ elements2);
			
			if (elements1-1==elements2) {
				
				System.out.println("Successfully Deleted Appointment");
				
			} else {
				
				System.out.println("Failed to Delete Appointment");

			}
			
		} else {
			
		    waitForClickabilityOf(PastAppointment);
			
			driver.findElement(PastAppointment).click();
			
		    waitForClickabilityOf(deleteAppointment);
			
			driver.findElement(deleteAppointment).click();
			
			int elements3 = (driver.findElements(existingAppo).size() -2);
			
			System.out.println("After Deleting PAST Appointments Numbers are : "+ elements3);
			
			if (elements-1==elements3) {
				
				System.out.println("Successfully Deleted Appointment");
				
			} else {
				
				System.out.println("Failed to Delete Appointment");

			}
			
		}

 
					
		return new MyAppointments(driver);
		
	}
	
	}

	
		


