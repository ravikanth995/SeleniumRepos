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

public class ElectionCommissionBrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.eci.gov.in/");
		driver.manage().window().maximize();
		
		//Verify WebPage Title
		System.out.println("WebSite Title :"+driver.getTitle());
		
		String title= ":Election Commission of India";
		if(title.equals(":Election Commission of India"))
		{
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			System.out.println("Total Links present in the website :"+allLinks.size());
			int NoOfLinks = 0;
			for(WebElement linksEle : allLinks)
			{
				String hrefAttValue = linksEle.getAttribute("href");
				if(hrefAttValue==null || hrefAttValue.isEmpty())
				{
					System.out.println("href attribue is null and empty, so not possible to extract link");
					continue;
				}
				
				try {
					URL linksURL = new URL(hrefAttValue);
					HttpURLConnection conn = (HttpURLConnection) linksURL.openConnection();
					conn.connect();
					
					if(conn.getResponseCode()>400)
					{
						System.out.println(hrefAttValue+" -- is a broken link");
						NoOfLinks++;
					}
					else
					{
						System.out.println(hrefAttValue+" -- link is working");
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Number of Links :"+NoOfLinks);
		}

	}

}
