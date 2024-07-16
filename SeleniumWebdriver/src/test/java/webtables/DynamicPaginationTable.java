package webtables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//login
		WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear(); // to clear the input box
		username.sendKeys("demo");
		
		WebElement pwd=driver.findElement(By.xpath("//input[@id='input-password']"));
		pwd.clear(); // to clear the input box
		pwd.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//click on Customers and then customers sub menu
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		//Capturing the number of pages
		String s=driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
		
		int num_pages=Integer.parseInt(s.substring(s.indexOf("(")+1, s.indexOf("P")-1));
		
		// clicking on each page -- we are reading only 5 pages for now as there are many pages
		for(int p=1;p<=4;p++) {
			if(p>1) {
				
				WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				Actions act =  new Actions(driver);
				act.moveToElement(active_page).click().perform();
				
				active_page.click();
				Thread.sleep(3000);
			}
			// reading data from the page
			int num_rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			for (int r=1;r<=num_rows;r++) {
				
				String custName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
			
				System.out.println(custName+"\t"+email+"\t"+status);
			}
		}
		

	}

}
