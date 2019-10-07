package selPackage_3_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HandlingCalendarUsingJS {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// driver.get("http://www.redbus.in");
		// WebElement dateField =
		// driver.findElement(By.xpath("//label[contains(text(),'Onward')]"));

		driver.get("https://www.spicejet.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement from = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		from.sendKeys("HYD");
		// Select fromOptions = new Select(from);
		// fromOptions.selectByVisibleText("Kolkata (CCU)");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement to = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
		to.sendKeys("BOM");
		// Select toOptions = new Select(to);
		// toOptions.selectByVisibleText("Mumbai (BOM)");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement dateField = driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));

		String date = "20-07-2019";

		// Selecting date using JSExecutor

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value', '" + date + "');", dateField);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement search = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));

		js.executeScript("arguments[0].scrollIntoView()", search);
		js.executeScript("arguments[0].click();", search);

	}

	// public static void selectDate(WebDriver driver, WebElement element, String
	// date) {
	//
	// JavascriptExecutor js = ((JavascriptExecutor) driver);
	// js.executeScript("arguments[0].setAttribute('value', '" + date + "');",
	// element);
	//
	// }

}
