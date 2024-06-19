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
import java.net.HttpURLConnection;
import java.net.URL;

public class HeroUkoApp {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		//Title of the Page
		System.out.println("Title of the Web Page :"+driver.getTitle());
		System.out.println("Page of the URL :"+driver.getCurrentUrl());
		if("The Internet".equals("The Internet")) {
			driver.findElement(By.xpath("//a[text()='Broken Images']")).click();
			List< WebElement > images  = driver.findElements(By.xpath("//img"));
			System.out.println("Number of Images :"+images.size());
			for(WebElement image: images) {
//				if(image.isDisplayed()) {
//					System.out.println("Image Source :"+image.getAttribute("src")+"Is Displayed.");
//				}else {
//					System.out.println("Image Source :"+image.getAttribute("src")+" Is not Displayed.");
//				}
				String imageURL = image.getAttribute("src");

				try {
                    // Create a URL object
                    URL url = new URL(imageURL);
                    
                    // Open a connection to the URL
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    
                    // Set request method
                    connection.setRequestMethod("GET");
                    
                    // Get HTTP response code
                    int responseCode = connection.getResponseCode();
                    
                    // Check if the response code indicates an error
                    if (responseCode >= 400) {
                        System.out.println("Broken image found: " + imageURL + " (HTTP status code: " + responseCode + ")");
                    } else {
                        System.out.println("Image source: " + imageURL + " is displayed");
                    }
                    
                    // Close the connection
                    connection.disconnect();
                } catch (Exception e) {
                    System.out.println("Error checking image: " + imageURL + " - " + e.getMessage());
                }

				
			}
			driver.navigate().back();
			
			driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
			List<WebElement > checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
			System.out.println("Check Boxes "+checkBox.size());
			try {
			for(WebElement y: checkBox) {
				y.click(); 
			}}
			catch(Exception name) {
				System.out.println("Exception is : "+name);
			}finally {
				System.out.println("Check Box Code completed.");
			}
			
		}
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Challenging DOM']")).click();
		
		List<WebElement> tableData = driver.findElements(By.xpath("//div[@class='large-10 columns']/table/thead/tr/th"));
        System.out.println(tableData.size());
        for(WebElement z: tableData) {
        	System.out.println(z.getText());
        }
        
        List<WebElement> tableDatea = driver.findElements(By.xpath("//div[@class='large-10 columns']/table/tbody/tr"));
        System.out.println(tableDatea.size());
        for(WebElement l: tableDatea) {
        	System.out.println(l.getText()+"|");
        }
        
        driver.findElement(By.xpath("//a[@class='button']")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)");
        
        System.out.println(driver.findElement(By.xpath("//div[@class='large-10 columns']/canvas")).getText());
     
        driver.navigate().back();
	}

}
