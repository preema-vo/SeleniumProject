package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * 
 * Open site: https://www.demoblaze.com/index.html
 * 1. total number of links and print them
 * 2. total number of images
 * 3. click on any product link using linkText/partiallinkText
 */

public class AssignmentLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.demoblaze.com/index.html");
		
		driver.manage().window().maximize();
		
		//1. total number of links and print them
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links on the page: "+links.size());
		//System.out.println("links on the page: "+links);
		
		//2. total number of images
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total number of images is: "+images.size());
		
		//3. click on any product link using linkText/partiallinkText
		driver.findElement(By.linkText("Samsung galaxy s7")).click();
		
		driver.quit();
		

	}

}
