package day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(3000);

		// 1) Normal alert with OK button

		// driver.switchTo().alert().accept();

		Alert alert = driver.switchTo().alert();

		String alerttext = alert.getText();
		System.out.println(alerttext);
		alert.accept();
		Thread.sleep(3000);

		// 2) Confirmation alert with OK and Cancel button
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		// driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();

		Thread.sleep(3000);
		// 3) Prompt alert - Input Box with OK and Cancel button

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert myalert = driver.switchTo().alert();
		myalert.sendKeys("Hello Alert"); // at run time this text will not appear but in Result you will see this text on screen
		myalert.accept();

		Thread.sleep(3000);
		driver.quit();
	}
}
