package locators;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserHandlesTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();	
		
		/*
		 * 1. search a string
		 * 2. count number of links
		 * 3.click on each link using for loop
		 * 4.get window id for every browser window
		 * 5. close specific browser window
		 * 
		 */
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> search_result=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a"));
		WebElement moreLink=driver.findElement(By.xpath("//a[normalize-space()='More »']"));
		
		int NumLinks= search_result.size()+1;
		
		System.out.println("Number of links are: "+NumLinks);
		
		moreLink.click();
		
		
		for(int i=0; i<search_result.size();i++) {
			search_result.get(i).click();
		}
		
		Set<String> windowIDS = driver.getWindowHandles();
		
		//System.out.println(windowIDS);
		for(String win:windowIDS) {
			String title = driver.switchTo().window(win).getTitle();
			System.out.println(title);
			if(title.equals("Selenium dioxide - Wikipedia") || title.equals("Selenium - Search results - Wikipedia")) {
				driver.close();
		}
		
		
		
		
		}

	}

}
