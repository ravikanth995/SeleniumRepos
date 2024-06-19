package datePickerSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

public class CalenderYearMonthDataPicker {
	
	public static class CalenderSelect{
		
		static Month convertMonth (String month)
		{
			HashMap<String, Month> monthMap = new HashMap<>();
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
		
	 static Year convertYear(String year)
		{
			HashMap<String, Year> yearsMap =new HashMap<>();
			for(int i=0; i<=2025; i++)
			{
				yearsMap.put(String.valueOf(i), Year.of(i));
			}
			
			Year vYear = yearsMap.get(year);
			if(vYear==null)
			{
				System.out.println("Invalid Year");
			}
			
			return vYear;
		}
		
		
		public static void selectDateCal(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate)
		{
			while(true)
			{
				String displayYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				String displayMonth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				
				Month expectedMonth = convertMonth(requiredMonth);
				Year expectedYear = convertYear(requiredYear);
				
				Month currentMonth = convertMonth(displayMonth);
				Year currentYear = convertYear(displayYear);
				
				int resultYear = expectedYear.compareTo(currentYear);
				int resultMonth = expectedMonth.compareTo(currentMonth);
				
				if(resultYear<0 || (resultYear==0 && resultMonth<0))
				{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				}
				else if(resultYear>0 || (resultYear==0 && resultMonth>0) )
				{
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				}
				
				else
				{
					break;
				}
				
				List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
				for(WebElement x: allDates)
				{
					if(x.getText().equals(requiredDate))
					{
						x.click();
					}
				}

			}
						
			
			
			List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
			for(WebElement x: allDates)
			{
				if(x.getText().equals(requiredDate))
				{
					x.click();
				}
			}
			
			
			WebElement callOne = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			Select drpYear = new Select(callOne);
			drpYear.selectByVisibleText("2020");
			
			WebElement calMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			Select drpMonth = new Select(calMonth);
			drpMonth.selectByVisibleText("Apr");
			
			
			List<WebElement> calDate = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
			for(WebElement a: calDate)
			{
				if(a.getText().equals(requiredDate))
				{
					a.click();
				}
			}

		}
		
		
		
		
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		
		//First Date Picker
		driver.findElement(By.xpath("//input[@id='first_date_picker']")).click();
		driver.findElement(By.xpath("//input[@id='third_date_picker']")).click();
		
		String requiredYear = "2020";
		String requiredMonth = "March";
		String requiredData = "18";
		CalenderSelect.selectDateCal(driver, requiredYear, requiredMonth, requiredData);

	}

}
