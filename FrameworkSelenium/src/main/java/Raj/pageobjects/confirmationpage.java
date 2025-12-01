package Raj.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponentforpages.AbstractComponents;

public class confirmationpage extends AbstractComponents{

	WebDriver driver;
	public confirmationpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".action__submit")
	WebElement submitorder;
	
	//driver.findElement(By.cssSelector(".hero-primary")).getText();
		@FindBy(css=".hero-primary")
		WebElement statusfinale;
		
		public String verifyconfirmationpage()
		{
			submitorder.click();
			return statusfinale.getText();
		}
	
	
	
	
	
	
	

}
