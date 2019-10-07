package selenium_JavaScriptExec;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSE_highlightElement {

	public static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_9\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		WebElement uname = driver.findElement(By.id("email"));
		uname.sendKeys("bs222093@gmail.com");
		JSE_highlightElement.highlightField(driver, uname);

		WebElement pword = driver.findElement(By.id("pass"));
		pword.sendKeys("senorita");
		JSE_highlightElement.highlightField(driver, pword);

		driver.quit();
	}

	public static void highlightField(WebDriver driver, WebElement element) {

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		 try {
		 Thread.sleep(1000);
		 } catch (InterruptedException e) {
		
		 System.out.println(e.getMessage());
		 }

		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','border: solid 2px white');",
				element);
	}
}
