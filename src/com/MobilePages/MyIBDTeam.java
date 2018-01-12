package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class MyIBDTeam extends BaseSetUp{

	public MyIBDTeam(WebDriver driver) {
		super(driver);
		
	}
	By emailId = By.id("emailET");

	By pin = By.id("pinFirstDigitET");

	By menuBtn = By.className("android.widget.ImageButton");

	By myIDBTeam = By.xpath("//*[@text='My IBD Team']");
	
	By closeBtn = By.id("closeButtonLayout");
	
//	By addTeamMember = By.xpath("//*[@text='ADD YOUR OWN TEAM MEMBER']");
	
	By addTeamMember = By.id("nhs.ibd.com.nhsibd:id/addTeamMemberPhotoIV");
	
	By deleteTeamMember = By.xpath("//*[@bounds='[426,513][480,567]']");
	
	By addPhoto = By.id("addTeamMemberPhotoFAB");
	
	By takePhoto = By.id("com.android.camera2:id/shutter_button");
	
	By savePhoto = By.id("com.android.camera2:id/done_button");
	
	By fullName = By.id("nameET");
	
	By job = By.id("jobET");
	
	By phoneNo = By.id("phoneET");
	
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	
	By teamMembers = By.id("teamMemberRootView");
	
	By addNewMember = By.id("nhs.ibd.com.nhsibd:id/saveTeamMemberBTN");
	
	public MyIBDTeam addIDBTeamMember(String userName,String pass,String FullName,String Job) throws InterruptedException{
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(emailId);

		driver.findElement(emailId).clear();

		System.out.println("Entering the Email  : " + userName);

		driver.findElement(emailId).sendKeys(userName);

		System.out.println("Entering the Pin  : " + pass);

		waitForClickabilityOf(pin);

		driver.findElement(pin).sendKeys(pass);
		
		System.out.println("Clicking on My My IDB Team ");
		
        waitForClickabilityOf(menuBtn);
		
		driver.findElement(menuBtn).click();
		
        waitForClickabilityOf(myIDBTeam);
		
		driver.findElement(myIDBTeam).click();
		
		System.out.println("Clicking on Closing Button ");
		
        waitForClickabilityOf(closeBtn);
		
		driver.findElement(closeBtn).click();
		
		int members = driver.findElements(teamMembers).size();
		
		System.out.println("Existing Team Size is : "+members);
		
		System.out.println("Clicking on Add Your Team Member ");
		
        waitForClickabilityOf(addTeamMember);
		
		driver.findElement(addTeamMember).click();
				
		try {
			System.out.println("Giving Camera Access to App");  
			
	        waitForClickabilityOf(allowAccess);
			
			driver.findElement(allowAccess).click();
			
	        waitForClickabilityOf(allowAccess);
			
			driver.findElement(allowAccess).click();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Clicking on Add Photo ");
		
        waitForClickabilityOf(addPhoto);
		
		driver.findElement(addPhoto).click();
		
		System.out.println("Taking Photo ");
		
        waitForClickabilityOf(takePhoto);
		
		driver.findElement(takePhoto).click();
		
		System.out.println("Saving the Photo ");
		
        waitForClickabilityOf(savePhoto);
		
		driver.findElement(savePhoto).click();
		
		System.out.println("Entering Full Name : "+FullName);
		
        waitForClickabilityOf(fullName);
		
		driver.findElement(fullName).sendKeys(FullName);
		
		System.out.println("Entering Job :  "+Job);
		
        waitForClickabilityOf(job);
		
		driver.findElement(job).sendKeys(Job);
		
//		scrollPageUp();		
		
		System.out.println("Clicking on Add New Member ");
		
        waitForClickabilityOf(addNewMember);
		
		driver.findElement(addNewMember).click();
				
        waitForClickabilityOf(closeBtn);
		
		driver.findElement(closeBtn).click();
		
		int members1 = driver.findElements(teamMembers).size();
		
		System.out.println("New Team Size is : "+members1);
		
		if (members+1==members1) {
			
			System.out.println("Successfully Added New Team Member ");
			
		} else {
			
			System.out.println("Failed to Add New Team Member ");

		}
		
		
		return new MyIBDTeam(driver);
		
	}
	
	public MyIBDTeam deleteTeamMember(String userName,String pass){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(emailId);

		driver.findElement(emailId).clear();

		System.out.println("Entering the Email  : " + userName);

		driver.findElement(emailId).sendKeys(userName);

		System.out.println("Entering the Pin  : " + pass);

		waitForClickabilityOf(pin);

		driver.findElement(pin).sendKeys(pass);
		
		System.out.println("Clicking on My My IDB Team ");
		
        waitForClickabilityOf(menuBtn);
		
		driver.findElement(menuBtn).click();
		
        waitForClickabilityOf(myIDBTeam);
		
		driver.findElement(myIDBTeam).click();
		
		System.out.println("Clicking on Closing Button ");
		
        waitForClickabilityOf(closeBtn);
		
		driver.findElement(closeBtn).click();
		
		int members = driver.findElements(teamMembers).size();
		
		System.out.println("Existing Team Size is : "+members);
		
		System.out.println("Deleting IBD Team Member ");
		
        waitForClickabilityOf(deleteTeamMember);
		
		driver.findElement(deleteTeamMember).click();
		
		int members1 = driver.findElements(teamMembers).size();
		
		System.out.println("After Deleting one Team Member the Team Size is : "+members1);
		
		if (members-1==members1) {
			
			System.out.println("Successfully Deleted Team Member ");
			
		} else {
			
			System.out.println("Failed to Delete Team Member ");

		}
		
		
		return new MyIBDTeam(driver);
		
	}
	

}
