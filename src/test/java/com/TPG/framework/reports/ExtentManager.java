package com.TPG.framework.reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static ExtentReports extent;
	public static String _reportFileName;
	
	public static ExtentReports getInstance(){
		
		String curDir = System.getProperty("user.dir");
		String repPath = "/reports/test_report.html";
		_reportFileName = curDir + repPath;
		
		if(extent == null)
			extent = new ExtentReports(_reportFileName);
		return extent;
	}

}
