package mouseActions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MousAction {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
	    WebElement primeLink = driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']"));
	    WebElement orderLink = driver.findElement(By.xpath("//li[normalize-space()='Orders']"));
		
	    Actions act = new Actions(driver);
		act.moveToElement(primeLink).moveToElement(orderLink).build().perform();
		
	}

}
