package firstDay;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class AutomationExercize {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		
		//Navigating to the URL
		driver.get("https://www.automationexercise.com/");
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		String expectedTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title of the WebPage matched...");
		}
		else
		{
			System.out.println("Title of the Page did not match..");
		}
		
		String expectedURL ="https://www.automationexercise.com/";
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equals(actualURL)) {
			System.out.println("URL matched");
		}
		else
		{
			System.out.println("URL did not match");
			System.out.println("URL of the Page :"+driver.getCurrentUrl());
		}
		
		//SignUp or Login 
		try {
		WebElement signUp = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
		signUp.click();}
		catch(Exception name) {
			System.out.println(name);
		}
		finally {
			System.out.println("Program Terminated.");
		}
		
		String SignUpName = "Ravikanth12";
		driver.findElement(By.name("name")).sendKeys(SignUpName);
		
		String emailName = "ravikanth133@gmail.com";
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(emailName);
		driver.findElement(By.xpath("//button[@type='submit' and text()='Signup']")).click();	
		
		//Check Box Male or Female
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		
		//Password
		String passWord = "ravi123";
		driver.findElement(By.id("password")).sendKeys(passWord);
		
		List<WebElement> daysLists = driver.findElements(By.xpath("//select[@id='days']/option"));
		System.out.println("Number of Days :"+daysLists.size());
		for(WebElement x: daysLists) {
			System.out.println(x.getText());
		}
		
		WebElement drpDown = driver.findElement(By.xpath("//select[@id='days']"));
		Select drpDays = new Select(drpDown);
		drpDays.selectByVisibleText("5");
		
		List<WebElement> monthLists = driver.findElements(By.xpath("//select[@id='months']/option"));
		System.out.println("Number of Days :"+monthLists.size());
		for(WebElement y: monthLists) {
			System.out.println(y.getText());
		}

		WebElement drpMonth = driver.findElement(By.xpath("//select[@id='months']"));
		Select drpMonths = new Select(drpMonth);
		drpMonths.selectByVisibleText("March");
		
		List<WebElement> yearsList = driver.findElements(By.xpath("//select[@id='years']/option"));
		System.out.println("Number of Years are :"+yearsList.size());
		for(WebElement z : yearsList) {
			System.out.println(z.getText());
			
		}
		
		WebElement yearsDown = driver.findElement(By.xpath("//select[@id='years']"));
		Select yearDrpDown = new Select(yearsDown);
		yearDrpDown.selectByVisibleText("1995");
		
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.xpath("//input[@name='optin' and @id='optin']")).click();
		
		//Additional Information
		//First Name
		String firstName = "Ravikanth";
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		
		//Last Name
		String lastName = "chavan";
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		
		//Company Name
		String comapanyName = "Birla Shakti cement";
		driver.findElement(By.id("company")).sendKeys(comapanyName);
		
		//Location 1
		String location_1 = "Birla Market Shauapayr";
		driver.findElement(By.id("address1")).sendKeys(location_1);
		
		//Location 2
		String location_2 = "Hitahks Kisjs ouyr";
		driver.findElement(By.id("address2")).sendKeys(location_2);
		
		List<WebElement> CountryList = driver.findElements(By.xpath("//select[@id='country']/option"));
		System.out.println("Number of Countries :"+CountryList.size());
		for(WebElement k : CountryList) {
			System.out.println(k.getText());
		}
		
		WebElement  CountriesNames = driver.findElement(By.xpath("//select[@id='country']"));
		Select drpCountries = new Select(CountriesNames);
		drpCountries.selectByVisibleText("India");
		
		//State
		String stateName = "Karnataka";
		driver.findElement(By.id("state")).sendKeys(stateName);
		
		//City
		String CityName = "Gulbarga";
		driver.findElement(By.id("city")).sendKeys(CityName);
		
		//ZipCode
		String zipCodes = "585201";
		driver.findElement(By.id("zipcode")).sendKeys(zipCodes);
		
		//Mobile Num
		String MobileNum = "833939393";
		driver.findElement(By.id("mobile_number")).sendKeys(MobileNum);
		
		//Create Account
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		
		//Again Login
		
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		
		//Login Email
		String emailAddress = "ravikanth133@gmail.com";
		driver.findElement(By.name("email")).sendKeys(emailAddress);
		
		String passwordAd = "ravi123";
		driver.findElement(By.name("password")).sendKeys(passwordAd);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			}

}
