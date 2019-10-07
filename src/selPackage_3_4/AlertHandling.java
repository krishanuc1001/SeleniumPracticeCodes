package selPackage_3_4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertHandling {

	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test(enabled = false)
	public void alertTestOne() throws InterruptedException {

		driver.get("https://ksrtc.in/oprs-web/");
		driver.findElement(By.xpath("//button[contains(text(),'Search for Bus')]")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000);
		driver.switchTo().alert().accept();

	}

	@Test(enabled = true)
	public void alertTestTwo() throws Exception {

		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[contains(text(), 'Alert with Textbox ')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'click the button to demonstrate the prompt box ')]"))
				.click();

		driver.switchTo().alert();

		Robot bot = new Robot();
		bot.keyPress(KeyEvent.VK_CONTROL);
		bot.keyPress(KeyEvent.VK_A);
		bot.keyRelease(KeyEvent.VK_CONTROL);
		bot.keyRelease(KeyEvent.VK_A);

		Thread.sleep(3000);

		bot.keyPress(KeyEvent.VK_BACK_SPACE);
		bot.keyRelease(KeyEvent.VK_BACK_SPACE);
		
		Thread.sleep(5000);

		driver.switchTo().alert().sendKeys("Krishanu");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.switchTo().alert().accept();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
