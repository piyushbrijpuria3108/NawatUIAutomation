package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	// Method to read all data from a specific column (using column number)
	public static List<String> readColumnData(String filePath, int colNum) throws IOException {
		List<String> columnData = new ArrayList<>();
		FileInputStream fis = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);

		// Iterate over all rows in the sheet
		for (Row row : sheet) {
			Cell cell = row.getCell(colNum);
			if (cell != null) {
				columnData.add(cell.getStringCellValue());
			}
		}
		workbook.close();
		return columnData;
	}

	// Method to read all data from a specific row (using row number)
	public static List<String> readRowData(String filePath, int rowNum) throws IOException {
		List<String> rowData = new ArrayList<>();
		FileInputStream fis = new FileInputStream(new File(filePath));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);

		Row row = sheet.getRow(rowNum);
		if (row != null) {
			// Iterate through all cells in the row
			for (Cell cell : row) {
				rowData.add(cell.getStringCellValue());
			}
		}
		workbook.close();
		return rowData;
	}
}