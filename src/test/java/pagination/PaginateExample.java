package pagination;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;
import java.net.URL;

public class PaginateExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://getdataden.com/docs/grid/features/pagination/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1100)");
		
		String texts = driver.findElement(By.xpath("//div[contains(text(),'1-10 of 15')]")).getText();
		System.out.println(texts);
		
		List<WebElement> arrowNext = driver.findElements(By.xpath("//section[1]//div[1]//div[1]//div[1]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//button[3]//*[name()='svg']"));
		for(WebElement x: arrowNext)
		{
			x.click();
		}
		 
		driver.findElement(By.xpath("//section[1]//div[1]//div[1]//div[1]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//button[3]//*[name()='svg']//*[name()='path' and contains(@stroke-linecap,'round')]"));

	}

}
