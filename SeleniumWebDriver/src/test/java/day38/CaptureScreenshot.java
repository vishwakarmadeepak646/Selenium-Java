package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		
		// 1) Takes Full Page Screenshot Using TakesScreenshot Interface
		/*
		 * TakesScreenshot ts = (TakesScreenshot) driver; File sourceFile =
		 * ts.getScreenshotAs(OutputType.FILE);
		 * 
		 * // D:\Selenium Workspace\SeleniumWebDriver\Screenshots File targetFile = new
		 * File(System.getProperty("user.dir") + "\\Screenshots\\FirstSS.png");
		 * sourceFile.renameTo(targetFile); // copy sourceFile into targetFile
		 */
		
		
		// 2) Takes Specific page Screenshot usign WebElement Interface
		
		WebElement specificArea = driver.findElement(By.xpath("//form[@id=\'basicBootstrapForm\']"));
		
		File sourceFile = specificArea.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir" )+  "\\Screenshots\\Specific.png");
		sourceFile.renameTo(targetFile);
		
		
		// 3) Capture Screenshot of any WebElement
		WebElement element = driver.findElement(By.xpath("//div[@class='col-sm-8 col-xs-8 col-md-8']"));
		
		File sourceSS = element.getScreenshotAs(OutputType.FILE);
		File targetSS = new File(System.getProperty("user.dir") + "\\Screenshots\\ElementSS.png");
		sourceSS.renameTo(targetSS);
		
		
		
		driver.quit();
		
	}
}
