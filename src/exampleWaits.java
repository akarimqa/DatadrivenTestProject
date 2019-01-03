import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exampleWaits {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//DYNAMIC WAIT---->pageLoadTimeout
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//STATIC WAIT-->Thead.sleep
		Thread.sleep(2000);
		driver.get("https://www.facebook.com/");
		//DYNAMIC WAIT---->implicitlyWait
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		WebElement userName=driver.findElement(By.xpath("//input[@name='email']"));
		WebElement passWord=driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement logIn=driver.findElement(By.xpath("//label[@id='loginbutton']"));
		userName.sendKeys("karim");
		passWord.sendKeys("12345");
		//DYNAMIC WAIT---->ExplicitlyWait Calling
		clickOnExplicitMethod(driver,logIn,20);
		driver.quit();
		
	}
	//DYNAMIC WAIT---->ExplicitlyWait Method
	public static void clickOnExplicitMethod(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
//	public static void explicitlyWait(WebDriver driver, WebElement locator, int timeout) {
//		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
//		
//	}
//public static void explicitWaitMethod(WebDriver driver, WebElement locator, int timeout) {
//	new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
//	locator.click();	
//}

}
