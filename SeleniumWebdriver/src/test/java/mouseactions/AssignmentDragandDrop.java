package mouseactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentDragandDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. Launch  http://demo.guru99.com/test/drag_drop.html
		 * 2. drag and drop
		 * 
		 */
		
WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize(); 
		
		Actions act=new Actions(driver);
		
		WebElement source1=driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]//a[1]"));
		WebElement bank=driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		
		WebElement target1=driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		WebElement target2=driver.findElement(By.xpath("//table//tbody//tr//td//div//ol[@id='amt7']"));
		
		act.dragAndDrop(source1, target2).build().perform();
		act.dragAndDrop(bank, target1).build().perform();
		
		WebElement source2=driver.findElement(By.xpath("//section[@id='g-container-main']//li[2]//a[1]"));
		WebElement sales=driver.findElement(By.xpath("//section[@id='g-container-main']//li[6]//a[1]"));
		
		WebElement target3=driver.findElement(By.xpath(" //ol[@id='loan']//li[@class='placeholder']"));
		WebElement target4=driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));
		
		act.dragAndDrop(source2, target4).build().perform();
		act.dragAndDrop(sales, target3).build().perform();
		
		System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Perfect!']")).isDisplayed());
		
		
		
 
	}

}
