package utilsPackage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class Citybank {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
        driver.manage().window().maximize();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 600)");
//        
        String filePath = "C:\\Users\\Shashikanth.DESKTOP-9G7BEQK\\eclipse-workspace\\seleniumWebdriver\\testData\\Compound.xlsx";
//        
        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
        for (int i = 1; i <= rows; i++) {
            // Reading data from Excel
            String princ = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String time = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String roi = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String expValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
            
//            // Passing data into Application
            WebElement pr = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
            pr.clear();
            pr.sendKeys(princ);
            
            WebElement timePeriod = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
            timePeriod.clear();
            timePeriod.sendKeys(time);
//            
            WebElement ROI = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
            ROI.clear();
            ROI.sendKeys(roi);
//            
            
            driver.findElement(By.xpath("//div[@class='mat-select-arrow ng-tns-c109-4']")).click();
            List<WebElement> comData = driver.findElements(By.xpath("//div[@role='listbox']/mat-option[@role='option']/span"));
            System.out.println("Total Lists :"+comData.size());
            for(WebElement x: comData)
            {
//            	System.out.println(x.getText());
            	if(x.getText().equals(freq))
            	{
            		x.click();
            		break;
            	}
            	
            	
            }
            
            
            String actValue = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText().replace("$", "").replace(",", "");;
            if (Double.parseDouble(expValue) == Double.parseDouble(actValue)) {
                System.out.println("Passed");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 6, "Pass");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 6);
            } else {
                System.out.println("Failed");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 6, "Fail");
                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 6);
            }
            Thread.sleep(600);
        }
//        driver.quit();
    }
}