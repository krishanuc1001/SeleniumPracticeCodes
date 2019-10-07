package selenium_JavaScriptExec;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE_scroll {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.jqueryui.com");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		JSE_scroll.captureScreenshot(driver, "ss1");
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		JSE_scroll.captureScreenshot(driver, "ss2");
		
		driver.quit();

	}

	public static void captureScreenshot(WebDriver driver, String ssName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/" + ssName + ".png"));
	}

}
