package firstDay;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class GetWindowHandlePart1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
//		String nameUser = "Admin";
//		String userPass = "admin123";
//		
//        driver.findElement(By.name("username")).sendKeys(nameUser);
//		driver.findElement(By.name("password")).sendKeys(userPass);
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
		Set<String> windowID = driver.getWindowHandles();
		System.out.println(windowID);
		
		List<String> windowList = new ArrayList(windowID);
		
		String parentWindow = windowList.get(0);
		String childWindow = windowList.get(1);
		
		System.out.println("Parent Window Handle :"+parentWindow);
		System.out.println("Child WIndow Handle :"+childWindow);
		
		System.out.println("Title of the WebPage :"+driver.getTitle()+":  Url of the Web Page :"+driver.getCurrentUrl());
		
		//Switching to child window
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle()+" : Url of the web Page :"+driver.getCurrentUrl());
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		
		for(String windID :windowID ) {
			String title = driver.switchTo().window(windID).getTitle();
			if(title.equals("OrangeHRM")) {
				driver.findElement(By.name("username")).sendKeys("Admin");
				driver.findElement(By.name("password")).sendKeys("admin123");
				driver.findElement(By.xpath("//button[text()=' Login ']")).click();
				
				List<WebElement> featureLists = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li"));
				System.out.println("Number of Feature Lists :"+featureLists.size());
				for(WebElement x: featureLists) {
					System.out.println(x.getText()+"| ");
				}
				
				driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Admin Zindabad");
				
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys("1233455");				
				
				System.out.println(driver.getTitle());	
			}else {
				System.err.println(driver.getCurrentUrl());
			}
		}
		
		
		
		
		

	}

}
