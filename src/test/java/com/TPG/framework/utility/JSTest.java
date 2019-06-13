package com.TPG.framework.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSTest {

	public static void main(String[] args) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
//		String dateS = dateFormat.format(cal.getTime());
//		System.out.println(dateS);
//		//cal.setTime(mar.getEventDate());
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int returnday = day + 7;
		
				
		System.out.println(day);
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
		Calendar c = Calendar.getInstance();
	//	String output1 = sdf.format(c.getTime());
		//System.out.println(c.getTime());
	//	c.setTime(new Date());
	//	System.out.println(c.getTime());
//		String output2 = sdf.format(c.getTime());// Now use today date.
//		System.out.println(output2);
//		c.add(Calendar.DATE, 7); // Adding 5 days
//		String output3 = sdf.format(c.getTime());
//		System.out.println(output3);
		
//				
	
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateS1 = dateFormat1.format(date);
		System.out.println(dateS1);
		
//	    WebDriver driver = null;
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(9000, TimeUnit.MILLISECONDS);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
	//	driver.get("https://en.wikipedia.org/wiki/Main_Page");
	//	driver.get("https://google.com.au");
	//	WebElement _searchTextElement = driver.findElement(By.name("q"));
	//	WebElement _signinButtonElement = driver.findElement(By.id("gb_70"));
	//	JavaScriptHelper JH = new JavaScriptHelper();
		//JH.flash(_signinButtonElement, driver);
		
		
		//JH.generateAlert("Flashing not happening", driver);
	//	_searchTextElement.sendKeys("Hello");
	//	_searchTextElement.sendKeys(Keys.TAB);
	//	JH.drawBorder(_signinButtonElement, driver);
	//	WebElement _SearchButtonElement = driver.findElement(By.name("btnK"));
		//JH.clickElementByJs(_SearchButtonElement, driver);
		//JH.refreshBrowserByJs(driver);
	//	String title = JH.titleByJs(driver);
	//	System.out.println(title);
	//	WebElement _wilkiElement = driver.findElement(By.id("mp-sister"));
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String innerText = JH.getPageInnerText(driver);
//		System.out.println(innerText);
//		
  //  JH.scrollIntoView(_wilkiElement, driver);
	}

}
