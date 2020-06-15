package com.base;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.TestUtility;

public class TestBase {
	public static WebDriver driver;
	public static Properties property;
	public static ChromeOptions chromeOptions;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	public static Logger Log;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public TestBase() {
		Log = Logger.getLogger(this.getClass());
	}

	@BeforeTest
	public void setExtent() {
		TestUtility.setDateForLog4j();

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/EveronLoggerFiles/EveronLoggerFilesReport" + TestUtility.getSystemDate() + ".html");
		extent = new ExtentReports();

		extent.attachReporter(reporter);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String temp = TestUtility.getScreenshot(driver);

			extentTest.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}

		extent.flush();
		driver.quit();
	}
}
