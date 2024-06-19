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

public class DatePickerCode {

    public static class DatePicker {
        static Month convertMonth(String month)
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
            if(vMonth == null)
            {
                System.out.println("Invalid Month");
            }
            return vMonth;
        }

        static Year convertYear(String year)
        {
            HashMap<String, Year> yearMap = new HashMap<>();
            for(int i = 2000; i <= 2026; i++)
            {
                yearMap.put(String.valueOf(i), Year.of(i));
            }
            
            Year vYear = yearMap.get(year);
            if(vYear == null)
            {
                System.out.println("Invalid Year");
            }
            return vYear;
        }

        static void YearDropDowns(WebDriver driver, String YearDown, String MonthDown, String DateDown)
        {
            driver.findElement(By.xpath("//input[@id='third_date_picker']")).click();
            
            // Select year
            WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
            Select drpYear = new Select(yearDropdown);
            drpYear.selectByVisibleText(YearDown);

            // Select month
            try {
            WebElement monthDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
            Select drpMonth = new Select(monthDropdown);
            drpMonth.selectByVisibleText(MonthDown);
            }
            catch(Exception name)
            {
            	System.out.println(name);
            }
            // Select date
            List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
            for(WebElement date : allDates)
            {
                if(date.getText().equals(DateDown))
                {
                    date.click();
                    break;
                }
            }
        }

        
        static void fourthBox(WebDriver driver, String fourthYear, String fourthMonth, String fourthDate)
        {
        	driver.findElement(By.xpath("//input[@id='fourth_date_picker']")).click();
        	WebElement fourthYearDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        	Select fourthDrp = new Select(fourthYearDown);
        	fourthDrp.selectByVisibleText(fourthYear);
        	
        	WebElement fourthMonthDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        	Select fourthDown = new Select(fourthMonthDown);
        	fourthDown.selectByVisibleText(fourthMonth);
        	
        	List<WebElement> allDownDates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
        	for(WebElement DatesDown: allDownDates)
        	{
        		if(DatesDown.getText().equals(fourthDate))
        		{
        			DatesDown.click();
        		}
        	}
        			
        	
        	
        }
        public static void selectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate)
        {
            while(true)
            {
                String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
                String displayYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
                
                Month expectMonth = convertMonth(requiredMonth);
                Month currentMonth = convertMonth(displayMonth);
                
                Year expectYear = convertYear(requiredYear);
                Year currentYear = convertYear(displayYear);
                
                int resultMonth = expectMonth.compareTo(currentMonth);
                int resultYear = expectYear.compareTo(currentYear);

                try {
                    if(resultYear < 0 || (resultYear == 0 && resultMonth < 0))
                    {
                        driver.findElement(By.xpath("//span[text()='Prev']")).click();
                    }
                    else if(resultYear > 0 || (resultYear == 0 && resultMonth > 0))
                    {
                        driver.findElement(By.xpath("//span[text()='Next']")).click();
                    }
                    else
                    {
                        break;
                    }
                }
                catch(Exception name)
                {
                    System.out.println(name);
                }
            }

            List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
            for(WebElement date : allDates)
            {
                if(date.getText().equals(requiredDate))
                {
                    date.click();
                    break;
                }
            }
        
        }
        
    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        driver.manage().window().maximize();
        
        driver.findElement(By.id("second_date_picker")).click();
        
        String requiredYear = "2021";
        String requiredMonth = "March";
        String requiredDate = "13";
        
        DatePicker.selectDate(driver, requiredYear, requiredMonth, requiredDate);
        
        // Example dropdown values
        String YearDown = "2022"; 
        String MonthDown = "Mar"; 
        String DateDown = "13"; 

        DatePicker.YearDropDowns(driver, YearDown, MonthDown, DateDown);
        
        String fourthYear = "2020";
        String fourthMonth = "Jun";
        String fourthDate = "18";
        
        DatePicker.fourthBox(driver, fourthYear, fourthMonth, fourthDate);
        
    }
}

 
