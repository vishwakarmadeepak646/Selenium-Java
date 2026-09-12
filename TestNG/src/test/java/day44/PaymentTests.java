package day44;

import org.testng.annotations.Test;

public class PaymentTests {
	
	
	@Test(priority = 2, groups={"sanity", "regression","functional"})
	void Rupess() {
		System.out.println("Payment via Rupess");
	}

	@Test(priority = 1, groups={"sanity", "regression", "functional"})
	void Doller() {
		System.out.println("Payment via Doller");
	}
}
