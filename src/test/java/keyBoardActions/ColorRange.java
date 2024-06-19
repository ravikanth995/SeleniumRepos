package keyBoardActions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ColorRange {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://practice.expandtesting.com/horizontal-slider");
		driver.manage().window().maximize();
		
		WebElement slicer = driver.findElement(By.xpath("//input[@value='0']"));
		System.out.println("Slicer Location :"+slicer.getLocation());
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(slicer, 100, 287).perform();
		System.out.println("Slicer Location after :"+slicer.getLocation());

		
			
	}

}
