package RajAutomation.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Raj.pageobjects.Landingpage;

public class BaseTest {
	
	public WebDriver driver;
	public Landingpage landingpage;
	public WebDriver initializedriver() throws IOException
	{
		//Properties class		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\RajAutomation\\resources\\GlobalData.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("forefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public List<HashMap<String,String>> getJsonDataToMap(String Filepath) throws Exception
	{
		//read JSON to String
		File file = new File(Filepath);
		String Jsoncontent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		
		//String to HashMap -- uses Jackson Databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(Jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
		
		return data;
		
		//FileUtils.readFileToString(null, null)
//readFileToString(new File("C:\\Users\\Appadurai\\eclipse-workspace\\FrameworkSelenium\\src\\test\\java\\Raj\\data\\purchaseorder.json"));
	}
	
	@BeforeMethod
	public Landingpage launchapplication() throws Exception
	{
		driver = initializedriver();
		 landingpage = new Landingpage(driver);
		landingpage.goTo();
		return landingpage;
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	public String getscreenshot(String testcasename, WebDriver driver) throws Exception 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File fs = new File(System.getProperty("user.dir")+ "//reports//" + testcasename + ".png");
		FileUtils.copyFile(Source, fs);
		return System.getProperty("user.dir")+ "//reports//" + testcasename + ".png";
	}
	

}
