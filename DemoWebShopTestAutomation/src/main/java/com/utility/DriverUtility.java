package com.utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pages.webshoppage;

public class DriverUtility {
	public static WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest tests;
	@BeforeTest
	@Parameters({"browser"})
	public void beforeTest(String browserValue) throws MalformedURLException
	{
		

		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss-ms");
		String filepath=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
		driver=new ChromeDriver();
		htmlReporter=new ExtentHtmlReporter(filepath);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		htmlReporter.config().setReportName("H&PS");
		htmlReporter.config().setDocumentTitle("My Custom Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		reports.setSystemInfo("Environment","TestEnv");
		reports.setSystemInfo("username","NarayananVn");
		
		
		
		if(browserValue.contentEquals("chrome")) 
		{ driver=new ChromeDriver();
		} else
			if(browserValue.contentEquals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"src/test/resources/drivers/geckodriver.exe"); driver=new FirefoxDriver(); }
			else { System.setProperty("webdriver.ie.driver",
					"src/test/resources/drivers/IEDriverServer.exe"); driver=new
					InternetExplorerDriver(); }

		/*
		 * DesiredCapabilities ds=new DesiredCapabilities();
		 * ds.setBrowserName("chrome"); ds.setPlatform(Platform.ANY); driver=new
		 * RemoteWebDriver(new URL(nodeValue), ds);
		 */
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
