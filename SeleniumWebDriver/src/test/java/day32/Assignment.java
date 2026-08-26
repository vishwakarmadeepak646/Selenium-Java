package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Select from = new Select(driver.findElement(By.name("fromPort")));
		from.selectByIndex(0);
		
		Select to = new Select(driver.findElement(By.name("toPort")));
		to.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
	}
}
