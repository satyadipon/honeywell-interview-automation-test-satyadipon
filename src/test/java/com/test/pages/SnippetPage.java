package com.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SnippetPage {

	WebDriver driver;
	
	@FindBy(id = "groupName")
	public WebElement oInputGroupName;
	@FindBy(id = "displayName")
	public WebElement oInputDisplayName;
	@FindBy(id = "desc")
	public WebElement oInputDescription;
	@FindBy(id = "tag-group-single_c")
	public WebElement oElementSnippet_tagGroupSingleC;
	@FindBy(id = "snippetDropArea")
	public WebElement oElementSnippetDropArea;
	
	
	public SnippetPage(WebDriver driver) {
		
		this.driver = driver;
        PageFactory.initElements(driver, this);
		
	}
	
	public void enterValuesAndDragDrop(WebDriver driver, String group, String display, String desc, WebElement dragElement) {
		
		oInputGroupName.sendKeys(group);
		oInputDisplayName.sendKeys(display);
		((JavascriptExecutor)driver).executeScript("arguments[0].value='" + desc + "'", oInputDescription);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(oElementSnippet_tagGroupSingleC, oElementSnippetDropArea);
		
	}
	
	
}
