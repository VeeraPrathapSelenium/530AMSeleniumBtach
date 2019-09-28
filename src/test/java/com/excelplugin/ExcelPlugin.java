package com.excelplugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reporting.ExtentReporting;

public class ExcelPlugin extends ExtentReporting {
	
	public static XSSFWorkbook workbook;
	
	public static String testcasename;
		
	public ExcelPlugin()
	{
		try {
		System.out.println("Loding Excel.......");
		File f=new File("./TestData/TestData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		workbook=new XSSFWorkbook(fis);
		System.out.println("Excel Loading is completed....");
		}
		catch(Exception e) {
			
		}
	}
	
	
	public static int getrowCount(String sheet)
	{
		int rowcount=0;
		
		rowcount=workbook.getSheet(sheet).getLastRowNum();
		
		//System.out.println(workbook.getSheet(sheet).getRow(1).getCell(0).getStringCellValue());
		
		return rowcount;
		
		
	}
	
	
	public static int getColCount(String sheet)
	{
		int colcount=0;
		
		colcount=workbook.getSheet(sheet).getRow(0).getLastCellNum();
		
		return colcount;
	}
	
	public static int searchTestCase(String sheetname,String testcasename)
	{
		int testcaserow=0;
		int rowcount=getrowCount(sheetname);
		
		for(int r=1;r<=rowcount;r++)
		{
			String crnttestcase=workbook.getSheet(sheetname).getRow(r).getCell(0).getStringCellValue();
			
			if(crnttestcase.trim().equals(testcasename))
			{
				testcaserow=r;
				
				System.out.println("The Test Case "+testcasename+" is found at row :"+(r+1));
				break;
			}
			
		}
		
		return testcaserow;
	}
	
	public static int searchColumn(String sheetname,String columnname)
	{
		int colfound=0;
		int colcount=getColCount(sheetname);
		
		for(int c=1;c<=colcount-1;c++)
		{
			String crntcol=workbook.getSheet(sheetname).getRow(0).getCell(c).getStringCellValue();
			
			if(crntcol.trim().equals(columnname))
			{
				colfound=c;
				
				System.out.println("The Column "+columnname+" is found at column :"+(c+1));
				break;
			}
			
		}
		
		return colfound;
	}
	
	
	public String getData(String sheetname,String columnname)
	{		
		String[] arr=new String[2];
		
		
		int rownumber=searchTestCase(sheetname,testcasename);
		int colnumber=searchColumn(sheetname, columnname);
		
		String data="";
		System.out.println(workbook.getSheet(sheetname).getRow(rownumber).getCell(colnumber).getCellType());
		switch(workbook.getSheet(sheetname).getRow(rownumber).getCell(colnumber).getCellType())
		{
		
		case 1:
			data=workbook.getSheet(sheetname).getRow(rownumber).getCell(colnumber).getStringCellValue();
			 break;
		case 0:
			
			data=String.valueOf(workbook.getSheet(sheetname).getRow(rownumber).getCell(colnumber).getNumericCellValue());
			 break;
		
		}
		
		if(data.length()>0)
		{
			System.out.println("The Data for the Test case:"+testcasename+" and for the column "+columnname+" is identified as "+data);
		}
		else
		{
			System.out.println("No data for for the testcase "+testcasename+" under the sheet "+sheetname);
		}
		
		return data;
		
		
	}
	
	
	public static String getURL(String Environment)
	{
		System.out.println("Searching url");
	int rownumber=searchTestCase("GenricData", Environment);	
	int colnumber=searchColumn("GenricData", "Url");

		String data="";
		
		switch(workbook.getSheet("GenricData").getRow(rownumber).getCell(colnumber).getCellType())
		{
		
		case 1:
			data=workbook.getSheet("GenricData").getRow(rownumber).getCell(colnumber).getStringCellValue();
			 break;
		case 0:
			
			data=String.valueOf(workbook.getSheet("GenricData").getRow(rownumber).getCell(colnumber).getNumericCellValue());
			 break;
		
		}
		
		if(data.length()>0)
		{
			System.out.println("The URL of the Application is "+data);
		}
		else
		{
			System.out.println("No Url Found");
		}
		
		
		return data;
		
		
	}
	
	
	

}
