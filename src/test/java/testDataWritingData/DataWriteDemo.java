package testDataWritingData;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataWriteDemo {

	public static void main(String[] args) throws IOException {
	
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testData\\myFile1.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("Sheet2");
		
		XSSFRow row0 = sheet.createRow(0);
	    row0.createCell(0).setCellValue("Languages");
	    row0.createCell(1).setCellValue("Names");
	    row0.createCell(2).setCellValue("Scriptre");
	    row0.createCell(3).setCellValue("Ook");
	    row0.createCell(4).setCellValue("No");
		
		XSSFRow row1 = sheet.createRow(1);
		    row1.createCell(0).setCellValue("Python");
		    row1.createCell(1).setCellValue("Java");
		    row1.createCell(2).setCellValue("Ruby");
		    row1.createCell(3).setCellValue("C#");
		    row1.createCell(4).setCellValue("Javascript");
		    
		XSSFRow row2 = sheet.createRow(2);
		    row2.createCell(0).setCellValue("Ravikanth");
		    row2.createCell(1).setCellValue("Shalini");
		    row2.createCell(2).setCellValue("ShashiKanth");
		    row2.createCell(3).setCellValue("Prakash");
		    row2.createCell(4).setCellValue("KasuBai");
		    
		XSSFRow row3 = sheet.createRow(3);
		    row3.createCell(0).setCellValue("Bhagwat Geeta");
		    row3.createCell(1).setCellValue("Upanishad");
		    row3.createCell(2).setCellValue("Brahmasutra");
		    row3.createCell(3).setCellValue("Samkhya Darshan");
		    row3.createCell(4).setCellValue("Origin of Species");
		    
		    
		
		    wb.write(file);
		    wb.close();
		    file.close();
	
	}

}
