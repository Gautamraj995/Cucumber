package com.base;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utilities.TestUtility;




public class BaseUtil {

	public static ExtentTest scenarioDef;

    public static ExtentTest features;

    public static String reportLocation = System.getProperty("user.dir")
			+ "/EveronExtentResults/EveronExtentReport" + TestUtility.getSystemDate() + ".html";
    public static Logger Log;
    public ExtentReports extent;
    
	public BaseUtil() {
		Log = Logger.getLogger(this.getClass());
	}
    
	

    

}
