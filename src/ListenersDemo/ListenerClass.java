package ListenersDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case successful: " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
}
