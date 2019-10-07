package ListenersDemo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;


@Listeners(ListenersDemo.ListenerClass.class)
public class SampleTestCase {

	// @Test (priority=1)
	public void verifyPageTitle()
	{
		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\Selenium Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cleartrip.com");

		String actualPageTitle = driver.getTitle();
		Assert.assertTrue(actualPageTitle.contains ("Cleartrip"),"The page title did not match");
		driver.quit();
	}

	@Test(priority=2)
	public void failVerifyTestCase()
	{
		Assert.assertTrue(false);
	}
}
