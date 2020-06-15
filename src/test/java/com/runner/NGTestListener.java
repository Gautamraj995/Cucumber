package com.runner;

import static com.base.BaseUtil.features;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.gherkin.model.Feature;
import com.base.ExtentReportUtil;



public class NGTestListener implements ITestListener {

    ExtentReportUtil extentReportUtil = new ExtentReportUtil();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("On test Sucess");
    }

   

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");

        extentReportUtil.ExtentReport();

        //ToDo: Feature - Hard coding the feature name
        features = extentReportUtil.extent.createTest(Feature.class, iTestContext.getName());

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
        extentReportUtil.FlushReport();
    }

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}