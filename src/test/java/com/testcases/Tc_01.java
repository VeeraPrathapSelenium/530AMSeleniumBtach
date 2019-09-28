package com.testcases;

import org.testng.annotations.Test;

import com.application_behaviours.HomePage;
import com.commonutilities.CommonMethods;

public class Tc_01 extends CommonMethods{
	
	@Test
	public static void Validate_RegisterModule()
	{
		launchApplication("QA");
		
		//create object for Home Page
		HomePage homepage=new HomePage();
		homepage.navigateToRegister_Module();
		
	}

}
