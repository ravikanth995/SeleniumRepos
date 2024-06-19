package drpDown;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;
import java.net.URL;

public class HiddenDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//credentials
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).submit();
		
		List< WebElement > listsOfContent = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li"));
		System.out.println("Number of Contents available :"+listsOfContent.size());
		for(WebElement x: listsOfContent) {
			System.out.println(x.getText());
		}
		
		driver.findElement(By.xpath("//ul//li//span[text()='Admin']")).click();
		
		//Admin
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("Ravikanth");
		
		driver.findElement(By.xpath("//div[@class='oxd-table-filter-area']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();		
		Thread.sleep(1000);
		
		List< WebElement > selectOption = driver.findElements(By.xpath("//div[@role='listbox']"));
		System.out.println("Number of Options Available :"+selectOption.size());
		for(WebElement y: selectOption) {
			System.out.println(y.getText());
		}
		
		driver.findElement(By.xpath("//div[@role='option'][2]/span")).click();

		driver.findElement(By.xpath("//div[4]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
		Thread.sleep(1000);
		
		List< WebElement > statusOption = driver.findElements(By.xpath("//div[@role='listbox']"));
		System.out.println("Status Options :"+statusOption.size());
		for( WebElement z: statusOption) {
			System.out.println(z.getText());
		}
		
		driver.findElement(By.xpath("//div[@role='option']/span[text()='Enabled']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button/i")).click();
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")).sendKeys("Admin Ok");
		
		driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")).sendKeys("Admin Cancel");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")).click();
		Thread.sleep(1000);
		
		List< WebElement > listBox = driver.findElements(By.xpath("(//div[@role='listbox'])"));
		System.out.println("List boxes :"+listBox.size());
		for(WebElement a: listBox) {
			System.out.println(a.getText());
		}
		
		driver.findElement(By.xpath("//div[@role='listbox']/div/span[text()='Full-Time Permanent']")).click();
		
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i")).click();
	    Thread.sleep(1000);
	    List < WebElement > listEmp = driver.findElements(By.xpath("//div[@role='listbox']"));
	    System.out.println("Number of Option :"+listEmp.size());
	    for(WebElement b: listEmp) {
	    	System.out.println(b.getText());
	    	System.out.println("-".repeat(20));
	    }
	    
	    driver.findElement(By.xpath("//div[@role='option']/span[text()='Current and Past Employees']")).click();
	    
	    
	    //Job Title
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[2]/i")).click();
	    Thread.sleep(1000);
	    List< WebElement > JobTitles = driver.findElements(By.xpath("//div[@role='listbox']"));
	    System.out.println("Number of Job Titles :"+JobTitles.size());
	    for(WebElement c: JobTitles)
	    {
	    	System.out.println(c.getText());
	    }
		
	    driver.findElement(By.xpath("//div[@role='option']/span[text()='Chief Executive Officer']")).click();
	    
	    //SubUnit
	    
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[2]/i")).click();
	    Thread.sleep(2000);
	    List< WebElement > subUnit = driver.findElements(By.xpath("//div[@role='listbox']"));
	    System.out.println("Number of Sub Units :"+subUnit.size());
	    for(WebElement d: subUnit) {
	    	System.out.println(d.getText());
	    }
	
	    driver.findElement(By.xpath("//div[@role='option']/span[text()='Engineering']")).click();
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
	    System.out.println("-".repeat(90));
	
	    //Profile
	    driver.findElement(By.name("firstName")).sendKeys("AdminPashaShaikhRaizada");
	    driver.findElement(By.name("middleName")).sendKeys("Shaikh Raozada");
	    driver.findElement(By.name("lastName")).sendKeys("Khan");
	    
	    WebElement inpuT = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
	    inpuT.clear();
	    inpuT.sendKeys("1234");
	    driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	    
	    
	   	driver.navigate().back();

	    //Leave Section
	    driver.findElement(By.xpath("//span[text()='Leave']")).click();
	    driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//i[1]")).click();
	    
	    ////ul[@role='menu']/li
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/i")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li[1]/div/i")).click();
	    
	    List<WebElement > monthLists = driver.findElements(By.xpath("//ul[@role='menu']/li"));
	    System.out.println("How Many Months are there :"+monthLists.size());
	    for(WebElement f: monthLists) {
	    	System.out.println(f.getText());
	    }
	    driver.findElement(By.xpath("//ul[@role='menu']/li[text()='March']")).click();
	    
	    //Years
	    
//	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/i")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/div/i")).click();
	    
	    List<WebElement> yearList = driver.findElements(By.xpath("//ul[@role='menu']/li"));
	    System.out.println("Total Number of Years :"+yearList.size());
	    for(WebElement h: yearList) {
	    	System.out.println(h.getText());
	    }
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//ul[@role='menu']/li[text()='2014']")).click();
	    
	    List<WebElement> datesList = driver.findElements(By.xpath("//div[@class='oxd-calendar-dates-grid']/div"));
	    System.out.println("How Many Dates are there :"+datesList.size());
	    for(WebElement k: datesList) {
	    	System.out.println(k.getText());
	    }
	    driver.findElement(By.xpath("//div[@class='oxd-calendar-date'][normalize-space()='1']")).click();
	    
	    driver.findElement(By.xpath("//ul[@role='menu']/li[text()='2014']")).click();
	    
	    	    //End Date
	    Thread.sleep(8000);
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/i")).click();
	   
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 200)");
	    

	  
	    js.executeScript("window.scrollBy(0, -200)");

	    //Month List
	    
	}
	

}
