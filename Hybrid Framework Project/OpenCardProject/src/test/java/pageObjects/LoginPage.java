package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email") WebElement emailid;
	@FindBy(id="input-password") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	
	public void setEmail(String email) {
		emailid.sendKeys(email);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickLogin_btn() {
		loginButton.click();
	}
}
