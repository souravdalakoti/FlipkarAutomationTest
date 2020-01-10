package com.flipkart.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.flipkart.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String WORK_BOOk_PATH="C:\\Users\\soura\\eclipse-workspace\\FlipkartTest\\src\\main\\java\\com\\flipkart\\qa\\testdata\\LoginTestData.xlsx";
	public static Workbook book;
	public static  Sheet sheet;
	
	public static String screenshot( String screenshotname) throws Throwable {
		String datename=new SimpleDateFormat("yyyymmddhhss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path= "C:\\Users\\soura\\eclipse-workspace\\FlipkartTest\\Screenshot\\";
	String destination= path+datename+screenshotname+".png";	
		//FileHandler.copy(src, new File(path+datename+screenshotname+".png"));
	File finaldestination= new File(destination);
	FileUtils.copyFile(src, finaldestination);
	return destination;
	}
	public static Object[][] getData() throws Throwable {
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(WORK_BOOk_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet= book.getSheetAt(0);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		System.out.println(data);
		return data;
}
}

