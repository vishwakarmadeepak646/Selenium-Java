package day21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Session_22_assignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		
//		List<WebElement> linksCount =  driver.findElements(By.tagName("img"));
//		System.out.println("Links counts : " + linksCount.size());
		
		driver.findElement(By.partialLinkText("Con")).click();
		
		driver.quit();
	}
}
