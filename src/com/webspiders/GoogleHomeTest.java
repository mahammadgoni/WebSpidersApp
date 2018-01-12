package com.webspiders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleHomeTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/goni/Documents/geckodriver");
		  WebDriver driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://google.com");
		  driver.close();
		  
		 
		

	}

}
