package selPackage_3_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyPageTitle {

	@Test
	public void verifyPageTitle() {

		System.setProperty("webdriver.gecko.driver",
				"E:\\Selenium\\Selenium Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cleartrip.com");

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		/*
		 * This is how we get the page title of an application.
		 * 
		 */
		String actualPageTitle = driver.getTitle();

		String actualPageSource = driver.getPageSource();

		System.out.println("The page title is " + actualPageTitle);

		System.out.println("The page is " + actualPageSource);

		String expectedPageTitle = "Cleartrip - Flights, Hotels, Local, Trains, Packages";

		// String expectedPageTitle = "Cleartrip - Flights, Hotels, Local, Trains";

		/*
		 * We have used Hard Assertion here
		 */

		Assert.assertEquals(actualPageTitle, expectedPageTitle, "The actual and expected title's do not match");

		Assert.assertTrue(actualPageSource.contains("Cleartrip"));
		System.out.println("The test is completed");

		/*
		 * We have used Soft Assertion here
		 */

		/*
		 * SoftAssert assertObj = new SoftAssert();
		 * assertObj.assertEquals(actualPageTitle, expectedPageTitle,
		 * "The actual and expected title's do not match");
		 * System.out.println("The test is completed"); driver.close();
		 * assertObj.assertAll();
		 * 
		 */

		driver.close();

	}

}
