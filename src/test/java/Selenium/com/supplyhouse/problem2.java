package Selenium.com.supplyhouse;

import org.testng.Assert;
import org.testng.annotations.Test;

import Resources.search;


public class problem2 extends Base{



	static String data = "AT082410C";
	
	@Test
	public void ValidsearchTC() {
		search s = new search(driver);
System.out.println(data);
		s.search(data);
		Assert.assertEquals(s.match(), data, "item matching");
		Assert.assertEquals(s.Nomatch(), "Sorry, we couldn't find any matches for \" "+data+"\"", "item not matching");
	Assert.assertTrue(s.resultsValidation(), "browse results showed");;
	}
	

}
