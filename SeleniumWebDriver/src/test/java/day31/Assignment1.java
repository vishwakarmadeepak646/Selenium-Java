package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	public static void main(String[] args)  throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("country-list")).click();
		driver.findElement(By.xpath("//option[@value=3]")).click();
		
	    List<WebElement> options =driver.findElements(By.xpath("//select[@id='country-list']/option"));
	    System.out.println(options.size());
	    
	    for(WebElement op : options) {
	    	System.out.println(op.getText());
	    }
		
		
		
		Thread.sleep(4000);
		driver.quit();
	}

}
