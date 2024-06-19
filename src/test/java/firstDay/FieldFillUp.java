package firstDay;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
public class FieldFillUp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practice-automation.com/form-fields/");
		driver.manage().window().maximize();
		
		String names= "Ravikanth";
		driver.findElement(By.id("name")).sendKeys(names);
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//form[@id='feedbackForm']/label"));
		System.out.println("Number of CheckBoxes are :"+checkBoxes.size());
		for(WebElement x: checkBoxes) {
			System.out.println(x.getText());
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300)");
		
		List<WebElement> drinkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement y: drinkBox) {
			Thread.sleep(2000);
			y.click();
		}
		
		js.executeScript("window.scrollBy(300, 350)");
		
		List<WebElement> colorBox = driver.findElements(By.xpath("//input[@type='radio']"));
		for(WebElement y: colorBox) {
			Thread.sleep(2000);
			y.click();
		}

		
					}

}
