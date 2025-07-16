package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.util.Properties;
import java.io.FileInputStream;

public class ReportSetup {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static Properties props;

	static {
		try {
			props = new Properties();
			props.load(new FileInputStream("src/main/resources/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initializeReport() {
		String reportPath = props.getProperty("extent.report.path", "test-output/reports/") + "TestReport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		// Configure report metadata
		sparkReporter.config().setDocumentTitle(props.getProperty("extent.report.title", "Test Automation Report"));
		sparkReporter.config().setReportName(props.getProperty("extent.report.name", "Test Results"));
	}

	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	public static void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}
}
