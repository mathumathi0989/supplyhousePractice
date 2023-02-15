package sel.com.supplyhouse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.resources.base;

import pages.search;

public class searchTest extends base{

	public WebDriver driver;
	public String data = "AT082410C";

	//correct data = AT082410C
	



	
	@Test
	public void searchvalid() throws Exception {
		driver = base.driver;
		search s = new search(driver);
		s.searchText(data);
	Assert.assertEquals(s.searchpageValid(), data);
	//	Assert.assertEquals(s.searchPageInvalid(),"Sorry, we couldn't find any matches for \""+data+"\"" );
	}
	
	
	
	
	
	
	
	
}
