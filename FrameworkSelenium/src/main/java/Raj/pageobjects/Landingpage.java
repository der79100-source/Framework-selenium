package Raj.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponentforpages.AbstractComponents;

public class Landingpage extends AbstractComponents {
	WebDriver driver;
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement username;
	@FindBy(id="userPassword")
	WebElement passworde;
	@FindBy(id="login")
	WebElement submits;
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	public Productcatalogue loginapplication(String email,String password)
	{
		username.sendKeys(email);
		passworde.sendKeys(password);
		submits.click();
		return new Productcatalogue(driver);
	}
	public void goTo() 
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public WebElement geterrormessage()
	{
		waitforerrormessage(errormsg);
		errormsg.getText();
		return errormsg;
	}
	

}
