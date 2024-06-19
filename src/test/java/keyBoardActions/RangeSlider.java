package keyBoardActions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RangeSlider {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.globalsqa.com/demoSite/practice/slider/range.html");
		driver.manage().window().maximize();

		
		WebElement minSlider = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
		
		System.out.println("Minimum Slider Location :"+minSlider.getLocation());
		System.out.println("Maximum Slider Location :"+maxSlider.getLocation());
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(minSlider, 100, 46).perform();
		act.dragAndDropBy(maxSlider, -300, 46).perform();
		
		System.out.println("Minimum after Slider Location :"+minSlider.getLocation());
		System.out.println("Maximum after Slider Location :"+maxSlider.getLocation());
	}

}
