package dataDrivenFramework;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTest {

	public static void main(String[] args) throws FileNotFoundException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_9\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://reg.ebay.in/reg/PartialReg");

		ExcelUtility reader = new ExcelUtility(
				"E:\\Selenium\\Project\\seleniumPracticeProject_3.4\\src\\dataDrivenFramework\\EbayTestData.xlsx");

		// Reading from excel
		String firstName = reader.getCellData("RegTestData", "firstname", 2);
		driver.findElement(By.xpath("//input[@id='firstname'][@name='firstname']")).sendKeys(firstName);

		String lastName = reader.getCellData("RegTestData", "lastname", 2);
		driver.findElement(By.xpath("//input[@id='lastname'][@name='lastname']")).sendKeys(lastName);

		String mail = reader.getCellData("RegTestData", "email", 2);
		driver.findElement(By.xpath("//input[@id='email'][@name='email']")).sendKeys(mail);

	}

}
