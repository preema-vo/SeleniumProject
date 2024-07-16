package webtables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentBootStrapTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 1. open https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		 * 2. login
		 *3. go to admin
		 * 4. get user name and user roles
		 * 
		 */
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.clear();
		username.sendKeys("Admin");
		
		WebElement pwd=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pwd.clear();
		pwd.sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		int rows=driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']")).size();

		for(int r=1; r<=rows;r++) {
			String name=driver.findElement(By.xpath("//div[@role='rowgroup']//div["+r+"]//div[1]//div[2]//div[1]")).getText();
			//String userrole=driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[3]//div")).getText();
			
			System.out.println(name);
			
		}
		List<WebElement> userroleEle=driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[3]//div[1]"));
		for(int i=0;i<userroleEle.size();i++) {
			String userrole=userroleEle.get(i).getText();
			System.out.println(userrole);
		}
		
		

	}

}
