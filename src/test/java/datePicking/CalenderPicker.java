package datePicking;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.net.HttpURLConnection;
public class CalenderPicker {
	
	public static class DemoPick{
		
		 static Month calenderMonth(String month)
		{
			HashMap <String, Month> monthMap = new HashMap<>();
			
			monthMap.put("January", Month.JANUARY);
			monthMap.put("February", Month.FEBRUARY);
			monthMap.put("March", Month.MARCH);
			monthMap.put("April", Month.APRIL);
			monthMap.put("May", Month.MAY);
			monthMap.put("June", Month.JUNE);
			monthMap.put("July", Month.JULY);
			monthMap.put("August", Month.AUGUST);
			monthMap.put("September", Month.SEPTEMBER);
			monthMap.put("October", Month.OCTOBER);
			monthMap.put("November", Month.NOVEMBER);
			monthMap.put("December", Month.DECEMBER);
			
			Month vMonth = monthMap.get(month);
			if(vMonth==null)
			{
				System.out.println("Invalid Month");
			}
			
			return vMonth;
		}
		
		public static void selectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate)
		{
			
			WebElement yearDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			Select yearDrop = new Select(yearDown);
			yearDrop.selectByVisibleText(requiredYear);
			
			while(true)
			{
				String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				
				Month expectMonth = calenderMonth(requiredMonth);
				Month currentMonth = calenderMonth(displayMonth);
				
				int result = expectMonth.compareTo(currentMonth);
				if(result<0)
				{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				}
				else if(result>0)
				{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				}
				
				else
				{
					break;
				}
			}
			
			List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
			for(WebElement x: allDates)
			{
				if(x.getText().equals(requiredDate)){
					x.click();
				}
			}
		}
	}

	public static void main(String[] args) {
		
              WebDriver driver = new ChromeDriver();
              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
              
              driver.get("https://testautomationpractice.blogspot.com/");
              driver.manage().window().maximize();
              
              driver.switchTo().frame("frame-one796456169");
              
              String requiredYear = "2020";
              String requiredMonth = "January";
              String requiredDate = "19";
              
              JavascriptExecutor js =(JavascriptExecutor) driver;
              js.executeScript("window.scrollBy(0, 1190)");
              
              driver.findElement(By.xpath("//*[@id=\"q4\"]/span")).click();
              
              DemoPick.selectDate(driver, requiredYear, requiredMonth, requiredDate);
              
	
	}

}
