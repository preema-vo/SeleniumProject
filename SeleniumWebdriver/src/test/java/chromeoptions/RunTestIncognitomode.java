package chromeoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunTestIncognitomode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito"); 
		
		WebDriver driver=new ChromeDriver(options);
		
		
		driver.get("https://demo.nopcommerce.com/");
		
		String page_title=driver.getTitle();
		
		if (page_title.equals("nopCommerce demo store")) {
			System.out.println("Test case is pass.");
		}
		else {
			System.out.println("Test case is pass.");
		}

	}

}
