package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class AmazonPractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Title of the WebPage :"+title);
		System.out.println("-".repeat(90));
		String url = driver.getCurrentUrl();
		System.out.println("Url of the WepPage :"+url);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("J Krishnamurti Books");
		driver.findElement(By.xpath("//input[@type='submit' and @value = 'Go']")).click();
		
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down the page by 1000 pixels vertically
        js.executeScript("window.scrollBy(0,800)");
		}
		catch(Exception name) {
			System.out.println(name);
		}
		finally {
			System.out.println("Program of try-catch executed.");
		}
		
		driver.findElement(By.xpath("//span[text()='The Book of life']")).click();
		
		String titleName = driver.getTitle();
		System.out.println("Title name is :"+titleName);
	    
		
	
	}

}
