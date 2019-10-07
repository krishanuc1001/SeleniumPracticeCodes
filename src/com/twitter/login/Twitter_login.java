package com.twitter.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Twitter_login {


	static WebDriver driver;

	//Log in
	@BeforeMethod
	public void loginMethod() 
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_3_3\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twitter.com");

		driver.manage().window().maximize();	

		driver.findElement(By.xpath(".//*[text()='Log in']")).click();
		driver.findElement(By.xpath(".//input[@placeholder='Phone, email or username']")).sendKeys("bs222093@gmail.com");
		driver.findElement(By.xpath(".//input[@placeholder='Password'][@class='js-password-field']")).sendKeys("senorita");
		driver.findElement(By.xpath(".//button[text()='Log in']")).click();
	}

	@AfterMethod
	public void logoutMethod() {
		driver.findElement(By.xpath(".//a[@id='user-dropdown-toggle'][@class='btn js-tooltip settings dropdown-toggle js-dropdown-toggle']")).click();
		driver.findElement(By.xpath(".//*[@id='signout-button']/button[@class='dropdown-link'][text()='Log out']")).click();
	}

	public static void searchPotus() {

		driver.findElement(By.xpath(".//input[@id='search-query'][@class='search-input']")).sendKeys("POTUS");
		driver.findElement(By.xpath(".//button[@class='Icon Icon--medium Icon--search nav-search']")).click();
	}

	@Test
	public void Search_Verify() {	

		//		WebElement num_following = driver.findElement(By.xpath(".//*[@id='page-container']/div[1]/div[1]/div/div[3]/ul/li[2]/a/span[2]"));
		//
		//		Actions action = new Actions(driver);
		//		action.moveToElement(num_following).click();
		//
		//		if (num_following.getText() == "1") {
		//
		//			driver.findElement(By.xpath(".//*[@id='page-container']/div[1]/div[1]/div/div[3]/ul/li[2]/a/span[2][@class='ProfileCardStats-statValue']")).click();
		//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//			driver.findElement(By.xpath(".//*[@id='stream-item-user-822215679726100480']/div/div/div[1]/div/div/div/span[2]")).click();
		//
		//			//driver.findElement(By.xpath(".//*[@id='stream-item-user-822215679726100480']/div/div/div[2]/span/a/span/b[@class='u-linkComplex-target'][text()='POTUS']")).click();
		//			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		//			Twitter_login.searchPotus();
		//			WebDriverWait wait = new WebDriverWait(driver, 10);
		//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='stream-item-user-822215679726100480']/div/div/div[1]/div/div/div/span[2]/button[1]")));
		//
		//			driver.findElement(By.xpath(".//*[@id='stream-item-user-822215679726100480']/div/div/div[1]/div/div/div/span[2]/button[1]")).click();
		//
		//			WebElement status = driver.findElement(By.xpath(".//*[@id='stream-item-user-822215679726100480']/div/div/div[1]/div/div/div/span[2]/button[2]"));
		//			System.out.println(status.getText());
		//
		//			//Validating whether we are following
		//
		//			if (status.getText().contains("Following Following"))
		//			{
		//				System.out.println("<<======VERIFICATION PASSED========>>");
		//			}	
		//			else
		//			{
		//				System.out.println("<<======VERIFICATION FAILED========>>");
		//			}		
		//		}
		//		else {

		//Search for POTUS
		Twitter_login.searchPotus();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='stream-item-user-822215679726100480']/div/div/div[1]/div/div/div/span[2]/button[1]")));

		driver.findElement(By.xpath(".//*[@id='stream-item-user-822215679726100480']/div/div/div[1]/div/div/div/span[2]/button[1]")).click();

		WebElement status = driver.findElement(By.xpath(".//*[@id='stream-item-user-822215679726100480']/div/div/div[1]/div/div/div/span[2]/button[2]"));
		System.out.println(status.getText());

		//Validating whether we are following

		if (status.getText().contains("Following Following"))
		{
			System.out.println("<<======VERIFICATION PASSED========>>");
		}	
		else
		{
			System.out.println("<<======VERIFICATION FAILED========>>");
		}

		//		Assert.assertEquals(status.getAttribute("innerHTML"), "There is no Following button");

		//		SoftAssert assertObj = new SoftAssert();
		//		System.out.println("Verification started");
		//
		//		//String actualPageSource = driver.getPageSource();
		//
		//		//System.out.println(actualPageSource);
		//
		//		assertObj.assertTrue(assertObj.contains(""));
		//		Assert.assertTrue(actualPageSource.contains("Cleartrip"));
		//		System.out.println("Verification finished");
		//		assertObj.assertAll();

	}
}