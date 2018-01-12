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
	
	By selectTimeAndDate = By.id("dateOfVisitSpinner");
	
	By nextMonth = By.id("nhs.ibd.com.nhsibd:id/nextMonthIV");
	
	By selectDate = By.id("calendar");
	
	By selectTime = By.id("selectedTimeTV");
	
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
		
        waitForClickabilityOf(radiology);
		
		driver.findElement(radiology).click();
		
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

	
		


