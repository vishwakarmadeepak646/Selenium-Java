package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://testautomationpractice.blogspot.com/");
		
		// 1. scroll down page by pixel number
	//	js.executeScript("window.scrollBy(0,1500)", "");
	//	System.out.println(js.executeScript("return window.pageYOffset;"));
		
		
	 //	 2. scroll the page till Element is visible on page
		WebElement element = driver.findElement(By.xpath("//div[@id='HTML8']//h2"));
		
	//	js.executeScript("arguments[0].scrollIntoView()", element);
	//	System.out.println(js.executeScript("return window.pageYOffset;")); // 2697.600
		
		// 3. Scroll page till end of doc or page
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;")); // 3318.399
		
		
		// 4. Scroll to intial position
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;")); // 3318
		
	}
}
