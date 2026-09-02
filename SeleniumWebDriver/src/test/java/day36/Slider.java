package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		Actions action = new Actions(driver);
		
		// Min Slide
		WebElement minSlider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
		System.out.println(minSlider.getLocation());  // To get Location of Min Slider (59, 246)
	//	System.out.println(minSlider.getLocation().getX()); // This will print X-Access location // 59
	//	System.out.println("Location of Min Slider Before: " + minSlider.getLocation().getY()); // This will print Y-Access location // 246
		
		action.dragAndDropBy(minSlider, 100, 246).perform(); // It will add 100 points in X-Access
		System.out.println("Location of Min Slider After Moving: " + minSlider.getLocation()); // 159,246
		
		
		System.out.println("--------------------------------");
		// Max Slider
		WebElement maxSlider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][2]"));
		
		System.out.println("Location of Min Slider : " + maxSlider.getLocation()); // (613, 246)
		action.dragAndDropBy(maxSlider, -300, 246).perform(); // 100 Kam kr dega
		System.out.println( "Location of Max Slider : " +maxSlider.getLocation());
		
	}
}
