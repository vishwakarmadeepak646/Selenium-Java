package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleFileUpload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("D:\\Interview Questions\\Mongo_Text_Queries.txt");
		
		String msg = driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText();
		
		if(msg.equals("Mongo_Text_Queries.txt")) {
			System.out.println("File uploaded successfully");
		}else {
			System.out.println("Upload failed...");
		}
	}
}
