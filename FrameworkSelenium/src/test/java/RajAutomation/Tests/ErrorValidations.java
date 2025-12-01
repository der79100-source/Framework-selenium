package RajAutomation.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import RajAutomation.Testcomponents.BaseTest;

//import RajAutomation.Testcomponents.BaseTest;

public class ErrorValidations extends BaseTest {
	
	@Test
	public void errororder()
	{
		String cartpro = "ADIDAS ORIGINAL";
		landingpage.loginapplication("sample.users@abc.com", "20Autumssn@25#");
		Assert.assertEquals("Incorrect email or password.", landingpage.geterrormessage());
		
		
	}

}
