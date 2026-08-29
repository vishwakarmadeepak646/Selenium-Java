package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		//Selecting month and Year from date picker using drop-down
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		String day = "23";
		
		//selecting year
		Select yeardrop = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		
		yeardrop.selectByValue("2028");
		
		Select monthdrop = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		monthdrop.selectByVisibleText("Mar");
		
		List<WebElement> daylist = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
		
		for(WebElement d : daylist) {
			
			if(d.getText().equals(day)){
				d.click();
				break;
			}
		}
		
		
	}

}
