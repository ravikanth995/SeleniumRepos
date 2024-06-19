package keyBoardActions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenLinkNewWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement enrollLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(enrollLink).keyUp(Keys.CONTROL).perform();

        List<String> idS = new ArrayList<>(driver.getWindowHandles());
        System.out.println(driver.getTitle());
        
        driver.switchTo().window(idS.get(0));
        String title = "nopCommerce demo store";
        if(title.equals("nopCommerce demo store"))
        {
        	driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Mobile");
        }
        driver.switchTo().window(idS.get(1));
        System.out.println(driver.getTitle());		
        String title2 = "nopCommerce demo store. Register";
        if(title2.equals("nopCommerce demo store. Register"))
        {
        	driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Register Link");
        	
        }
        
        driver.switchTo().window(idS.get(0));
		if(title.equals("nopCommerce demo store"))
		{
			WebElement computer = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
			
			WebElement deskTop = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
			
			act.moveToElement(computer).moveToElement(deskTop).build().perform();
			
			deskTop.click();
		}
		else
		{
			System.out.println("Kindly, inquire any mistake in Code...");
		}
	}

}
