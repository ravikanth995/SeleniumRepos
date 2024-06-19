package firstDay;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		String titleName = "OrangeHRM";
		String actualTitle = driver.getTitle();
		if(titleName.equals(actualTitle)) {
			System.out.println("Title is Matching..");
		}else {
			System.out.println("Title Name is not Matching...");
		}
		System.out.println("Title is :"+driver.getTitle());
		
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String urlActual = driver.getCurrentUrl();
		if(url.endsWith(urlActual))
		{
			System.out.println("URL Address is matchimg...");
		}
		else {
			System.out.println("URL address is not matching..");
		}
		
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("Admin");
		
		WebElement userPassword = driver.findElement(By.name("password"));
		userPassword.sendKeys("admin123");
		
		WebElement buttonSubmit = driver.findElement(By.xpath("//button[text()=' Login ']"));
		buttonSubmit.click();
		
		List<WebElement> toggleList = driver.findElements(By.xpath("//a[@class='oxd-main-menu-item toggle']"));
		System.out.println(toggleList.size());
		for(WebElement x: toggleList) {
			System.out.println(x.getText()+" |");
		}
		
		//Main menu
		List<WebElement> listMenu = driver.findElements(By.xpath("//li[@class='oxd-main-menu-item-wrapper']/a"));
		System.out.println("Lists of Main Menu are :"+listMenu.size());
		for(WebElement y: listMenu) {
			System.out.println(y.getText());
		}	

		WebElement adminLink = driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper']/a/span[text()='Admin']"));
		adminLink.click();

		String inputBox = "AdminZiappa";
		WebElement userNameInput = driver.findElement(By.xpath("//div[@class='oxd-form-row']/div/div/div/div[2]/input"));
		userNameInput.sendKeys(inputBox);
		
		List<WebElement> userData = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
		System.out.println("Total Data :"+userData.size());
		for(WebElement z: userData)
		{
			Thread.sleep(1000);
			System.out.println(z.getText()+" |");
		}
		
		List<WebElement> usernameData = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
		System.out.println("Total User NameData :"+usernameData.size());
		for(WebElement k: usernameData)
		{
			Thread.sleep(1000);
			System.out.println(k.getText()+" |");
		}

		
		
		
		
		

	}

}
