package selPackage_3_4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

public class Test_JSExe {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id='gh-ac'][@placeholder='Search for anything']")).sendKeys("DSLR camera");
		driver.findElement(By.xpath("//*[@id='gh-btn'][@value='Search']")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// String pageSrc = driver.getPageSource();
		// System.out.println(pageSrc);

		// List<WebElement> list = driver.findElements(By.className("s-item__title"));

		List<WebElement> list = driver.findElements(By.xpath("//a/h3[@role='text']"));
		//System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains("Canon")) {
				WebElement ele_canon = list.get(i);
				//List<WebElement> canon_list = list.addAll(ele_canon);
				Test_JSExe.scrolltoElement(ele_canon);
				Test_JSExe.flash(ele_canon, driver);
				//Test_JSExe.safeJavaScriptClick();
				
			}
		}
	}

	// Highlight the elements
	public static void flash(WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 50; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

		}

	}

	// method to scroll
	public static void scrolltoElement(WebElement ScrolltoThisElement) {
		Coordinates coordinate = ((Locatable) ScrolltoThisElement).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
	}

	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}

	// method to highlight
	// public static void highlightelement(WebElement element) {
	// for (int i = 0; i < 4; i++) {
	// JavascriptExecutor js = ((JavascriptExecutor) driver);
	// js.executeScript(“arguments[0].setAttribute(‘style’, arguments[1]);”,
	// element, “color: yellow; border: 4px solid blue;”);
	// js.executeScript(“arguments[0].setAttribute(‘style’, arguments[1]);”,
	// element, “”);
	// }
	// }
}
