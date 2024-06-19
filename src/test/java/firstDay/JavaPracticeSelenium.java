package firstDay;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public class JavaPracticeSelenium {

	public static void main(String[] args) throws InterruptedException, IOException {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Title of the Page :"+title);
		System.out.println("-".repeat(90));
		
		
		String urlPage = driver.getCurrentUrl();
		System.out.println("URL of the Page :"+urlPage);
		System.out.println("-".repeat(90));
		
		boolean logo = driver.findElement(By.className("navbar-brand")).isDisplayed();
		System.out.println("Is logo displayed :"+logo);
		System.out.println("-".repeat(90));
		
		List<WebElement> imagesLogo = driver.findElements(By.xpath("//div/img"));
		System.out.println("How Many Images are in WebPage :"+imagesLogo.size());
		System.out.println("-".repeat(90));
		
		List<WebElement> topLinks = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));
		System.out.println("How many Top Links are there :"+topLinks.size());
		System.out.println("-".repeat(90));
		
		List<WebElement> ResourceLinks = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
		System.out.println("How many Resource Links are there :"+ResourceLinks.size());
		System.out.println("-".repeat(90));
		
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class='col-sm-2']"));
		System.out.println("Footer Links are :"+footerLinks.size());
		System.out.println("-".repeat(90));
		
		List<WebElement> footLinks = driver.findElements(By.xpath("//div[@class='col-sm-2']/section/ul/li"));
		for(WebElement x: footLinks) {
			System.out.println(x.getText());
			System.out.println("-".repeat(50));
		}
		
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links in the OpenCart page is :"+totalLinks.size());
		System.out.println("-".repeat(90));
//		int count=0;
//		for (int i=0; i<totalLinks.size(); i++) {
//			String url = totalLinks.get(i).getAttribute("href");
//			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//            connection.setRequestMethod("HEAD");
//            int statusCode = connection.getResponseCode();
//            if (statusCode >= 400) {
//                System.out.println(url + " Broken");
//                count++;
//            } else {
//                System.out.println(url + " Valid Link");
//            }
//            count++;
//            connection.disconnect();
//		}
		
		driver.findElement(By.xpath("//div/a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Ravikanth");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ravi");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kanth");
		
		

		driver.close();
	}

}
