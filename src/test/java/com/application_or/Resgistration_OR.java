package com.application_or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Resgistration_OR {
	//********************************* Registration Form *********************************
		@FindBy(xpath="//input[@id='gender-male']")
		public static WebElement rdo_genderMale;
		
		@FindBy(xpath="//input[@id='gender-female']")
		public static WebElement rdo_genderFemale;
}
