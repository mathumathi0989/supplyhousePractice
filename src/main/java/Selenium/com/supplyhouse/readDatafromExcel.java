package Selenium.com.supplyhouse;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readDatafromExcel {

	public static String[] getExecelData() {
		
		String fileLoc = "D:\\2023AutoPractice\\com.supplyhouse\\data\\Book1.xlsx";
		
		XSSFWorkbook wbook = null;
		
		try {
			wbook = new XSSFWorkbook(fileLoc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet = wbook.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		int PhysicalNumberRows = sheet.getPhysicalNumberOfRows();
		
		System.out.println("Inclusive of Headers " +PhysicalNumberRows);
		System.out.println("No. of Rows " +lastRowNum);
		
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("No. of Cells "+lastCellNum);
		
		String[] data = new String[lastRowNum];
		for(int i=1; i<=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j=0; j<lastCellNum; j++) {
			XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
			String value = 	dft.formatCellValue(cell);
			data[i-1] = value;
					
			}
		}
		
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
		
		
		
		
	}
	
	
	
}
