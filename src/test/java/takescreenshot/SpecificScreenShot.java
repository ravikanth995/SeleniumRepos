package takescreenshot;
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

public class SpecificScreenShot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		JavascriptExecutor js =(JavascriptExecutor) driver;
		
		
		WebElement footer = driver.findElement(By.id("navFooter"));
		js.executeScript("window.scrollBy(0, 1300)");
		try {
		File sourceFile = footer.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user-dir")+"\\screenShot\\footerimag1.png");
		
		sourceFile.renameTo(targetFile);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
