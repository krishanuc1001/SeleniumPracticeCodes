package testSel;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing_flow {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		String message;
		// File file = new File("F:\\Selenium\\webdriver\\geckodriver.exe");
		// System.setProperty("webdriver.firefox.marionette", file.getAbsolutePath());
		//System.setProperty("webdriver.firefox.marionette","F:\\Selenium\\webdriver\\geckodriver.exe");

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("C:\\Users\\Krishanu\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\rx58w8af.Krishanu");

		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\Selenium Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(myprofile);

		// WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait mywaitvar= new WebDriverWait(driver,20);
		//driver.get("https://qa2.chilis.com/");
		driver.get("https://www.chilis.com/");

		driver.manage().window().maximize();
		//driver.findElement(By.id("DepartDate")).click();
		//xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[6]/a";
		//String blank= "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[1]/td[1]";
		//String one = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[1]/td[4]/span";
		driver.findElement(By.xpath("//*[@id='location-bar-select-location']")).click();
		driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys("7524");
		//Thread.sleep(1000);
		//mywaitvar
		System.out.println(driver.findElements(By.cssSelector(".aa-suggestion")).get(0).getText());
		System.out.println(driver.findElements(By.cssSelector(".aa-suggestion")).size());
		System.out.println(driver.findElements(By.cssSelector(".aa-suggestions")).get(0).getText());
		System.out.println(driver.findElements(By.cssSelector(".aa-suggestions")).size());
		mywaitvar.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".aa-suggestion")));
		// WebDriverWait(self.selenium, 10).until(lambda s: s.find_element(By.ID, loginbox).is_displayed())
		//mywaitvar.until(ExpectedConditions.elementToBeClickable(By.cssSelector("mini-cart-view-upsell"))).click();
		driver.findElements(By.cssSelector(".aa-suggestion")).get(0).click();
		driver.findElement(By.id("button-location-query"));
		//System.out.println(driver.findElements(By.cssSelector(".button.slim.details-btn")).get(2).getText());
		//System.out.println(driver.findElements(By.cssSelector(".button.slim.order-btn")).get(0).getText());
		driver.findElements(By.cssSelector(".button.slim.order-btn")).get(0).click();
		//driver.findElement(By.id("menu-category-image-craft-burgers")).click();
		driver.findElement(By.id("menu-category-image-sandwiches")).click();
		//System.out.println(driver.findElements(By.cssSelector(".button.slim.green.btn-menu-item")).size());
		driver.findElements(By.cssSelector(".button.slim.green.btn-menu-item")).get(0).click();
		List item = driver.findElements(By.className("detail-title"));
		if (item.size()>0)
		{
			//System.out.println(driver.findElement(By.className("detail-title")).getText());
			message = driver.findElement(By.className("detail-title")).getText();

		}
		driver.findElement(By.id("item-add-to-order")).click();

		//System.out.println(driver.findElements(By.id("mini-cart-view-upsell")).get(0).click());
		//driver.findElements(By.id("mini-cart-add-food")).get(0).click();
		//System.out.println("Size = "+driver.findElements(By.id("mini-cart-view-upsell")).get(0).getText());
		//driver.findElement(By.xpath("//*[@id='mini-cart-view-upsell']")).click();;
		//driver.findElement(By.xpath("//*[@id='mini-cart-view-upsell']")).click();;
		if (driver.findElements(By.id("mini-cart-view-upsell")).size()>0)
		{
			mywaitvar.until(ExpectedConditions.elementToBeClickable(By.id("mini-cart-view-upsell"))).click();
		}
		else
		{
			driver.findElement(By.cssSelector(".bag.js-bag")).click();
		}
		List<WebElement> ordereditems = driver.findElements(By.className("heading-secondary"));

		for (Iterator iterator = ordereditems.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());

		}
		System.out.println("abc");
		//driver.findElement(By.partialLinkText("Log In and Checkout")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Log In and Checkout')])[2]")).click();;
		//mywaitvar.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.small.ghost.cart-login-and-checkout-btn"))).click();
		//driver.findElement(By.cssSelector(".button.small.ghost.cart-login-and-checkout-btn")).click();
		//driver.findElement(By.cssSelector(".button.small.cart-checkout-guest-btn")).click();
		//driver.findElements(By.id("upsell-continue"));
		//driver.findElement(By.cssSelector(".button.small.ghost.cart-login-and-checkout-btn")).click();
		//zzdriver.findElement(By.id("first-name")).sendKeys("Preetam");
		//driver.findElement(By.id("last-name")).sendKeys("Mitra");
		//driver.findElement(By.id("contact-phone")).sendKeys("9876543210");
		//driver.findElement(By.id("email")).sendKeys("abc@gmail");
		System.out.println("efg");
		driver.findElement(By.cssSelector(".form-control.curbside-btn.no-curbside")).click();;
		System.out.println("efgq");
		driver.findElement(By.id("pickup-payment")).click();

		Select dropdown = new Select(driver.findElement(By.id("pickup-payment")));
		dropdown.selectByValue("online");
		driver.findElement(By.id("continue-to-payment")).click();




	}

}
