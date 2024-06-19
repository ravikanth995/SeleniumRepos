package firstDay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoClass {

	public static void main(String[] args) {
		WebDriver driver  = new ChromeDriver();
		
		driver.get("https://acharyaprashant.org/");
		driver.manage().window().maximize();
		
		String titleName = driver.getTitle();
		System.out.println(titleName);
		
//		driver.findElement(By.linkText("Interviews and Podcasts")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Available Links are :"+links.size());
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Number of Image are :"+images.size());
		
		driver.close();
	}
}
