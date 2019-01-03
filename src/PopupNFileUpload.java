import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PopupNFileUpload {
	WebDriver driver;
//	System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
//	  driver=new ChromeDriver();
//	File file((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 @BeforeMethod
		 public void setup() {
		 System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		  driver=new ChromeDriver();
		// driver=new SafariDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 
		 
		 }
		 
	  
	
	
	
 @Test(priority=1)
 public void rediffPopupTest() throws InterruptedException {
	 driver.findElement(By.name("proceed")).click();
	 Thread.sleep(5000);
	 Alert alert=driver.switchTo().alert();
	 System.out.println(alert.getText());
	 //String alertMessage=alert.getText();
	 alert.accept(); 
	
 }
 
 @Test(priority=2)
 public void fileUploadTest() throws InterruptedException {
	 driver.get("http://html.com/input-type-file/");
	 Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("/Users/ahmadkarim/Desktop/Game.docx");
		
		
 }
 



 @AfterMethod
 public void tearDown() {
	  driver.quit();
 }


}
