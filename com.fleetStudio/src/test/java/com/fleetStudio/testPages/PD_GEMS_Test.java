package com.fleetStudio.testPages;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fleetStudio.base.BrowserFactory;
import com.fleetStudio.base.ExcelOperations;

public class PD_GEMS_Test extends BrowserFactory {

	ExcelOperations excel = new ExcelOperations("");

	// DataProvider method
	@DataProvider (name = "data")
	public Object[][] testDataSupplier() throws Exception {
		// array of 3 and 1: 3 for sets of data (as in tutorial 3) and 1 for columns
		// getting from hashmap
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData = excel.getDataInMap(i);
			/*
			 * obj[row][col] Obj index starts from 1, and we want from 0 row so i-1 Array
			 * indexing starts from 0 therefore column has 0 instead of 1
			 */
			obj[i - 1][0] = testData;
		}
		return obj;
	}

	@Test (dataProvider = "data")
	public void GEM_Test() {
		pdGems.verifyHeading();
		test.log(Status.PASS, "Heading verified");
		Assert.assertEquals(pdGems.actualProductDevTxt, pdGems.productDevTxt,
				"Product Dev heading verification failed.");
	}

	@Test
	public void GEM_Test1() {
		pdGems.verifyHeading();
		test.log(Status.PASS, "Heading verified");
		Assert.fail("Failed intentionally");
	}
}
