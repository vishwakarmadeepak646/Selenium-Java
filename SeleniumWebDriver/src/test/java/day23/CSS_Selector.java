package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Selector {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		// tag and Id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Mobile");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Mobile"); // As tag name is optional
		
		// tag class
		driver.findElement(By.cssSelector("")).click();
		
		// tag attribute
		//driver.findElement(By.cssSelector("img[title='iPhone']")).click();
		//driver.findElement(By.cssSelector("[title='iPhone']")).click();
		
		//tag class attribute
	//	driver.findElement(By.cssSelector("img.img-responsive[title='MacBook']")).click();
	//	driver.findElement(By.cssSelector(".img-responsive[title='MacBook']")).click();
		
		driver.quit();
	}

}
