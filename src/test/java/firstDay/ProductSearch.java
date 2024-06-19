package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductSearch {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.automationexercise.com/");
		driver.manage().window().maximize();
		
//		String sourceCode = driver.getPageSource();
//		System.out.println(sourceCode);
		
		
		String WindowId = driver.getWindowHandle();
		System.out.println(WindowId);
//		driver.findElement(By.xpath("//a[text()=' Products']")).click();
//		
//		String search = "Top";
//		WebElement searchBox = driver.findElement(By.id("search_product"));
//		searchBox.sendKeys(search);
//		
//		WebElement submit = driver.findElement(By.xpath("//button[@id='submit_search']"));
//		submit.click();
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrolly(0,700)");
		
		

	}

}
