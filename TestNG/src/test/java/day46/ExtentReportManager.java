package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	
	public ExtentSparkReporter sparkReport; // UI of the report
	public ExtentReports extent; // populate common info on the report like env, projectName, tester name
	public ExtentTest test; //creating TCs entries on the report and update status of execution.
	
	
	@Override
	public void onStart(ITestContext context) {

		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") +"\\ExtentReport\\myreport.html" );          //System.getProperty("user.dir" + "\\ExtentReport\\myreport.html"));
		
		sparkReport.config().setDocumentTitle("Automation DKV Report"); // Title of report
		sparkReport.config().setReportName("Functional Testing"); //Name of report
		sparkReport.config().setTheme(Theme.DARK); // UI Theme of report
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester name", "Deepak");
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("Browser name", "Chrome");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "TC Passed..." + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "TC is failed" + result.getName());
		test.log(Status.FAIL, "TC is failed cause is : " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "TC is skipped : " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush(); // mandatory method if not use then nothing is get in report /Writes test information from the started reporters to their output view 
	}

}
