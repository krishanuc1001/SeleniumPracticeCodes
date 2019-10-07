package selPackage_3_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.ElementNotInteractableException;

public class Selenium {

	public static void main(String[] args) {
		        
		
		//ChromeDriver Instantiation
		//System.setProperty("webdriver.chrome.driver","E://Selenium//Selenium Drivers//chromedriver_win32//chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

		//HTMLUnitDriver Instantiation
		//HtmlUnitDriver driver = new HtmlUnitDriver();

		//InternerExplorerDriver Instantiation
		//System.setProperty("webdriver.ie.driver", "E://Selenium//Selenium Drivers//IEDriverServer_x64_3.3.0//IEDriverServer.exe");
		//WebDriver driver= new InternetExplorerDriver();


		//FirefoxDriver Instantiation
		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\Selenium Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");

		driver.manage().window().maximize();
        
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//For entering value in a Text box, we have to use sendKeys() method
		driver.findElement(By.xpath(".//*[@id='u_0_2']")).sendKeys("Krish");
		driver.findElement(By.xpath(".//*[@id='u_0_4']")).sendKeys("Chak");
        driver.findElement(By.xpath(".//*[@id='u_0_7']")).sendKeys("8013220218");
        driver.findElement(By.xpath(".//*[@id='u_0_e']")).sendKeys("alover1001");
        
		//For clicking on RadioButtons, Buttons, CheckBox & Links, we have to use click() method
		driver.findElement(By.xpath(".//*[@id='u_0_i']")).click(); //Clicking on Male radio button
		
        //For handling Dropdowns, we have a class called Select class
		Select dayDropdown = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
		dayDropdown.selectByIndex(10); //Using .selectByIndex(int arg0) 
		
		Select monthDropdown = new Select(driver.findElement(By.xpath(".//*[@id='month']")));
		monthDropdown.selectByVisibleText("Jan"); //Using .selectByVisibleText(String arg0)
		
		Select yearDropdown = new Select(driver.findElement(By.xpath(".//*[@id='year']")));
		yearDropdown.selectByValue("1991");   //Using .selectByValue(String arg0)
		
		driver.findElement(By.xpath(".//*[@id='u_0_m']")).click(); //Clicking on Create Account button
		
        driver.quit();
			
	}

}
