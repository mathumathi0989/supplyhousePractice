package Selenium.com.supplyhouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class search {
	
	String data = "AT082411C";
	//correct data = AT082410C
	@Test
	public void launch() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.supplyhouse.com/Boiler-Parts-Finder-Tool");
		driver.manage().window().maximize();
		driver.findElement(By.id("model-number")).sendKeys(data);
		driver.findElement(By.xpath("//div[@id='model-number-input-container']/following-sibling::button")).click();
		
		Thread.sleep(2000);
		
		String search = driver.findElement(By.xpath("//*[@id='search-result-message']/p")).getText();
		String expSearch = "Search Result for Model Number "+"\""+data+"\"";
		
		if(search.contentEquals(expSearch)) 
			
		//Output found
		{
		String title = driver.findElement(By.xpath("//*[@class='product-name']/strong")).getText();
		System.out.println(title);
		
		String[] split_title = title.split(" ",10);
		System.out.println(split_title[0]);
		
		}
		else 
		//Output not found
		{
		String woTitle = driver.findElement(By.xpath("//*[@id='search-result-message']/p")).getText();
		System.out.println(woTitle);
		}
		
		
	}
	
	
	
	
	
	
	
}
