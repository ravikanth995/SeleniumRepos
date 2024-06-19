package dataReading;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoOne {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\100-kb.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int totalRow = sheet.getLastRowNum();
		int totalCol = sheet.getRow(1).getLastCellNum();
		
		System.out.print("Number of Rows are :"+totalRow);
		System.out.print("Number of Columns are :"+totalCol);
		
		for(int r=0; r<=totalRow; r++)
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
