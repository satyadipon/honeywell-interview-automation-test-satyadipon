package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpConfShftPage {

	WebDriver driver;
	
	@FindBy(id = "Operation")
	public WebElement oDropdownOperation;
	@FindBy(id = "Configuration")
	public WebElement oDropdownConfiguration;
	@FindBy(id = "ShiftConfiguration")
	public WebElement oDropdownShiftConfiguration;
	@FindBy(id = "AssetConfiguration")
	public WebElement oDropdownOptionAssetConfiguration;
	
	
	public OpConfShftPage(WebDriver driver) {
		
		this.driver = driver;
        PageFactory.initElements(driver, this);
		
	}
	
	public void performMouseOverAndSelectOperation(WebDriver driver, WebElement element, WebElement selectElement) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		action.moveToElement(selectElement).click().build().perform();
	}
	
	
}
