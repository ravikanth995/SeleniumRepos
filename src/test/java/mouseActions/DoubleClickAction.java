package mouseActions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DoubleClickAction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 900)");
		
		WebElement fieldBox_1 = driver.findElement(By.xpath("//input[@id='field1']"));
		fieldBox_1.clear();
		fieldBox_1.sendKeys("WelCome to Chittapur");
		
		WebElement copyBox = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		Actions act = new Actions(driver);
		act.doubleClick(copyBox).perform();
		
		WebElement fieldBox2 = driver.findElement(By.xpath("//input[@id='field2']"));
		
		String textBox = fieldBox2.getAttribute("value");
		System.out.println("Captured String :"+textBox);
		if(textBox.equals("WelCome to Chittapur"))
		{
			System.out.println("Text has been copied to the Feild 2");
		}
		else
		{
			System.out.println("Not Copied");
		}
		
		
	}

}
