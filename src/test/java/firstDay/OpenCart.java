package firstDay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCart {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
		
		String titleName = driver.getTitle();
		System.out.println("Title of the WebSite :"+titleName);
		
		boolean image = driver.findElement(By.xpath("//img[@title='nopCommerce']")).isDisplayed();
		System.out.println("Is Image of NOP commerce displayed :"+image);
		
	    

	}

}
