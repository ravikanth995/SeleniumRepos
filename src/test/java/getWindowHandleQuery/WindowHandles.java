package getWindowHandleQuery;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
public class WindowHandles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		System.out.println("Title of the Home Page :"+driver.getTitle());
		
		WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		List<String> ids = new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(ids.get(0));
		System.out.println("Title of get(0) "+driver.getTitle());
		
		driver.switchTo().window(ids.get(1));
		System.out.println("title of get(1) :"+driver.getTitle());
	}

}
