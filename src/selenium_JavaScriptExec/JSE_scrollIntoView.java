package selenium_JavaScriptExec;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE_scrollIntoView {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"mCSB_2_container\"]/p[1]"));

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		JSE_scroll.captureScreenshot(driver, "ss1");

		System.out.println(element.getText());

		driver.quit();

	}

	public static void captureScreenshot(WebDriver driver, String ssName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/" + ssName + ".png"));
	}

}
