package com.webspiders;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest {

	// private AppiumDriver<MobileElement> driver;

//	protected AndroidDriver<AndroidElement> driver = null;
	
	public WebDriver driver = null;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		File appDir = new File("/Users/goni/Documents/workspace/WebSpiders/WebSpidersApp/APK");

		File app = new File(appDir, "MyIDBCare.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Google Nexus 5 - 4.4.4 - API 19 - 1080x1920");

		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("platformVersion", "4.4.4");

		capabilities.setCapability("appActivity", "nhs.ibd.com.nhsibd.Features.SplashScreen.SplashScreenActivity");

		capabilities.setCapability("appPackage", "nhs.ibd.com.nhsibd");

		capabilities.setCapability("app", app.getAbsolutePath());
		
		capabilities.setCapability("noReset", "true");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test (priority = 1,alwaysRun = true)
	public void AppTest() {

		System.out.println("Inside Create Account");

		// AndroidElement registerNow = driver.findElementById("registerNowLayout");

//		WebElement registerNow = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/registerNowTV']"));
		
		WebElement registerNow = driver.findElement(By.id("registerNowTV"));

//		WebElement fullName = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/nameET']"));
		
		WebElement fullName = driver.findElement(By.id("nameET"));

//		WebElement emailId = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/emailET']"));
		
		WebElement emailId = driver.findElement(By.id("emailET"));

//		WebElement hospitalNo = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/hospitalNumberET']"));
		
		WebElement hospitalNo = driver.findElement(By.id("hospitalNumberET"));

//		WebElement phoneNo = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/phoneET']"));
		
		WebElement phoneNo = driver.findElement(By.id("phoneET"));

//		WebElement addHospital = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/selectedHospitalTV']"));
		
		WebElement addHospital = driver.findElement(By.id("selectedHospitalTV"));

//		WebElement searchHospital = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/searchHospitalACTV']"));
		
		WebElement searchHospital = driver.findElement(By.id("searchHospitalACTV"));

//		WebElement chooseHospital = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/nameTV']"));
		
		WebElement chooseHospital = driver.findElement(By.id("nameTV"));


//		WebElement completeReg = driver.findElement(By.xpath("//*[@resource-id ='nhs.ibd.com.nhsibd:id/registerBTN']"));
		
		WebElement completeReg = driver.findElement(By.id("registerBTN"));
		
		System.out.println(driver.getPageSource());
		
		List<WebElement> elements = driver.findElements(By.id(""));
		
		System.out.println(elements);
		
		
		WebDriverWait driverWait = new WebDriverWait(driver, 30);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerNowTV")));
		
		driver.findElement(By.id("registerNowTV"));


		if (registerNow.isDisplayed()) {

			registerNow.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		
		if (fullName.isDisplayed()) {

			fullName.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		
		if (emailId.isDisplayed()) {

			emailId.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		if (hospitalNo.isDisplayed()) {

			hospitalNo.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		
		if (phoneNo.isDisplayed()) {

			phoneNo.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		if (addHospital.isDisplayed()) {

			addHospital.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		if (searchHospital.isDisplayed()) {

			searchHospital.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		if (chooseHospital.isDisplayed()) {

			chooseHospital.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		if (completeReg.isDisplayed()) {

			completeReg.click();

			System.out.println("Visible");

		}else {
			
			System.out.println("Not Visible");
			
		}
		

	}

}
