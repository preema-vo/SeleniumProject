package verifylinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1. get the href link
 * 2. check the sever status code
 * 3. status code >=400 -- broken link
 * 		status code<400 -- not broken link
 * 
 */

public class BrokenLinksDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://deadlinkcity.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links: "+links.size());
		
		int numOfBrokenLinks=0;
		int numOfActualLinks=0;
		
		for(WebElement l:links) {
			String hrefAttributeValue=l.getAttribute("href");
			System.out.println(hrefAttributeValue);
			if(hrefAttributeValue==null || hrefAttributeValue.isEmpty()) {
				System.out.println("href value is empty or null, so not possible to check");
				continue;
			}
			
			try 
			{
			//hit url to the server
			URL linkURL=new URL(hrefAttributeValue); //converting string format of href value to URL format
			HttpURLConnection connlinkURL=(HttpURLConnection) linkURL.openConnection();  // opens connection the the server
			connlinkURL.connect(); //connect to the sever and send the request to server
			if(connlinkURL.getResponseCode()>=400) {
				System.out.println(hrefAttributeValue+ " >> is broken link");
				numOfBrokenLinks++;
			}
			else {
				System.out.println(hrefAttributeValue+ " >> Not a broken link");
				numOfActualLinks++;
			}
			
			}
			catch(Exception e){
				
			}
			
		}
		System.out.println("Number of broken links: "+numOfBrokenLinks);
		System.out.println("Number of working links: "+numOfActualLinks);

	
	}

}
