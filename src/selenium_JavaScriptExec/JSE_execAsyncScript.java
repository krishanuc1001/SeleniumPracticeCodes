package selenium_JavaScriptExec;

// JavascriptExecutor interface comprises of executeAsyncScript() method that is
// called an additional final argument “arguments[arguments.length-1];” which is
// a callback function to signal that async execution has finished. We have to
// call from JavaScript, to tell Webdriver, that our Asynchronous execution has
// finished. If we do not do that, then executeAsyncScpript will timeout and
// throw a timeout exception.

// Before we execute AsyncScript, we have to make sure to set the script
// timeout. Its default is 0. If we do not set a script timeout, our
// executeAsyncScript will immediately timeout and it won’t work.

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class JSE_execAsyncScript {

	static WebDriver driver;
	private static String url = "http://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/";

	// Setup Driver
	@BeforeClass
	public static void setupTest() {
		driver = new FirefoxDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	// First Example: Performing a sleep in the browser under test.

	// Test Scenario:
	//
	// First I will get the start time before waiting 4 seconds by using
	// executeAsyncScript() method.
	// Then, I will use executeAsyncScript() to wait 4 seconds.
	// Then, I will get the current time
	// I will subtract (current time – start time) = passed time
	// Assert that passed time is greater than 4 seconds.

	@Test
	public void browserSleepExampleTest() {
		// Set ScriptTimeout
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

		// Declare and set start time
		long startTime = System.currentTimeMillis();

		// Declare JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Call executeAsyncScript() method
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 4000);");

		// Get the difference (currentTime - startTime) it should be greater than 1500
		System.out.println("Passed time: " + (System.currentTimeMillis() - startTime));

		// Assert that the time difference is greater than 4000
		assertTrue("Time difference must be greater than 4000 milliseconds",
				(System.currentTimeMillis() - startTime) > 4000);
	}

	// Close Driver
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}
}
