package com.TPG.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class TPGPage {
	
	public WebDriver driver;
	public ExtentTest _report;
	
	//Initialization of elements in to PageFactory 
	public TPGPage(WebDriver driver, ExtentTest _report){
		this.driver = driver;
		this._report = _report;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
	}

}
