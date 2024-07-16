package mouseactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentDoubleClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. Launch https://testautomationpractice.blogspot.com/
		 * 2. double click
		 * 3. drag and drop
		 * 
		 */
		
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize(); 
		
		Actions act=new Actions(driver);
		
		/*
		//2. double click
		
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field1']"));
		box1.clear();
		box1.sendKeys("Welcome");
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		act.doubleClick(button).build().perform();
		
		String text1=box1.getAttribute("value");
		String text2=box2.getAttribute("value");
		
		System.out.println(text1);
		System.out.println(text2);
		
		if(text1.equals(text2)) {
			System.out.println("Text is copied..");
		}
		else
			System.out.println("Text is not copied..");
		
		*/
		
		// 3.drag and drop
		WebElement sourceEle=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetEle=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		act.dragAndDrop(sourceEle, targetEle).build().perform();
		
		String txt=driver.findElement(By.xpath("//div[@id='droppable']//p")).getText();
		
		System.out.println(txt);
		if(txt.equals("Dropped!")) {
			System.out.println("Item is dropped..");
		}
		else
			System.out.println("Item is not dropped..");

	}

}
