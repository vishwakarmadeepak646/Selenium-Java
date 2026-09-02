package day37;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInAndZoomOut {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().window().minimize();
		
		driver.get("https://google.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(2000);
		js.executeScript("document.body.style.zoom='50%'");
		
		Thread.sleep(2000);
		js.executeScript("document.body.style.zoom='80%'");
		
		
	}
}
