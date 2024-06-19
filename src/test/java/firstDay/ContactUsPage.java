package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
public class ContactUsPage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		String WebPageUrl = "https://www.automationexercise.com/";
		driver.get(WebPageUrl);
		
		driver.manage().window().maximize();
		
		//Contact Us Page click
		driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
		
		//Name
		driver.findElement(By.name("name")).sendKeys("Ravikanth");
		
		//email
		driver.findElement(By.name("email")).sendKeys("ravikanth133@gmail.com");
		
		//Subject
		driver.findElement(By.name("subject")).sendKeys("Regarding the inefficiency of the loading of the Webpage");
		
		//Message Box
		
		String queries = "Namaste sir, I would like to bring your attention to the immediate issue faced by the server and that is causing many problem to the employee and not able execute thier work and i hope issue will be resolved as early as possible Thank You ";
		driver.findElement(By.name("message")).sendKeys(queries);
			
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		
		driver.findElement(By.name("upload_file")).click();
		System.setProperty("webdriver.chrome.driver", "Downloads/_77eb22a1-ade7-48f0-9807-42f60bbcacd5");


		
		
	}

}
