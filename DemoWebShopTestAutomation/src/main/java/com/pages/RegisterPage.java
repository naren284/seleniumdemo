package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.ExcelFunctionsUtility;

public class RegisterPage {
	WebDriver driver;
	@FindBy(how = How.ID,using = "gender-male")
	static
	WebElement gender;
	@FindBy(how = How.ID,using = "FirstName")
	static
	WebElement fname;
	@FindBy(how = How.ID,using = "LastName")
	static
	WebElement lname;
	@FindBy(how = How.ID,using = "Email")
	static
	WebElement email;
	@FindBy(how = How.ID,using = "Password")
	static
	WebElement password;
	@FindBy(how = How.ID,using = "ConfirmPassword")
	static
	WebElement confirmPassword;
	@FindBy(how = How.ID,using = "register-button")
	static WebElement registerButton;
	@FindBy(how = How.LINK_TEXT,using = "Register")
	static
	WebElement registerLink;
	

	
	public void clickRegister()
	{
		
	}
	public RegisterPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public static void clickRegister(String excelgender, String firstname,String lastname, String excelemail,String excelpassword,String excelconfirmpassword)
	{
	registerLink.click();	
	gender.click();
	fname.sendKeys(firstname);
	lname.sendKeys(lastname);
	email.sendKeys(excelemail);
	password.sendKeys(excelpassword);
	confirmPassword.sendKeys(excelconfirmpassword);
	registerButton.click();

	}
	public String registrationlinke()
	{
	
	return driver.getTitle();
	}


	
	


	

}


