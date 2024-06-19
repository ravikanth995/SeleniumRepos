package takescreenshot;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotClass {
	
	
	public static void main(String[] args) {
	    WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://www.amazon.in/ref=nav_logo");
	    driver.manage().window().maximize();
	    
	    TakesScreenshot ts =  (TakesScreenshot) driver;
	    
	    File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	    
	    File targetFile = new File(System.getProperty("user-dir")+"\\screenShot\\amazonPage.png");
	    
	    sourceFile.renameTo(targetFile);
	    
	    
		
	}

}
