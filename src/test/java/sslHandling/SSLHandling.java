package sslHandling;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.openqa.selenium.By;
public class SSLHandling {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
		
		System.out.println(driver.getTitle());
		

	}

}
