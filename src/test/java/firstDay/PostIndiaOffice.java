package firstDay;

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


public class PostIndiaOffice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.indiapost.gov.in/vas/Pages/IndiaPostHome.aspx");
		driver.manage().window().maximize();
		//Title of the Page
		System.out.println("Title of the Web Page :"+driver.getTitle());
		
		//URL of Page
		System.out.println("URL of the WebPage :"+driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//figure[@class='india-post-tool-figure']/a/img[@alt='Find Pincode']")).click();
		
		Set<String> windowsIDs = driver.getWindowHandles();
//		List <String> windowsLists = new ArrayList(windowsIDs);
		System.out.println(windowsIDs);
		
		
		
		
	}

}
