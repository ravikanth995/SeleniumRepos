package autoMationSite;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class AutomationTesting {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		List<WebElement> RegLinks = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));
		System.out.println("Number of Links :"+RegLinks.size());
		for(WebElement x: RegLinks)
		{
			System.out.println(x.getText()+" |");
		}
		
		WebElement swicthTo = driver.findElement(By.xpath("//a[normalize-space()='SwitchTo']"));
		WebElement alertTo = driver.findElement(By.xpath("//a[normalize-space()='Alerts']"));
		act.moveToElement(swicthTo).moveToElement(alertTo).build().perform();
		
		WebElement names = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		names.clear();
		names.sendKeys("Ravikanth");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.clear();
		lastName.sendKeys("Chavan");
		
		WebElement address = driver.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']"));
		address.clear();
		address.sendKeys("California");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 800)");
		
		
		WebElement emailAd = driver.findElement(By.xpath("//div[@id='eid']/input"));
		emailAd.clear();
		emailAd.sendKeys("BarackObama@gmail.com");
		
		WebElement phoneId = driver.findElement(By.xpath("//input[@type='tel']"));
		phoneId.clear();
		phoneId.sendKeys("773367382");
		
		WebElement maleId = driver.findElement(By.xpath("//input[@value='Male']"));
		maleId.click();
		
		
		
		List<WebElement> checkBox = driver.findElements(By.xpath("//div/input[@type='checkbox']"));
		for(int i=0; i<checkBox.size()-1; i++)
		{
			checkBox.get(i).click();
			System.out.println(checkBox.get(i).isSelected());	
		}
		
		driver.findElement(By.xpath("//div[@id='msdd']")).click();
		
		List<WebElement> languages = driver.findElements(By.xpath("//section[@id='section']//li"));
		System.out.println("Total Number of Languages are :"+languages.size());
		String englishL = "English";
		for(int i=0; i<languages.size(); i++)
		{
			languages.get(i).click();
		}
				
		driver.findElement(By.xpath("(//select[@id='Skills'])[1]")).click();
		String skills = "AutoCAD";
		List<WebElement> skillSet = driver.findElements(By.xpath("//select[@id='Skills']/option"));
		System.out.println("Number of Skills :"+skillSet.size());
		for(WebElement z: skillSet)
		{
			if(z.getText().equals(skills))
				
			{
				z.click();
			}
		}
		
		WebElement country = driver.findElement(By.xpath("//select[@id='countries']"));
		country.click();
		Select countrY = new Select(country);
		countrY.selectByVisibleText("Select Country");
		
		WebElement countryList = driver.findElement(By.xpath("//span[@role='combobox']"));
		countryList.click();
		String deshName = "Bangladesh";
		List<WebElement> countryLists = driver.findElements(By.xpath("//span[@class='select2-results']/ul/li"));
		for(WebElement a: countryLists)
		{
			if(a.getText().equals(deshName))
			{
				a.click();
			}
		}
		
		

//		String year = "2015";
//		WebElement yearBox = driver.findElement(By.xpath("//select[@id='yearbox']"));
//		yearBox.click();
//				
//		System.out.println(js.executeScript("return window.pageYOffset;"));
	}

}
