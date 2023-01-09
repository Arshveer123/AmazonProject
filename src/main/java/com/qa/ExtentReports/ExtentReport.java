package com.qa.ExtentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazom.base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReport extends TestBase implements ITestListener{

	
		ExtentTest test;
	ExtentReports reports=	extentobj.getReport();
		
		
		
		
	

	@Override
	public void onTestStart(ITestResult result) {
		test= reports.createTest(result.getMethod().getMethodName());
		
		
		
		
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		test.log(Status.PASS, "Test is passed..."+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		

		test.log(Status.FAIL, "Test is Fail..."+result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		test.log(Status.SKIP, "Test is Skipped..."+result.getName());
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
		
		
	}


















}
