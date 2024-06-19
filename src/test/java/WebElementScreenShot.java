import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenShot {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		
		WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
		
		File sourceFile = logo.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user-dir")+"\\screenShot\\logoPic.png");
		
		sourceFile.renameTo(targetFile);
	}

}
