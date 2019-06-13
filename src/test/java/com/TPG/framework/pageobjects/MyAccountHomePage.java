package com.TPG.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.TPG.framework.base.TPGPage;
import com.TPG.framework.elementhelpers.ClickNSetHelpers;
import com.relevantcodes.extentreports.ExtentTest;

public class MyAccountHomePage extends TPGPage {
	
	@FindBy(how=How.XPATH, using="//b[text()='Log Out']")
	public WebElement logoutButtonElement;
	
	public MyAccountHomePage(WebDriver driver, ExtentTest _report){
		super(driver,_report);
	}
	
	public MyAccountLoginPage clickLogoutButtonElement(){
		ClickNSetHelpers.click(logoutButtonElement);
		return new MyAccountLoginPage(driver,_report);
	}

}
