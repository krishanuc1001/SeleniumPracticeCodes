package selPackage_3_4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Screenshot {

	WebDriver driver;

	@Test
	public void failScreenshot() throws Exception {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("C:\\Users\\Krishanu\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\rx58w8af.Krishanu");

		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\Selenium Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(myprofile);
		driver.get("http://www.cleartrip.com");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//driver.findElement(By.cssSelector(".flightApp>a")).click();
		//driver.findElement(By.xpath("//a[@href='/flights'][@title='Flights']")).click();
		//driver.findElement(By.xpath(".//*[@id='Home']/div/div/ul/li/div/div[2]/aside[1]/nav/ul[1]/li[1]/a[1]")).click();
		driver.findElement(By.xpath(".//*[@id='Home']/div/div/ul/li/div/div[2]/aside[1]/nav/ul[1]/li[1]/a[1].dhdhhh")).click(); //Provided wrong xpath purposefully to check Screenshot on failure

		driver.findElement(By.xpath(".//*[@id='OneWay']")).click();
		//driver.findElement(By.xpath(".//*[@id='OneWay1']")).click(); //Provided wrong xpath purposefully to check Screenshot on failure 

		//library.Utility.captureScreenshot(driver, "Clicked On One way Radio button");

		driver.findElement(By.xpath(".//*[@id='FromTag']")).sendKeys("Kolkata, IN - Netaji Subhas Chandra Bose Airport (CCU)");

		//library.Utility.captureScreenshot(driver, "Entered the Origin");

		driver.findElement(By.xpath(".//*[@id='ToTag']")).sendKeys("Pune, IN - Lohegaon (PNQ)");

		//library.Utility.captureScreenshot(driver, "Entered the Destination");

		//Taking a screenshot
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File ("./Screenshots/CleartipShot1.png"));
		System.out.println("First Screenshot taken"); */

		//Taking a screenshot by calling the Static method captureScreenshot
		//library.Utility.captureScreenshot(driver, "Clicked On One way Radio button");

		driver.findElement(By.xpath(".//*[@id='ORtrip']/section[2]/div[1]/dl/dd/div/a/i")).click();

		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[2]/a")).click(); //18th July 2017
		//driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[5]/a")).click(); //21st July 2017


		WebElement adtDD = driver.findElement(By.xpath(".//*[@id='Adults']"));
		Select adult = new Select(adtDD);
		adult.selectByVisibleText("2");


		WebElement chdDD = driver.findElement(By.cssSelector("#Childrens[class='span span15']"));
		Select children = new Select(chdDD);
		children.selectByValue("1");

		// It checks whether the required value is selected or not
		/* WebElement getAdtVal = adult.getFirstSelectedOption();
		//System.out.println("This returns the value after selecting the dropdown" + getAdtVal); */

		// To check whether the number of values in a dropdown is correct or not. Say, for a Month it should be 12 values. 
		/* List<WebElement> adultList = adult.getOptions();
		int total_adts = adultList.size();
		System.out.println("The number of adult that can be added is: " + total_adts); */

		driver.findElement(By.xpath(".//*[@id='SearchBtn']")).click();

		Thread.sleep(5000);

		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.xpath(".//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[3]/table/tbody[2]/tr[2]/td[3]/button")).click();

		//driver.quit();

	}


	@AfterMethod
	public void demoMethod (ITestResult result)

	{
		if (ITestResult.FAILURE == result.getStatus())
		{
			System.out.println("Screenshot has been taken");
			library.Utility.captureScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}

