import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class DropDown {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");	//enter url
			//String handleName=driver.getWindowHandle();
		 
//		 Alert alert=driver.switchTo().alert();
//		 alert.accept();
//		 WebElement target1=driver.findElement(By.id(" "));
//		 WebElement target=driver.findElement(By.id(" "));
//		 
//		 Actions action=new Actions(driver);
//		 action.moveToElement(target).build().perform();
//		 action.clickAndHold(target).moveToElement(target1).build().perform();
		 
		 JavaScriptExecutor js= ((JavaScriptExecutor)driver);
		 js.executeScript("document.getElementById('some id').value='someValue';");
		 js.executeScript("document.getElementById('Email').value='SoftwareTestingMaterial.com';");
		 
			//handle drop box:
			Select select = new Select(driver.findElement(By.id("state")));
			select.selectByVisibleText("California");
			//System.out.println(handleName);
			
	}

}
