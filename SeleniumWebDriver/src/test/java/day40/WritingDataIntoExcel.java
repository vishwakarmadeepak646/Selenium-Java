package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\MyFile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("DataSheet");
		
		XSSFRow row = sheet.createRow(0);
			row.createCell(0).setCellValue("Java");
			row.createCell(1).setCellValue("01-01-1998");
			row.createCell(2).setCellValue("Selenium");
			
			XSSFRow row1 = sheet.createRow(1);
			row1.createCell(0).setCellValue("Python");
			row1.createCell(1).setCellValue("01-01-1999");
			row1.createCell(2).setCellValue("PlayWrite");
			
			XSSFRow row2 = sheet.createRow(2);
			row2.createCell(0).setCellValue("Ruby");
			row2.createCell(1).setCellValue("01-01-2000");
			row2.createCell(2).setCellValue("New Lang");
			
			workbook.write(file); // attaching workbook to the file
			
			workbook.close();
			file.close();
			System.out.println("File is created...");
	}
}
