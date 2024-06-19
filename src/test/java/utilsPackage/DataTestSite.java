////package utilsPackage;
////import org.openqa.selenium.chrome.ChromeDriver;
////import org.openqa.selenium.support.ui.Select;
////
////import java.io.IOException;
////import java.nio.file.Paths;
////import java.time.Duration;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.JavascriptExecutor;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.WebDriver;
////
////public class DataTestSite {
////
////	public static void main(String[] args) throws IOException, InterruptedException{
////
////		WebDriver driver = new ChromeDriver();
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////		
////		driver.get("https://www.moneycontrol.com/fixed-income/calculator/bombay-mercantile-co-operative-bank-/fixed-deposit-calculator-ZZZ-BBM002.html");
////		driver.manage().window().maximize();
////		
////		//Validation of Site Name
////		System.out.println("Site Title :"+driver.getTitle());
////		
////		String filePath = "C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\ExcelFile2.xlsx";
////		
////
////		
////		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
////		
////		JavascriptExecutor js = (JavascriptExecutor) driver;
////		
////		js.executeScript("window.scrollBy(0, 500)");
////		for(int i=1; i<=rows; i++)
////		{
////			String prin = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
////			String RoI = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
////			String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
////			String peiod2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
////			String freqMode = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
////			String mat_Value = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
////			
////			//Pass above data into Application
////			WebElement princ = driver.findElement(By.xpath("//input[@id='principal']"));
////			princ.clear();
////			princ.sendKeys(prin);
////			WebElement roi = driver.findElement(By.xpath("//input[@id='interest']"));
////			roi.clear();
////			roi.sendKeys(RoI);
////			
////			WebElement tenure = driver.findElement(By.xpath("//input[@id='tenure']"));
////			tenure.clear();
////			tenure.sendKeys(period1);
////			
////			Select drpTenure2 = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
////			drpTenure2.selectByVisibleText(peiod2);
////			
////			Select drpMode = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
////			drpMode.selectByVisibleText(freqMode);
////			
////            			
////			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]")).submit();
////						
////			//Validation
////			String act_Value = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
////			if(Double.parseDouble(mat_Value)==Double.parseDouble(act_Value))
////			{
////				System.out.println("Test Passed");
////				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Pass");
////				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
////			}
////			else
////			{
////				System.out.println("Test Failed");
////				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Fail");
////				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
////			}
////			Thread.sleep(300);
////					
////
////		}
////		
////			
////		
////		
////
////	}
////
////}
//package utilsPackage;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import java.io.IOException;
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
//
//public class DataTestSite {
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        
//        driver.get("https://www.moneycontrol.com/fixed-income/calculator/bombay-mercantile-co-operative-bank-/fixed-deposit-calculator-ZZZ-BBM002.html");
//        driver.manage().window().maximize();
//        
//        // Validation of Site Name
//        System.out.println("Site Title :" + driver.getTitle());
//        
//        String filePath = "C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\ExcelFile2.xlsx";
//        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
//        
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 500)");
//        
//        for (int i = 1; i <= rows; i++) {
//            String prin = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
//            String RoI = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
//            String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
//            String period2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
//            String freqMode = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
//            String mat_Value = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
//            
//            // Pass above data into Application
//            WebElement princ = driver.findElement(By.name("principal"));
//            princ.clear();
//            princ.sendKeys(prin);
//            WebElement roi = driver.findElement(By.xpath("//input[@id='interest']"));
//            roi.clear();
//            roi.sendKeys(RoI);
//            WebElement tenure = driver.findElement(By.xpath("//input[@id='tenure']"));
//            tenure.clear();
//            tenure.sendKeys(period1);
//            
//            Select drpTenure2 = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
//            drpTenure2.selectByVisibleText(period2);
//            
//            Select drpMode = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
//            drpMode.selectByVisibleText(freqMode);
//            
//            driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]")).submit();
//            
//            // Validation
//            try {
//            String act_Value = driver.findElement(By.xpath("//div[@class='PR20 PT5']/span[@id='resp_matval']/strong")).getText();
//            if (Double.parseDouble(mat_Value)==Double.parseDouble(act_Value)) {
//                System.out.println("Test Passed");
//                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Pass");
//                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
//            } else {
//                System.out.println("Test Failed");
//                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Fail");
//                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
//            }}
//            catch(Exception e)
//            {
//            	System.out.println(e.getMessage());
//            }
//            Thread.sleep(300);
//        }
//    }
//}
package utilsPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class DataTestSite {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.moneycontrol.com/fixed-income/calculator/bombay-mercantile-co-operative-bank-/fixed-deposit-calculator-ZZZ-BBM002.html");
            driver.manage().window().maximize();

            System.out.println("Site Title :" + driver.getTitle());

            String filePath = "C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\ExcelFile2.xlsx";
            int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500)");

            for (int i = 1; i <= rows; i++) {
                String prin = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
                String RoI = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
                String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
                String period2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
                String freqMode = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
                String mat_Value = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

                WebElement princ = driver.findElement(By.name("principal"));
                princ.clear();
                princ.sendKeys(prin);
                WebElement roi = driver.findElement(By.xpath("//input[@id='interest']"));
                roi.clear();
                roi.sendKeys(RoI);
                WebElement tenure = driver.findElement(By.xpath("//input[@id='tenure']"));
                tenure.clear();
                tenure.sendKeys(period1);

                Select drpTenure2 = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
                drpTenure2.selectByVisibleText(period2);

                Select drpMode = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
                drpMode.selectByVisibleText(freqMode);

                driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]")).submit();

                String act_Value = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
                if (Double.parseDouble(mat_Value) == Double.parseDouble(act_Value)) {
                    System.out.println("Test Passed");
                    ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Pass"); // Update "Actual Result" column
                    ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7); // Optional: Fill cell with green color
                } else {
                    System.out.println("Test Failed");
                    ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Fail"); // Update "Actual Result" column
                    ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7); // Optional: Fill cell with red color
                }
                Thread.sleep(300);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     }
}
