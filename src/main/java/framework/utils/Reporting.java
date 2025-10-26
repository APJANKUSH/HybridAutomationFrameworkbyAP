package framework.utils;

//Listener class used to generate Extent reports

import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	static String repName;

	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/" + repName);
																											
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Ankush");

		htmlReporter.config().setDocumentTitle("Automation Test Project ");
		htmlReporter.config().setReportName("Functional API Test Automation Report"); 
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); 
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName()); 
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.assignCategory(tr.getMethod().getGroups());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		logger.log(Status.FAIL,tr.getThrowable().getMessage());

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
		System.out.println("Extent report generated." + repName);
		int totalTests = testContext.getAllTestMethods().length;

		// Passed tests
		int passedTests = testContext.getPassedTests().size();

		// Failed tests
		int failedTests = testContext.getFailedTests().size();

		// Skipped tests
		int skippedTests = testContext.getSkippedTests().size();
		
//		String getUser = testContext.getHost();
//		System.out.println(getUser);

		System.out.println("Total: " + totalTests + ", Passed: " + passedTests + ", Failed: " + failedTests
				+ ", Skipped: " + skippedTests);
		EmailReport.sendReport(
               "ankushpawarapj111@gmail.com", 
               "wsoy iatc ybwz lxkp", 
               "hpcreations1529@gmail.com", repName, 
               totalTests,
               passedTests, 
               failedTests, 
               skippedTests

		);
	}
	

}
