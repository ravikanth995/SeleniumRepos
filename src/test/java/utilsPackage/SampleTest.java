package utilsPackage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class SampleTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/fd_calculator.php?classic=true");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 330)");

		try {
			WebElement clearBtn = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]"));
			clearBtn.click();
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is :"+e.getMessage());
		}
		
	}

}
