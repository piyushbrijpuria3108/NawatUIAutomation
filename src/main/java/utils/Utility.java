package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utility {

	WebDriver driver;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	// Random Number Generation Methods
	public static String generateRandomNumber(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	public static String generateRandomPhoneNumber() {
		return "1" + generateRandomNumber(10); // US format: 1XXXXXXXXXX
	}

	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}

	public static String generateRandomEmail() {
		return "test_" + generateRandomNumber(6) + "@example.com";
	}

	// Excel Reading Methods
	public static Object[][] readExcelData(String filePath, String sheetName) {
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[rowCount][colCount];

			for (int i = 1; i <= rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = getCellValue(cell);
				}
			}
			return data;

		} catch (IOException e) {
			throw new RuntimeException("Failed to read Excel file: " + e.getMessage());
		}
	}

	public static Map<String, String> readExcelRowAsMap(String filePath, String sheetName, int rowNum) {
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			Row dataRow = sheet.getRow(rowNum);

			Map<String, String> rowData = new HashMap<>();

			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				String header = headerRow.getCell(i).getStringCellValue();
				String value = getCellValue(dataRow.getCell(i)).toString();
				rowData.put(header, value);
			}
			return rowData;

		} catch (IOException e) {
			throw new RuntimeException("Failed to read Excel file: " + e.getMessage());
		}
	}

	private static Object getCellValue(Cell cell) {
		if (cell == null) {
			return "";
		}

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			}
			return String.valueOf((long) cell.getNumericCellValue());
		case BOOLEAN:
			return cell.getBooleanCellValue();
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}
	}

	// Random String Generation
	private static final String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String generateRandomString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(ALPHA_NUMERIC.length());
			sb.append(ALPHA_NUMERIC.charAt(index));
		}
		return sb.toString();
	}

	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);"); // Scroll down by 500 pixels
		System.out.println("Scrolled down the page by 500 pixels.");
	}
}
