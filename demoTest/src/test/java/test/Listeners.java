package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Successfull");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		extentTest.get().fail(result.getThrowable());
		Object testObject = result.getInstance();
		Class clazz =result.getTestClass().getRealClass();
		try {
			driver = (WebDriver)clazz.getDeclaredField("driver").get(testObject);
		} catch (Exception e) {
		}
	
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void testStepDescription(String Message) {
		extentTest.get().log(Status.INFO,Message);
	}

	@Override
	public void onFinish(ITestContext context) {
		//long endTime= System.currentTimeMillis();
		//System.out.println("Inform all the suite have finished execution at"+ endTime);
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestFinish(String Message) {
		extentTest.get().log(Status.INFO,Message);
	}
	
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		//test.skip(null)
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}
	


	


	
}
