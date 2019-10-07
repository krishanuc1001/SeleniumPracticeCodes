package fileUpload_Download_Robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownload {

	WebDriver driver;
	Robot robot;

	// public static String filePath =
	// "C:\\Users\\Krishanu\\Downloads\\Compressed\\Test_IEDriverServer_x64_3.14.0.zip";
	private final String filePath = "E:\\Selenium\\TestDownload";

	// @BeforeTest
	// public void setUp() {
	//
	// System.setProperty("webdriver.ie.driver",
	// "E:\\Selenium\\Selenium
	// Drivers\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");
	// driver = new InternetExplorerDriver();
	// driver.get("https://www.seleniumhq.org/download/");
	// driver.manage().window().maximize();
	//
	// }

	// Worked perfect without using Robot class. Its recommended to use this approach to download any file.
	@Test
	public void download() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", filePath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(cap);
		driver.get("https://www.seleniumhq.org/download/");
		driver.manage().window().maximize();
		//driver.findElement(By.linkText("Download")).click();
		driver.findElement(By.xpath("//a[contains(text(),'64 bit Windows IE')]")).click();
		Thread.sleep(3000);

	}

	
	// This method did not work properly 
	
	// @Test(priority = 1, description = "This is for file download using Robot
	// class.")
	// public void download() throws IOException, Exception {
	//
	// driver.findElement(By.xpath("//a[contains(text(),'64 bit Windows
	// IE')]")).click();
	//
	// robot = new Robot();
	//
	// for (int i = 1; i <= 7; i++) {
	// robot.keyPress(KeyEvent.VK_TAB);
	// }
	//
	// robot.delay(10000);
	//
	// FileDownload fd = new FileDownload();
	//
	// fd.copy();
	// fd.paste();
	//
	// robot.delay(2000);
	//
	// fd.cancelDownload();
	//
	// }

	public void copy() {
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public void paste() throws AWTException {

		robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void cancelDownload() throws AWTException {

		robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}