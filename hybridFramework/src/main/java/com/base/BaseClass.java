package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertiesUtilities;

public class BaseClass {
	//common code
	public static WebDriver driver;
	public static Logger log=Logger.getLogger("BaseClass");
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	public static  void intialisation(){
		String browser=PropertiesUtilities.readproperty("browser");
		System.out.println("intialising browser");
		log.info("intialising browser");//console file with date and time

		if(browser .equals("chrome")){
				 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				 driver=new ChromeDriver();
				 
			}
			if(browser.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
				 driver=new FirefoxDriver();
				 
			}
			driver.manage().window().maximize();
			driver.get(PropertiesUtilities.readproperty("url"));
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
	public void reportinit(){
		report=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
	}
	
		
	}
		
	 
	


