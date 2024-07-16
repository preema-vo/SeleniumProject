package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* go to: https://ui.vision/demo/webtest/frames/
		 * Go to frame 5 pass values
		 * click on the link, another iframe opens
		 * click on some elements on that page
		 * and validate the logo
		 */
		
WebDriver driver=new ChromeDriver();
		
		driver.get("https://ui.vision/demo/webtest/frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("welcome");
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		Boolean logostatus=driver.findElement(By.xpath("//img[@alt='UI Vision by a9t9 software - Image-Driven Automation']")).isDisplayed();
		System.out.println("Logo dispalyed status: "+logostatus);
		driver.findElement(By.xpath("//a[normalize-space()='Support']")).click();
		
		driver.switchTo().defaultContent();

	}

}
