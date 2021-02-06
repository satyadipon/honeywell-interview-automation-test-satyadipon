package com.test.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.setup.TestSetup;
import com.main.utils.Config;
import com.test.pages.OpConfShftPage;
import com.test.pages.SnippetPage;

public class WebpageTest extends TestSetup{
	
	
	@Test
	public void webpageTest() throws InterruptedException {
		
		//case 1
		// defined in com.main.setup.TestSetup  - @BeforeMethod
		
		//case 2
		String url = Config.getProperty("url").replaceAll("://", "://"+Config.getProperty("username")+":"+Config.getProperty("password")+"@");
		System.out.println(url);
		
		getDriver().get(url);
		Thread.sleep(3000);
		
		//case 3
		OpConfShftPage opConfShftPage = new OpConfShftPage(getDriver());
		opConfShftPage.performMouseOverAndSelectOperation(getDriver(), opConfShftPage.oDropdownConfiguration, opConfShftPage.oDropdownOptionAssetConfiguration);
		
		//case 4
		SnippetPage snippetPage = new SnippetPage(getDriver());
		snippetPage.enterValuesAndDragDrop(getDriver(), Config.getProperty("value_groupname"), Config.getProperty("value_displayname"), Config.getProperty("value_description"), snippetPage.oElementSnippet_tagGroupSingleC);
		
	}

}
