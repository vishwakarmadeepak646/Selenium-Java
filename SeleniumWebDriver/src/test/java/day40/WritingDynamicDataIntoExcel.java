package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\DynamicFile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("DynamicData");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter no of rows : ");
		int totalRows = sc.nextInt();
		System.out.println("Enter no of cells : ");
		int totalCells = sc.nextInt();

		System.out.println("Now add data :");
		for (int r = 0; r <= totalRows; r++) {

			XSSFRow row = sheet.createRow(r);

			for (int c = 0; c < totalCells; c++) {

				row.createCell(c).setCellValue(sc.next());
			}
		}
		System.out.println("File Created ....");
		workbook.write(file); // attach file to workbook
		workbook.close();
		file.close();
		
		
		
	}
}
