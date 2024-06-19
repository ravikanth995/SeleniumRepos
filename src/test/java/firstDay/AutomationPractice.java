package firstDay;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPractice {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		String url = "https://www.wipro.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		String titleName = driver.getTitle();
		System.out.println(titleName);

		driver.close();
	}

}
