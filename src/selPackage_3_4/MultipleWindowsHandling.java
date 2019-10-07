package selPackage_3_4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindowsHandling {

	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test(priority = 2)
	public void test_MultipleTabs() {

		driver.get("http://www.seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");

		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("The Parent window handle is: " + driver.switchTo().window(parentWindowHandle).getTitle());

		driver.findElement(By.xpath("//a[contains(@href, 'http://www.google.com')]")).click();
		driver.findElement(By.xpath("//a[2][contains(@href, 'http://www.facebook.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'http://www.yahoo.com')]")).click();

		Set<String> childWindowHandles = driver.getWindowHandles();
		int numOfChildWindows = childWindowHandles.size();
		System.out.println("The number of child windows are: " + (numOfChildWindows - 1));

		for (String child : childWindowHandles) {

			if (!parentWindowHandle.equalsIgnoreCase(child)) {

				System.out.println("<******************************>");

				System.out.println("Switching to window - > " + child);

				driver.switchTo().window(child);

				System.out.println("Closing the window ===> " + driver.switchTo().window(child).getTitle());

				driver.close();

				System.out.println("<******************************>");

			}

		}

		driver.switchTo().window(parentWindowHandle);
	}

	@Test(priority = 1)
	public void test_Naukri_PopUpWindows() throws AWTException {

		driver.get("https://www.naukri.com");

		driver.manage().window().maximize();

		// Handling multiple browser based pop-ups

		String parentWindow = driver.getWindowHandle();

		System.out.println("The Parent window handle is ===> " + parentWindow);

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			if (!parentWindow.equals(window)) {

				System.out.println("<******************************>");

				System.out.println("Switching to window - > " + window);

				driver.switchTo().window(window);

				System.out.println("Closing the window ===> " + driver.switchTo().window(window).getTitle());

				driver.close();

				System.out.println("<******************************>");

			}

		}

		driver.switchTo().window(parentWindow);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='mTxt'][contains(text(),'Login')]")).click();

		// Switching to Login window and logging in

		String loginWindow = driver.getWindowHandle();

		driver.switchTo().window(loginWindow);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("krishanuc1001@gmail.com");

		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("*******");

		driver.findElement(By.xpath("//button[@value='Login']")).click();

		// Clicking on the Update button

		// driver.findElement(By.xpath("//a[@class='btn btn-block btn-large
		// white-text']")).click();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Scrolling down to the Attach resume button and clicking

		// driver.findElement(By.xpath("//li[12]/a[@href='javascript:;' and
		// @class='secondary-content']")).click();
		//
		// driver.findElement(By
		// .xpath("//input[@id='attachCV'][@type='file'][@class='fileUpload waves-effect
		// waves-light btn-large']"))
		// .click();
		//
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Runtime.getRuntime().exec("E:\\Selenium\\AutoIT\\ResumeUploader.exe");

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_HOME);

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// ((JavascriptExecutor) driver).executeScript("scroll(0,- 400)");

		WebElement myNaukri = driver.findElement(By.xpath("//a/div[2][@class='mTxt'][text()='My Naukri']"));

		Actions action = new Actions(driver);
		action.moveToElement(myNaukri).build().perform();

		// driver.findElement(By.xpath("//ul[@class='rghtSec fr menu
		// logged']//div[@class='subMenu c2']//ul[2]/li[5]")).click();

		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@class='rghtSec fr menu logged']//div[@class='subMenu c2']//ul[2]/li"));

		int list_size = list.size();

		System.out.println("The list size is: " + list_size);

		for (int i = 0; i < list_size; i++) {

			WebElement dropDwnEle = list.get(i);
			String title = dropDwnEle.getAttribute("innerHTML");
			System.out.println("The different title values are: " + title);
			if (title.contentEquals("Logout")) {
				dropDwnEle.click();
				break;
			}
		}

	}

	// @AfterTest
	// public void tearDown() {
	// driver.quit();
	// }

}
