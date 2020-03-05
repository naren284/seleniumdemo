package com.tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pages.RegisterPage;
import com.pages.webshoppage;
import com.utility.DriverUtility;
import com.utility.ExcelFunctionsUtility;
import com.pages.Login;


public class DemoWebshopTest{
WebDriver driver;
webshoppage welcomePage;
Login loginPage;
RegisterPage registerPage;
ExtentHtmlReporter htmlreporter;
ExtentReports reports;
ExtentTest tests;
Class<DriverUtility> driversetup;
static String email=null;
static String password =null;
@BeforeTest
@Parameters({"browser"})
public void beforetest(String browserValue) {
	System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
	SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss-ms");
	String filepath=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
	driver=new ChromeDriver();
	htmlreporter=new ExtentHtmlReporter(filepath);
	reports=new ExtentReports();
	reports.attachReporter(htmlreporter);
	
	htmlreporter.config().setReportName("H&PS");
	htmlreporter.config().setDocumentTitle("My Custom Report");
	htmlreporter.config().setTheme(Theme.DARK);
	
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

welcomePage=PageFactory.initElements(driver, webshoppage.class);
loginPage=PageFactory.initElements(driver, Login.class);
registerPage=PageFactory.initElements(driver, RegisterPage.class);

}

/*@BeforeTest
public void beforeTest()
{
driver=new ChromeDriver();
driver.get("http://demowebshop.tricentis.com/");
driver.manage().window().maximize();
welcomePage=PageFactory.initElements(driver, webshoppage.class);
loginPage=PageFactory.initElements(driver, Login.class);
registerPage=PageFactory.initElements(driver, RegisterPage.class);

}*/


@AfterTest
public void afterTest()
{
driver.close();
welcomePage=null;
loginPage=null;
registerPage=null;


}

@Test(priority = 1, dataProvider = "dp1")
public void testRegisterLink(String excelgender, String firstname,String lastname, String excelemail,String excelpassword,String excelconfirmpassword) {

RegisterPage.clickRegister(excelgender, firstname, lastname, excelemail, excelpassword, excelconfirmpassword);
email=excelemail;
password=excelpassword;
ExcelFunctionsUtility.writeExcel(email, password);
}


@Test(priority = 2, dataProvider = "dp2")
public void testLoginLink(String excelemail, String excelpassword)
{
loginPage.loginButtonClick(excelemail, excelpassword);
}
/*@Test(priority = 3)
public void testLoginButton()
{
loginPage.loginButtonClick(null, null);
}*/

@DataProvider(name="dp1")
public Object[][] data() {
return ExcelFunctionsUtility.readDataFromExcelforRegistration();
}

@DataProvider(name="dp2")
public Object[][] data1() {
return ExcelFunctionsUtility.UserLogin();
}

}