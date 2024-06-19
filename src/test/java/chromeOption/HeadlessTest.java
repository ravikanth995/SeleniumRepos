package chromeOption;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeadlessTest {

	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("headless=new");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jkrishnamurti.in/india/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String title = "India – Krishnamurti Foundation India";
		if(title.equals("India – Krishnamurti Foundation India"))
		{
		
			driver.findElement(By.xpath("//li[@id='menu-item-35493']//a[normalize-space()='THE STORE']")).click();
			List<WebElement> productsArchieve = driver.findElements(By.xpath("//div[@class='products-archive--products']"));
			for(WebElement x: productsArchieve)
				
			{
				System.out.println(x.getText());
			}
			List<WebElement> allPrices = driver.findElements(By.xpath("//span[@class='price']"));
			System.out.println("Prices Data :"+allPrices.size());
			for(WebElement y: allPrices)
			{
				System.out.println(y.getText());
			}
			String ar[] = new String [allPrices.size()];
			for(int i=0; i<allPrices.size(); i++)
			{
				ar[i] = allPrices.get(i).getText();
			}
			
			Arrays.sort(ar);
			boolean status = false;
			for(String price: ar)
			{
				System.out.println(price);
				if(price.contains("₹250.00 ₹150.00"))
				{
					
					driver.findElement(By.xpath("//a[normalize-space()='On Relationship']")).click();
					js.executeScript("window.scrollBy(0, 500)");
					WebElement plusOrNeg = driver.findElement(By.xpath("//div[@class='quantity buttons_added']"));
					System.out.println(plusOrNeg.getText());
					
					
				}
			}
			if(status==false)
			{
				System.out.println("Not succeeded in Clicking Book");
			}
		}
		
		
	}

}
