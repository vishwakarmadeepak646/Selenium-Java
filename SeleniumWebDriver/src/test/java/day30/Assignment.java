package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
	/*
	 * 'Assignment
	 * 
	 * https://ui.vision/demo/webtest/frames/ 1) switch to 5th frame 2) click on
	 * link - opens new iframe 3) switch to inner frame 4) check logo presence n
	 * inte inner frame.
	 */

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.name("mytext5")).sendKeys("Frame-5");
		driver.findElement(By.linkText("https://a9t9.com")).click();
		
		driver.findElement(By.linkText("OCR")).click();
		
		
	}
}
