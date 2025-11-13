package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm;jsessionid=718CC536A189071CC2725802BCD3B22A");
		
		driver.findElement(By.xpath("//li[@class='Solutions']"));
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[2]/a"));
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[3]/a"));
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[4]/a"));
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[5]/a"));
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[6]/a"));
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/h2[1]"));
		driver.findElement(By.xpath("//input[@name='username']"));
		driver.findElement(By.xpath("//input[@name='password']"));
		driver.findElement(By.xpath("//input[@value='Log In']"));
				
		driver.close();
	}

}
