package firstDay;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class AutomatePractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		String url = "https://www.orangehrm.com/";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		//Title of the Page
		String title = driver.getTitle();
		System.out.println("Title of the page :"+title);
		
		//URL of the Page
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		//Counting the Images of the Webpage
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Images in the WebPage are :"+images.size());
		
		List<WebElement> links  = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links are :"+links.size());
		
		boolean logos = driver.findElement(By.xpath("//div[@class = 'container-fluid']/a/img")).isDisplayed();
		System.out.println("Is Logos Displayed :"+logos);
		
//		List<WebElement> otherLinks = driver.findElements(By.className("row"));
//		System.out.println("Number of Footers are :"+otherLinks.size());
//		for(WebElement x: otherLinks) {
//			System.out.print(x.getText()+", ");
//		}System.out.println();
		
		driver.findElement(By.name("EmailHomePage")).sendKeys("admin@gmail.com");
		driver.findElement(By.name("action_request")).click();
		
		driver.findElement(By.name("subdomain")).sendKeys("ravikanth");
		driver.findElement(By.name("Name")).sendKeys("Ravikanth chavan");
		driver.findElement(By.name("Email")).sendKeys("admin123@gmail.com");
		driver.findElement(By.name("Contact")).sendKeys("73902022722");
		
		//DropDown
		WebElement drpDown = driver.findElement(By.xpath("//select[@name = 'Country']"));
		Select drpCountries  = new Select(drpDown);
		drpCountries.selectByVisibleText("India");
		
		//Capta
		driver.findElement(By.xpath("//div[@class = 'recaptcha-checkbox-border']")).click();
		
		driver.close();

	}

}
