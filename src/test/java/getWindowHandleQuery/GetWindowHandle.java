package getWindowHandleQuery;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		String inputBox = "Life Ahead J Krishnamurti";
		driver.findElement(By.name("field-keywords")).sendKeys(inputBox);
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 240)");
		
		List< WebElement > imageTruthOrFalse = driver.findElements(By.tagName("a"));
		System.out.println("How many links are there in Amazon HomePage :"+imageTruthOrFalse.size());
		
		List< WebElement > images = driver.findElements(By.tagName("img"));
		System.out.println("How many images are there :"+images.size());
		
		List< WebElement > bookTitles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("Books are :"+bookTitles.size());
		for(WebElement x: bookTitles) {
			System.out.println(x.getText());
		}
		
		driver.findElement(By.xpath("//span[text()='Life Ahead']")).click();
		Set< String > windowIDs = driver.getWindowHandles();
		
		List< String > windowLists = new ArrayList(windowIDs);
		
		String bookSearchPage = windowLists.get(0);
		String bookDetailPage = windowLists.get(1);
		
		System.out.println("WebPage Title :"+driver.getTitle());
		System.out.println("WebPage URL :"+driver.getTitle());
		
		//Switching to bookDetail Page
		driver.switchTo().window(bookDetailPage);
		System.out.println("Page Title :"+driver.getTitle());
		System.out.println("-".repeat(90));
		
		Thread.sleep(2000);
		
		//switch to BookSearchPage
		driver.switchTo().window(bookSearchPage);
		System.out.println(driver.getTitle());
		System.out.println("-".repeat(90));

		Thread.sleep(2000);
		driver.switchTo().window(bookDetailPage);
		System.out.println("Page Title :"+driver.getTitle());

		////div[@id='buyBoxAccordion']/div/div/div[2]/div/form
		
		WebElement boxText = driver.findElement(By.xpath("//*[@id=\"desktop_qualifiedBuyBox\"]/div"));
		System.out.println(boxText.getText());
		
		driver.findElement(By.name("submit.add-to-cart")).click();
		
		driver.findElement(By.name("proceedToRetailCheckout")).click();
		
		driver.findElement(By.name("email")).sendKeys("Avdihta@gmail.com");
		
		driver.findElement(By.id("continue")).click();
		
	}

}
