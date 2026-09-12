package day43;

import org.testng.annotations.*;

public class AllAnnotation {

	@Test(priority = 5)
	void test1() {
		System.out.println("Test1 method...");
	}

	@Test(priority = 3)
	void test2() {
		System.out.println("Test2 method...");
	}

	@BeforeTest
	void bt() {
		System.out.println("Before Test...");
	}

	@AfterTest
	void at() {
		System.out.println("Aftest Test...");
	}

	@BeforeSuite
	void bs() {
		System.out.println("Before Suite...");
	}

	@AfterSuite
	void as() {
		System.out.println("After Suite...");
	}

	@BeforeClass
	void bc() {
		System.out.println("Before Class...");
	}

	@AfterClass
	void ac() {
		System.out.println("After Class...");
	}

	@BeforeMethod
	void bm() {
		System.out.println("Before Method...");
	}

	@AfterMethod
	void am() {
		System.out.println("After Method...");
	}
}
