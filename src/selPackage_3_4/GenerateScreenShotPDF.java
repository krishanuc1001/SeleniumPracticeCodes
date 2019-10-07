package selPackage_3_4;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateScreenShotPDF {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium\\Selenium Drivers\\chromedriver_win32_2_4.1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");

		// Capture screenshot and store it in byte[] array format
		byte[] input = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Document document = new Document();
		String output = "E:\\Selenium\\GeneratedScreenshotsInPDF\\" + "Image_" + getCurrentDateTime() + ".pdf";
		FileOutputStream fos = new FileOutputStream(output);

		// Instantiate the PDF writer
		PdfWriter writer = PdfWriter.getInstance(document, fos);

		// open the pdf for writing
		writer.open();
		document.open();

		// process content into image
		Image im = Image.getInstance(input);

		// set the size of the image
		im.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight() / 2);

		// add the captured image to PDF
		document.add(im);
		document.add(new Paragraph(" "));

		// close the files and write to local system
		document.close();
		writer.close();

		driver.quit();
	}

	public static String getCurrentDateTime() {
		DateFormat df = new SimpleDateFormat("YYYY_MMM_dd HH_MM_SS");
		Date d = new Date();
		String date_time = df.format(d);
		return date_time;
	}

}
