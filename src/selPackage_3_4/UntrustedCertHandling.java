package selPackage_3_4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class UntrustedCertHandling {

	WebDriver driver;

//	@Test(priority = 1)
//	public void acceptSSLChrome() {
//
//		System.setProperty("webdriver.chrome.driver",
//				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
//
//		ChromeOptions options = new ChromeOptions();
//		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://www.cacert.org/");
//
//	}
//
//	@Test(priority = 2)
//	public void acceptSSLCertFirefox() {
//
//		System.setProperty("webdriver.gecko.driver",
//				"E:\\Selenium\\Selenium Drivers\\geckodriver-v0.23.0-win64\\geckodriver.exe");
//
//		FirefoxOptions options = new FirefoxOptions();
//		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//
//		driver = new FirefoxDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://www.cacert.org/");
//
//	}

	@Test(priority = 3)
	public void acceptSSLCertIE() {

		System.setProperty("webdriver.ie.driver",
				"E:\\Selenium\\Selenium Drivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.acceptInsecureCerts();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		InternetExplorerOptions options = new InternetExplorerOptions(cap);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		driver = new InternetExplorerDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.cacert.org/");

	}

}
