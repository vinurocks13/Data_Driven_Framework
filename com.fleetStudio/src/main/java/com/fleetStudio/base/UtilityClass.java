package com.fleetStudio.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass extends BrowserFactory {
	protected static Properties prop;
	protected static FileInputStream propFile;
	private static String propFilePath = System.getProperty("user.dir")+"/data.properties";
	
	
	public static String getPropertyValueByKey(String key) throws Exception {
		//load data from properties file
		propFile = new FileInputStream(propFilePath);
		prop = new Properties();
		prop.load(propFile);
		
		//read data
		String value = prop.get(key).toString();
		
		// using stringutils from apache lang3 to check for null or spaces in the string check
		if(StringUtils.isEmpty(value)) {
			throw new Exception("Value is not specified for the key "+ key + " in Properties file.");
		}
		return value;
	}
	
	/*
	 * Maximizing the browser window
	 */
	public static void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

//	public static int waitUntilCondition(WebDriver driver, timeOut) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
//		try {
//			wait.wait(timeOut);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		return timeOut;
//	}

	public static String getCurrentDate() {
		//formatting date in ddmmyyyy hhmmss format
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		//get current date
		Date date = new Date();
		String actualDate = dateFormat.format(date);
		return actualDate;
	}
	
	public static File failedCaseScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/SS"+getCurrentDate()+".jpeg";
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	
	public static void closeDriverInstance(WebDriver driver, int timeOut) {
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
