package dataDrivenFramework_TestNG;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DataProviderClass {

	static ExcelUtility reader;

	public static ArrayList<Object[]> getTestDataFromExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new ExcelUtility("\\Selenium\\Project\\seleniumPracticeProject_3.4\\src\\dataDrivenFramework_TestNG\\EbayTestData.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int rowCount = reader.getRowCount("RegTestData");

		for (int rowNum=2; rowNum<= rowCount; rowNum++) {
			String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
			String mail  = reader.getCellData("RegTestData", "email", rowNum);

			Object obArray[] = {firstName, lastName, mail};
			myData.add(obArray);
		}
		return myData;
	}
}
