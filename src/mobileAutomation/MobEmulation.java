package mobileAutomation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MobEmulation {

	public ChromeOptions options;
	public WebDriver driver;

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_77\\chromedriver.exe");

		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "iPhone X");

		options = new ChromeOptions();
		options.setExperimentalOption("mobileEmulation", mobileEmulation);

		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@Test
	public void launchGoogleOnEmulator() throws Exception {

		driver.get("https://www.google.com");
		Thread.sleep(5000);
		System.out.println("Successfully launched Google on Mobile Emulator !!!");

	}

	// @AfterTest
	public void tearDown() {

		driver.quit();

	}

}
