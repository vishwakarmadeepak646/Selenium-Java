package day41;

import java.io.FileInputStream;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		// Inside your main method, before clicking the dropdown:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
		    // Note: Verify the exact locator for the accept button on the actual site. 
		    // Many sites use "onetrust-accept-btn-handler" for the ot-sdk banners.
		    WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
		    acceptCookies.click();
		} catch (Exception e) {
		    System.out.println("No cookie banner displayed.");
		}

		String file = System.getProperty("user.dir") + "\\testdata\\Deposit_Data.xlsx";

		int rowCount = ExcelUtils.getRowCount(file, "Deposit Data");

		for (int i = 1; i < rowCount; i++) {

			String deposit = ExcelUtils.getCellData(file, "Deposit Data", i, 0);
			String length = ExcelUtils.getCellData(file, "Deposit Data", i, 1);
			String rate = ExcelUtils.getCellData(file, "Deposit Data", i, 2);
			String compounding = ExcelUtils.getCellData(file, "Deposit Data", i, 3);
			String total = ExcelUtils.getCellData(file, "Deposit Data", i, 4);

			WebElement amt = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			amt.clear();
			amt.sendKeys(deposit);

			WebElement lnt = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			lnt.clear();
			lnt.sendKeys(length);

			WebElement apy = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			apy.clear();
			apy.sendKeys(rate);

			//dropdown
			driver.findElement(By.xpath("//div[@id='mat-select-value-0']")).click(); // //mat-select[@id='mat-select-0']
			driver.findElement(By.xpath("//mat-option[@id='mat-option-1']")).click();

			// button
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();

			String currVal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			// 1. Remove the '$' and any commas before converting to Double
			String cleanDeposit = deposit.replace("$", "").replace(",", "");
			String cleanTotal = total.replace("$", "").replace(",", "");
			
			System.out.println(currVal);
			if (Double.parseDouble(cleanDeposit) == Double.parseDouble(cleanTotal)) {
				System.out.println("Passed");
				ExcelUtils.setCellData(file, "Deposit Data", i, 6, "Passed");
			} else {
				System.out.println("Failed");
				ExcelUtils.setCellData(file, "Deposit Data", i, 6, "Passed");
			}

		}
	}

}
