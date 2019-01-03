package com.webtable.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//it gives the total no of rows
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='customers']//tr"));
		///it gives the total no of Columns
		//List<WebElement>rows=driver.findElements(By.xpath("//table[@id='customers']//td"));
		
		System.out.println("Total no of rows is-->"+(rows.size()-1));
		String beforeXpathCompany="//*[@id='customers']/tbody/tr[";
		String afterXpathCompany="]/td[1]";
		String beforeXpathContact="//*[@id='customers']/tbody/tr[";
		String afterXpathContact="]/td[2]";
		
		for (int i=2;i<=rows.size();i++) {
			String actualXpathCompany=beforeXpathCompany+i+afterXpathCompany;
			String actualXpathContact=beforeXpathContact+i+afterXpathContact;
			
			String companyName=driver.findElement(By.xpath(actualXpathCompany)).getText();
			String contactName=driver.findElement(By.xpath(actualXpathContact)).getText();
			System.out.print(companyName);
			System.out.print("-->");
			System.out.println(contactName);
			
		}
		
		driver.close();
		
	}


}
