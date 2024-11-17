package readtestdata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public Object[][] readExcelData(String filePath, String sheetName) throws IOException {
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude header row

        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            data[i - 1][j] = cell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = cell.getBooleanCellValue();
                            break;
                        default:
                            data[i - 1][j] = "Unknown Cell Type";
                    }
                }
            }
        }
        workbook.close();
        return data;
	}
	
	public static void main(String[] args) throws IOException {
		
		String excelFilePath = "D:\\VISHAL\\eclipse-workspace\\selenium-automation\\src\\main\\java\\readtestdata\\TestDataFile.xlsx"; // Provide the path to your Excel file
        String sheetName = "TestDataSheet"; // Provide the sheet name
        Object[][] data = new ReadExcelFile().readExcelData(excelFilePath, sheetName);
        
        for (Object[] row : data) {
            for (Object element : row) {
                System.out.print("|"+ element + "\t"); // Print each element with a tab separator
            }
            System.out.println(); // Newline after each row
        }
	}
}
