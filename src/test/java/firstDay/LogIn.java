package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class LogIn {

	public static void main(String[] args) {
		
		WebDriver driver =new  ChromeDriver();
		
		//Launching browser
		String url = "https://www.automationexercise.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		String actualURL = driver.getCurrentUrl();
		if(url.equals(actualURL)) {
			System.out.println("url address matching");
		}
		else {
			System.out.println("Url is not matching..");
		}
		
		String titlePage = "Automation Exercise";
		String actualTitle = driver.getTitle();
		System.out.println("Title of th Page :"+actualTitle);
			
		if(titlePage.equals(actualTitle)) {
			System.out.println("Title of the WebPage matching..");
		}else {
			System.out.println("Page title not matching with the string you have provided..");
		}
		
		WebElement Login = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		Login.click();
		
		String EmailName = "ravikanth133@gmail.com";
		driver.findElement(By.name("email")).sendKeys(EmailName);
		
		String passW = "ravi123";
		driver.findElement(By.name("password")).sendKeys(passW);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
//		driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
		

	}

}
