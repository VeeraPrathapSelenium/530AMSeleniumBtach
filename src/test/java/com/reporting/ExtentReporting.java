package com.reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.commonutilities.CommonMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporting {
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	//Step 1:intialize the test reports
	
	public static void intilaizeReports()
	{
		extent=new ExtentReports(createResultsFolder()+"\\AutomatiomnSummaryReport.html");
	}
	//step 2:enable a place holder to capture the test case
	public static void startTest(String testcasename)
	{
		test=extent.startTest(testcasename);
	}
	//Step 3:Enable Logging
	public static void logEvent(String status,String description)
	{
		switch(status.toLowerCase())
		{
		case "pass":
			test.log(LogStatus.PASS, description+test.addBase64ScreenShot(getScreenShot()));
			break;
		case "fail":
			test.log(LogStatus.FAIL, description+test.addBase64ScreenShot(getScreenShot()));
			break;
		case "warning":
			test.log(LogStatus.WARNING, description);
			break;
		
		}
	}
	//end the current executing test case 
	public static void endTest()
	{
		extent.endTest(test);
	}
	
	//flush the report
	public static void flushReport()
	{
		extent.flush();
	}
	
	
	public static String createResultsFolder()
	{
		//format the system date and time  only to get the date
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
		
		//this line will generate both system date and time
		Date date=new Date();
		
		//this line will format the sys date and time to MM-dd-yyyy format
		String crntdate=sdf.format(date).toString();
		
		//here we will get the current working directory and will create the result folder based current date
		String resultpath=System.getProperty("user.dir")+"\\Results\\"+crntdate;
		
		File file=new File(resultpath);
		
		if(!file.exists())
		{
			file.mkdirs();
		}
		return resultpath;
		
	}
	
	//capture the screen shot
	
	public static String getScreenShot()
	{
		String sht=((TakesScreenshot) CommonMethods.driver).getScreenshotAs(OutputType.BASE64);
		return "data:image/png;base64,"+sht;
		
	}
	

}
