package framework.concepts;

public class AppCommons {

	public void loginIntoApplication(String username, String password) {
		System.out.println("Login process started for user: " + username);
		System.out.println("User logged in successfully with password: " + password);
	}

	public void logoutFromApplication() {
		System.out.println("User logged out successfully.");
	}

	public void closeApplication() {
		System.out.println("Application is closed successfully.");
	}

	public void verifyApplicationHomePage() {
		System.out.println("Application home page is verified successfully.");
	}
	
	public void verifyFundTransfer() {
		System.out.println("Fund transfer is verified successfully.");
	}
	
	public void verifyAccountBalance() {
		System.out.println("Account balance is verified successfully.");
	}
	
}	
	