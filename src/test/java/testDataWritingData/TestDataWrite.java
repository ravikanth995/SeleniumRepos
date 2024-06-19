package testDataWritingData;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataWrite {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream("C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\SampleExcel.xlsx");
		
		XSSFWorkbook  wb =new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("Sheet1");
		
		XSSFRow row1 = sheet.createRow(0);
		   row1.createCell(0).setCellValue("22");
		   row1.createCell(1).setCellValue("Marijuana");
		   row1.createCell(2).setCellValue("Female");
		   row1.createCell(3).setCellValue("India");
		   row1.createCell(4).setCellValue("99");
		   
		   XSSFRow row2 = sheet.createRow(1);
		   row2.createCell(0).setCellValue("23");
		   row2.createCell(1).setCellValue("Ghajnni");
		   row2.createCell(2).setCellValue("Male");
		   row2.createCell(3).setCellValue("Pakistan");
		   row2.createCell(4).setCellValue("100");
		   
		   XSSFRow row3 = sheet.createRow(1);
		   row3.createCell(0).setCellValue("24");
		   row3.createCell(1).setCellValue("Osho");
		   row3.createCell(2).setCellValue("Trans");
		   row3.createCell(3).setCellValue("China");
		   row3.createCell(4).setCellValue("919");


		   
		   
		   wb.write(file);
		   wb.close();
		   file.close();
		   

	}

}
