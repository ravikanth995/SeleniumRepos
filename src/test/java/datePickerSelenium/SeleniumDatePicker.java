package datePickerSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SeleniumDatePicker {

    public static class DatePicker {

        static Month convertMonth(String month) {
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
            if (vMonth == null) {
                System.out.println("Invalid Month");
            }
            return vMonth;
        }

        static Year convertYear(String year) {
            HashMap<String, Year> yearMaps = new HashMap<String, Year>();

            HashMap<String, Year> yearsMaps = new HashMap<>();
            for(int i = 2000; i <= 2026; i++)
            {
                yearsMaps.put(String.valueOf(i), Year.of(i));
            }


            Year vYears = yearsMaps.get(year);
            if (vYears == null) {
                System.out.println("Invalid Year");
            }
            return vYears;
        }

        public static void selectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate) {
            while (true) {
            	String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
                String displayYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

                Month expectedMonth = convertMonth(requiredMonth);
                Month currentMonth = convertMonth(displayMonth);

                Year expectedYear = convertYear(requiredYear);
                Year currentYear = convertYear(displayYear);

                int resultMonth = expectedMonth.compareTo(currentMonth);
                int resultYear = expectedYear.compareTo(currentYear);

                if (resultYear < 0 || (resultYear == 0 && resultMonth < 0)) {
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
                } else if (resultYear > 0 || (resultYear == 0 && resultMonth > 0)) {
                    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
                } else {
                    break;
                }
            }

            List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
            for (WebElement date : allDates) {
                if (date.getText().equals(requiredDate)) {
                    date.click();
                    break;
                }
            }
        }
        }

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.globalsqa.com/demo-site/datepicker/");
        driver.manage().window().maximize();

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iframeElement);

        driver.findElement(By.id("datepicker")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 80)");

        String requiredYear = "2022";
        String requiredMonth = "March";
        String requiredDate = "18";

        DatePicker.selectDate(driver, requiredYear, requiredMonth, requiredDate);
    }

}
