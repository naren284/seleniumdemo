package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.ExcelFunctionsUtility;

public class Login {
	WebDriver driver;
	@FindBy(how = How.ID,using = "Email")
	WebElement email;
	@FindBy(how = How.ID,using = "Password")
	WebElement password;
	@FindBy(how = How.CSS,using = "input[value='Log in']")
	WebElement loginButton;
	@FindBy(how=How.LINK_TEXT,using = "Log out")
	WebElement logout;
	@FindBy(how = How.LINK_TEXT,using = "Log in")
	WebElement loginLink;
	
	@Test(dataProvider="dp2")
	public void loginButtonClick(String excelemail, String excelPassword)
	{
		loginLink.click();
	email.sendKeys(excelemail);
	password.sendKeys(excelPassword);
	loginButton.click();
	logout.click();
	 
	}
	

	public void logout()
	{
	logout.click();
	}

	

}
