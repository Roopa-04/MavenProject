package testng.framework.concepts;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	
	public void onTestStart(ITestResult result) {
	    System.out.println("Test Execution Started: " + result.getName()); // gives the TC name
	  }
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test Executed Successfully: " + result.getName());
	  }
	
	public void onTestFailure(ITestResult result) {
		    System.out.println("Test Execution Failed: " + result.getName());
		    System.out.println("Failure Reason: " + result.getThrowable().getLocalizedMessage()); //Gives the failure reason
		    System.out.println("Taking Screenshot for failed test case: " + result.getName());
		  }
	
}
