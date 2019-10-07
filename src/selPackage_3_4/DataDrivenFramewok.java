package selPackage_3_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.ReadWriteExcel;

public class DataDrivenFramewok {

	WebDriver driver;

	@Test(dataProvider = "test data")
	public void testFireFox(String username, String password) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(username);

		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@DataProvider(name = "test data")
	public Object[][] testDataProvider() {

		ReadWriteExcel rwExcel = new ReadWriteExcel(
				"E:\\Selenium\\Project\\seleniumPracticeProject_3.4\\Test Data\\SampleTestDataWorkbook.xlsx");
		int rows = rwExcel.giveRowCount(0);

		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			data[i][0] = rwExcel.getExcelData(0, i, 0);
			data[i][1] = rwExcel.getExcelData(0, i, 1);
		}

		return data;

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
