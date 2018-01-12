package com.webspiders;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import java.net.URL;
import java.net.MalformedURLException;

public class AndroidStudio {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Login";
	protected AndroidDriver<AndroidElement> driver = null;

	DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeClass
	public void setUp() throws MalformedURLException {
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability("deviceName", "Google Nexus 5 - 4.4.4 - API 19 - 1080x1920");
		dc.setCapability(MobileCapabilityType.UDID, "192.168.56.101:5555");
		dc.setCapability(MobileCapabilityType.APP,"/Users/goni/Documents/workspace/WebSpiders/WebSpidersApp/APK/MyIDBCare.apk");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "nhs.ibd.com.nhsibd");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Features.SplashScreen.SplashScreenActivity");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability("instrumentApp", true);
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
	}

	@Test
	public void testLogin() {

		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='registerNowLayout']")));
		driver.findElement(By.xpath("//*[@id='registerNowLayout']")).click();
//		driver.findElement(By.xpath("//*[@text='Don't have an account? REGISTER NOW!']")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nameET']")));
		driver.findElement(By.xpath("//*[@id='nameET']")).sendKeys("Md Goni");
//		driver.getKeyboard().sendKeys("{ENTER}");
		driver.getKeyboard().sendKeys("skmahammad.goni@webspiders.com");
//		driver.getKeyboard().sendKeys("{ENTER}");
		driver.getKeyboard().sendKeys("1637");
//		driver.getKeyboard().sendKeys("{ENTER}");
//		driver.getKeyboard().sendKeys("\\");
//		driver.getKeyboard().sendKeys("{ENTER}");
		driver.findElement(By.xpath("//*[@text='Select Hospital']")).click();
		driver.findElement(By.xpath("//*[@hint='Search Hospitals']")).sendKeys("ash");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Ashford Hospital']")));
		driver.findElement(By.xpath("//*[@text='Ashford Hospital']")).click();
		driver.findElement(By.xpath("//*[@text='COMPLETE REGISTRATION']")).click();
		driver.findElement(By.xpath("//*[@id='emailET']")).sendKeys("skmahammad.goni@webspiders.com");
//		driver.getKeyboard().sendKeys("{ENTER}");
		driver.getKeyboard().sendKeys("5045");
		driver.context("NATIVE_APP");
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='registerNowLayout']")));
		driver.findElement(By.xpath("//*[@id='registerNowTV']")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
