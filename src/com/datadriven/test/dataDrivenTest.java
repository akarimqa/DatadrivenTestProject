package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testdata.TestUtil;

public class dataDrivenTest {
	
	
	
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
		 
	  
	
	
	
 @Test(priority=1)
 public void discoverTittleTest() {
	 String tittle= driver.getTitle();
	 String expectedTittle="Credit Card Login | Discover Card";
	 //System.out.println("Given Tittle is: "+tittle);
	 Assert.assertEquals(tittle, expectedTittle,"Tittle is not matched");
	 //Assert.assertEquals(actual, expected);
 }
 
 @DataProvider
 public Iterator<Object[]> getTestData() {
	ArrayList<Object[]>testData= TestUtil.getDataFromExcel();
	return testData.iterator();
	 
 }
 
 @Test(dataProvider="getTestData", priority=2)
 public void discoverLoginTest(String username, String password) {
	 driver.findElement(By.xpath("//input[@name=\"userID\" and @id=\"userid-content\"]")).clear();
	 driver.findElement(By.xpath("//input[@name=\"userID\" and @id=\"userid-content\"]")).sendKeys(username);
	 
	 driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"password-content\"]")).clear();
	 driver.findElement(By.xpath("//input[@type=\"password\" and @id=\"password-content\"]")).sendKeys(password);
	 
 }
 


 @AfterMethod
 public void tearDown() {
	  driver.quit();
 }

}
