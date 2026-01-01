package testng.framework.concepts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppCommons extends WebCommons {

	@BeforeMethod(dependsOnMethods = "launchBrowserAndApplication",alwaysRun = true)
	@Parameters({"USER","PASSWORD"})
	public void login(String username, String password) {
		//Assert.fail("Intentional failure to test dependsOnMethods behaviour");
		System.out.println("Login process started for user: " + username);
		System.out.println("User logged in successfully with password: " + password);
	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromApplication() {
		System.out.println("User logged out successfully.");
	}

	@AfterMethod (dependsOnMethods = "logoutFromApplication",alwaysRun = true)
	public void closeApplication() {
		System.out.println("Application is closed successfully.");
	}

	@BeforeMethod (dependsOnMethods = {"login","launchBrowserAndApplication"},alwaysRun = true)
	public void verifyApplicationHomePage() {
		System.out.println("Application home page is verified successfully.");
	}
	
	@Test(priority=2, groups = {"Regression", "Sanity"}, timeOut=6000, retryAnalyzer = RetryTest.class)
	public void verifyFundTransfer() throws InterruptedException {
		Assert.fail("Intentional failure to test RetryAnalyzer behaviour");
		Thread.sleep(5000);
		System.out.println("Fund transfer is verified successfully.");
	}
	
	@Test(priority=1, groups = {"Regression"}, invocationCount=3)
	public void verifyAccountBalance() {
		System.out.println("Account balance is verified successfully.");
	}
	
	@Test (groups = {"Sanity"}, enabled=false)
	public void verifyLoanBalance() {
		System.out.println("Loan balance is verified successfully.");
	}
	
	@Test(dataProvider = "emiData",priority=3, groups = {"Regression","Smoke"})
	public void calculateEMI(double principal, double rateOfInterest, double tenureInYears) {
	    double emi;
	    double tenureInMonths = tenureInYears * 12;
	    double monthlyInterestRate = rateOfInterest / (12 * 100);
	    emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureInMonths)
	          / (Math.pow(1 + monthlyInterestRate, tenureInMonths) - 1));
	    System.out.printf("The calculated EMI is: %.2f%n", emi);
	}
	
}	
	