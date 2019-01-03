package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTest {
	

	WebDriver driver;
	
	
	 @BeforeMethod
		 public void setup() {
		 System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://portal.discover.com/customersvcs/universalLogin/ac_main");
		 
			 
		 }
		 
	  
	 @DataProvider
		public Object[][] testData(){
			 
				Object [][] data=new Object[][]{{"Selenium"},{"QTP"},{"RFT"},{"UFT"},{"SQL"}};
			return data;
		}
	

 
 
 
 @Test(dataProvider="testData", priority=1)
 public void discoverLoginTest(String data) {
	 
	 driver.findElement(By.xpath("//input[@name=\"userID\" and @id=\"userid-content\"]")).clear();
	 driver.findElement(By.xpath("//input[@name=\"userID\" and @id=\"userid-content\"]")).sendKeys(data);
	 
	 driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"password-content\"]")).clear();
	 driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"password-content\"]")).sendKeys(data);
	 
 }
 


 @AfterMethod
 public void tearDown() {
	  driver.quit();
 }
	//=============
	
	
//@Test(dataProvider="testData")	
//public void dataProviderSearchTest(String data) {
//	
//	System.out.println(data);
//	
//}

}
