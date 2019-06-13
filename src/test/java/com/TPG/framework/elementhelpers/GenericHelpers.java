package com.TPG.framework.elementhelpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

public class GenericHelpers {
	WebDriver driver = null;
	ExtentTest _report;
	
	public GenericHelpers(WebDriver driver,ExtentTest _report){
		this.driver = driver;
		this._report = _report;
	}
	
	public void assertEqual(String actual,String expected,String msg){
		Assert.assertEquals(actual, expected,msg);
	}
	
	public void assertNotEqual(String actual,String expected,String msg){
		Assert.assertNotEquals(actual,expected,msg);
	}
	
	public void assertNull(WebElement el){
		Assert.assertNull(el);
	}
	
	public void assertNotNull(WebElement el){
		Assert.assertNotNull(el);
	}

}
