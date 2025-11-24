package selenium.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Program6 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/slider/");
		
		//4.Switch to the frame which contains the slider element
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		//5.Locate the slider element
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));
		
		//6. Locate the handle of the slider(slider.findElement())
		WebElement sliderHandle = slider.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]"));
		
		//7. The slider handle to the right by 200 pixels
		Actions action = new Actions(driver);
		action.dragAndDropBy(sliderHandle, 200, 0).perform();
		
		//8. The slider handle to the left by 100 pixels
		action.dragAndDropBy(sliderHandle, -100, 0).perform();
		action.dragAndDropBy(sliderHandle, -100, 0).perform();
		
		driver.quit();
	}

}
