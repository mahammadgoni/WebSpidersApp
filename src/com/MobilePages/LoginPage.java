package com.MobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.BaseSetup.BaseSetUp;

public class LoginPage extends BaseSetUp {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	By userId = By.id("emailInputLayout");

	By password = By.id("pinFirstDigitET");
	
	By someoneElse = By.id("nhs.ibd.com.nhsibd:id/logoutLayout");
	
	By menu = By.id("Apps");

	By searchBar = By.id("com.android.launcher3:id/search_box_container");
	
	By app = By.xpath("//*[@bounds='[48,288][294,581]']");
	
	By dashboard = By.xpath("//*[@text ='Dashboard']");
	
	By errorMsg = By.id("nhs.ibd.com.nhsibd:id/snackbar_text");
	
	String eMsg = "invalid email or pin";
	
	

	public LoginPage accountLogin(String userName, String pin) {

		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(userId);

		driver.findElement(userId).clear();

		System.out.println("Entering the Email  :" + userName);

		driver.findElement(userId).sendKeys(userName);

		System.out.println("Entering the Pin  :" + pin);

		waitForClickabilityOf(password);

		driver.findElement(password).sendKeys(pin);
		
		waitForClickabilityOf(dashboard);
		
		boolean Dashboard = driver.findElement(dashboard).isDisplayed();
		
//		boolean ErrorMsg = driver.findElement(errorMsg).isDisplayed();
		
		if ( Dashboard == true) {
			
			System.out.println("Successfully Logged in ");
			
		} else {
			System.out.println("Failed to Login ");
			
//			System.out.println("===============================================");

		}

		return new LoginPage(driver);
	}


	public LoginPage loginAsLogedInUser(String userName, String pin){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(userId);

		driver.findElement(userId).clear();

		System.out.println("Entering the Email  :" + userName);

		driver.findElement(userId).sendKeys(userName);

		System.out.println("Entering the Pin  :" + pin);

		waitForClickabilityOf(password);

		driver.findElement(password).sendKeys(pin);
		
		boolean Dashboard = driver.findElement(dashboard).isDisplayed();
		
		if ( Dashboard == true) {
			
			System.out.println("This is User's Homepage");
			
		} else {
//			System.out.println();

		}
		
		System.out.println("Going Back to Home");

		driver.navigate().back();
		
		System.out.println("Clicking on Menu Button");

		driver.findElement(menu).click();
		
		System.out.println("Searching for My IBD Care App");
		
		driver.findElement(searchBar).sendKeys("My IBD Care");
		
		System.out.println("Clicking on My IBD Care App");
		
		driver.findElement(app).click();
		
		System.out.println("Entering the Pin  :" + pin);

		waitForClickabilityOf(password);

		driver.findElement(password).sendKeys(pin);
		
		boolean Dashboard1 = driver.findElement(dashboard).isDisplayed();
		
		if ( Dashboard1 == true) {
			
			System.out.println("Successfully Log in as Logged User ");
			
		} else {
			System.out.println("Failed to Log in as Logged User");

		}

		return new LoginPage(driver);
		
	}

	
	public LoginPage loginAsSomeoneElse(String userName, String pin ){
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(userId);

		driver.findElement(userId).clear();

		System.out.println("Entering the Email  :" + userName);

		driver.findElement(userId).sendKeys(userName);

		System.out.println("Entering the Pin  :" + pin);

		waitForClickabilityOf(password);

		driver.findElement(password).sendKeys(pin);
		
		boolean Dashboard = driver.findElement(dashboard).isDisplayed();
		
		if ( Dashboard == true) {
			
			System.out.println("This is User's Homepage");
			
		} else {
//			System.out.println();

		}
		
		System.out.println("Going Back to Home");

		driver.navigate().back();
		
		System.out.println("Clicking on Menu Button");

		driver.findElement(menu).click();
		
		System.out.println("Searching for the App");
				
		driver.findElement(searchBar).sendKeys("My IBD Care");
				
		driver.findElement(app).click();
		
		System.out.println("Clicking On LOG IN as Someone else ");
		
		waitForClickabilityOf(someoneElse);

		driver.findElement(someoneElse).click();
		
		System.out.println("Clicking on  Your Email ");

		waitForClickabilityOf(userId);

		driver.findElement(userId).clear();

		System.out.println("Entering the Email  :" + userName);

		driver.findElement(userId).sendKeys(userName);

		System.out.println("Entering the Pin  :" + pin);

		waitForClickabilityOf(password);

		driver.findElement(password).sendKeys(pin);
		
		boolean Dashboard1 = driver.findElement(dashboard).isDisplayed();
		
		if ( Dashboard1 == true) {
			
			System.out.println("Successfully Logged in as Someone Else  ");
			
		} else {
			System.out.println("Failed to Log in as Someone Else");

		}
		
		
		return new LoginPage(driver);
		
	}

	

}