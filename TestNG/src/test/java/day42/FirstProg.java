package day42;

import org.testng.annotations.Test;

public class FirstProg {

	@Test(priority = 1)
	void login() {
		System.out.println("Login method...");
	}
	
	@Test(priority = 2)
	void logout() {
		System.out.println("Logout method...");
	}
	
	@Test(priority = 3)
	void test() {
		System.out.println("testing ...");
	}
	
	@Test
	void test2() {
		System.out.println("test2 ...");
	}
}

