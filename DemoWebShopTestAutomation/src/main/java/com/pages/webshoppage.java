package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class webshoppage {
	WebDriver driver;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT,using = "Electronics")
	WebElement electronics;
	@FindBy(how = How.PARTIAL_LINK_TEXT,using = "Cell phones")
	WebElement loginLink;
	@FindBy(how = How.XPATH,using = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")
	WebElement firstproduct;
	@FindBy(how = How.XPATH,using ="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[3]/div[2]/input")
	WebElement secondproduct;
	
	/**
	 * This Function returns the title of the Register Page
	 * @return String
	 */

	public webshoppage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
}