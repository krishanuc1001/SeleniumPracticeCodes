package dataDrivenFramework;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterizeTest {

	public static void main(String[] args) throws FileNotFoundException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_9\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://reg.ebay.in/reg/PartialReg");
		driver.manage().window().maximize();

		ExcelUtility reader = new ExcelUtility(
				"E:\\Selenium\\Project\\seleniumPracticeProject_3.4\\src\\dataDrivenFramework\\EbayTestData.xlsx");

		int rowCount = reader.getRowCount("RegTestData");

		reader.addColumn("RegTestData", "Status");

		// Parameterization of data using For loop
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			// Reading from excel
			String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
			driver.findElement(By.xpath("//input[@id='firstname'][@name='firstname']")).clear();
			driver.findElement(By.xpath("//input[@id='firstname'][@name='firstname']")).sendKeys(firstName);

			String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
			driver.findElement(By.xpath("//input[@id='lastname'][@name='lastname']")).clear();
			driver.findElement(By.xpath("//input[@id='lastname'][@name='lastname']")).sendKeys(lastName);

			String mail = reader.getCellData("RegTestData", "email", rowNum);
			driver.findElement(By.xpath("//input[@id='email'][@name='email']")).clear();
			driver.findElement(By.xpath("//input[@id='email'][@name='email']")).sendKeys(mail);

			// writing to Excel
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");

		}

		driver.close();
	}

}
