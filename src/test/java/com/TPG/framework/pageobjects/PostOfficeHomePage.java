package com.TPG.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.TPG.framework.base.TPGPage;
import com.TPG.framework.elementhelpers.ClickNSetHelpers;
import com.relevantcodes.extentreports.ExtentTest;

public class PostOfficeHomePage extends TPGPage{
	
	@FindBy(how=How.NAME, using="btnSignOut")
	public WebElement signoutButtonElement;
	
	public PostOfficeHomePage(WebDriver driver, ExtentTest _report){
		super(driver,_report);
	}
	
	public PostOfficeLoginPage clickSignOutButton(){
		ClickNSetHelpers.click(signoutButtonElement);
		return new PostOfficeLoginPage(driver, _report);
	}

}
