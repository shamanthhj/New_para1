package com.framework.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public static String getCellData(String sheetName, int rowNum, int colNum) {
		String value = "";
		try {
			FileInputStream fis = new FileInputStream("test-data/TestData.xlsx");
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(colNum);
			
			DataFormatter formatter = new DataFormatter();
			value = formatter.formatCellValue(cell);
			workbook.close();
		}catch (IOException e){
			System.out.println("Failed to read Excel file: " + e.getMessage());
		}
		
		return value;
	}

}
