package selPackage_3_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class BootstrapDropdown {


	public static void main(String[] args) {

		/* System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Selenium Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); */

		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='menu1']"));


		//First way to handle Bootstrap dropdowns, using traditional For loop
		/* List<WebElement> dropdownmenu = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));

		for (int i=0; i<dropdownmenu.size(); i++)
		{

			WebElement dropdownmenu_value = dropdownmenu.get(i);

			String innerHTML = dropdownmenu_value.getAttribute ("innerHTML");

			if (innerHTML.contentEquals("JavaScript"))
			{
				dropdownmenu_value.click();
				break;
			} 
			System.out.println("Values from the Dropdown is: " + innerHTML);

		} */

		//First way to handle Bootstrap dropdowns, using Enhanced For loop
		List<WebElement> dropdownmenu = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
		
		for (WebElement dropdownmenu_value: dropdownmenu)
		{
			//WebElement dropdownmenu_value = dropdownmenu.get(i);
			String innerHTML = dropdownmenu_value.getAttribute ("innerHTML");

			if (innerHTML.contentEquals("JavaScript"))
			{
				dropdownmenu_value.click();
				break;
			} 
			System.out.println("Values from the Dropdown is: " + innerHTML);

		}

		//driver.quit();

	}

}
