package RajAutomation.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Raj.pageobjects.Landingpage;
import Raj.pageobjects.Productcatalogue;
import Raj.pageobjects.checkoutpage;
import Raj.pageobjects.confirmationpage;
import RajAutomation.Testcomponents.BaseTest;

public class Standalone extends BaseTest{

		@Test(dataProvider="getData")
		public void standalone(HashMap<String, String> input) throws Exception 
		{
		WebDriver driver = new ChromeDriver();
		//mail -  sample.users@abc.com | phone - 8456971582 | password - 20Autumn@25#
		//String cartpro = "ADIDAS ORIGINAL";
		String country = "India";
		Productcatalogue prodcat = landingpage.loginapplication(input.get("email"), input.get("password"));
		List<WebElement> products = prodcat.getproductlist();
		prodcat.addproducttocart(input.get("cartpro"));
		Boolean match = prodcat.navigatetocartandvalidate(input.get("cartpro"));
		Assert.assertTrue(match);
		checkoutpage checkp = prodcat.submitorders();
		confirmationpage confirmpge = checkp.selectcountry(country);
		String validationmessage = confirmpge.verifyconfirmationpage();
		Assert.assertTrue(validationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
		
		@DataProvider
		public Object[][] getData() throws Exception
		{
			List<HashMap<String,String>> data = getJsonDataToMap("C:\\Users\\Appadurai\\eclipse-workspace\\FrameworkSelenium\\src\\test\\java\\Raj\\data\\purchaseorder.json");
			return new Object[][] {{data.get(0)}, {data.get(1)}};
		}
		
//		public String getscreenshot(String testcasename) throws Exception 
//		{
//			TakesScreenshot ts = (TakesScreenshot)driver;
//			File Source = ts.getScreenshotAs(OutputType.FILE);
//			File fs = new File(System.getProperty("user.dir")+ "//reports//" + testcasename + ".png");
//			FileUtils.copyFile(Source, fs);
//			return System.getProperty("user.dir")+ "//reports//" + testcasename + ".png";
//		}
//		
//		@DataProvider
//		public Object[][] getData()
//		{
//			return new Object[][] {{"sample.users@abc.com", "20Autumn@25#", "ADIDAS ORIGINAL"}, {"sample.users@abc.com", "20Autumn@25#", "ADIDAS ORIGINAL"}};
//			HashMap<String, String> map = new HashMap<String, String>();
//			map.put("email", "sample.users@abc.com");
//			map.put("password", "20Autumn@25#");
//			map.put("cartpro", "ADIDAS ORIGINAL");
//		}
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "sample.users@abc.com");
//		map.put("password", "20Autumn@25#");
//		map.put("cartpro", "ADIDAS ORIGINAL");
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "sample.users@abc.com");
//		map1.put("password", "20Autumn@25#");
//		map1.put("cartpro", "ADIDAS ORIGINAL");
		
		
		
		
		
		
		

}
