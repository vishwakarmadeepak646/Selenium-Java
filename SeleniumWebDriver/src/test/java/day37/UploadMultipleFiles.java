package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadMultipleFiles {

public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		String file1 = "D:\\Interview Questions\\Mongo_Text_Queries.txt";
		String file2 = "D:\\Interview Questions\\blank.txt";
		
		//add files here
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);
		
		int count = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
// 		1. 	Validation-1 : No. of files
		
		if(count == 2) {
			System.out.println("File uploaded successfully");
		}else {
			System.out.println("Upload failed...");
		}
		
		// 2. Validation-2 : Name of File
		
		String fileOne = driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText();
		String fileTwo = driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText();
		
		System.out.println(fileOne);
		System.out.println(fileTwo);
	}

}
