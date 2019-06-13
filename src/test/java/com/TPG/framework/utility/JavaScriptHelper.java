package com.TPG.framework.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
	
	public void flash(WebElement el,WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = el.getCssValue("backgroundColor");
		for(int i=0; i<100; i++){
			changeColor("rgb(200,0,0)",el,driver);
			changeColor(bgcolor,el,driver);
		}
	}
	
	public void changeColor(String color,WebElement el,WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", el);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void drawBorder(WebElement el,WebDriver driver){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", el);
	}
	
	public void generateAlert(String msg,WebDriver driver){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("alert('"+msg+"')");
	}
	
	public void clickElementByJs(WebElement el,WebDriver driver){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", el);
	}
	
	//driver.navigate().refresh();
	
	public void refreshBrowserByJs(WebDriver driver){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public String titleByJs(WebDriver driver){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public String getPageInnerText(WebDriver driver){
		JavascriptExecutor js =(JavascriptExecutor)driver;
	String pageText =js.executeScript("return document.documentElement.innerText;").toString();
	return pageText;
	}
	
	public void scrollPageDown(WebDriver driver){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollIntoView(WebElement el,WebDriver driver){//Target element
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", el);
		
	}

}
