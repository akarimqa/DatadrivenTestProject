import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "/Users/ahmadkarim/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("http://www.google.com");

		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src,
		new File("/Users/ahmadkarim/Documents/eclipse/TestngProject/src/ScreenShot/" + dateToName() + ".png"));
		driver.quit();
	}
	
	public static String dateToName() {
		Date nowTime = new Date();
		SimpleDateFormat obj = new SimpleDateFormat();
		String time = obj.format(nowTime);
		String time1 = (time.replace(" ", "")).replace(",", "/");
		return time1;
	}

}
