package com.fleetStudio.base;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {
	String filePath;
	Sheet sh;

	public ExcelOperations(String sheetname) {
		try {
			filePath = System.getProperty("user.dir") + UtilityClass.getPropertyValueByKey("testDataLocation");
		} catch (Exception e) {
			e.printStackTrace();
		}

		File testDataFile = new File(filePath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(testDataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

	sh=wb.getSheet(sheetname);

	}

	public HashMap<String, String> getDataInMap(int rowNum) throws Exception {
		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}
		return hm;
	}

	public int getRowCount() {
		return sh.getLastRowNum();
	}

	public int getCellCount() {
		return sh.getRow(0).getLastCellNum();
	}

}
