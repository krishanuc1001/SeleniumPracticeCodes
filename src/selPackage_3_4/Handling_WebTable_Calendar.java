package selPackage_3_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handling_WebTable_Calendar {

	public WebDriver driver;
	public ChromeOptions options;

	public String date = "25-December-2019";
	public String dateVal[] = date.split("-");
	public String day = dateVal[0];
	public String month = dateVal[1];
	public String year = dateVal[2];

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("http://www.redbus.in");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@Test(priority = 1, description = "First approach: Using list")
	public void datePickerUsingList() {

		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Esplanade, Kolkata");
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Electronic City, Bangalore");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//label[contains(text(), 'Onward Date')]")).click();

		// First approach: Using list
		List<WebElement> onwardDayList = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//td"));

		for (int i = 0; i < onwardDayList.size(); i++) {

			if (onwardDayList.get(i).getAttribute("innerHTML").contentEquals(day)) {

				onwardDayList.get(i).click();
				break;

			}

		}

		driver.findElement(By.xpath("//button[@id='search_btn']")).click();

	}

	// @Test(priority = 2, description = "Second approach: Using xpath")
	public void datePickerUsingXpath() {

		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Esplanade, Kolkata");
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Electronic City, Bangalore");

		driver.findElement(By.xpath("//label[contains(text(), 'Onward Date')]")).click();
		// div[@id='rb-calendar_onward_cal']//tbody/tr[3]/td[1]
		// div[@id='rb-calendar_onward_cal']//tbody/tr[3]/td[7]
		//
		//
		// div[@id='rb-calendar_onward_cal']//tbody/tr[8]/td[1]
		// div[@id='rb-calendar_onward_cal']//tbody/tr[8]/td[7]

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// driver.switchTo().alert().dismiss();

		List<WebElement> rowNum = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody/tr"));

		String xpathPrefix = "//div[@id='rb-calendar_onward_cal']//tbody/tr[";
		String xpathMid = "]/td[";
		String xpathSuffix = "]";

		final int numWeekdays = 7;

		String dayVal = null;

		boolean flag = false;

		for (int i = 3; i <= rowNum.size(); i++) {

			for (int j = 1; j <= numWeekdays; j++) {

				WebElement dayCal = driver.findElement(By.xpath(xpathPrefix + i + xpathMid + j + xpathSuffix));

				try {
					dayVal = dayCal.getAttribute("innerHTML");
				} catch (NoSuchElementException e) {
					System.out.println("Enter valid date !!!");
					flag = false;
					break;
				}

				System.out.println(dayVal);
				if (dayVal.contentEquals(day)) {

					dayCal.click();
					flag = true;
					break;

				}

			}

			if (flag = true) {
				break;
			}

		}

		driver.findElement(By.xpath("//button[@id='search_btn']")).click();

	}

	// Not working with JS
	// @Test 
	public void datePickerUsingJS() {

		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Esplanade, Kolkata");
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Electronic City, Bangalore");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement dateField = driver.findElement(By.xpath("//label[contains(text(), 'Onward')]"));

		dateField.click();

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value', '" + date + "');", dateField);

		// selectDate(driver, dateField, date);

		driver.findElement(By.xpath("//button[@id='search_btn']")).click();

	}

	// public static void selectDate(WebDriver driver, WebElement element, String
	// date) {
	//
	// JavascriptExecutor js = ((JavascriptExecutor) driver);
	// js.executeScript("arguments[0].setAttribute('value', '" + date + "');",
	// element);
	//
	// }

	// @AfterTest
	public void tearDown() {

		driver.quit();

	}

}