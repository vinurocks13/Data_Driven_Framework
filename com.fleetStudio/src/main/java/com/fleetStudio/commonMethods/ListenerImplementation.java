package com.fleetStudio.commonMethods;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.fleetStudio.base.BrowserFactory;
import com.fleetStudio.base.UtilityClass;

public class ListenerImplementation extends BrowserFactory implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = ObjectRepo.extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		UtilityClass.failedCaseScreenshot(driver);
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		// setup method call
		ExtentReporting.setupExtentReport();

	}

	public void onFinish(ITestContext context) {
		// close extent
		ObjectRepo.extent.flush();
	}

}
