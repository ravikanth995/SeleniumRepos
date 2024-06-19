package webTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class DynamicTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 190)");
		
//		WebElement text = driver.findElement(By.id("chrome-cpu"));
//		System.out.println(text.getText());
//		
//		List<WebElement> allCPUData = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
//		for(WebElement x: allCPUData)
//		{
//			System.out.println(x.getText());
//		}
//		System.out.println(text.getText());
//
//		String ar[] = new String[allCPUData.size()];
//		for(int i=0; i<allCPUData.size(); i++)
//		{
//			ar[i] = allCPUData.get(i).getText();
//			
//		}
//		
//		System.out.println("After Sorting...");
//		
//		Arrays.sort(ar);
//		boolean textPresent = false;
//		List<WebElement> rowsData = driver.findElements(By.xpath("//table/tbody/tr/td"));
//		for(WebElement x: rowsData)
//		{
//			System.out.println(x.getText()+"| ");
//			if(x.getText().equals(text))
//			{
//				System.out.println("text matched..");
//				textPresent=true;
//				break;
//			}
//		}
//		if(textPresent==false)
//		
//		{
//			System.out.println("Text did not match");
//		}
//		     
		WebElement textElement = driver.findElement(By.id("chrome-cpu"));
        String textToMatch = textElement.getText();
        System.out.println("Text to match: " + textToMatch);

        // Extract all CPU data from the table
        boolean matchFound = false;
        List<WebElement> allCPUData = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        for (WebElement cpuData : allCPUData) {
            String cellText = cpuData.getText();
            if(cellText.equals(textToMatch))
            {
            	System.out.println("Matched :"+cellText);
            	matchFound=true;
            	break;
            }
        }
        if(matchFound==false)
        {
        	System.out.println("did not match ");
        }

               		
		}
		
		
		
		

	}

