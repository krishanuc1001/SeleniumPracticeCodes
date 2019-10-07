package selPackage_3_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	
	public static void main(String[] args) throws Exception {
		
		
		File source = new File("E:\\Selenium\\Apache POI\\SampleTestDataWorkbook.xlsx");
		FileInputStream fis = new FileInputStream(source);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis); //When using .xlsx files
		//HSSFWorkbook wb = new HSSFWorkbook(fis); //When using .xls files
		XSSFSheet sheet0 = wb.getSheetAt(0);
		
		
		// This code writes to the specified excel sheet 
		sheet0.getRow(0).createCell(2).setCellValue("Pass");
		sheet0.getRow(1).createCell(2).setCellValue("Fail");
		
		FileOutputStream fos = new FileOutputStream(source);
		wb.write(fos);
		
		wb.close();
	}

}
