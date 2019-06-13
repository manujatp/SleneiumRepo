package com.TPG.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TPG.framework.base.TestBase;
import com.TPG.framework.pageobjects.MyAccountHomePage;
import com.TPG.framework.pageobjects.MyAccountLoginPage;
import com.TPG.framework.pageobjects.PostOfficeHomePage;
import com.TPG.framework.pageobjects.PostOfficeLoginPage;
import com.TPG.framework.pageobjects.TPGHomePage;

public class TPGTestIT extends TestBase {
	
	@Test(groups={"TPGMyAccountgrp"}, dataProvider="logindata")
	public void loginToMyAccount(String userID,String pwd){
		_report = _startReport.startTest("TPGTest");
		TPGHomePage _tpgHome = new TPGHomePage(driver, _report);
		_tpgHome.clickMyAccountLink();
		MyAccountLoginPage _myaccountLogin = new MyAccountLoginPage(driver, _report);
		_myaccountLogin.setUserIDElement(userID);
		_myaccountLogin.setPasswordElement(pwd);
		_myaccountLogin.clickSignInButton();
		MyAccountHomePage _myaccountHome = new MyAccountHomePage(driver, _report);
		_myaccountHome.clickLogoutButtonElement();
	}

	@Test(groups={"TPGPostOfficegrp"}, dataProvider="logindata")
	public void loginToPostOffice(String userID,String pwd){
		_report = _startReport.startTest("TPGTest");
		TPGHomePage _tpgHome = new TPGHomePage(driver, _report);
		_tpgHome.clickPostOffice();
		PostOfficeLoginPage _postofficeLogin = new PostOfficeLoginPage(driver, _report);
		_postofficeLogin.setUserIDElement(userID);
		_postofficeLogin.setPasswordElement(pwd);
		_postofficeLogin.clickSignInButton();
		PostOfficeHomePage _postofficeHome = new PostOfficeHomePage(driver, _report);
		_postofficeHome.clickSignOutButton();
	}
	
	@DataProvider(name="logindata")
	public Object[][] getDataFromExternalExcel() throws Exception{
		return fetchData("TestDataLogin.xlsx");
	}
}
