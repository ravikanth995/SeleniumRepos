package fileUpload;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class FileUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\JavaPractice\\text1.txt");
		if(driver.findElement(By.xpath("//input[@id='filesToUpload']")).getText().equals("text1.txt"))
		{
		
			System.out.println("File Uploaded Successfully..");
		}
		else
		{
			System.out.println("File Upload did not work");
		}
		

	}

}
