package datePicking;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.awt.Desktop.Action;
import java.net.HttpURLConnection;
public class DatePickerExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://dummy-tickets.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='Flight']")).click();
		
		driver.findElement(By.xpath("//input[@value='roundtripmain']")).click();


		//Source
		String sourceCity = "Hyderabad";
		driver.findElement(By.xpath("(//input[@name='source[]'])[2]")).sendKeys(sourceCity);
		
		driver.findElement(By.xpath("//ul[@class='suggestions-list']/li[2]")).click();
		

		//Destination
		String destCity = "HAL";
		driver.findElement(By.xpath("(//input[@name='destination[]'])[2]")).sendKeys(destCity);
		driver.findElement(By.xpath("//ul[@class='suggestions-list']/li[2]")).click();
		
		
					} 

}
