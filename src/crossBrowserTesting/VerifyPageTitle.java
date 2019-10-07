package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyPageTitle {


	WebDriver driver;
	//VerifyPageTitle vgt;

	@Test (priority=1)
	@Parameters("browser")
	public void verifyPageTitle(String browserName)
	{

		if (browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Selenium Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Test case running on Firefox");
		}

		else if (browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_3\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Test case running on Chrome");
			
		}

		else if (browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Selenium\\Selenium Drivers\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("Test case running on IE");
			
		}

		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");

		String actualTitle = driver.getTitle();
		System.out.println("Page Title is: " + actualTitle);

		driver.quit();
	}
}