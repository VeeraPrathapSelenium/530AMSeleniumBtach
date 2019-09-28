package com.application_behaviours;

import javax.net.ssl.HostnameVerifier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application_or.HomePage_OR;
import com.commonutilities.CommonMethods;

public class HomePage extends CommonMethods{
	
	public static void navigateToRegister_Module()
	{
		boolean status=false;
		HomePage_OR homepage=PageFactory.initElements(driver, HomePage_OR.class);
		//hover  to register link
		status=hover("Home Page","Register",homepage.lnk_register);
		
		Assert.assertEquals(status, true,"Failed to hover on the webelement Register on the Home page");
		
		//click on the register Link
		status=hoverandClick("Home Page","Register",homepage.lnk_register);
		Assert.assertEquals(status, true,"Failed to click on the webelement Register on the Home page");
	}
	
	

}
