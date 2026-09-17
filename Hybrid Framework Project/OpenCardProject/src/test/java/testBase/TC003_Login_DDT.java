package testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import utilities.DataProviders;

public class TC003_Login_DDT extends BaseClass {

	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void loginDDT(String email, String pass, String exp) {
		
		try {
		logger.info("***********Execution started for TC003_Login_DDT ************");
		// Home Page
		logger.info("Clicking on MyAccount and Login");
		HomePage h = new HomePage(driver);
		h.clickMyAccount();
		h.clickLogin();

		// Login Page
		logger.info("Entering credentials");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pass);
		logger.info("Click on Login button");
		lp.clickLogin_btn();

		// My Account page
		MyAccount ac = new MyAccount(driver);
		boolean exptectVal = ac.isMyAccountDisplayed();
				
		/*
		 * Data is valid - login success - test pass - logout Data is valid 
		 *                               - login failed - test fail
		 * 
		 * Data is invalid - login success - test fail - logout Data is invalid 
		 *                                 - login failed - test pass
		 */
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(exptectVal==true) {
				ac.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(exptectVal==true) {
				ac.clickLogout();
				Assert.fail();
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e){
			Assert.fail();
		}
		logger.info("***********Execution Finished for TC003_Login_DDT ************");
	}
}