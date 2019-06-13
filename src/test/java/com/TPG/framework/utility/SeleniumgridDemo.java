package com.TPG.framework.utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumgridDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("-incognito");
		options.addArguments("chrome.switches","--disable-extensions");
		
		options.merge(cap);
		String hubUrl = "http://192.168.1.7:4444/wd/hub";
		WebDriver driver = null;
		try {
			 driver = new RemoteWebDriver(new URL(hubUrl),options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("https://google.com.au");
		System.out.println(driver.getTitle());
		driver.close();
		

	}

}
