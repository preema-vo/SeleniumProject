package locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Assgnt 1: Handle country drop down with/without using Select class
		 * 	https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/
		 * 	count number of options -- in country and print
		 * select one option
		 */
		WebDriver driver=new ChromeDriver();
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		WebElement country_element=driver.findElement(By.xpath("//select[@id='country-list']"));
		
		Select country=new Select (country_element);
		//country.selectByIndex(3);
		
		//country.selectByValue("3");
		
		country.selectByVisibleText("China");
		
		List<WebElement> country_list=country.getOptions();
		
		System.out.println("Number of countries in the drop down "+country_list.size());
		
		for(WebElement op:country_list) {
			System.out.println(op.getText());
		}
		
		

	}

}
