package com.annotations;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.excelplugin.ExcelPlugin;
import com.reporting.ExtentReporting;

public class CommonAnnotations extends ExcelPlugin {
	

public static ExcelPlugin plugin;
public static ExtentReporting reporting;
	
	@BeforeSuite
	public static void intializeSetUp() throws IOException
	{
		plugin=new ExcelPlugin();
		reporting =new ExtentReporting();
		reporting.intilaizeReports();
	}
	
	@BeforeMethod
	public static void beforeEachMethod(Method methodname)
	{
		ExcelPlugin.testcasename=methodname.getName().toString();
		reporting.startTest(methodname.getName().toString());
	}
	@AfterMethod
	public static void afterMethod()
	{
		reporting.endTest();
	}
	
	@AfterSuite
	public static void afterSuite()
	{
		reporting.flushReport();
	}
	

}
