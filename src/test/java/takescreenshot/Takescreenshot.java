package takescreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Takescreenshot {

    public static void FlipKart(WebDriver driver) {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        // Construct the target file path
        String targetFilePath = System.getProperty("user.dir") + "\\screenShot\\fullPage.png";
        File targetFile = new File(targetFilePath);

        // Ensure the directory exists
        try {
            Files.createDirectories(Paths.get(targetFile.getParent()));
        } catch (IOException e) {
            System.err.println("Failed to create directory: " + e.getMessage());
        }

        // Save the screenshot to the target location
        try {
            Files.copy(sourceFile.toPath(), targetFile.toPath());
            System.out.println("Screenshot saved successfully at " + targetFilePath);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Takescreenshot.FlipKart(driver);

        // Quit the driver after the screenshot is taken
        driver.quit();
    }
}
