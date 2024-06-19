package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//WebSite
		driver.get("https://www.automationexercise.com/");
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		//Going to Test Case page
		driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[text()=' Products']")).click();
		
//		scrollDownSlowly(driver);
//		
//	
//		scrollUpSlowly(driver);
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total Images on WebPage :"+images.size());
		
		List<WebElement> sourceInfo = driver.findElements(By.xpath("//div[@class='col-sm-4']/div"));
		System.out.println("Number of data :"+sourceInfo.size());
		for(int i=0; i<sourceInfo.size(); i++) {
			System.out.println(sourceInfo.get(i).getText()+"| ");
		}
		
		List<WebElement> ProductData = driver.findElements(By.xpath("//div[@class='choose']/ul/li"));
		System.out.println("Total Number of Products are :"+ProductData.size());
		
		driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")).click();
		
		boolean image = driver.findElement(By.xpath("//div[@class='view-product']/img")).isDisplayed();
		System.out.println("Is Image displayed while opening product information "+image);
		
		WebElement productInfo = driver.findElement(By.xpath("//div[@class='product-information']"));
		System.out.println(productInfo.getText());
		
		
	}
//
//	private static void scrollUpSlowly(WebDriver driver) {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		for(int i=0; i<10; i++) {
//			js.executeScript("window.scrollBy(0, -600)");
//			try {
//				Thread.sleep(2000);
//			}
//			catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}
//
//	private static void scrollDownSlowly(WebDriver driver) {
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        // Scroll down slowly
//        for (int i = 0; i < 10; i++) {
//            js.executeScript("window.scrollBy(0, 1000)");
//            try {
//                Thread.sleep(200); // Adjust the sleep time for desired scrolling speed
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//	}

}
