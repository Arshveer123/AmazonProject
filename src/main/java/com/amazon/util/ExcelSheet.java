package com.amazon.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Arrays;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelSheet {
	
	static FileInputStream fis ;
	static Workbook book;
	
	public static void main(String[] args) {

		Object[][] obj= ExcelSheet.getData();
		System.out.println(Arrays.asList(obj));
	}
	
	
	public static Object[][] getData() {
		Object[][] obj;
		try {
			 fis = new FileInputStream("C:\\Users\\HH\\eclipse-workspace\\AmazonProject\\src\\main\\resources\\datadriven.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet=book.getSheet("sheet1");
		obj= new Object[8][5];
		for(int i = 0;i<8;i++) {
			for(int k=0; k<5;k++) {
				obj[i][k] =	sheet.getRow(i+1).getCell(k).toString();
			
				
			}
		}
		return obj;
	}
}





