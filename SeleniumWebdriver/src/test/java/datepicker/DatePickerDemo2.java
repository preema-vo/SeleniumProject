package datepicker;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {
	
	//user defined method for converting month from string to month Object
	
	static Month convertMonth(String month) {
		
		HashMap<String, Month> monthMap=new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vmonth=monthMap.get(month);
		
		if(vmonth==null) {
			System.out.println("Invalid month...");
			
		}
		
		return vmonth;
		
		
		
	}
	
	static void selectDate(WebDriver driver, String reqYear, String reqMonth, String reqDate) {
		
		//Select year
		
		
				WebElement yearEle=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				
				Select yearSelect=new Select(yearEle);
				yearSelect.selectByVisibleText(reqYear);
				
				//select month
				
				while(true) {
				String displayMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				
				//convert reqMonth and displayMonth to month Object
				
				Month reqMonthObj=convertMonth(reqMonth);
				Month displayMonthObj=convertMonth(displayMonth);
				
				//compare the month
				// if result is 0 then months are equal
				// result is >0 then future month
				// result is <0 then past month
				int result=reqMonthObj.compareTo(displayMonthObj);
				
				if(result>0) {
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				}
				
				if(result<0) {
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				}
				
				
				
				else 
					break;

			}
				
				// Select date
				List<WebElement> dateList=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
				for(WebElement dt:dateList) {
					
					if(dt.getText().equals(reqDate)) {
						dt.click();
						break;
					}
					
				}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize(); 
		
		String reqDate="3";
		String reqMonth="October";
		String reqYear="1996";
		
		
		
		//Switch to the frame
		WebElement frame1=driver.findElement(By.xpath("//iframe[@id='frame-one796456169']"));
		driver.switchTo().frame(frame1);
		
		//clicking on calendar icon
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		selectDate(driver, reqYear, reqMonth, reqDate);
		
		
		
		
	
	}

}
