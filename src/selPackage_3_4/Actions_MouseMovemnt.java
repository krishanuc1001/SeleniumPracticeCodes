package selPackage_3_4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actions_MouseMovemnt {

	public WebDriver driver;
	public Robot robot;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	// @Test
	public void mouseHoverAndSelect() throws InterruptedException {
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");

		WebElement content = driver.findElement(By.className("menulink"));
		WebElement option = driver.findElement(By.xpath("//a[text()='Single Videos']"));

		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.moveToElement(content).build().perform();

		Thread.sleep(3000);

		option.click();

	}

	@Test
	public void dragAndDrop() {

		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);
		act.clickAndHold(source).moveToElement(target).release().build().perform();

	}

	// @Test
	public void rightClick() {

		driver.get("http://http://swisnl.github.io/jquery-contextmenu/demo.html");

		WebElement rightClickBtn = driver.findElement(By.cssSelector(".context-menu-one"));

		Actions act = new Actions(driver);
		act.contextClick(rightClickBtn).build().perform();

	}

	// @Test(priority = 1)
	public void flipkartLogout() {

		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@type='text' and @class='_2zrpKA']")).sendKeys("krish.shanu100@gmail.com");
		driver.findElement(By.xpath("//input[@type='password' and @class='_2zrpKA _3v41xv']"))
				.sendKeys(Actions_MouseMovemnt.decode());
		driver.findElement(By.xpath("//button[@type='submit' and @class='_2AkmmA _1LctnI _7UHT_c']")).click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement userNameAccount = driver.findElement(By.xpath("//div[contains(text(),'Krishanu')]"));
		WebElement logOutBtn = driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));

		Actions action = new Actions(driver);
		// action.clickAndHold(userNameAccount).moveToElement(logOutBtn).build().perform();
		action.moveToElement(userNameAccount).build().perform();

		logOutBtn.click();

	}

	// @Test(priority = 2)
	public void naukriLogout() throws AWTException {

		driver.get("https://www.naukri.com");

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

		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(Actions_MouseMovemnt.decode());

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

		// robot = new Robot();
		// robot.keyPress(KeyEvent.VK_CONTROL);
		// robot.keyPress(KeyEvent.VK_HOME);
		// robot.keyRelease(KeyEvent.VK_CONTROL);
		// robot.keyRelease(KeyEvent.VK_HOME);

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
			if (title.contains("Logout")) {
				dropDwnEle.click();
				break;
			}
		}

	}

	// @AfterTest
	public void tearDown() {
		driver.quit();
	}

	public static String encode() {

		String password = "********";
		byte[] encodedPwd = Base64.getEncoder().encode(password.getBytes());
		// System.out.println("Encoded form of " + password + "is ==> " + new
		// String(encodedPwd));
		return new String(encodedPwd);

	}

	public static String decode() {

		byte[] decodedPwd = Base64.getDecoder().decode(encode());
		// System.out.println("Decoded form of " + encode() + "is ==> " + new
		// String(decodedPwd));
		return new String(decodedPwd);

	}
}
