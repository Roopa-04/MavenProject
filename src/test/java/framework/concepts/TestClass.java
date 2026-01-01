package framework.concepts;

public class TestClass extends AppCommons {

	public static void main(String[] args) {

		WebCommons web = new WebCommons();
		AppCommons app = new AppCommons();

		// Test Case 1 - Verify login with valid credentials.
		System.out.println("********** Test Case 1 - Verify login with valid credentials. **********");
		web.launchBrowserAndApplication("Chrome", "www.icici.com");
		app.loginIntoApplication("Bharath", "Bharath@123");
		app.verifyApplicationHomePage();
		app.logoutFromApplication();
		web.closeBrowser();

		// Test Case 2 - Verify login with Invalid credentials.
		System.out.println("********** Test Case 2 - Verify login with Invalid credentials. **********");
		web.launchBrowserAndApplication("Chrome", "www.icici.com");
		app.loginIntoApplication("Invalid", "Invalid@123");
		app.verifyApplicationHomePage();
		app.logoutFromApplication();
		web.closeBrowser();

		// Test Case 3 - Verify fund transfer.
		System.out.println("********** Test Case 3 - Verify fund transfer. **********");
		web.launchBrowserAndApplication("Chrome", "www.icici.com");
		app.loginIntoApplication("Bharath", "Bharath@123");
		app.verifyApplicationHomePage();
		app.verifyFundTransfer();
		app.logoutFromApplication();
		web.closeBrowser();

		// Test Case 4 - Verify Account balance.
		System.out.println("********** Test Case 4 - Verify Account balance. **********");
		web.launchBrowserAndApplication("Chrome", "www.icici.com");
		app.loginIntoApplication("Bharath", "Bharath@123");
		app.verifyApplicationHomePage();
		app.verifyAccountBalance();
		app.logoutFromApplication();
		web.closeBrowser();

	}

}