package com.resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public static WebDriver driver;
	

	public  WebDriver launch() throws Exception {
	WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	
	File fs = new File("D:\\\\2023AutoPractice\\\\com.supplyhouse\\\\data\\\\prop.properties");
	FileInputStream fis = new FileInputStream(fs);

	Properties prop = new Properties();
	prop.load(fis);
	
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	return driver;
	}
	

	
	
	
}
