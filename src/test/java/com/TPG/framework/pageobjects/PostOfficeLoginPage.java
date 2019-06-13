package com.TPG.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.TPG.framework.base.TPGPage;
import com.TPG.framework.elementhelpers.ClickNSetHelpers;
import com.relevantcodes.extentreports.ExtentTest;

public class PostOfficeLoginPage extends TPGPage{
	
	@FindBy(how=How.ID, using="imapuser")
	public WebElement userIDElement;
	
	@FindBy(how=How.ID, using="pass")
	public WebElement passwordElement;
	
	@FindBy(how=How.ID, using="btnLogin")
	public WebElement signinButtonElement;
	
	public PostOfficeLoginPage(WebDriver driver,ExtentTest _report){
		super(driver,_report);
	}
	
	public PostOfficeLoginPage setUserIDElement(String userID){
		ClickNSetHelpers.set(userIDElement, userID);
		return this;
	}
	
	public PostOfficeLoginPage setPasswordElement(String pwd){
		ClickNSetHelpers.set(passwordElement, pwd);
		return this;
	}
	
	public PostOfficeHomePage clickSignInButton(){
		ClickNSetHelpers.click(signinButtonElement);
		return new PostOfficeHomePage(driver,_report);
	}

}
