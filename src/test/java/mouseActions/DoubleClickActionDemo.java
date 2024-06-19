package mouseActions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DoubleClickActionDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 900)");
		
		WebElement Box1= driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement box3 = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		Box1.clear();
		String inputString = "Bro... You are nerd";
		Box1.sendKeys(inputString);
		
		Actions act = new Actions(driver);
		
		act.doubleClick(box3).build().perform();
		
		String text = box2.getAttribute("value");
		System.out.println("Value Text :"+text);
		if(text.equals(inputString))
		{
			System.out.println("Copied");
			
		}
		else
		{
			System.out.println("Not Copied");
		}
		

	}

}
