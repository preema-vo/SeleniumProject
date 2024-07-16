package chromeoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingSSL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true); //accepts SSL certificat
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		
		System.out.println("title of the page: "+driver.getTitle());
		

	}

}
