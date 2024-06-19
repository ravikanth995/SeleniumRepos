package testDataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class DataTestingExcel {

	public static void main(String[] args) throws IOException {
		
//		FileInputStream file = new FileInputStream(System.getProperty("user-dir")+"\\testData\\file_example_XLSX_100.xlsx");
		FileInputStream file = new FileInputStream("C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\file_example_XLSX_100.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total Number of Rows :"+totalRows);
		System.out.println("Total Cells in the Row :"+totalCells);
		
		for(int r=0; r<=totalRows; r++)
		
		{
			XSSFRow currentRow = sheet.getRow(r);
			  for(int c=0; c<totalCells; c++)
			  {
				  XSSFCell cell = currentRow.getCell(c);
				  System.out.print(cell.toString()+"\t");
				  
			  }System.out.println();
			
		}
		
		wb.close();
		file.close();
	}

}
