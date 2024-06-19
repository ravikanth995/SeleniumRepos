package googleToAmazon;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;
import java.net.URL;

public class AmazonWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Amazon");
		List< WebElement > searchNames = driver.findElements(By.xpath("//div[@class='wM6W7d']"));
		System.out.println("Number of Amazon Options. :"+searchNames.size());
		for(WebElement x: searchNames) {
			System.out.println(x.getText());
		}
		
				driver.findElement(By.xpath("//div[@class='wM6W7d']/span[text()='Amazon']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");
		
		driver.findElement(By.xpath("//h3[text()='Amazon.in']")).click();
				
		driver.findElement(By.name("field-keywords")).sendKeys("Tradition and Revolution");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Tradition and Revolution: Dialogues with J. Krishnamurti']")).click();
		
		Set< String > windowIDs = driver.getWindowHandles();
		System.out.println("WIndow handles :"+windowIDs);
		
		List< String > windowList = new ArrayList( windowIDs);
		
		String mainAmazon = windowList.get(0);
		String bookDetail = windowList.get(1);
		
		System.out.println("Main Amazon Page Window ID :"+mainAmazon);
		System.out.println("Book Detail Page Window ID "+bookDetail);
		System.out.println("-".repeat(90));

		System.out.println("URL of the Page :"+driver.getCurrentUrl());
		System.out.println("Title of the Page :"+driver.getTitle());
		System.out.println("-".repeat(90));
		
		driver.switchTo().window(bookDetail);
		System.out.println("URL of the Page :"+driver.getCurrentUrl());
		System.out.println("Title of the Page :"+driver.getTitle());
		System.out.println("-".repeat(90));

		List< WebElement > pageRate = driver.findElements(By.id("a-autoid-0-announce"));
		for(WebElement y: pageRate) {
			System.out.println(y.getText());
		}
		
		System.out.println("-".repeat(90));
		List<WebElement > pageDetail = driver.findElements(By.xpath("//div[@id='detailBullets_feature_div']/ul/li"));
		for(WebElement z: pageDetail)
		{
			System.out.println("Page Details :"+
		"\n"+z.getText()+"|");
			System.out.println("-".repeat(90));

		}
		
	
	
	
	}

}
