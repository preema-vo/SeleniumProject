package chromeoptions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		
		//1. capture full page screenshot
		/*
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);  // here we dont know where it is stored in the memory
		
		//File targetFile=new File("K:\\SeleniumLearning\\Automation_Workspace\\SeleniumWebdriver\\SeleniumWebdriver\\screenshots\\fullpage.png");
		
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		sourceFile.renameTo(targetFile); //copy the source file to target file
		*/
		
		//2. capture the screenshot of specific section of the page
		/*
		WebElement featureProductSection=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File sourceFile=featureProductSection.getScreenshotAs(OutputType.FILE);
		
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\featureproducts.png");
		
		sourceFile.renameTo(targetFile); 
		*/
		
		//3. capture the screenshot of specific web element of the page
				
		WebElement logo=driver.findElement(By.xpath("//div[@class='header-logo']"));
				
		File sourceFile=logo.getScreenshotAs(OutputType.FILE);
				
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
				
		sourceFile.renameTo(targetFile); 
		

	}

}
