package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethod {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(6000);
		
		// isDisplayed()
		WebElement elmt = driver.findElement(By.cssSelector("img[alt='company-branding']"));
		System.out.println("Is Displayed()  : " + elmt.isDisplayed());
		
		Boolean b = driver.findElement(By.cssSelector("img[alt='company-branding']")).isDisplayed(); // This is also correct
	
		
		//isEnabled()
		Boolean element = driver.findElement(By.cssSelector("*[placeholder=\"Username\"]")).isEnabled();
		System.out.println("Is Enabled() : " + element);
		
		driver.quit();
	}

}
