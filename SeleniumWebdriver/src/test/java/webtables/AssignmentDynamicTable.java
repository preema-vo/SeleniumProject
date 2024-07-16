package webtables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentDynamicTable {

	public static void main(String[] args) throws InterruptedException {
		
		
		// TODO Auto-generated method stub

		/*
		 * 1. go to https://testautomationpractice.blogspot.com/
		 * 2.go to pagination table at bottom
		 * 3. read all the data and select the checkbox
		 * 4. go to next page
		 * 5. read the data and select the checkbox
		 * 6. go till 4th page
		 * 7. read the data and select the checkbox
		 * 
		 */
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		int pages=driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
		
		System.out.println(pages);
		
		
		
		for(int p=1;p<=pages;p++) {
			if(p>1) {
			driver.findElement(By.xpath("//ul[@id='pagination']//li["+p+"]//a")).click();
			Thread.sleep(3000);
			}
			
			int rows=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			for(int r=1;r<=rows;r++) {
					
				String id=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[1]")).getText();
				String name=driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]//td[2]")).getText();
				String price=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[3]")).getText();
				System.out.println(id+"\t"+name+"\t"+price);
				driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]/td[4]/input")).click();
			
			}
		}

	}
	

}
