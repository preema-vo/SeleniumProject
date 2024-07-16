package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AssignmentCSSLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// write css locators to identify elements
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.opencart.com/");
		
		driver.manage().window().maximize();
		
		// 1. tag and id
		boolean logostatus=driver.findElement(By.cssSelector("div#logo")).isDisplayed();
		
		System.out.println(logostatus);
		
		//2. tag.classname
		
		driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.dropdown-toggle")).click();
		
		//3. tag[attribute='value'] and 2.tag.classname
		driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("phone");
		driver.findElement(By.cssSelector("button.btn.btn-light.btn-lg")).click();
		
		// 4.  tag.classname[attribute="value"]
		
		//driver.findElement(By.cssSelector("a.nav-link.dropdown-toggle[href='https://demo.opencart.com/index.php?route=product/category&language=en-gb&path=34']")).click();
		
		//driver.findElement(By.cssSelector("a.nav-link[href='https://demo.opencart.com/index.php?route=product/category&language=en-gb&path=33']")).click();
	}

}
