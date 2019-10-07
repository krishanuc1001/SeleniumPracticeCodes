package headlessAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHeadless {

	public static void main(String[] args) {

		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");

		System.setProperty("webdriver.gecko.driver",
				"E:\\Selenium\\Selenium Drivers\\geckodriver-v0.23.0-win64\\geckodriver.exe");

		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);

		WebDriver driver = new FirefoxDriver(firefoxOptions);
		driver.get("https://www.seleniumhq.org");

		System.out.println(driver.getTitle());

		FirefoxHeadless.captureScreenshot(driver, "HeadlessTest");

	}

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
		} catch (WebDriverException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
