package Raj.pageobjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import Abstractcomponentforpages.AbstractComponents;

public class Productcatalogue extends AbstractComponents {
	WebDriver driver;
	public Productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".mb-3")
	List <WebElement> p1;
	@FindBy(css=".ng-animating")
	WebElement spin;
	@FindBy(css="[routerlink*=cart]")
	WebElement cartadded;
	@FindBy(css=".cartSection h3")
	List<WebElement> selecteditem;
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
	
	By prodlist = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toaster = By.cssSelector("#toast-container");
	
	public List<WebElement> getproductlist()
	{
		waitforelement(prodlist);
		return p1;
	}
	public WebElement getproductbyname(String productname)
	{
		WebElement prod = getproductlist().stream().filter(s->
		s.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;	
	}
	public void addproducttocart(String productname) 
	{
		WebElement prd = getproductbyname(productname);
		prd.findElement(addtocart).click();
		waitforelement(toaster);
		waitforelementdisapper(spin);
		//waitforelement(toaster);
		cartadded.click();
	}
	public Boolean navigatetocartandvalidate(String cartpro) 
	{
		Boolean match = selecteditem.stream().anyMatch(s->s.getText().equalsIgnoreCase(cartpro));
		return match;
	}
	public checkoutpage selectcountry(String country) {
		// TODO Auto-generated method stub
		return new checkoutpage(driver);
	}
	public checkoutpage submitorders() throws Exception
	{
		Thread.sleep(2000);
		checkout.click();
		return new checkoutpage(driver);
	}

	
	

}