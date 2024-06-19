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

public class PaginationTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1580)");
		
		List<WebElement> pagesNo = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
		System.out.println(pagesNo.size());		
		for(WebElement x: pagesNo)
			{
			x.click();
			Thread.sleep(3000);
			List<WebElement> pagesData = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
			for(WebElement y: pagesData)
			{
				System.out.println(y.getText());
			}
			List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@id=\"productTable\"]/tbody/tr/td/input"));
			for(WebElement z: checkBoxes)
			{
				z.click();
			}
			
			}
			}

}
