package utils;

import java.io.File;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListener implements ITestListener {
	private ExtentReports extent;
	public static ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		String timestamp = new Date().toString().replace(":", "_").replace(" ", "_");
		String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport_" + timestamp + ".html";

		// Use ExtentSparkReporter instead of ExtentHtmlReporter
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(reportPath));
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("VisionWaves Test Report");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Environment", "Dev");
		extent.setSystemInfo("Tester", "Himanshu pathak");
		extent.setSystemInfo("Browser", "Edge");
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("Test Failed: " + result.getMethod().getMethodName());
		test.fail(result.getThrowable());

		// Capture screenshot on failure
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + result.getMethod().getMethodName()
				+ ".png";
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test Skipped: " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

}
