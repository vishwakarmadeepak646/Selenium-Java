package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
	//	ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement box1 = driver.findElement(By.xpath("//input[@id='name']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver; //		JavascriptExecutor js = driver;
		
		// passing the text into textbox alternative of SendKeys("Deepak");
		js.executeScript("arguments[0].setAttribute('value','Deepak')", box1);
		
		WebElement radio = driver.findElement(By.id("male"));
		
		js.executeScript("arguments[0].click()", radio);
				
		
	}
}
