package exelItils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static XSSFWorkbook wb;
    public static FileInputStream fi;
    public static FileOutputStream fo;

    public static void openFile(String xlfile) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
    }

    public static void closeFile() throws IOException {
        if (wb != null) {
            wb.close();
        }
        if (fi != null) {
            fi.close();
        }
        if (fo != null) {
            fo.close();
        }
    }

    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        openFile(xlfile);
        XSSFSheet ws = wb.getSheet(xlsheet);
        int rowCount = ws.getLastRowNum();
        closeFile();
        return rowCount;
    }

    public static int getCellCount(String xlfile, String xlsheet, int rowNum) throws IOException {
        openFile(xlfile);
        XSSFSheet ws = wb.getSheet(xlsheet);
        XSSFRow row = ws.getRow(rowNum);
        int cellCount = row != null ? row.getLastCellNum() : 0;
        closeFile();
        return cellCount;
    }

    public static String getCellData(String xlfile, String xlSheet, int rowNum, int cellNum) throws IOException {
        openFile(xlfile);
        XSSFSheet ws = wb.getSheet(xlSheet);
        XSSFRow row = ws.getRow(rowNum);
        XSSFCell cell = row != null ? row.getCell(cellNum) : null;
        String data;
        try {
            if (cell != null) {
                DataFormatter formatter = new DataFormatter();
                data = formatter.formatCellValue(cell);
            } else {
                data = ""; // Or a default value
            }
        } catch (Exception e) {
            System.out.println("Error getting cell data: " + e.getMessage());
            data = "";
        }
        closeFile();
        return data;
    }

    public static void setCellData(String xlfile, String xlsheet, int rowNum, int cellNum, String data) throws IOException {
        openFile(xlfile);
        XSSFSheet ws = wb.getSheet(xlsheet);
        XSSFRow row = ws.getRow(rowNum);
        XSSFCell cell = row != null ? row.getCell(cellNum) : ws.createRow(rowNum).createCell(cellNum);
        cell.setCellValue(data);

        fo = new FileOutputStream(xlfile);
        wb.write(fo);
        closeFile();
    }

    public static void fillGreenColor(String xlfile, String xlsheet, int rowNum, int cellNum) throws IOException {
        openFile(xlfile);
        XSSFSheet ws = wb.getSheet(xlsheet);
        XSSFRow row = ws.getRow(rowNum);
        XSSFCell cell = row != null ? row.getCell(cellNum) : ws.createRow(rowNum).createCell(cellNum);
        CellStyle style = wb.createCellStyle();
        cell.setCellStyle(style);
        style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());

        fo = new FileOutputStream(xlfile);
        wb.write(fo);
        closeFile();
    }

    public static void FillRedColor(String xlfile, String xlsheet, int rowNum, int cellNum) throws IOException {
        openFile(xlfile);
        XSSFSheet ws = wb.getSheet(xlsheet);
        XSSFRow row = ws.getRow(rowNum);
        XSSFCell cell = row != null ? row.getCell(cellNum) : ws.createRow(rowNum).createCell(cellNum);
        CellStyle style = wb.createCellStyle();
        cell.setCellStyle(style);
        
        style.setFillBackgroundColor(IndexedColors.RED.getIndex());
        
        fo = new FileOutputStream(xlfile);
        wb.write(fo);
        closeFile();

}
}