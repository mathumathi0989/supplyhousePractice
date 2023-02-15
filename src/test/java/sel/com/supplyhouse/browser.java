package sel.com.supplyhouse;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.resources.base;

public class browser extends base {

	@BeforeSuite
	public void Browser_launch() throws Exception {
		base.driver = launch();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
