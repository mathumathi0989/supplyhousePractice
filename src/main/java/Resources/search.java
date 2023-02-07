package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import Selenium.com.supplyhouse.Base;

public class search extends Base {

	

	public search(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public search search(String modelNum) {
		System.out.println(modelNum);
			driver.findElement(By.id("model-number")).sendKeys(modelNum);
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
