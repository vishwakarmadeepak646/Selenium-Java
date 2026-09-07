package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws Exception {
		
	//	Excel File --- >Workbook --- >Sheets --- >Rows ---- Cells
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\TestData.xlsx"); // open the file in reading mode
		
		// Extract the workbook
		XSSFWorkbook  workbook = new XSSFWorkbook(file); 
		
		// get the sheet inside workbook and store it in sheet
		XSSFSheet sheet =  workbook.getSheet("sheet1"); // 	XSSFSheet sheet = workbook.getSheetAt(0);  // two ways to get sheet
		
		int totalRows  = sheet.getLastRowNum();  // last row means total no of rows
		int	totalColumn	=  sheet.getRow(1).getLastCellNum(); // from any first row finding No. of column
		
		System.out.println("Number of Rows : " + totalRows);// 5
		System.out.println("Number of Rows : " + totalColumn); //4
		
		for (int  rows= 0;  rows<= totalRows ; rows++) {
			
		   XSSFRow currentRow = sheet.getRow(rows);
			
			for (int cell = 0; cell < totalColumn; cell++) {
				
			XSSFCell cellData =	currentRow.getCell(cell);
		
			System.out.print(cellData.toString()+ "\t");
			
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
	}
}
