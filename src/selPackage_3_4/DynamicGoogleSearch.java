package selPackage_3_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleSearch {

	public static WebDriver driver;
	public static String query = "avengers";
	public static String desiredQuery = "avengers endgame";

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.findElement(By.xpath("//input[@name='q' or @title='Search']")).sendKeys(query);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// List<WebElement> list =
		// driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbqs_c']"));

		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbl1']"));

		System.out.println("Total number of results:=====>>> " + list.size());

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		for (int j = 0; j < list.size(); j++) {
			System.out.println("Below are the search results:======>>" + list.get(j).getText());

		}

		System.out.println("<<==============================================================>>");

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().contains(desiredQuery)) {
				list.get(i).click();
				System.out.println("Hey there!!! I have clicked on ==>" + desiredQuery);
				break;

			}

		}

		driver.close();

	}

}