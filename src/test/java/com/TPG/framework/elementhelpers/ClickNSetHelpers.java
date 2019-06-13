package com.TPG.framework.elementhelpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ClickNSetHelpers {
	public static void click(WebElement el){
		el.click();
	}
	
    public static void set(WebElement el,String userID){
    	el.click();
    	el.clear();
    	el.sendKeys(userID);
    	el.sendKeys(Keys.TAB);
    }
    
}
