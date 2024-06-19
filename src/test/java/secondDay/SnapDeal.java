package secondDay;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class SnapDeal {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
	
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		//Title
		System.out.println("Title of the Web Page :"+driver.getTitle());
		
		//URL
		System.out.println("URL of the WebPage :"+driver.getCurrentUrl());
        JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 1500)");
	    
	    List <WebElement> socialMedia = driver.findElements(By.xpath("//div[@class='middleBottomFooterImgs footerConnectImgs']/a/img"));
	    System.out.println("Number of Social Media Links :"+socialMedia.size());
	    for(WebElement y: socialMedia) {
	    	String altText = y.getAttribute("alt");
	    	System.out.println(altText);
	    }	    
	    
	    driver.findElement(By.xpath("//img[@alt='Snapdeal Facebook Page']")).click();
	    Set<String> windowIds = driver.getWindowHandles();
	    System.out.println(windowIds);
	    
	    List<String> windowList = new ArrayList(windowIds);
	    String parentId = windowList.get(0);
	    String childId = windowList.get(1);
	    System.out.println("Parent Window Id :"+parentId);
	    System.out.println("Child Window Id :"+childId);
	    
	    System.out.println("Title of the Page :"+driver.getTitle());
	    System.out.println("URL of the Web Page "+driver.getCurrentUrl());
	    driver.switchTo().window(childId);
	    System.out.println("Title of the Child Window :"+driver.getTitle());
	    if("Snapdeal".equals("Twitter")) {
	    	System.out.println("Url of the WebPage :"+driver.getCurrentUrl());
	    		driver.findElement(By.id(":rt:")).sendKeys("kattimani112@gmail.com");
	    		driver.findElement(By.id(":r10:")).sendKeys("kattimani@123");
	    		driver.findElement(By.xpath("//div[@role='none']/span/span[text()='Log in']")).click();
	    		
	    }
	    else
	    {
	    	driver.close();
	    }
	    
	    
}}