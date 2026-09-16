package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "input-firstname")
	WebElement txtfirstName;
	@FindBy(id = "input-lastname")
	WebElement txtlastName;
	@FindBy(id = "input-email")
	WebElement txtemail;
	@FindBy(id = "input-telephone")
	WebElement txttelephone;
	@FindBy(id = "input-password")
	WebElement txtpassword;
	@FindBy(id = "input-confirm")
	WebElement txtcnfPassword;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement chkPolicy;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement textVerify;

	public void setFirstName(String fName) {
		txtfirstName.sendKeys(fName);
	}

	public void setLastName(String lastname) {
		txtlastName.sendKeys(lastname);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setTelephone(String mob) {
		txttelephone.sendKeys(mob);
	}

	public void setPassword(String pass) {
		txtpassword.sendKeys(pass);
	}

	public void setCnfPassword(String cnfpass) {
		txtcnfPassword.sendKeys(cnfpass);
	}

	public void clickPolicy() {
		chkPolicy.click();
	}

	public void clickSubmt() {
		btnSubmit.click();
	}

	public String compareSuccessText() {
		try {
			return textVerify.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
