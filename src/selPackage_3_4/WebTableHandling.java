package selPackage_3_4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_9\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// Row variable, Column constant
		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[4]/td[1]
		// ..............
		// *[@id="customers"]/tbody/tr[7]/td[1]

		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Number of rows: " + rowCount);

		String beforeXpath = "//*[@id='customers']/tbody/tr[";
		String afterXpath_Comp = "]/td[1]";

		System.out.println("The values under Company column are: ");
		for (int i = 2; i <= rowCount; i++) {

			String cellTexts = driver.findElement(By.xpath(beforeXpath + i + afterXpath_Comp)).getText();
			System.out.println(cellTexts);

		}

		System.out.println("*******************************************************************");

		System.out.println("The values under Contact column are: ");
		String afterXpath_Cont = "]/td[2]";
		for (int i = 2; i <= rowCount; i++) {

			String cellTexts = driver.findElement(By.xpath(beforeXpath + i + afterXpath_Cont)).getText();
			System.out.println(cellTexts);

		}

		System.out.println("*******************************************************************");

		System.out.println("The values under Country column are: ");
		String afterXpath_Country = "]/td[3]";
		for (int i = 2; i <= rowCount; i++) {

			String cellTexts = driver.findElement(By.xpath(beforeXpath + i + afterXpath_Country)).getText();
			System.out.println(cellTexts);

		}

		System.out.println("*******************************************************************");

		// Column variable, Row constant
		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[2]/td[2]
		// *[@id="customers"]/tbody/tr[2]/td[3]
		
		// *[@id="customers"]/tbody/tr[3]/td[1]

		List<WebElement> columns = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[2]/td"));
		int colCount = columns.size();
		System.out.println("Number of Columns: " + colCount);

		String beforeXpath_Col = "//*[@id='customers']/tbody/tr[2]/td[";
		String afterXpath_rowOne = "]";

		System.out.println("The values under first row are: ");
		for (int i = 1; i <= colCount; i++) {
			String cellTexts = driver.findElement(By.xpath(beforeXpath_Col + i + afterXpath_rowOne)).getText();
			System.out.println(cellTexts);

		}
		
		System.out.println("*******************************************************************");

		driver.quit();

	}

}
