package day39;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://shop.polymer-project.org/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		// This Element is inside 2 nested shadow DOM.

		SearchContext shadow = driver.findElement(By.cssSelector("shop-app[page='home']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("a[href='/list/mens_outerwear']")).click();

	}
}
