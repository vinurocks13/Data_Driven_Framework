package com.fleetStudio.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fleetStudio.commonMethods.ObjectRepo;

public class BrowserFactory extends ObjectRepo {
	public static WebDriver driver;

	@BeforeMethod
	public void browserInitiate() throws Exception {

		String browser = UtilityClass.getPropertyValueByKey("browser");
		String url = UtilityClass.getPropertyValueByKey("url");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\ingal\\AppData\\Local\\Chromium\\Application\\chrome.exe");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {

		} else
			System.out.println("Incorrect browser parameter. Failed to initiate browser instance.");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(url);
		UtilityClass.maximize(driver);
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		UtilityClass.closeDriverInstance(driver, 3000);
	}
}
