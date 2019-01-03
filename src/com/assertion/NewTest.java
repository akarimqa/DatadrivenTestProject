package com.assertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewTest {
	
WebDriver driver;
  @Test(priority=1)
  public void assertExampleTest() {
	  //Assert.assertEquals(true, false);
	  SoftAssert softAssert=new SoftAssert();
	  
	 System.out.println("Running part1 of assertExampleTes"); 
	 Assert.assertEquals(true, true);
	 
	 System.out.println("Running part2 of assertExampleTest");
	 softAssert.assertEquals(true, false);
	 
	 System.out.println("Running part3 of assertExampleTes");
	 softAssert.assertEquals(true, false);
	 
	 softAssert.assertAll();
	  
  }
  @BeforeTest
  public void setup() {
		 System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://www.google.com/");
  }
		 

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
