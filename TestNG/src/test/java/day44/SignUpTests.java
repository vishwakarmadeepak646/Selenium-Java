package day44;

import org.testng.annotations.Test;

public class SignUpTests {

	@Test(priority = 1, groups="regression")
	void signUpByFacebook() {
		System.out.println("This is SignUp with Facebook");
	}
	@Test(priority = 2, groups="regression")
	void signUpByEmail() {
		System.out.println("This is signUp with Email");
	}
	
	@Test(priority = 3, groups="regression")
	void signUpByTwitter() {
		System.out.println("This is signUp with Twitter");
	}
}
