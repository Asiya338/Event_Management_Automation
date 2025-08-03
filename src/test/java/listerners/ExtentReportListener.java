package listerners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReportListener implements ITestListener
{
	private ExtentReports extent;
	private ExtentTest test;
	
	public ExtentReportListener() {}
	
	@Override
	public void onStart(ITestContext context)
	{
		String reportPath = System.getProperty("user.dir") + "/extentReport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester", "Asiya");
        extent.setSystemInfo("Sprint", "Sprint-2");
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		test.info(">>>Test created : " + result.getMethod().getMethodName() );
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.pass(">>>Test passed : " + result.getMethod().getMethodName());
	}
	
	@Override 
	public void onTestFailure(ITestResult result)
	{
		test.fail(">>>Test failed : " + result.getMethod().getMethodName());
		test.fail(result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.skip(">>>Test skipped : " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}