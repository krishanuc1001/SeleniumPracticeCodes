package selPackage_3_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws Exception {

		File source = new File("E:\\Selenium\\Apache POI\\SampleTestDataWorkbook.xlsx");
		FileInputStream fis = new FileInputStream(source);

		XSSFWorkbook wb = new XSSFWorkbook(fis); //When using .xlsx files
		//HSSFWorkbook wb = new HSSFWorkbook(fis); //When using .xls files

		XSSFSheet sheet0 = wb.getSheetAt(0);
		String data0 = sheet0.getRow(2).getCell(1).getStringCellValue(); //Here getCell() method is for specifying the Column number

		System.out.println("Data from the first row and column is ====>>> " + data0);

		wb.close();
	}

}
