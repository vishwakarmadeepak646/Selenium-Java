package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	// Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By txt_username_loc = By.xpath("//input[@placeholder='Username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Username']");
	By btn_login_loc = By.xpath("//button[normalize-space()='Login']");

	
	// Action methods

	public void setUsername(String user) {

		driver.findElement(txt_username_loc).sendKeys(user);
	}

	public void setPassword(String password) {

		driver.findElement(txt_password_loc).sendKeys(password);
	}

	public void clickLogin() {

		driver.findElement(btn_login_loc).click();
	}
}
