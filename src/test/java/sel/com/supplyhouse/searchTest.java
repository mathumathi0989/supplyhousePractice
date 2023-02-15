package sel.com.supplyhouse;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.resources.base;
import com.resources.dataPro;

import pages.search;

@Listeners(org.testng.reporters.EmailableReporter.class)
public class searchTest extends base{

	public WebDriver driver;

	@Test(dataProvider = "boilerPart", dataProviderClass=dataPro.class)
	public void searchvalid(String data) throws Exception {
		driver = base.driver;
		search s = new search(driver);
		s.searchText(data);
		try {
			Boolean results = driver.findElement(By.xpath("//ul[@id='browse-results']/li")).isDisplayed();
			if(results)
			{
				Assert.assertEquals(s.searchpageValid(), data);
				}
			else
			{
				Assert.assertEquals(s.searchPageInvalid(),"Sorry, we couldn't find any matches for \""+data+"\"" );
			}
		} catch (NoSuchElementException e) {
			Assert.assertEquals(s.searchPageInvalid(),"Sorry, we couldn't find any matches for \""+data+"\"" );
		}
	}
	
	
	
	
	
	
	
}
