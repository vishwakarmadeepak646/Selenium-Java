package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement dropdown = driver.findElement(By.id("country"));
		Select s = new Select(dropdown);
		s.selectByValue("canada");
		
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='colors']/option"));
		System.out.println(options.size() + "\nSelected checkbox : ");
		
		for(WebElement op : options) {
			
			if(op.getText().equals("Red") || op.getText().equals("Yellow") || op.getText().equals("White")) {
				op.click();
				System.out.println(op.getText());
			}
			
		}
		
		Thread.sleep(4000);
		driver.quit();
	}

}
