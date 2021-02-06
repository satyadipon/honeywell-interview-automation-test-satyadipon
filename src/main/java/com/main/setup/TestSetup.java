package com.main.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.main.utils.Config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSetup {
	
private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	@BeforeSuite
	public void beforeSuite() {
		
		WebDriverManager.chromedriver().setup();
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriver tempDriver = null;
		
		//Handle SSL alerts - case 1
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		tempDriver = new ChromeDriver(cap);
		
		setDriver(tempDriver);
		TestSetup.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}

	@AfterMethod
	public void afterMethod() {
		
		getDriver().quit();
	}

}
