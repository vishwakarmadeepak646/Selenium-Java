package day44;

import org.testng.annotations.Test;

public class LoginTests {

	@Test(priority = 1, groups="sanity")
	void loginByFacebook() {
		System.out.println("This is login with Facebook");
	}
	@Test(priority = 2, groups="sanity")
	void loginByEmail() {
		System.out.println("This is login with Email");
	}
	
	@Test(priority = 3, groups="sanity")
	void loginByTwitter() {
		System.out.println("This is login with Twitter");
	}
}
