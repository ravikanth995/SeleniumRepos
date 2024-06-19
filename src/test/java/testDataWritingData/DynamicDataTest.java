package testDataWritingData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicDataTest {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file  = new FileOutputStream(System.getProperty("user.dir")+"\\testData\\DynamicData1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("Sheet1");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Rows : ");
		int noOfRow = sc.nextInt();
		
		System.out.println("Enter Cells :");
		int noOfCol = sc.nextInt();
		
		for(int r=0; r<=noOfRow; r++)
		{
			XSSFRow currentRow = sheet.createRow(r);
			for(int c=0; c<noOfCol; c++)
			{
				XSSFCell cells = currentRow.createCell(c);
				cells.setCellValue(sc.next());
			}
		}
		
		wb.write(file);
		wb.close();
		file.close();
		System.out.println("File Created.");

	}

}
