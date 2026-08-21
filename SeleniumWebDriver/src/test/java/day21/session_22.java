package day21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class session_22 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	//	driver.findElement(By.name("search")).sendKeys("Iphone");
	//	driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
	//	Boolean isDisplay = driver.findElement(By.id("logo")).isDisplayed();
	//	System.out.println("Logo Displayed ? :" + isDisplay);
		
		// LinkText and partialLinkText
		//driver.findElement(By.linkText("Desktops")).click();
		// driver.findElement(By.partialLinkText("Desk")).click();
		
	//	WebElement emt =  driver.findElement(By.xpath("//ul[@class='list-inline']/descendant::span[1]"));
	//	System.out.println(emt);//*[@id="top-links"]/ul/li[1]/span
		
	//	List<WebElement> count =  driver.findElements(By.className("//ul[@class='list-inline")); 
	//	System.out.println("Count of Header elements  : " + count.size());  // Need to check once
		
//		List<WebElement> count = driver.findElements(By.tagName("a"));
//		System.out.println("a/link count on WebPage : " + count.size());
		
		List<WebElement> count = driver.findElements(By.tagName("img"));
		System.out.println("a/link count on WebPage : " + count.size());
		
		driver.quit();

	}

}
