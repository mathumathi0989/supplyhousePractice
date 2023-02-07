package Selenium.com.supplyhouse;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public RemoteWebDriver driver = null;
	
	
	@BeforeMethod
	public RemoteWebDriver setup() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Properties prop = new Properties();
		prop.load(new FileInputStream("D:\\2023AutoPractice\\com.supplyhouse\\src\\main\\java\\utils\\properties.properties"));
		String urlName = prop.getProperty("url");
	
		System.out.println(urlName);
		driver.get(urlName);
		driver.manage().window().maximize();
		driver.manage().timeouts();
		
		return driver;

	}
	
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}

}
