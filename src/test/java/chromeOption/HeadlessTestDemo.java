package chromeOption;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeadlessTestDemo {

	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jkrishnamurti.in/india/");
		driver.manage().window().maximize();
		
		String title = "KRISHNAMURTI FOUNDATION INDIA";
		if(title.equals(driver.getTitle()))
		{
			WebElement logo = driver.findElement(By.id("site-logo"));
			File sourceFile = logo.getScreenshotAs(OutputType.FILE);
			File targetFile = new File(System.getProperty("user-dir")+"\\screenShot\\kfi_logo.png");
			
			sourceFile.renameTo(targetFile);
		}
		List<WebElement> mainMenu = driver.findElements(By.xpath("//ul[@id='menu-main-menu']"));
		String mainMenuOne = "THE STORE";
		for(WebElement menu: mainMenu)
		{
			if(mainMenuOne.equals("THE STORE"))
			{
				menu.click();
			}
				
		}
		

	}

}
