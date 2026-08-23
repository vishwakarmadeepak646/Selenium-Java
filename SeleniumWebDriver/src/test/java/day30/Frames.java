package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Argument;

public class Frames {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']")); // Extract webElement
		driver.switchTo().frame(frame1); // pass frame as a webElement | switch to frame 1
		driver.findElement(By.name("mytext1")).sendKeys("Frame - 1");

		driver.switchTo().defaultContent(); // go back to default content

		// Frame 2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.name("mytext2")).sendKeys("Frame-2");

		driver.switchTo().defaultContent(); // go back to default page.

		// Frame 3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.name("mytext3")).sendKeys("Frame-3");

		driver.switchTo().frame(0); // Switch to inner frame of Frame-3 using index

		driver.findElement(By.xpath("//div[@id='i6']//div[@class='vd3tt']")).click();
		
	//	driver.findElement(By.xpath("//div[@id='i21']//div[@class='rq8Mwb']")).click(); // Inside Inner frame we can't click directly some elements so use JSExecutor to do that
		
		WebElement checkbox =  driver.findElement(By.xpath("//div[@id='i21']//div[@class='rq8Mwb']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", checkbox);

		driver.switchTo().defaultContent(); // go back to default content
		
		Thread.sleep(3000);
		driver.quit();

	}
}
