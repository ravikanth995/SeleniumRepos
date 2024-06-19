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

public class PaginationTests {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).submit();
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
//		JavascriptExecutor js= (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 60)");
		
		List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='oxd-table']/div[2]/div"));
		System.out.println("Number of Rows :"+tableRows.size());
		for(WebElement x: tableRows)
		{
			System.out.println(x.getText());	
			
			}
		System.out.println("-".repeat(90));
		
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//div[@class='oxd-checkbox-wrapper']/label/span"));
		for(WebElement y: checkBoxList)
		{
			Thread.sleep(2000);
			y.click();
		}
		
	}

}
