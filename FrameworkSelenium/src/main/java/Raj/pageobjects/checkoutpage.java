package Raj.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Abstractcomponentforpages.AbstractComponents;

public class checkoutpage extends AbstractComponents{

	WebDriver driver;
	public checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
		@FindBy(css="[placeholder='Select Country']")
		WebElement choosecount;
		
		@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
		WebElement selectiondrop;
	
		@FindBy(css=".action__submit")
		WebElement submitorder;
		
		@FindBy(css=".hero-primary")
		WebElement statusfinale;
		
		public confirmationpage selectcountry(String country) throws Exception
		{
			Actions a = new Actions(driver);
			a.sendKeys(choosecount, country).build().perform();
			selectiondrop.click();
			return new confirmationpage(driver);
			
		}
		
		
		
		
		
		
		
		

}
