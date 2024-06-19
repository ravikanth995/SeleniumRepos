package firstDay;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomationTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		String url = "https://demo.automationtesting.in/Register.html";
		driver.get(url);
		driver.manage().window().maximize();
		String TitleOfWebpage = driver.getTitle();
		System.out.println("WebPage title is :"+TitleOfWebpage);
		
		String urlAddress = driver.getCurrentUrl();
		System.out.println("Url Address of the WebPage :"+urlAddress);
		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ravikanth");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Chavan");
		try {
		driver.findElement(By.xpath("//div[@class='form-group']/div/textarea")).sendKeys("Raiway Station");
		}
		catch(Exception name) {
			System.out.println(name);
		}
		finally {
			System.out.println("Program terminated.");
		}
		
		String emailAddress = "ravikanthchauhan95@gmail.com";
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(emailAddress);
		
        String cellNum = "9082782922";
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(cellNum);
        
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkboxes.size());
        for(WebElement x: checkboxes) {
        	x.click();
        }
        
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        
        List<WebElement> languages = driver.findElements(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']/multi-select/div[2]/ul/li"));
        System.out.println("Number of languages are :"+languages.size());
        
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        
        driver.findElement(By.xpath("//multi-select/div[2]/ul/li/a[text()='English']")).click();
        
        List<WebElement> skillsLength= driver.findElements(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']/select[@type='text']/option"));
        System.out.println("Length of the Skills are :"+skillsLength.size());
        for(WebElement x: skillsLength) {
        	System.out.println(x.getText());
        }
        WebElement dropSkills = driver.findElement(By.xpath("//select[@id='Skills']"));
        Select drpDownSkills = new Select(dropSkills);
        drpDownSkills.selectByVisibleText("Java");
        
        List<WebElement> countriesChoose = driver.findElements(By.xpath("//select[@id='country']/option"));
        System.out.println("Number of Select Country :"+countriesChoose.size());
        for(WebElement y: countriesChoose) {
        	System.out.println(y.getText());
        }
        System.out.println("-".repeat(90));
        
        try {
        WebElement emptyCountry = driver.findElement(By.xpath("//select[@id='countries']/option"));
        Select drpCout = new Select(emptyCountry);
        drpCout.selectByVisibleText("Select Country");}
        catch(Exception name) {
        	System.out.println(name);
        }
        
        WebElement country = driver.findElement(By.xpath("//select[@id='countries']"));
        Select drpCountries = new Select(country);
        drpCountries.selectByVisibleText("Select Country");
        
        List<WebElement> countries = driver.findElements(By.xpath("//select[@id='country']/option"));
        System.out.println("Number of Countries :"+countries.size());
        for(WebElement y: countries) {
        	System.out.println(y.getText());
        }
        
        WebElement countryList = driver.findElement(By.xpath("//select[@id='country']"));
        Select drpCountry = new Select(countryList);
        drpCountry.selectByVisibleText("India");   
        
        List<WebElement> yearLists = driver.findElements(By.xpath("//select[@id='yearbox']/option"));
        System.out.println("Number of years :"+yearLists.size());
        for(WebElement z: yearLists) {
        	System.out.println(z.getText());
        }
        
        WebElement yearslist = driver.findElement(By.xpath("//select[@id='yearbox']"));
        Select drpYears = new Select(yearslist);
        drpYears.selectByVisibleText("1995");
        
        List<WebElement>monthTime = driver.findElements(By.xpath("//select[@placeholder='Month']/option"));
        System.out.println("Number of Months are :"+monthTime.size());
        for(WebElement MonthList : monthTime) {
        	System.err.println(MonthList.getText());
        }
        
        WebElement MonthNum = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        Select monthSelect = new Select(MonthNum);
        monthSelect.selectByVisibleText("March");
        
        
        List<WebElement> dayNums = driver.findElements(By.xpath("//select[@id='daybox']/option"));
        System.out.println("Number of Days are :"+dayNums.size());
        for(WebElement days : dayNums) {
        	System.out.println(days.getText());
        }
        
        WebElement DayDate = driver.findElement(By.xpath("//select[@id='daybox']"));
        Select drpDay = new Select(DayDate);
        drpDay.selectByVisibleText("5");

        driver.findElement(By.id("firstpassword")).sendKeys("password");
        driver.findElement(By.id("secondpassword")).sendKeys("password");
        
        driver.findElement(By.id("submitbtn")).click();
        
        
	}
}
