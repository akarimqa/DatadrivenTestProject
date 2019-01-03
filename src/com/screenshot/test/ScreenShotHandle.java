package com.screenshot.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotHandle {
static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com");
		takeScreenshot("pix1");
		driver.close();
	}
	public static void takeScreenshot(String fileName) throws IOException {
		//File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.File);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("/Users/ahmadkarim/Documents/eclipse/"
				+ "TestngProject/src/ScreenShot/"+fileName+".jpg"));
	}

}
