package webtables;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmemtStaticWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. Open https://blazedemo.com/
		 * 2. Select the departure and destination city 
		 * 3. click on Find flights. 
		 * 4. Table will be displayed. Select the lowest price flight and click on choose flight
		 * 5. fill the form with dummy data and click on Purchase flight
		 * 6. Verify the "Thank You" message
		 * 
		 */
		
		//1. Open https://blazedemo.com/
		WebDriver driver=new ChromeDriver();
		driver.get("https://blazedemo.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		WebElement departure_element=driver.findElement(By.xpath("//select[@name='fromPort']"));
		
		//2. Select the departure and destination city 
		Select departure=new Select(departure_element);
		departure.selectByValue("Boston");
		
		WebElement destination_element=driver.findElement(By.xpath("//select[@name='toPort']"));
		
		Select destination=new Select(destination_element);
		destination.selectByValue("London");
		
		//3. click on Find flights.
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		
		//4. Table will be displayed. Select the lowest price flight and click on choose flight
		int size=driver.findElements(By.xpath("//table[@class='table']//tr//td[6]")).size();
		String[] pricelist = new String[size];
		String [] org_pl=new String[size];
		for(int i=1;i<=size;i++) {
				int j=i-1;
		pricelist[j]=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
		org_pl[j]=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
		
		//System.out.println(pricelist[j]);
			
		}
		
					 
				
	
		
	Arrays.sort(pricelist);
	//System.out.println(Arrays.toString(pricelist));
	
	
	String lowest_price=pricelist[0];
	
	

	
	for(int k=0;k<org_pl.length;k++) {
		int in=k+1;
		//System.out.println(org_pl[k]);
		if(lowest_price.equals(org_pl[k])) {
			//System.out.println(driver.findElement(By.xpath("//tbody/tr["+in+"]/td[1]/input[1]")));
			driver.findElement(By.xpath("//tbody/tr["+in+"]/td[1]/input[1]")).click();
			
						//System.out.println("if loop: "+in);
			break;
		}
		else
		{
			in=in+1;
		//System.out.println("else loop: "+in);
		}
		
		
		
	}
	
	//5. fill the form with dummy data and click on Purchase flight
	
	String title="BlazeDemo Purchase";
	String page_title=driver.getTitle();
	if(title.equals(page_title)) {
		System.out.println("Step 4 is pass");
	}
	else
		System.out.println("Step 4 is fail");
	
	driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("name");
	driver.findElement(By.xpath("//input[@id='address']")).sendKeys("12e mansjh");
	driver.findElement(By.xpath("//input[@id='city']")).sendKeys("anytown");
	driver.findElement(By.xpath("//input[@id='state']")).sendKeys("state");
	driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("12345");
	
	
	WebElement cardtype=driver.findElement(By.xpath("//select[@id='cardType']"));
	Select ct=new Select(cardtype);
	ct.selectByValue("visa");
	
	
	driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("1234123412341234");
	
	driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("smith");
	
	driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
	
	 // 6. Verify the "Thank You" message
	boolean thankyou_msg=driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).isDisplayed();
	String title1="BlazeDemo Confirmation";
	String page_title1=driver.getTitle();
	if(title1.equals(page_title1)  && thankyou_msg==true) {
		System.out.println("Step 5 is pass");
	}
	else
		System.out.println("Step 5 is fail");
	
	

	

}
	
	
}

