package com.TPG.framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

//import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.TPG.framework.reports.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static ExtentReports _startReport = ExtentManager.getInstance();
	public static ExtentTest _report;
	Properties properties;
	static String curDir = System.getProperty("user.dir");
	String propertyPath = "src/test/java/config.properties";
	public WebDriver driver = null;
	String browserType;
	String appURL;
	
	@BeforeTest
	public void ConfigFileRead(){
		
		try {
			InputStream file = new FileInputStream(propertyPath);
			properties = new Properties();
			properties.load(file);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//initBrowser();
		
		
	}
	
	@BeforeMethod
	public void initBrowser(){
		appURL = properties.getProperty("url");
		browserType = properties.getProperty("browser");
		browserType = browserType.toLowerCase();
		switch(browserType){
		
		case "chrome"     : driver = initChromeBrowser(appURL);
						    break;
		case "ff"         : driver = initFirefoxBrowser(appURL);
						    break;
		case "ie"		  :driver =  initIEBrowser(appURL);
							break;
		case "edge"		  :driver =  initEdgeBrowser(appURL);
							break;
		default           :System.out.println("browser : " + browserType
				            + " is invalid, Launching Chrome..");
		                   driver = initChromeBrowser(appURL);
			
		}
	}
		private WebDriver initChromeBrowser(String browserType){
			System.out.println("Launching chrome browser");
			//System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("-incognito");
			options.addArguments("chrome.switches","--disable-extensions");
			driver = new ChromeDriver(options);
			System.out.println("Navigate to Url");
			driver.manage().window().maximize();
			driver.get(appURL);
			return driver;
		}
	
		private WebDriver initFirefoxBrowser(String browserType){
			System.out.println("Launching firefox browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Navigate to Url");
			driver.manage().window().maximize();
			driver.get(appURL);
			return driver;
		}
		private WebDriver initIEBrowser(String browserType){
			System.out.println("Launching ie browser");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println("Navigate to Url");
			driver.manage().window().maximize();
			driver.get(appURL);
			return driver;
		}
		
		private WebDriver initEdgeBrowser(String browserType){
			System.out.println("Launching edge browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Navigate to Url");
			driver.manage().window().maximize();
			driver.get(appURL);
			return driver;
		}
		
		protected Object[][] fetchData(String fileName) throws IOException{
			
			File file = new File("src/test/resources/data/" + fileName);
			FileInputStream fis = new FileInputStream(file);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0) ;
			wb.close();
			
			int lastRowNum = sheet.getLastRowNum();
			int lastColNum = sheet.getRow(0).getLastCellNum();
			
			Object[][] obj = new Object[lastRowNum][lastColNum];
			XSSFRow row;
			XSSFCell cell;
			for(int i=0; i<lastRowNum; i++){
				row = sheet.getRow(i+1);
				for(int j=0; j<lastColNum; j++){
					if(row==null)
						obj[i][j]="";
					else {
						 cell = row.getCell(j);
						if(cell==null)
						 obj[i][j]="";
						else												
				       obj[i][j] = cell.toString();
					}
				}
			}
			return obj;	
		}
		
		
		private static String getScreenShot(WebDriver driver,String screenShotName){
			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts =(TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = curDir + "//FailedTestsScreenshots//"+screenShotName+date+".png";
			File finalDestination = new File(destination);
			try{
				//FileUtils.copyFile(source, finalDestination);
				FileHandler.copy(source, finalDestination);
			}
			catch(IOException e){}
			 return destination;
			
		}
		
		@AfterMethod
		public void tearDown(ITestResult result){
			if(result.getStatus()==ITestResult.FAILURE){
				_report.log(LogStatus.FAIL, "Test case failed is "+ result.getName());
				_report.log(LogStatus.FAIL, "Test case failed is " + result.getThrowable());
				String screenShotPath = TestBase.getScreenShot(driver, result.getName());
				_report.log(LogStatus.FAIL, _report.addScreenCapture(screenShotPath));
			}
			else if(result.getStatus()==ITestResult.SKIP){
				_report.log(LogStatus.SKIP, "Test case skipped is " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				_report.log(LogStatus.PASS, "Test case is passed is "+result.getName());
			}
			_report.log(LogStatus.INFO, "Closing the browser");
			if(driver!= null)
			driver.close();
			
			_startReport.flush();
			_startReport.endTest(_report);;
		}
		
}
