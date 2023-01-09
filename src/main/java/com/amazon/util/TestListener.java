package com.amazon.util;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazom.base.TestBase;


public class TestListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {	
		String fileName= result.getMethod().getMethodName();
		String filePath= "C:\\Users\\HH\\eclipse-workspace\\AmazonProject\\target"+fileName+".png";
		Utilities.takeScreenShot(filePath);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	








































}
