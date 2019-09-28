package com.commonutilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.annotations.CommonAnnotations;

public class CommonMethods extends CommonAnnotations {

	public static WebDriver driver;

	public static void launchApplication(String environment) {
		// syntax to launch the chrome browser

		// step 1:set the path of the chrome driver

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		// step2 intiate the process to launch the browser

		driver = new ChromeDriver();

		// pass the url

		driver.get(getURL(environment));
		// maximize the browser

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(35,TimeUnit.SECONDS);
		logEvent("Pass", "Browser is launched sucessfully");
	}

	public void closeBrowser() {
		driver.close();
	}

	public static void clickAndSendData(String page, String elementname, WebElement element, String data) {
		element.click();
		element.clear();
		element.sendKeys(data);
	}

	public static boolean hover(String page, String elementname, WebElement element) {
		boolean status = true;
		try {
			Actions acc = new Actions(driver);
			acc.moveToElement(element).build().perform();
			logEvent("Pass", "Mouse Hovered sucessfully to the element " + elementname + " On the webpage " + page);
		} catch (Exception e) {
			status = false;
			logEvent("Fail", "Unable to move the mouse on to the element " + elementname + " On the webpage " + page);
		}
		return status;
	}

	public static boolean hoverandClick(String page, String elementname, WebElement element) {
		boolean status = true;
		try {
			Actions acc = new Actions(driver);
			acc.moveToElement(element).click(element).build().perform();
			logEvent("Pass", "Mouse Hovered sucessfully to the element " + elementname + " On the webpage " + page+" and clicked sucessfully");
		} catch (Exception e) {
			status = false;
			logEvent("Fail", "Unable to move the mouse on to the element " + elementname + " On the webpage " + page);
		}
		return status;
	}

	public static void selectItemByIndex(String page, String elementname, WebElement element, int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);

	}

	public static void selectByValue(String page, String elementname, WebElement element, String value) {
		Select dropdown = new Select(element);

		dropdown.selectByValue(value);

	}

	public static void selectByVisibleText(String page, String elementname, WebElement element, String text) {
		Select dropdown = new Select(element);

		dropdown.selectByVisibleText(text);

	}

}
