package brokenLinks;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrokenLinksDemo {

	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		File file = new File("C:\\CRX Path\\Stands-AdBlocker.crx");
		opt.addExtensions(file);
		
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/links");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links :"+links.size());
		
		for(WebElement linksEle : links)
		{
			String hrefAttValue = linksEle.getAttribute("href");
			if(hrefAttValue==null || hrefAttValue.isEmpty())
			{
				System.out.println("href Attribute is null and empty, so possoble");
				continue;
			}
			
			try {
				URL linksURL = new URL(hrefAttValue);
				
				HttpURLConnection conn= (HttpURLConnection) linksURL.openConnection();
				conn.connect();
				if(conn.getResponseCode()>400)
				{
					System.out.println(hrefAttValue+" : Broken Link");
				
				
			}
				else
				{
					System.out.println(linksURL+" Not a Broken Link");
				}
			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	
	}


		}
}