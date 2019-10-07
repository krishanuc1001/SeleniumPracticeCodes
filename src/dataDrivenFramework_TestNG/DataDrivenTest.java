package dataDrivenFramework_TestNG;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataDrivenFramework.ExcelUtility;

public class DataDrivenTest {

	public WebDriver driver;

	@BeforeMethod
	public void setUpContext()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_7\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.in/reg/PartialReg");

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = DataProviderClass.getTestDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider="getTestData")
	public void Test(String firstName, String lastName, String mail){

		driver.findElement(By.xpath("//input[@id='firstname'][@name='firstname']")).clear();
		driver.findElement(By.xpath("//input[@id='firstname'][@name='firstname']")).sendKeys(firstName);

		driver.findElement(By.xpath("//input[@id='lastname'][@name='lastname']")).clear();
		driver.findElement(By.xpath("//input[@id='lastname'][@name='lastname']")).sendKeys(lastName);

		driver.findElement(By.xpath("//input[@id='email'][@name='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email'][@name='email']")).sendKeys(mail);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
