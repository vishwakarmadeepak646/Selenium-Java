package day_28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set windowsID = driver.getWindowHandles();
		
		List<String> windIds = new ArrayList(windowsID);
		String parentId = windIds.get(0);
		String childId = windIds.get(1);
		
		System.out.println(driver.getTitle());
		
		//switching to child window
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@class='nav-link'][normalize-space()='Pricing']")).click();
		
		// switching to parent window
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		driver.quit();
	}
}
