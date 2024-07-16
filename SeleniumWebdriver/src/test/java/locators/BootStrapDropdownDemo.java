package locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropdownDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		
		
		driver.findElement(By.cssSelector("button[class=' css-47sehv']")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); // opens drop down options
		
		
		//1. Select single options from drop down
		//driver.findElement(By.xpath("//input[@value='Bootstrap']")).click();
		
		//2. Capture all the options in the drop down and find the size
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		
		System.out.println("Number of options in drop down: "+options.size());
		
		//printing options in the drop down
		/*
		for(WebElement op:options) {
			
			System.out.println(op.getText());
		}
		
		*/
		//3.Select multiple check box in the drop down
		
		
		for(WebElement op:options) {
			String option=op.getText();
			if(option.equals("Java") || option.equals("Angular") || option.equals("Python")){
				op.click();
				
			}
 		}
		

	}

}
