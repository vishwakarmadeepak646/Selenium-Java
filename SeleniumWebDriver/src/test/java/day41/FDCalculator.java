package day41;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("file:/C:/Users/Asus/Downloads/SBI_FD_Selenium_Practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String file = System.getProperty("user.dir") + "\\testdata\\Caldata.xlsx";
		System.out.println("File path : " + file);
		int rowCount = ExcelUtils.getRowCount(file, "Interest Data");
		
		System.out.println("Row count : " + rowCount);
		
		for (int i = 1; i <=rowCount ; i++) {
		
		driver.findElement(By.xpath("//button[@id='clear']")).click();
				
		// 1) Read data from excel
		String pri	=	ExcelUtils.getCellData(file, "Interest Data", i, 0);
		String roi =ExcelUtils.getCellData(file, "Interest Data", i, 1);
		String time = ExcelUtils.getCellData(file, "Interest Data", i, 2);
		String period = ExcelUtils.getCellData(file, "Interest Data", i, 3);
		String freq = ExcelUtils.getCellData(file, "Interest Data", i, 4);
		
		// 2) pass above data to application
		
		driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pri);
		driver.findElement(By.xpath("//input[@id='rate']")).sendKeys(roi);
		driver.findElement(By.xpath("//input[@id='period']")).sendKeys(time);
		
		Select s1 = new Select(driver.findElement(By.xpath("//select[@id='periodUnit']")));
		s1.selectByVisibleText(period);
		
		Select s2 = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
		s2.selectByVisibleText(freq);
		
		driver.findElement(By.xpath("//button[@id='calculate']")).click();
		
		
		// 3) Validation
		
		String MaturityVal = ExcelUtils.getCellData(file, "Interest Data", i, 5);
		
		String currVal = driver.findElement(By.xpath("//span[@id=\"maturityValue\"]")).getText();
		
		
		
		if(Double.parseDouble(currVal)== Double.parseDouble(MaturityVal)) {
			System.out.println("Test Passed...");
			ExcelUtils.setCellData(file, "Interest Data", i, 7, "Passed");
			ExcelUtils.fillGreenColor(file, "Interest Data", i, 7);
		}else {
			System.out.println("Failed ...");
			ExcelUtils.setCellData(file, "Interest Data", i, 7, "Failed");
			ExcelUtils.fillRedColor(file, "Interest Data", i, 7);
		}
		
			}
		driver.quit();
		}
		
	
}
