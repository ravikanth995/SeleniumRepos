package keyBoardActions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DragandDragBy {
//Not working
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		String text = "Mobile";
		
		WebElement inputSearch = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
		inputSearch.sendKeys(text);
		
		driver.findElement(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']/li[1]")).click();

		WebElement minSlider = driver.findElement(By.xpath("//div[@class='iToJ4v Kaqq1s']//div[@class='PYKUdo']"));
		System.out.println("Before Dis-locating...");
		System.out.println("Location of the Min. Slider (x, y) are :"+minSlider.getLocation());
		
		Actions act = new Actions (driver);
		try {
		act.dragAndDropBy(minSlider, 200, 331).build().perform();
		}
		catch(Exception name)
		{
			System.out.println(name);
		}
		System.out.println("After dis-Locating...");
		System.out.println("Location of the Min. Slider (x, y) are :"+minSlider.getLocation());

		
	}

}
