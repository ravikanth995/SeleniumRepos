package exelItils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utilsPackage.ExcelUtils;

public class ExcelClass {

	
		public static void main(String[] args) throws IOException, InterruptedException{

			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://www.moneycontrol.com/fixed-income/calculator/bombay-mercantile-co-operative-bank-/fixed-deposit-calculator-ZZZ-BBM002.html");
			driver.manage().window().maximize();
			
			//Validation of Site Name
			System.out.println("Site Title :"+driver.getTitle());
			
			String filePath = System.getProperty("user.dir")+"\\testData\\ExcelFile.xlsx";
			int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 500)");
			for(int i=1; i<=rows; i++)
			{
				String prin = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
				String RoI = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
				String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
				String peiod2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
				String freqMode = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
				String mat_Value = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
				
				//Pass above data into Application
				driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(prin);
				driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(RoI);
				driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
				
				Select drpTenure2 = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
				drpTenure2.selectByVisibleText(peiod2);
				
				Select drpMode = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
				drpMode.selectByVisibleText(freqMode);
				
	            			
				driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]")).submit();
							
				//Validation
				String act_Value = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
				if(Double.parseDouble(mat_Value)==Double.parseDouble(act_Value))
				{
					System.out.println("Test Passed");
					ExcelUtils.setCellData(filePath, "Sheet1", i, 8, "Passed");
					ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 8);
				}
				else
				{
					System.out.println("Test Failed");
					ExcelUtils.setCellData(filePath, "Sheet1", i, 8, "Failed");
					ExcelUtils.fillRedColor(filePath, filePath, rows, rows);
				}
				Thread.sleep(1000);
				driver.findElement(By.xpath("//img[@class='PL5']")).click();
			

			}
			
			driver.close();
			
			

	}

}
