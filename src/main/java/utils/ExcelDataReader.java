package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class ExcelDataReader {
		
	public static String readSingleRowData(String filePath, int sheetIndex, int colNum, int rowIndex) throws IOException {
	    FileInputStream fis = new FileInputStream(filePath);
	    Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheetAt(sheetIndex); // Read specified sheet
 
	    String data = ""; // Default empty value
 
	    Row row = sheet.getRow(rowIndex);
	    if (row != null) {
	        Cell cell = row.getCell(colNum);
	        data = (cell != null) ? cell.toString().trim() : ""; // Trim to avoid extra spaces
	    }
 
	    workbook.close();
	    fis.close();
	    return data;
	}
	}

//public static List<String[]> readExcelData(String filePath) throws IOException {
//FileInputStream fis = new FileInputStream(filePath);
//Workbook workbook = new XSSFWorkbook(fis);
//Sheet sheet = workbook.getSheetAt(1); // Read the first sheet
//
//List<String[]> data = new ArrayList<>();
//
//for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header row
//	Row row = sheet.getRow(i);
//	if (row != null) {
//		String[] rowData = new String[row.getLastCellNum()];
//		for (int j = 0; j < row.getLastCellNum(); j++) {
//			Cell cell = row.getCell(j);
//			rowData[j] = cell != null ? cell.toString() : "";
//		}
//		data.add(rowData);
//	}
//}
//workbook.close();
//fis.close();
//return data;
//}
