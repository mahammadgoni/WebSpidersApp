package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.BaseSetup.BaseSetUp;

public class MyMedication extends BaseSetUp {



	By emailId = By.id("emailET");

	By pin = By.id("pinFirstDigitET");

	By menuBtn = By.className("android.widget.ImageButton");

	By myMedications = By.xpath("//*[@text='My Medications']");

	By closeBtn = By.id("closeButtonLayout");

	By onGoing = By.xpath("//*[@text='ONGOING']");

	By stopped = By.xpath("//*[@text='STOPPED']");

	By addNewMedication = By.id("addAppointmentBTN");

	By nameOfMedication = By.id("medicationNameLayout");

	By searchBtn = By.id("searchMedicationACTV");

	By selectMedication = By.id("medicationsRV");

	By dosage = By.id("dosageET");

	By unitSpinner = By.id("medicationUnitsSpinner");

	By mcgUnit = By.xpath("//*[@text='mcg']");

	By mgUnit = By.xpath("//*[@text='mg']");

	By gUnit = By.xpath("//*[@text='g']");

	By mlUnit = By.xpath("//*[@text='ml']");

	By frequencySpinner = By.id("medicationFrequencySpinner");

	By onePerday = By.xpath("//*[@text='1']");

	By twoPerday = By.xpath("//*[@text='2']");

	By threePerday = By.xpath("//*[@text='3']");

	By fourPerday = By.xpath("//*[@text='4']");

	By frequencyIntervalSpinner = By.id("medicationFrequencyIntervalSpinner");

	By timesADay = By.xpath("//*[@text='Times a Day']");

	By timesWeekly = By.xpath("//*[@text='Times Weekly']");

	By timesFourtNightly = By.xpath("//*[@text='Times Fortnightly']");

	By mon = By.xpath("//*[@text='Mon']");

	By tue = By.xpath("//*[@text='Tue']");

	By wed = By.xpath("//*[@text='Wed']");

	By thu = By.xpath("//*[@text='Thu']");

	By fri = By.xpath("//*[@text='Fri']");

	By sat = By.xpath("//*[@text='Sat']");

	By sun = By.xpath("//*[@text='Sun']");

	By setReminder = By.id("setMedicationReminderCB");

	By setTime = By.id("selectedTimeTV");

	By clickOnOkBtn = By.id("deleteButtonLayout");

	By addMedication = By.id("addMedicationBtn");

	By clickOnMedication = By.xpath("//*[@bounds='[24,446][1056,680]']");

	By deleteMedication = By.id("deleteMedication");

	By reason = By.xpath("//*[@text='It wasn’t need anymore']");

	By okBtn = By.id("deleteButtonLayout");

	By restartBtn = By.id("restartMedication");

	By medicationNo = By.id("nhs.ibd.com.nhsibd:id/rootView");

	By goBack = By.id("Navigate up");
	
	
	public MyMedication(WebDriver driver) {
		super(driver);

	}
	

	public MyMedication addMedication(String userName, String Pass, String paracetamol, CharSequence dosageAmt,
			int dosagePerDay, String unitName, String dosageInterval) {

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

		waitForClickabilityOf(myMedications);

		driver.findElement(myMedications).click();

		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();

		System.out.println("Clicking on Add New Medication ");

		waitForClickabilityOf(addNewMedication);

		driver.findElement(addNewMedication).click();

		System.out.println("Enterting Name Of Medication as  : " + paracetamol);

		waitForClickabilityOf(nameOfMedication);

		driver.findElement(nameOfMedication).click();

		waitForClickabilityOf(searchBtn);

		driver.findElement(searchBtn).sendKeys(paracetamol);

		waitForClickabilityOf(selectMedication);

		driver.findElement(selectMedication).click();

		System.out.println("Enter Dosage Amount : " + dosageAmt);

		waitForClickabilityOf(dosage);

		driver.findElement(dosage).sendKeys(dosageAmt);

		waitForClickabilityOf(unitSpinner);

		driver.findElement(unitSpinner).click();

		// String MGUnit = driver.findElement(mgUnit).getText();
		//
		// String GUnit = driver.findElement(gUnit).getText();
		//
		// String MLUnit = driver.findElement(mlUnit).getText();

		Boolean MGUnit = driver.findElement(mgUnit).isDisplayed();

		Boolean GUnit = driver.findElement(gUnit).isDisplayed();

		Boolean MLUnit = driver.findElement(mlUnit).isDisplayed();

		if (MGUnit == true & unitName == "mg") {

			System.out.println("Selecting the Dosage Unit  : " + unitName);

			waitForClickabilityOf(mgUnit);

			driver.findElement(mgUnit).click();

		} else if (GUnit == true & unitName == "g") {

			System.out.println("Selecting the Dosage Unit  : " + unitName);

			waitForClickabilityOf(gUnit);

			driver.findElement(gUnit).click();

		} else if (MLUnit == true & unitName == "ml") {

			System.out.println("Selecting the Dosage Unit  : " + unitName);

			waitForClickabilityOf(mlUnit);

			driver.findElement(mlUnit).click();

		} else {
			System.out.println("Selecting the Dosage Unit  :  mcg");

			waitForClickabilityOf(mcgUnit);

			driver.findElement(mcgUnit).click();

		}

		System.out.println("Selecting Dosage Frequency : " + dosagePerDay);

		waitForClickabilityOf(frequencySpinner);

		driver.findElement(frequencySpinner).click();

		if (dosagePerDay == 2) {

			waitForClickabilityOf(twoPerday);

			driver.findElement(twoPerday).click();

		} else if (dosagePerDay == 3) {

			waitForClickabilityOf(threePerday);

			driver.findElement(threePerday).click();

		} else if (dosagePerDay == 4) {

			waitForClickabilityOf(fourPerday);

			driver.findElement(fourPerday).click();

		} else {
			waitForClickabilityOf(onePerday);

			driver.findElement(onePerday).click();

		}

		System.out.println("Selecting Dosage Frequency Interval  : " + dosageInterval);

		waitForClickabilityOf(frequencyIntervalSpinner);

		driver.findElement(frequencyIntervalSpinner).click();

		if (dosageInterval == "Week") {

			waitForClickabilityOf(timesWeekly);

			driver.findElement(timesWeekly).click();

			System.out.println("Selecting the day as : Friday");

			waitForClickabilityOf(fri);

			driver.findElement(fri).click();

		} else if (dosageInterval == "Fortnight") {

			waitForClickabilityOf(timesFourtNightly);

			driver.findElement(timesFourtNightly).click();

			System.out.println("Selecting the day as : Wednesday");

			waitForClickabilityOf(wed);

			driver.findElement(wed).click();

		} else {
			waitForClickabilityOf(timesADay);

			driver.findElement(timesADay).click();

		}

		System.out.println("Selecting the Days ");

		// Need to code here for Future use for days selecting

		System.out.println("Selecting the Remainder ");

		waitForClickabilityOf(setReminder);

		driver.findElement(setReminder).click();

		// Setting the Time

		waitForClickabilityOf(setTime);

		driver.findElement(setTime).click();

		waitForClickabilityOf(clickOnOkBtn);

		driver.findElement(clickOnOkBtn).click();

		System.out.println("Selecting the Time : " + driver.findElement(setTime).getText());

		System.out.println("Clicking on Add Medication  ");

		waitForClickabilityOf(addMedication);

		driver.findElement(addMedication).click();
		
		System.out.println("Successfully Added New Medication ");

		return new MyMedication(driver);

	}

	public MyMedication stopMedication(String userName, String Pass) {

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

		waitForClickabilityOf(myMedications);

		driver.findElement(myMedications).click();

		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();

		System.out.println("Go to Stopped Medications ");

		waitForClickabilityOf(stopped);

		driver.findElement(stopped).click();

		int elements = driver.findElements(medicationNo).size();

		if (elements <= 2) {

			System.out.println("Current Stopped Mediaction No : 0");

		} else {

			System.out.println("Current Stopped Mediaction No : " + (elements - 2));

		}

		System.out.println("Stopping Medication from On Going Tab ");

		waitForClickabilityOf(onGoing);

		driver.findElement(onGoing).click();

		waitForClickabilityOf(clickOnMedication);

		driver.findElement(clickOnMedication).click();

		waitForClickabilityOf(deleteMedication);

		driver.findElement(deleteMedication).click();

		System.out.println("Choosing the reason to stop the Medication :  It wasn’t need anymore");

		waitForClickabilityOf(reason);

		driver.findElement(reason).click();

		System.out.println("Clicking on OK button");

		waitForClickabilityOf(okBtn);

		driver.findElement(okBtn).click();

		System.out.println("Go to Stopped Medications ");

		waitForClickabilityOf(stopped);

		driver.findElement(stopped).click();

		int elements2 = driver.findElements(medicationNo).size();

		if (elements2 <= 2) {

			System.out.println("New Stopped Mediaction No : 0");

		} else {

			System.out.println("New Stopped Mediaction No : " + (elements2 - 2));

		}
		
		System.out.println("Successfully Stopped Medication ");

		return new MyMedication(driver);

	}

	public MyMedication editMedication(String userName, String Pass, String newMedicine, CharSequence dosageAmt) {

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

		waitForClickabilityOf(myMedications);

		driver.findElement(myMedications).click();

		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();

		waitForClickabilityOf(clickOnMedication);

		driver.findElement(clickOnMedication).click();

		System.out.println("Enterting Name Of Medication as  : " + newMedicine);

		waitForClickabilityOf(nameOfMedication);

		driver.findElement(nameOfMedication).click();

		waitForClickabilityOf(searchBtn);

		driver.findElement(searchBtn).sendKeys(newMedicine);

		waitForClickabilityOf(selectMedication);

		driver.findElement(selectMedication).click();

		System.out.println("Enter Dosage Amount : " + dosageAmt);

		waitForClickabilityOf(dosage);

		driver.findElement(dosage).clear();

		driver.findElement(dosage).sendKeys(dosageAmt);

		waitForClickabilityOf(unitSpinner);

		driver.findElement(unitSpinner).click();

		waitForClickabilityOf(mlUnit);

		driver.findElement(mlUnit).click();

		waitForClickabilityOf(frequencyIntervalSpinner);

		driver.findElement(frequencyIntervalSpinner).click();

		waitForClickabilityOf(timesADay);

		driver.findElement(timesADay).click();

		waitForClickabilityOf(tue);

		driver.findElement(tue).click();

		waitForClickabilityOf(wed);

		driver.findElement(wed).click();

		boolean Reminder = driver.findElement(setTime).isDisplayed();

//		System.out.println(Reminder);

		if (Reminder == true) {

			System.out.println("Unchecking the Remainder ");

			waitForClickabilityOf(setReminder);

			driver.findElement(setReminder).click();

		} else {

			System.out.println("Selecting the Remainder ");

			waitForClickabilityOf(setReminder);

			driver.findElement(setReminder).click();

			waitForClickabilityOf(setTime);

			driver.findElement(setTime).click();

			waitForClickabilityOf(clickOnOkBtn);

			driver.findElement(clickOnOkBtn).click();

			System.out.println("Selecting the Time : " + driver.findElement(setTime).getText());

		}

		System.out.println("Clicking on Edit Medication  ");

		waitForClickabilityOf(addMedication);

		driver.findElement(addMedication).click();
		
		System.out.println("Successfully Edited Medication ");

		return new MyMedication(driver);

	}

	public MyMedication restartMedication(String userName, String Pass) {

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

		waitForClickabilityOf(myMedications);

		driver.findElement(myMedications).click();

		System.out.println("Clicking on Close Button ");

		waitForClickabilityOf(closeBtn);

		driver.findElement(closeBtn).click();

		System.out.println("Go to Stopped Medications ");

		waitForClickabilityOf(stopped);

		driver.findElement(stopped).click();

		int elements = driver.findElements(medicationNo).size();

		if (elements <= 2) {

			System.out.println("Current Stopped Mediaction No : 0");

		} else {

			System.out.println("Yet to Restart Mediaction No : " + (elements - 2));

		}

		System.out.println("Restarting Medication from STOPPED Tab ");

		waitForClickabilityOf(clickOnMedication);

		driver.findElement(clickOnMedication).click();

		waitForClickabilityOf(restartBtn);

		driver.findElement(restartBtn).click();

		int elements2 = driver.findElements(medicationNo).size();

		if (elements2 <= 2) {

			System.out.println("Current Stopped Mediaction No : 0");

		} else {

			System.out.println("Yet to Restart Mediaction No : " + (elements2 - 2));

		}
		
		System.out.println("Successfully Restarted Medication ");

		return new MyMedication(driver);

	}

}
