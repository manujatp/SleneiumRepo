package com.TPG.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.TPG.framework.base.TPGPage;
import com.TPG.framework.elementhelpers.ClickNSetHelpers;
import com.relevantcodes.extentreports.ExtentTest;

public class MyAccountLoginPage extends TPGPage {
	
	@FindBy(how=How.ID, using="check_username")
	protected WebElement userIDElement;       //@FindBy(id="check_username")WebElement userid;
	
	@FindBy(how=How.ID, using="password")
    protected WebElement passwordElement;
	
	@FindBy(how=How.XPATH, using="//input[contains(@class,'yapo-sibtn')]")
	protected WebElement signinButton;
	
	public MyAccountLoginPage(WebDriver driver, ExtentTest _report){
		super(driver,_report);
	}
	
    public MyAccountLoginPage setUserIDElement(String userID){
    	ClickNSetHelpers.set(userIDElement,userID);
    	return this;
    }
    
    public MyAccountLoginPage setPasswordElement(String pwd){
    	ClickNSetHelpers.set(passwordElement, pwd);
    	return this;
    }
    
    public MyAccountHomePage clickSignInButton(){
    	ClickNSetHelpers.click(signinButton);
    	return new MyAccountHomePage(driver,_report);
    }
	
}
