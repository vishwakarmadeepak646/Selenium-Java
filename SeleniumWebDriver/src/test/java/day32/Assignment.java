package day32;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		
		
		// Get all prices
		Long[] prices = new Long[5];
		for (int p = 1; p <= 5; p++) {
		
			String price= driver.findElement(By.xpath("//table[@class='table']//tr["+p+"]//td[6]")).getText();
			
			price = price.replace("$", "").trim();
			price = price.split("\\.")[0];
			prices[p-1] = Long.parseLong(price);
		}
		
		for(Long p : prices) {
			System.out.println(p);
		}
		Arrays.sort(prices);
		System.out.println("Lowest Prices : " + prices[0]);
		
		driver.findElement(By.xpath("(//input[@value='Choose This Flight'])[3]")).click();
		
		String msg  = driver.findElement(By.xpath("//div[@class='container']//h2")).getText();
		System.out.println(msg);
		
		
		
	}
}
