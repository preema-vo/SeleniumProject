package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	
	
	static void selectFutureDate(WebDriver driver, String month, String year, String date) {
		
		//Select month and year
				while(true) {
					 String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					 String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
					 if (currentYear.equals(year) && (currentMonth.equals(month))) {
						 break;
					 }
					 
					 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // clicking next button
					// driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // clicking on previous button
				}
				
		//selecting the date
				
				List<WebElement> dateList=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
				
				for(WebElement d:dateList) {
					if(d.getText().equals(date)) {
						d.click();
						break;
					}
				}
	}
	
	
static void selectPastDate(WebDriver driver, String month, String year, String date) {
		
		//Select month and year
				while(true) {
					 String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					 String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
					 if (currentYear.equals(year) && (currentMonth.equals(month))) {
						 break;
					 }
					 
					 
					 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // clicking on previous button
				}
				
		//selecting the date
				
				List<WebElement> dateList=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
				
				for(WebElement d:dateList) {
					if(d.getText().equals(date)) {
						d.click();
						break;
					}
				}
	}
	
	
	
		
				
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		//switch to the frame
		driver.switchTo().frame(0); // we have only single frame
		
		//Method 1: send keys
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("07/09/2024"); //mm/dd/yyyy
		
		//Method 2: Using date picker
		// date which has to selected
		String year="2025";
		String month="December";
		String date="2";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();  //opens the date picker
		
		selectFutureDate(driver, month, year, date);
		//selectPastDate(driver, month, year, date);
		
		
		
		
	}

}
