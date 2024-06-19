package dataReading;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoDataRead {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream file = new FileInputStream("C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\100-kb.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int totalRow = sheet.getLastRowNum();
		int totalCol = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of Rows :"+totalRow);
		System.out.println("Number of Columns :"+totalCol);
		
		for(int r=0; r<=totalRow; r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0; c<totalCol; c++)
			{
				XSSFCell cells = currentRow.getCell(c);
				System.out.print(cells.toString()+"\t");
				Thread.sleep(300);
				
			}System.out.println();

		}
		wb.close();
		file.close();
				
	}

}
