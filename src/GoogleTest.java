import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class GoogleTest {
	
	WebDriver driver;
	
	
	 @BeforeMethod
		 public void setup() {
		 System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://www.google.com/");
		 
			 
		 }
		 
	  
	
	
	
  @Test(priority=1)
  public void googleTittleTest() {
	 String tittle= driver.getTitle();
	 String expectedTittle="Google";
	 //System.out.println("Given Tittle is: "+tittle);
	 Assert.assertEquals(tittle, expectedTittle,"Tittle is not matched");
	 //Assert.assertEquals(actual, expected);
  }
  
 @Test(priority=2)
 public void googleLogoTest() {
	 boolean b=driver.findElement(By.xpath(".//*[@id='hplogo']")).isDisplayed();
	 Assert.assertTrue(b);
 }
 @Test(priority=3)
 public void gmailLinkTest() {
	 boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
	 Assert.assertTrue(b);
 }
 @Test(dependsOnMethods="gmailLinkTest",priority=4)
 public void searchTest() {
	 driver.findElement(By.xpath("//input[@id='lst-ib']")).clear();
	 driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("selenium");
	 driver.findElement(By.xpath(".//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul/li[11]/div/span[1]/span/input")).click();
	 //driver.findElement(By.xpath("//input[aria-label=\"Google Search\"]")).click();
 }
 @Test(priority=0)
 public void googleBrokenLinksTest() throws MalformedURLException, IOException {
	 List<WebElement>linkList=driver.findElements(By.tagName("a"));
	 linkList.addAll(driver.findElements(By.tagName("img")));
	 System.out.println("Total no of Links and Images are: "+linkList.size());
	 List<WebElement>activeLinks=new ArrayList<WebElement>();
	 for(int i=0;i<linkList.size();i++) {
		 System.out.println(linkList.get(i).getAttribute("href"));
		 if(linkList.get(i).getAttribute("href")!=null &&(!linkList.get(i).getAttribute("href").contains("javascript"))){
			 activeLinks.add(linkList.get(i));
		 }
	 }
	 System.out.println("Total No of Active Links: "+activeLinks.size());
	 for(int j=0;j<activeLinks.size();j++) {
		 HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
	     connection.connect();
	     String response =connection.getResponseMessage();
	     connection.disconnect();
		 System.out.println(activeLinks.get(j).getAttribute("href")+"--->"+response);
	 }
 }
 
 

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
