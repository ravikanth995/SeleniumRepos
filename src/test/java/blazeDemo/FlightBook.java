package blazeDemo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;
import java.net.URL;

public class FlightBook {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//select[@name='fromPort']")).click();
		
		
		//List of Cities
		List<WebElement> listCity= driver.findElements(By.xpath("//select[@name='fromPort']/option"));
		System.out.println("Number of Cities :"+listCity.size());
		for(WebElement x: listCity) {
			System.out.println(x.getText());
		}
				WebElement drpCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select drpDownCity = new Select(drpCity);
		drpDownCity.selectByVisibleText("Boston");
		
		driver.findElement(By.xpath("//select[@name='toPort']")).click();
				
		List<WebElement> portCity = driver.findElements(By.xpath("//select[@name='toPort']/option"));
		System.out.println("Port Cities :"+portCity.size());
		for(WebElement y: portCity) {
			System.out.println(y.getText());
		}
		
		WebElement cityDrp = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select cityDown = new Select(cityDrp);
		cityDown.selectByVisibleText("London");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

		List<WebElement> tableData = driver.findElements(By.xpath("//table/tbody/tr/td[6]"));
		System.out.println("Number of Price Data :"+tableData.size());
		for(WebElement price: tableData) {
			System.out.println(price.getText());
		}
		
		String ar[] = new String[tableData.size()];
		for(int i=0; i<tableData.size(); i++) {
			ar[i] = tableData.get(i).getText();
		}
		
		System.out.println("After Sorting Prices :");
		Arrays.sort(ar);
		boolean check=false;
		for(String price: ar) {
			System.out.println(price);
			
			if(price.contains("$200")){
					
				driver.findElement(By.xpath("//tbody/tr/td/input")).click();
				check=true;
				break;
							}
			if(check==false) {
				System.out.println("Try Again");
			}
					}
		boolean hTwoText = driver.findElement(By.xpath("//h2")).isDisplayed();
		System.out.println(hTwoText);
		
		WebElement textRead = driver.findElement(By.xpath("//h2"));
		System.out.println(textRead.getText());
		
		driver.findElement(By.id("inputName")).sendKeys("Ravikanth");
		driver.findElement(By.id("address")).sendKeys("karnataka");
		driver.findElement(By.id("city")).sendKeys("Chittapur");
		driver.findElement(By.id("state")).sendKeys("Karnataka");
		driver.findElement(By.id("zipCode")).sendKeys("426272");
		
		//dropdown of cards
		driver.findElement(By.xpath("//select[@name='cardType']")).click();
		
		List<WebElement> cardsDetail = driver.findElements(By.xpath("//select[@name='cardType']/option"));
		System.out.println("Number of Cards :"+cardsDetail.size());
		for(WebElement t: cardsDetail) {
			System.out.println(t.getText());
		}
		
		WebElement cardSelect  = driver.findElement(By.xpath("//select[@name='cardType']"));
		Select crdDown = new Select(cardSelect);
		crdDown.selectByVisibleText("American Express");
		
		driver.findElement(By.id("creditCardNumber")).sendKeys("728292020202");
		
		WebElement monthCol = driver.findElement(By.id("creditCardMonth"));
		monthCol.clear();
		Thread.sleep(2000);
		
		monthCol.sendKeys("12");
		
		WebElement yearCol = driver.findElement(By.id("creditCardYear"));
		yearCol.clear();
		Thread.sleep(2000);
		
		yearCol.sendKeys("2022");
		
		//Name
		driver.findElement(By.id("nameOnCard")).sendKeys("RaviKanth");
		
		//CheckBox
		driver.findElement(By.id("rememberMe")).click();
		
		//Submit
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		WebElement pageHead = driver.findElement(By.xpath("//h1"));
		System.out.println("Page Head is :"+pageHead.getText());
		
		List<WebElement> tableInfo = driver.findElements(By.xpath("//table/tbody/tr/td"));
		for(WebElement data: tableInfo) {
			System.out.println(data.getText());
		}
	}
	
	

}
