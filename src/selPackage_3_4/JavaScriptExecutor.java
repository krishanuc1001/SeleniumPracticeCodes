package selPackage_3_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id='gh-ac'][@placeholder='Search for anything']")).sendKeys("DSLR camera");
		driver.findElement(By.xpath("//*[@id='gh-btn'][@value='Search']")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<String> elements = new ArrayList<String>();

		List<WebElement> canon = driver.findElements(By.xpath("//h3[starts-with(.,'Canon')]"));

		Iterator<WebElement> itr = canon.iterator();
		while (itr.hasNext()) {
			WebElement ele = itr.next();
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,-60)");
			HighlightObject(driver, ele);
			Thread.sleep(1000);
		}

		//js.executeScript("arguments[0].click();", click_last);
		js.executeScript("alert('Search Done');");
		Thread.sleep(10000);
		driver.quit();

	}

	private static void HighlightObject(WebDriver driver, WebElement ele) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < 10; i++) {
			//js.executeScript("arguments[0].style.border='3px dotted blue'", sevenButton);
			js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px dotted red;');", ele);
			Thread.sleep(50);
			js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px dotted red;');", ele);
			Thread.sleep(50);
			js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px dotted red;');", ele);
			Thread.sleep(50);

		}

	}

}
