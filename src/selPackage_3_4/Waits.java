package selPackage_3_4;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.FluentWait;

public class Waits {

	WebDriver driver;

	// @BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// @Test(priority = 1, description = "This test explains Implicit wait")
	public void ImplicitWait() throws InterruptedException {

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://the-internet.herokuapp.com/dynamic_controls");

		driver.findElement(By.xpath("//button[@id='btn']")).click();

		WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkbox']"));

		Assert.assertTrue(checkBox.isDisplayed(), "checkBox is not displayed");

		driver.findElement(By.xpath("//button[text()='Remove']")).click();

		WebElement message = driver.findElement(By.id("message"));

		Assert.assertTrue(message.isDisplayed(), "Message is not displayed");

	}

	// @Test(priority = 2, description = "This test explains Explicit wait")
	public void ExplicitWait() throws InterruptedException {

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//button[text()='Start']")).click();
		WebElement content = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

		// Explicit Wait
		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait.until(ExpectedConditions.visibilityOf(content));

		Assert.assertTrue(content.isDisplayed(), "Content is not displayed");
		System.out.println(content.getText());

	}

	// @Test(priority = 3, description = "This test explains Fluent wait")
	public void FluentWait() throws InterruptedException {

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		// Fluent Wait
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement content = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//h4[text()='Hello World!']"));
			}
		});
		System.out.println(content.getText());
	}

	// @Test(priority = 4, description = "This test explains PageLoadTimeout")
	public void pageLoadTimeout() {

		// Page Load Time Out
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MILLISECONDS);

		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

	}

	// Best Custom Wait method using object of ExpectedCondition class
	public static WebElement masterWait(WebDriver driver, final String xPath, int timeOut) {

		WebDriverWait expWait = new WebDriverWait(driver, timeOut);
		expWait.ignoring(org.openqa.selenium.NoSuchElementException.class);
		expWait.ignoring(org.openqa.selenium.StaleElementReferenceException.class);
		expWait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xPath));
				if (element != null) {
					if (element.isDisplayed() && element.isEnabled()) {
						return true;
					} else {
						return false;
					}
				}

				return false;
			}
		});

		return driver.findElement(By.xpath(xPath));
	}

	// Custom wait: By creating the object of Expected Condition class and by using
	// the method apply
	@Test
	public void customExpectedCondition() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_77\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.uitestpractice.com");

		driver.findElement(By.xpath("//a[contains(text(),'AjaxCall')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'This is a Ajax link')]")).click();

		// Explicit Wait
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);

		explicitWait.until(WaitFor.elementContainsText("C#"));

		String text = driver
				.findElement(By.xpath("//p[contains(text(),'Selenium is a portable software testing framework')]"))
				.getText();

		System.out.println("The text inside is ==> " + text);

		driver.quit();

	}

	// @AfterTest
	public void close() {
		driver.quit();
	}
}

/*******************************************************************************/

// Custom wait: By creating a custom expected condition in a class
class WaitFor {

	public static ExpectedCondition<Boolean> elementContainsText(String textMustContain) {

		return new ElementContainsTextCondition(textMustContain);

	}

}

class ElementContainsTextCondition implements ExpectedCondition<Boolean> {

	private String textToFind;

	// Constructor
	public ElementContainsTextCondition(final String textToFind) {
		this.textToFind = textToFind;
	}

	@Override
	public Boolean apply(WebDriver driver) {

		WebElement element = driver
				.findElement(By.xpath("//p[contains(text(),'Selenium is a portable software testing framework')]"));

		return element.getText().contains(textToFind);
	}

}
