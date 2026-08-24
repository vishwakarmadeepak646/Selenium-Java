package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.testmuai.com/selenium-playground/jquery-dropdown-search-demo/");
		driver.findElement(By.xpath("//select[@name='files']")).click();
		
		// 1) Select single checkbox
		
		driver.findElement(By.xpath("//optgroup[@label='Scripting languages']//option[2]")).click();
		
		// 2) capture all the checkbox and find out the size
		List<WebElement> options = driver.findElements(By.xpath("//optgroup//option"));
		System.out.println("Total number of options listed" + options.size());
		
		// 3) printing all options
		System.out.println("Options listed under dropdown : ");
		for(WebElement op : options) {
			System.out.println(op.getText());
		}
		
		
	}
}
