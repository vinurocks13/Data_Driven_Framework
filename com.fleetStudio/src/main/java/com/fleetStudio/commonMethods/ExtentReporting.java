package com.fleetStudio.commonMethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fleetStudio.base.BrowserFactory;
import com.fleetStudio.base.UtilityClass;

public class ExtentReporting extends BrowserFactory {
	public static ExtentReports setupExtentReport() {
		
		String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+ UtilityClass.getCurrentDate()+ ".html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("Execution Report");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Test Report for fleetStudio");
		
		return extent;
	}
}
