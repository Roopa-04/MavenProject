package testng.framework.concepts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {
	
	int counter = 0;
	int retryLimit = 2;
	
	@Override
	public boolean retry(ITestResult result) {

		if(!result.isSuccess()) {
			if(counter < retryLimit) {
				counter++;
				return true; 
			}
		}
		
		return false; // Don't want to re-run the TC
	}

}
