package com.resources;

import org.testng.annotations.DataProvider;

public class dataPro {

	
	
@DataProvider(name="boilerPart")
public Object[][] getBoilerPart(){
	return new Object[][] {
		{"AT082330C"},
		{"AT082410C"}
	};
	
}
}
