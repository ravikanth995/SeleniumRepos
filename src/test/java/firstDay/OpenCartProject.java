package firstDay;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
public class OpenCartProject {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//Title of the Page
		String expectedTitle = "Your Store";
		System.out.println(driver.getTitle());
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title of the WebPage matched...");
		}
		else
		{
			System.out.println("Title of the WebPage did not match..");
		}
		
		//URL of the WebPage
		String ExpectedURL = "https://demo.opencart.com/";
		String actualURL = driver.getCurrentUrl();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("URL of the Webpage matched..");
		}
		else {
			System.out.println("URL of the WebPage did not match");
		}
		
		//My Account dropdown menu
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		//Register Account Click
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		//Abondoned due to verification pop up in webpage
		
	}

}
