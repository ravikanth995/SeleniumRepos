package dataWriteExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWriting {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file  = new FileOutputStream("C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\NewFile.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("Sheet1");
		
		XSSFRow row1 = sheet.createRow(0);
		   row1.createCell(0).setCellValue("First Name");
		   row1.createCell(1).setCellValue("Last Name");
		   row1.createCell(2).setCellValue("Caste");
		   row1.createCell(3).setCellValue("Religion");
		   row1.createCell(4).setCellValue("Vocation");
		   
		   XSSFRow row2 = sheet.createRow(1);
		       row2.createCell(0).setCellValue("Ravikanth");
		       row2.createCell(1).setCellValue("Chavan");
		       row2.createCell(2).setCellValue("Tribal Caste");
		       row2.createCell(3).setCellValue("Hindu");
		       row2.createCell(4).setCellValue("Unemployed");
		       
		   XSSFRow row3 = sheet.createRow(2);
		       row3.createCell(0).setCellValue("Shalini");
		       row3.createCell(1).setCellValue("Jadhav");
		       row3.createCell(2).setCellValue("Tribal Caste");
		       row3.createCell(3).setCellValue("Hindu");
		       row3.createCell(4).setCellValue("House-Wife");
		       
		   XSSFRow row4 = sheet.createRow(3);
		       row4.createCell(0).setCellValue("ShashiKanth");
		       row4.createCell(1).setCellValue("Chavan");
		       row4.createCell(2).setCellValue("Tribal Caste");
		       row4.createCell(3).setCellValue("Hindu");
		       row4.createCell(4).setCellValue("Employed");
		       
    wb.write(file);
	wb.close();
	file.close();
		       
		       
		   

		
	}

}
