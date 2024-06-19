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

public class BlazeDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		//Title of the Page
		System.out.println("Title of the page: "+driver.getTitle());
		System.out.println("URL of the Page :"+driver.getCurrentUrl());
		
		//Performing action
		driver.findElement(By.xpath("//select[@name='fromPort']")).click();
		Thread.sleep(2000);
		
		List<WebElement> startStation = driver.findElements(By.xpath("//select[@name='fromPort']/option"));
		System.out.println("Starting Cities :"+startStation.size());
		for(WebElement x: startStation)
		{
			System.out.println("Cities :"+x.getText());
		}
		
		WebElement cityDrp = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select cityDown = new Select(cityDrp);
		cityDown.selectByIndex(5);
		
		driver.findElement(By.xpath("//select[@name='toPort']")).click();
		
		List<WebElement> endStation = driver.findElements(By.xpath("//select[@name='fromPort']/option"));
		System.out.println("End Stations are :"+endStation.size());
		for(WebElement y: endStation)
		{
			System.out.println("End Stations :"+y.getText());
		}
		
		WebElement endStn= driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select endDrp = new Select(endStn);
		endDrp.selectByIndex(5);
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		List<WebElement> listTable = driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
		System.out.println("How Many Rows are there in Price Tag :"+listTable.size());
		for(WebElement priceTable: listTable)
		{
			System.out.println(priceTable.getText());
		}
	}

}
