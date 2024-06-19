package frames;
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

public class FrameDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		////input[@name='mytext1']
		try {
		WebElement frame_1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame_1);
		}
		catch(Exception name) {
			System.out.println(name);
		}finally {
			System.out.println("Frame Passed..");
		}
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Dhayanam Gyanam");
		
		driver.switchTo().defaultContent();
		
		WebElement frame_2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame_2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Haseeba Kheliba Dhyanam");
		
		driver.switchTo().defaultContent();
		
		
		WebElement frame_4 = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(frame_4);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Ramama Raghavam..");
		
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Ranadheram Rajasam..");

		driver.switchTo().frame(0);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		
		driver.findElement(By.xpath("//div[@id='i5']//div[@class='AB7Lab Id5V1']")).click();
//		js.executeScript("arguments[0].click();", rebttn);
		
		js.executeScript("window.scrollBy(100, 150)");
		driver.findElement(By.xpath("//div[@id='i19']//div[@class='uHMk6b fsHoPb']")).click();
		
		js.executeScript("window.scrollBy(150, 250)");
		driver.findElement(By.xpath("//div[@role='presentation']")).click();
		
		js.executeScript("window.scrollBy(250, 300)");

		try {
		driver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();
				}
		catch(Exception name) {
			System.out.println(name);
		}
	}
}
