package keyBoardActions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPriceSlider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobile");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).submit();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 370)");
		
		WebElement minSlider = driver.findElement(By.xpath("//input[@id='p_36/range-slider_slider-item_lower-bound-slider']"));
		WebElement maxSlider = driver.findElement(By.xpath("//input[@id='p_36/range-slider_slider-item_upper-bound-slider']"));
		
		Actions act = new Actions(driver);
		System.out.println("Min Slider Location :"+minSlider.getLocation());
		
		act.dragAndDropBy(minSlider, 50, 0).perform();
		js.executeScript("arguments[0].value = 'new_value';", minSlider);

		System.out.println("After moving :"+ minSlider.getLocation());
		
		
				
		
	}

}
