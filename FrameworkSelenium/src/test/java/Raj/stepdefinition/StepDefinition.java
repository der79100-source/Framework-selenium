package Raj.stepdefinition;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Raj.pageobjects.Landingpage;
import Raj.pageobjects.Productcatalogue;
import Raj.pageobjects.checkoutpage;
import Raj.pageobjects.confirmationpage;
import RajAutomation.Testcomponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest{

	public Landingpage landingpage;
	public Productcatalogue prodcat;
	public List<WebElement> products;
	public checkoutpage checkp;
	public Boolean match;
	public String validationmessage;
	public confirmationpage confirmpge;
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws Exception
	{
		landingpage = launchapplication();
	}
	
	@Given("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String username, String password)
	{
		prodcat = landingpage.loginapplication(username,password);
	}
	
	@When("^I add the Product (.+) from cart$")
	public void I_add_the_Product_from_cart(String productname) 
	{
		products = prodcat.getproductlist();
		prodcat.addproducttocart(productname);
	}
	
	@When("^checkout (.+) and submit order$")
	public void checkout_and_submit_order(String productname) throws Exception
	{
		match = prodcat.navigatetocartandvalidate(productname);
		Assert.assertTrue(match);
		checkp = prodcat.submitorders();
		confirmpge = checkp.selectcountry("India");
	}
	
	@Then("{string} message is diplayed")
	public void message_is_displayed(String string)
	{
		validationmessage = confirmpge.verifyconfirmationpage();
		Assert.assertTrue(validationmessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	
	
}
