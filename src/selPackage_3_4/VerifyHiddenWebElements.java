package selPackage_3_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyHiddenWebElements {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_3\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
		
		driver.manage().window().maximize();
		
		//Any hidden webelements X nad Y co-ordinate is 0,0.
		
//		int x = driver.findElement(By.id("male")).getLocation().getX();
//		int y = driver.findElement(By.id("male")).getLocation().getY();
//		
//		System.out.println("X,Y" + "==========>>>" + x + "," + y); 
//		//Output: X,Y==========>>>0,0
		
		List<WebElement> ele = driver.findElements(By.id("male"));
		
		for (int i=0; i<ele.size(); i++)
		{
			if (ele.get(i).getLocation().getX() != 0 && ele.get(i).getLocation().getY() != 0)
			{
				ele.get(i).click();
				break;
			}
		}
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.quit();
	}

}
