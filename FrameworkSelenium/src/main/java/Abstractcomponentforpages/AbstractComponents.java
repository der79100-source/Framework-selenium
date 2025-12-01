package Abstractcomponentforpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	public void waitforelement(By findby)
	{
	WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(5));
	wa.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforerrormessage(WebElement findby)
	{
	WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(10));
	wa.until(ExpectedConditions.visibilityOf(findby));
	}
	
	
	//w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	public void waitforelementdisapper(WebElement dry)
	{
		WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(5));
		wa.until(ExpectedConditions.invisibilityOf(dry));
	}
	
	

}
