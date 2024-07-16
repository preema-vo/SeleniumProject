package locators;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

/*
 * Test Case:
 To verify the title of the browser:
 1. Launch the browser
 2. Open the URL
 3. Validate the title
 4. Close the browser
 */


public class FirstTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Launch the browser
		
		//ChromeDriver chDriver=new ChromeDriver();
		
		//or
		
		// WebDriver driver=new ChromeDriver();	
		 WebDriver driver=new EdgeDriver();
		 
		// 2. Open the URL
		 
		 driver.get("https://demo.opencart.com/");
		 
		 //3. Validate the title
		 
		String page_title= driver.getTitle();
		String expect_title="Your_Store";
		
		if(page_title.equals(expect_title)) 
		{
			System.out.println("Test case is passed");
		}
		else
		{
			System.out.println("Test case is passed");
		}
		;
		//	4. Close the browser
		
		//driver.close();
		
		driver.quit();
	}

}
