package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

import Selenium.com.supplyhouse.Base;
import Selenium.com.supplyhouse.readDatafromExcel;

public class search extends Base {


	public search(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	
	@DataProvider
	public Object[][] readExcel() {
		
		Object[][] data = new Object[2][1];
		data[0][0] = "AT082410C";
		data[1][0] = "AT082410C1";
		
		//System.out.println(data[0]);
	return data;
	}
	
	@DataProvider(name = "readExcel")
	public search searchT(String model) {
			driver.findElement(By.id("model-number")).sendKeys(model);
		driver.findElement(By.xpath("//*[@id='model-number-input-container']/following-sibling::button")).submit();
		return this;
		
	}
	
	public boolean resultsValidation() {
		return driver.findElement(By.id("browse-results")).isDisplayed();
	}
	
	public String match() {
	String actualSearchResult =	driver.findElement(By.xpath("//*[contains(@class,'none') and contains(@class,'inline-sku-and-brand')]/strong")).getText();
	return actualSearchResult;
	}
	
	public String Nomatch() {
			String noMatch = driver.findElement(By.xpath("//*[@id='search-result-message']/p")).getText();
		return noMatch;
		
	}
	
}
