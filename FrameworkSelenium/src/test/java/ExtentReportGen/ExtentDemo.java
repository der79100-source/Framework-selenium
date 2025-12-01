package ExtentReportGen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentDemo {
	
	ExtentReports extent;
	@BeforeTest
	public void configuration()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Raj");
	}
	
	@Test
	public void demometh()
	{
		ExtentTest test = extent.createTest("Demo method");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Test case failed");
		extent.flush();
	}
	
	@Test
	public void wikip() 
	{
		ExtentTest tes = extent.createTest("Wiki method");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		System.out.println(driver.getTitle());
		driver.quit();
		extent.flush();
		
	}
	

}
