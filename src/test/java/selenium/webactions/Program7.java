package selenium.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program7 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://books-pwakit.appspot.com/");
		
		//Shadow element so not locating
		//WebElement element = driver.findElement(By.xpath("//input[@id='input']"));
		
		//4.Locate the shadow host element(always use CSS)
		WebElement shadowHost = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
		
		//5.Look at the shadow root element
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		
		//6.Locate the shadow element inside the shadow root
		WebElement appHeader = shadowRoot.findElement(By.cssSelector("app-header"));
		
		//7.Locate the search books element available within the appHeader element
		WebElement searchBooks = appHeader.findElement(By.cssSelector("input#input"));
		searchBooks.sendKeys("Selenium");
		
		driver.quit();
		
	}

}
