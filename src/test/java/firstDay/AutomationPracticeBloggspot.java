package firstDay;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationPracticeBloggspot {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//Getting into WebSite
		
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		
		//Enlarging window
		driver.manage().window().maximize();
		
		//Getting the URL of the page
		
		String currentURL = driver.getCurrentUrl();
		if(url.equals(currentURL)) {
			System.out.println("URL address is matching");
		}
		else {
			System.out.println("URL address is not matching...");
		}
		
		String title = "Practice Page";
		String siteTitle = driver.getTitle();
		if(title.endsWith(siteTitle)) {
			System.out.println("Title Is Matching..");
		}
		else {
			System.out.println("Title is not matching..");
		}
		
		boolean logo = driver.findElement(By.className("logoClass")).isDisplayed();
		System.out.println("Is Logo os Rahul Shetty Automation displayed..."+logo);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("How many links are there :"+links.size());
		
//		for(WebElement x: links) {
//			System.out.println(x.getText());
//		}
		
		WebElement signUp = driver.findElement(By.xpath("//button[text()='Signup']"));
		signUp.click();
		
		boolean radioLabel = driver.findElement(By.xpath("//fieldset/legend[text()='Radio Button Example']")).isDisplayed();
		System.out.println("Is Label "+"Radio Button Example : "+radioLabel);
		
		
		boolean radioBtn = driver.findElement(By.xpath("//input[@value='radio1']")).isEnabled();
		System.out.println("Is Radio 1 Button Enabled :"+radioBtn);
		
		System.out.println("-".repeat(90));
		 System.out.println("Before Radio Button Selection ");
		
		boolean radiobtn = driver.findElement(By.xpath("//input[@value='radio1']")).isSelected();
		System.out.println("Is Radio 1 Button Selected.. :"+radiobtn);
		System.out.println("-".repeat(90));
		
		System.out.println("After Radio Button Selected");
		WebElement radioBtns = driver.findElement(By.xpath("//input[@value='radio1']"));
		radioBtns.click();
		
		boolean radiobtns = driver.findElement(By.xpath("//input[@value='radio1']")).isSelected();
		System.out.println("Is Radio 1 Button Selected.. :"+radiobtns);
		System.out.println("-".repeat(90));
		
		//Suggestion class Logo
		
		boolean suggestionLogo = driver.findElement(By.xpath("//legend[text()='Suggession Class Example']")).isDisplayed();
		System.out.println("Is Suggestion class Logo Displayed :"+suggestionLogo);
		
		String inputBox = "I have an Suggestion";
		driver.findElement(By.id("autocomplete")).sendKeys(inputBox);
		
		//DropDown Logo
		boolean drpDownLogo = driver.findElement(By.xpath("//legend[text()='Dropdown Example']")).isDisplayed();
		System.out.println("Is DropDown Logo Displayed :"+drpDownLogo);
		
		List<WebElement> drpDown = driver.findElements(By.xpath("//select[@id='dropdown-class-example']/option"));
		System.out.println("How Many DropDown Option is Available "+drpDown.size());
		for(WebElement y: drpDown) {
			System.out.println(y.getText());
		}
		
		WebElement drpDowns = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select drpDownOf = new Select(drpDowns);
		drpDownOf.selectByVisibleText("Option1");
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
		System.out.println("How many Checkboxes are there  :"+checkBoxes.size());
		for(WebElement c: checkBoxes) {
			System.out.println(c.getText());
		}
		for(WebElement z: checkBoxes) {
			z.click();
		}
		boolean windowLabel = driver.findElement(By.xpath("//legend[text()='Switch Window Example']")).isDisplayed();
		System.out.println("Is Logo of Switch Window Displayed:"+windowLabel);
		
//		WebElement WindowPage = driver.findElement(By.id("openwindow"));
//		WindowPage.click();
//		
//		System.out.println("Window ID :"+driver.getWindowHandle());
		
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th"));
		for(WebElement data: tableData) {
			System.out.println(data.getText());
		}
		
		List<WebElement> fullData = driver.findElements(By.xpath("//table[@id='product']/tbody/tr"));
		System.out.println("Number of Data Present is :"+fullData.size());
		for(WebElement fData : fullData) {
			Thread.sleep(1000);
			System.out.println(fData.getText()+"| ");
		}
		
		//Instructor Name 
		List<WebElement> InstName = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[1]"));
		System.out.println("Totall Instructor Names :"+InstName.size());
		for(WebElement iName : InstName) {
			
			Thread.sleep(1000);
			System.out.println(iName.getText());
		}
		
		List<WebElement> CourseName = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[2]/td[2]"));
		for(WebElement CourName: CourseName) {
			System.out.println(CourName.getText());
		}
		}

}
