package com.TPG.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.TPG.framework.base.TPGPage;
import com.TPG.framework.elementhelpers.ClickNSetHelpers;
import com.relevantcodes.extentreports.ExtentTest;

public class TPGHomePage extends TPGPage {
	
	@FindBy(how=How.LINK_TEXT , using="My Account")
    public WebElement myaccountLinkElement;
	@FindBy(how=How.LINK_TEXT, using="Post Office")
	public WebElement postofficeLinkElement;
	
	public TPGHomePage(WebDriver driver,ExtentTest _report){
		super(driver,_report);
	}
	
	public MyAccountLoginPage clickMyAccountLink(){
		ClickNSetHelpers.click(myaccountLinkElement);
		return new MyAccountLoginPage(driver, _report);
	}
	
	public PostOfficeLoginPage clickPostOffice(){
		ClickNSetHelpers.click(postofficeLinkElement);
		return new PostOfficeLoginPage(driver, _report);
	}
	
}
