package selPackage_3_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iFramesHandling {

	public WebDriver driver;

	@Test(priority = 1, description = "Idenfying frame using Name or Id")
	public void testFramesUsingNameID() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("E:\\Selenium\\myiFramesHTML.html");

		int numOfIFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The number of iframes in the page is: " + numOfIFrames);

		// Switching to first iFrame using name
		driver.switchTo().frame("automation");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"sendx-close-dNnOns5gBj56SFGkOimE4p\"]")).click();

		driver.findElement(By.xpath(
				"//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[1]/div/div[2]/a[2][@class='fusion-icon fusion-icon-search']"))
				.click();

		// Switching to parent frame
		driver.switchTo().parentFrame();

		// Switching to second iFrame using id
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//*[@id=\"gsc-i-id1\"]")).sendKeys("JAVA");
		driver.findElement(By.xpath(
				"//*[@id=\"___gcse_0\"]/div/div/form/table/tbody/tr/td[2]/button[@class='gsc-search-button gsc-search-button-v2']"))
				.click();

		// Switching to parent frame
		driver.switchTo().parentFrame();

		driver.findElement(By.xpath("/html/body/a")).click();

	}

	@Test(priority = 2, description = "Idenfying frame using WebElement")
	public void testFramesUsingWebElement() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("E:\\Selenium\\myiFramesHTML.html");

		int numOfIFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The number of iframes in the page is: " + numOfIFrames);

		// Switching to Third iFrame using WebElement
		WebElement frame_ele = driver.findElement(By.xpath("//iframe[@title='selenium']"));
		driver.switchTo().frame(frame_ele);

		driver.findElement(By.xpath("//*[@id=\"menu_projects\"]/a[@title='Selenium Projects']")).click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Switching to parent frame
		driver.switchTo().parentFrame();

		driver.findElement(By.xpath("/html/body/a")).click();

	}
}