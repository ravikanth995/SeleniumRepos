package testDataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataDem {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream("C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\Financial Sample.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
	
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total Rows in the Table :"+totalRows);
		System.out.println("Total Cells in the Table :"+totalCells);
		
		for(int r=0; r<=totalRows; r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0; c<totalCells; c++)
			{
				XSSFCell cells = currentRow.getCell(c);
				System.out.print(cells.toString()+"\t");
				Thread.sleep(100);
			}System.out.println();
		}
		
		wb.close();
		file.close();
		
	}
}
