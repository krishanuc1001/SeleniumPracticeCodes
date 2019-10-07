package selPackage_3_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyErrorMessage {


	WebDriver driver;

	@BeforeClass
	public void startBrowser()
	{
//		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\Selenium Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe");
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("<=================BROWSER HAS STARTED=================>");

	}

	//@Test (priority=1)
	public void verifyErrorMsg1()
	{
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//span[text()='Next']")).click();

		String actual_err = driver.findElement(By.xpath("//div[@class='GQ8Pzc']")).getText();
		
		//div[@class='dEOOab RxsGPe']/div[@class='GQ8Pzc']
		
		System.out.println("The actual error message is " + actual_err);

		String expected_err = "Enter an email or phone number";

		Assert.assertEquals(actual_err, expected_err, "The actual and expected errors do not match !!");

		System.out.println("Error message verified by method 1 using getText() !!");

	}

	@Test (priority=2)
	public void verifyErrorMsg2()
	{
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//span[text()='Next']")).click();

		String actual_err = driver.findElement(By.xpath("//div[@class='GQ8Pzc']")).getAttribute("innerHTML");
		System.out.println("The actual error message is " + actual_err);

		String expected_err = "Enter an email or phone number";

		Assert.assertEquals(actual_err, expected_err, "The actual and expected errors do not match !!");

		System.out.println("Error message verified by method 2 using getAttribute() !!");

	}

	//@AfterClass
	public void closeBrowser()
	{
		driver.close();
		System.out.println("<=================BROWSER HAS CLOSED=================>");

	}

}