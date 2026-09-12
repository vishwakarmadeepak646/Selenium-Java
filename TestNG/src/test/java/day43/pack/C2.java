package day43.pack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {

	@Test
	void abc() {
		System.out.println("C2- abc method");
	}
	
	@AfterTest
	void beforeTestMethod() {
		System.out.println("AfterTest Method...");
	}
}
