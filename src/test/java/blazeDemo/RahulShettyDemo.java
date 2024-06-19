package blazeDemo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;
import java.net.URL;

public class RahulShettyDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#search.aspx?mode=search");
		driver.manage().window().maximize();
		
		System.out.println("Title of the Site :"+driver.getTitle());
		System.out.println("URL of the Page :"+driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXTaction\']")).click();
		Thread.sleep(2000);
		
		List<WebElement> listCities = driver.findElements(By.xpath("//select[@name='ctl00$mainContent$ddl_originStation1']/option"));
	    System.out.println("How Many Cities are there in the List :"+listCities.size());
	    
	    List<WebElement> cityNames = driver.findElements(By.xpath("//div[@class='search_options_menucontentbg']/div/table/tbody/tr/td/div/div/div/ul/li"));
	    System.out.println(cityNames.size());
	    for(WebElement lists: cityNames)
	    {
	    	System.out.println(lists.getText());
	    }
	    
	    driver.findElement(By.xpath("//div[@class='search_options_menucontentbg']/div/table/tbody/tr/td/div/div/div/ul/li/a[text()=' Belagavi (IXG)']")).click();

	    System.out.println("+-".repeat(90));
	    //Down
	    driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXTaction\"]")).click();
	    
	    List<WebElement> listDowns =  driver.findElements(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul/li"));
	    System.out.println("List of Down Cities :"+listDowns.size());
	    for(WebElement listCity: listDowns)
	    {
	    	System.out.println(listCity.getText());
	    }
	    	try {
	          driver.findElement(By.xpath("//div[@class='search_options_menucontentbg']/div/table/tbody/tr/td/div/div/div/ul/li/a[text()=' Adampur (AIP)']")).click();
	    	}
	    	catch(Exception name) {
	    		System.out.println(name);
	    	}
	    }

}
