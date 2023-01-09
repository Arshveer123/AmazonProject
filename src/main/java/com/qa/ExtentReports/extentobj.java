package com.qa.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentobj {

	String path=System.getProperty("user.dir")+"\\reports\\extentreports.html";
	static ExtentReports reports;
	static ExtentSparkReporter extent;
	
	
	
	
	
	public static  ExtentReports getReport() {
		String path=System.getProperty("user.dir")+"\\reports\\extentreports.html";
		extent= new ExtentSparkReporter(path);
		extent.config().setReportName("Arshveer kaur");
		extent.config().setDocumentTitle("Amazon Automation Test");
		reports= new ExtentReports();
		reports.attachReporter(extent);
		reports.setSystemInfo("project","Amazon");
		return reports;
	
	}
}
