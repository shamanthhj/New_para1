package com.framework.utilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.framework.base.BaseClass;

public class TestListener extends BaseClass implements ITestListener{

	 @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Shyam");
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		String screenshotPath1 = ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
		test.log(Status.PASS, "Test Passed");
		test.addScreenCaptureFromPath(screenshotPath1);
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String screenshotPath = ScreenshotUtil.captureScreenshot(result.getMethod().getMethodName());
		test.log(Status.FAIL, "Test Failed" + result.getThrowable());
		test.addScreenCaptureFromPath(screenshotPath);	
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, "Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		if (extent != null) {
            extent.flush(); 
        }
	}
}
