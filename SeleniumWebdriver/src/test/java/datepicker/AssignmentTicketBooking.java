package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentTicketBooking {
	
	static void selectDate(WebDriver driver, String month, String year, String date) {
		WebElement monthEle=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthSel=new Select(monthEle);
		monthSel.selectByVisibleText(month);
		
		WebElement yearEle=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yearSel=new Select(yearEle);
		yearSel.selectByVisibleText(year);
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		
		for(WebElement dt:allDates) {
			
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. open https://www.dummyticket.com/dummy-ticket-for-visa-application/
		 * 2. provide all the required details
		 * 
		 */
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// providing name
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("smith");
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("alex");
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
		String birthDate="15";
		String birthMonth="Jul";
		String birthYear="1995";
		selectDate(driver, birthMonth, birthYear, birthDate);
		
		driver.findElement(By.xpath("//input[@id='sex_2']")).click();
		
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Delhi");
		driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("Bangalore");
		
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		selectDate(driver, "Dec", "2024", "25");
		
		/*WebElement dummyEle=driver.findElement(By.xpath("//p//span//select[@name='reasondummy']"));
		Select dummySel=new Select(dummyEle);
		dummySel.selectByValue("3");
		*/
		
		
		driver.findElement(By.xpath("//input[@id='appoinmentdate']")).click();
		selectDate(driver, "Apr", "2025", "25");
		
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("0123456789");
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("abc@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("123 bjbk");
		
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("City");
		
		//driver.findElement(By.xpath("//button[@id='place_order']")).click();
		
		
		

	}

}
