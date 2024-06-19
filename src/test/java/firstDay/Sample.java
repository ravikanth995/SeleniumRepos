package firstDay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) {
		
//		ChromeDriver driver = new ChromeDriver();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		String actual_Title = driver.getTitle();
		
		System.out.println(actual_Title);
//		if(actual_Title.equals("OrangeHRM"))
//		{
//			System.out.println("Test Passed..");
//		}
//		else
//		{
//			System.out.println("Test Failed..");
//		}
//
		driver.close();
		
	}

}
