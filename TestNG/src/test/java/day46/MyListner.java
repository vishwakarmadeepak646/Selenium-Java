package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListner implements ITestListener {

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Execution Started...");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Method Starts...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed...");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Test Failed...");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped...");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("all Test Method execution finished...");
	}
}
