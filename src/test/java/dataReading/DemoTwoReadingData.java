package dataReading;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTwoReadingData {

	public static void main(String[] args) throws IOException {
		
		
		//Locating file in Directory
		FileInputStream file  = new FileInputStream("C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\100-kb.xlsx");
		
		//Importing WorkBook and adding location
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		//Importing Sheet  and creating the Sheet Name via workbbok
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		//Counting Rows and Columns
		
		int totalRows = sheet.getLastRowNum();
		int totalCol = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of Rows :"+totalRows);
		System.out.println("Number of Cells :"+totalCol);
		
		for(int r=0; r<=totalRows; r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0; c<totalCol; c++)
			{
				XSSFCell cells = currentRow.getCell(c);
				System.out.print(cells.toString()+"\t");
			}System.out.println();
		}
		wb.close();
		file.close();
		

	}

}
