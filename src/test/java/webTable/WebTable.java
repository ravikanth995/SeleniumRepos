package webTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://cosmocode.io/automation-practice-webtable/#google_vignette");
		driver.manage().window().maximize();
		
		
			
			 List<WebElement> allCheckBox = driver.findElements(By.xpath("//tbody/tr/td/input"));
			 for(int i=0; i<=5 && i<allCheckBox.size(); i++)
			 {
				 allCheckBox.get(i).click();
			 }
			
			
					
	}

}
