package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.base;


public class search extends base{

	public WebDriver driver;

	@FindBy(xpath="//div[@id='model-number-input-container']/following-sibling::button")
	private WebElement searchButton;
	

	@FindBy(id="model-number")
	private WebElement id;
	
	public search(WebDriver driver) throws Exception {
		this.driver = base.driver;
		if (base.driver == null) {
		    throw new Exception("WebDriver is null");
		}
		PageFactory.initElements(driver, this);
	}


	public void searchText(String data) throws Exception {
		id.clear();
		id.sendKeys(data);
		searchButton.click();
		Thread.sleep(2000);
	}

	public String searchpageValid() throws Exception {
		String title = driver.findElement(By.xpath("//*[@class='product-name']/strong")).getText();
		System.out.println("Title of the product: " +title);
		String[] split_title = title.split(" ",10);
		System.out.println(split_title[0]);
		return split_title[0];
	}

	public String searchPageInvalid() {
		String woTitle = driver.findElement(By.xpath("//*[@id='search-result-message']/p")).getText();
		System.out.println(woTitle);
		return woTitle;
	}






}
