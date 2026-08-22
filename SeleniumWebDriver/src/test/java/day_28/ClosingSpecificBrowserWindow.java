package day_28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windId = driver.getWindowHandles();
		
		
		for(String id : windId) {
			
			String title = driver.switchTo().window(id).getTitle();
			System.out.println(title);
			
			if(title.equals("OrangeHRM")) {
				System.out.println("Closing window is :" + title + " " + id);
				driver.close();
				
			}
			
			
		}
	}
}
