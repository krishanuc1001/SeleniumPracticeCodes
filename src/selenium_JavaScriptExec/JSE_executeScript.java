package selenium_JavaScriptExec;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JSE_executeScript {
	static WebDriver driver;
	private static String url = "http://www.anaesthetist.com/mnm/javascript/calc.htm";

	// Setup Driver
	@BeforeClass
	public static void setupTest() {
		driver = new FirefoxDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	@Test
	public void T01_returnTest() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		assertEquals("Addition Javascript Test!", 20L, js.executeScript("return (arguments[0]+arguments[1]);", 10, 10));
	}

	@Test
	public void T02_alertPopUpWindow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('SW Test Academy!');");
		driver.switchTo().alert().accept();
	}

	@Test
	public void T03_getTitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		assertThat(driver.getTitle(), is(title));
	}

	@Test
	public void T04_refreshBrowser() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0);");
	}

	@Test
	public void T05_scrollDownUntilAnElementDisplayed() {
		WebElement element = driver.findElement(By.xpath("//*[text()[contains(.,'JavaScript for DoExponent')]]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@Test
	public void T06_getURL() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String currentUrl = (String) js.executeScript("return document.URL;");
		assertThat(currentUrl, is(driver.getCurrentUrl()));
	}

	@Test
	public void T07_highlightAnElement() {
		WebElement sevenButton = driver.findElement(By.name("seven"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px dotted blue'", sevenButton);
	}

	@Test
	public void T08_hideAndShowElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Hide an element
		js.executeScript("document.getElementsByName('five')[0].style.display='none'");
		// Show an element
		js.executeScript("document.getElementsByName('five')[0].style.display='block'");
	}

	@Test
	public void T09_createAnAnonymousFunction() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change title with JavascriptExecutor
		js.executeScript("document.title='Title is changed manually!';");
		assertThat(driver.getTitle(), Is.is("Title is changed manually!"));

		// Create an anonymous function that will stored and added into the global
		// window
		js.executeScript("window.changetitle = function(){document.title='Title is changed by function!';};"
				+ "window.changetitle.call();");
		assertThat(driver.getTitle(), Is.is("Title is changed by function!"));

		// Change title manually
		js.executeScript("document.title='Title is changed manually!';");
		assertThat(driver.getTitle(), Is.is("Title is changed manually!"));

		// Change title with Function
		js.executeScript("window.changetitle.call();");
		assertThat(driver.getTitle(), Is.is("Title is changed by function!"));
	}

	@Test
	public void T10_navigateToOtherPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location = 'https://www.swtestacademy.com/'");
	}

	@Test
	public void T11_clickAnElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elementToClick = driver.findElement(By.cssSelector("Element CSS"));
		js.executeScript("arguments[0].scrollIntoView()", elementToClick);
		js.executeScript("arguments[0].click();", elementToClick);
	}

	@Test
	public void T12_clickDisabledRadioButton() {
		((JavascriptExecutor) driver).executeScript("document.getElementById('enter your element id').click();");
	}

	@Test
	public void T13_clickDisabledCheckbox() {
		// This will execute JavaScript in your script
		((JavascriptExecutor) driver).executeScript("document.getElementById('enter element id').checked=false;");
	}

	@Test
	public void T14_enterText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('Id of textbox').value = 'SW Test Academy';");
	}

	@Test
	public static void T15_selectDate(WebDriver driver, WebElement element, String dateVal) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value', '" + dateVal + "');", element);

	}

	// Close Driver
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}

}