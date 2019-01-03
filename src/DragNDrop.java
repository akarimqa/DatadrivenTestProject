import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 //driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://jqueryui.com/droppable/");
		
		
//driver.get("http://jqueryui.com/droppable/");
		
//		driver.switchTo().frame(0);//switch to frame if its present
//		
//		Actions action = new Actions(driver);
//		
//		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
//		.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']")))
//		.release()
//		.build()
//		.perform();
		
		List<WebElement>list=driver.findElements(By.xpath("//iframe"));
		
		
		driver.switchTo().frame(0);
		
		Actions action=new Actions(driver);
		WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
		action.clickAndHold(draggable).moveToElement(target).release().build().perform();
		
		Thread.sleep(3000);
		
		driver.close();
	
	}

}
