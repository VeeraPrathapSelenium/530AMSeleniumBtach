package com.application_or;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR {
	//********************************* Menu Header Section *********************************
	@FindBy(xpath="//a[text()='Register']")
	public static WebElement lnk_register;
	
	@FindBy(xpath="//a[text()='Log in']")
	public static WebElement lnk_login;
	//********************************* Tabs Section ****************************************
	@FindBy(xpath="(//a[normalize-space(text())='Computers'])[1]")
	public static WebElement tab_computers;
	
}
