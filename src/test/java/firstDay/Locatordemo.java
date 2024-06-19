package firstDay;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locatordemo {

	public static void main(String[] args) {


		WebDriver driver  = new ChromeDriver();
		
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		
//		driver.findElement(By.name("newsletter")).sendKeys("Mac");
		List<WebElement>images = driver.findElements(By.className("img-responsive"));
//		System.out.println("Number of Images are :"+images.size());

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links are :"+links.size());	
	}
}
