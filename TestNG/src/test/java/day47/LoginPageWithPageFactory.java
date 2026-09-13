package day47;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory {

	WebDriver driver;

	// Constructor

	LoginPageWithPageFactory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);  // as we did not use driver.findElement in below code, So this method driver applied to every method internally
	}											// This method used to initiate all the element in class. It is mandatory.		
	
	// Locators
	@FindBy(how=How.XPATH, using="//input[@placeholder='Username']") WebElement txt_username_loc; // how, using ---> Keyword , HOW--> Class (Another way to specify locator)
	
//	@FindBy(xpath=("//input[@placeholder='Username']")) WebElement txt_username_loc ;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement txt_password_loc;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btnElement;
	
	@FindBy(tagName="a") List<WebElement> links; // to fatch multiple elements as we did in findByElements();
	
	//Action methods
	
	public void setUsername(String user) {
		
		txt_username_loc.sendKeys(user);
	}
	
	public void setPassword(String password) {
		txt_password_loc.sendKeys("admin123");
	}
	
	public void clickLogin() {
		btnElement.click();
	}
	


	
}
