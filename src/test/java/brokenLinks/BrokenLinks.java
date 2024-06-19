package brokenLinks;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links :"+links.size());
		int noOfBrokenLinks = 0;
		for(WebElement linkEle : links)
		{
			String hrefAttValue = linkEle.getAttribute("href");
			if(hrefAttValue==null || hrefAttValue.isEmpty())
			{
				System.out.println("href attribute value is null or empty, not possible to pass");
				continue;
			}
			
			try {
				URL linkURL = new URL(hrefAttValue);
				  HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
				  conn.connect();
				  if(conn.getResponseCode()>=400)
				  {
					  System.out.println(hrefAttValue+" : is a broken Link");
					  noOfBrokenLinks++;
				  }
				  else
				  {
					  System.out.println(hrefAttValue+" : is not a broken link");
				  }
			}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		System.out.println("Number of Links :"+noOfBrokenLinks);
		
	
	
		

	}

}
