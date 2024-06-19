package alertsAndPopUp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;
import java.net.URL;


public class AlertsAndPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='JavaScript Alerts']")).click();
//		
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		 Thread.sleep(3000);
//		 
//		 Alert myAlert = driver.switchTo().alert();
//		 System.out.println(myAlert.getText());
//		 
//		 Thread.sleep(2000);
//		 
//		 myAlert.accept();
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		 Thread.sleep(3000);
//		 
//		 Alert myAlert = driver.switchTo().alert();
//		 System.out.println(myAlert.getText());
//		 myAlert.accept();
		 
		 //Click for JS Prompt
		 driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		 Thread.sleep(3000);
		 Alert myAlert = driver.switchTo().alert();
		 myAlert.sendKeys("Hi Hello, kemcho majama");
		 myAlert.accept();
		 
		 
		 
				
					}

}
