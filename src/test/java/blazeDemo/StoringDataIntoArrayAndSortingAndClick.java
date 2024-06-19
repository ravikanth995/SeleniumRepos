package blazeDemo;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoringDataIntoArrayAndSortingAndClick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		String cityName = "Portland";
		boolean check = false;
		List<WebElement> fromPort = driver.findElements(By.xpath("//select[@name='fromPort']/option"));
		for(WebElement fromCity : fromPort)
		{
			if(fromCity.getText().equals(cityName))
			{
				fromCity.click();
				check=true;
				System.out.println("Passed..");
				break;
			}
		}
		if(check==false)
		{
			System.out.println("Error Encountered");
		}
		
		String toCity= "London";
		boolean checks = false;
		List<WebElement> ToPort = driver.findElements(By.xpath("//select[@name='toPort']/option"));
		for(WebElement x: ToPort)
		{
		if(x.getText().equals(toCity))	
		{
			x.click();
			checks = true;
			System.out.println("Passed..");
			break;
		}
			
		}
		
		if(checks==false)
		{
			System.out.println("Failed");
		}
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		List<WebElement> allPrice = driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
		System.out.println("Number of Prices :"+allPrice.size());
		for(WebElement priceTags : allPrice)
		{
			System.out.println(priceTags.getText());
		}
		String ar[] = new String[allPrice.size()];
		for(int i=0; i<allPrice.size(); i++)
		{
			ar[i] = allPrice.get(i).getText();
			System.out.println("Array Priced :"+ar[i]);
		}
		
		Arrays.sort(ar);
		boolean checksArray=false;
		System.out.println("After Sorting...");
		for(String sortedArray: ar)
		{
			System.out.println(sortedArray);
			if(sortedArray.contains("$200.98"))
			{
				driver.findElement(By.xpath("(//input[@value='Choose This Flight'])")).click();
			}
		}
		
	}

}
