package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	XSSFWorkbook wb;
	XSSFSheet sheet0;

	public ReadWriteExcel(String excel_path)  //Constructor is used to pass the excel path
	{
		try {
			File source = new File(excel_path);
			FileInputStream fis = new FileInputStream(source);
			wb = new XSSFWorkbook(fis); //When using .xlsx files
			//HSSFWorkbook wb = new HSSFWorkbook(fis); //When using .xls files		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	public String getExcelData(int sheetNumber, int rowNumber, int columnNumber)
	{
		sheet0 = wb.getSheetAt(sheetNumber);
		String data = sheet0.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
		return data;	
	}

	public int giveRowCount(int sheetNumber)
	{
		int rowCount = wb.getSheetAt(sheetNumber).getLastRowNum();
		rowCount =rowCount + 1; 
		return rowCount;
	}
}
