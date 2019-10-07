package selPackage_3_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicRadioAndCheckbox {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> radiobuttons = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
		for (int i=0; i< radiobuttons.size(); i++)
		{
			WebElement radiobuttons_value = radiobuttons.get(i);
			String actualRadioButtonValues = radiobuttons_value.getAttribute("value");

			System.out.println("Values of the Radio button are >>>>> " + actualRadioButtonValues);

			if (actualRadioButtonValues.contentEquals("RUBY"))
			{
				radiobuttons_value.click();
				break;
			}
		}


		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int j=0; j< checkboxes.size(); j++ )
		{
			WebElement checkboxes_value = checkboxes.get(j);
			String actualCheckboxesValue = checkboxes_value.getAttribute("id");

			System.out.println("Values of the Checkboxes are >>>>> " + actualCheckboxesValue);

			if (actualCheckboxesValue.equalsIgnoreCase("code"))
			{
				checkboxes_value.click();
				break;
			}
		}


	}

}
