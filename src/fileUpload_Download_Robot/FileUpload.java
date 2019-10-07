package fileUpload_Download_Robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload {

	public WebDriver driver;
	public static Robot robot;
	static String filePath = "E:\\Companies\\Resume_Krishanu_Senior QA Test Analyst.pdf";

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://my.monsterindia.com/create_account.html");
		driver.manage().window().maximize();

	}

	@Test(priority = 1, description = "This is for file upload using Robot class.")
	public void upload() throws IOException, Exception {

		driver.findElement(By.xpath("//input[@id='wordresume']")).click();

		FileUpload.copy();
		FileUpload.paste();

	}

	@AfterTest
	public void tearDown() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	public static void copy() {
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void paste() throws AWTException {

		robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}