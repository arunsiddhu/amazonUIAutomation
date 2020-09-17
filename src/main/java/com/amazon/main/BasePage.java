package com.amazon.main;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import com.amazon.objectrepository.ElementLocators;
import com.amazon.utils.CommonFunctionLibrary;
import com.amazon.utils.ReusableStaticMethods;


public class BasePage {

	protected static AndroidDriver<MobileElement> driver;
	static WebDriverWait wait;
	public static CommonFunctionLibrary functionLibrary;
	private static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

	public BasePage(AndroidDriver<MobileElement> driver) {
		BasePage.driver = driver;
		functionLibrary = new CommonFunctionLibrary(BasePage.driver);
	}

	/*
	 * public boolean isElementPresent(MobileBy locator, int timeoutInSeconds) { try
	 * { wait = new WebDriverWait(driver, timeoutInSeconds); WebElement elem =
	 * wait.until(ExpectedConditions.presenceOfElementLocated(locator)); if (elem !=
	 * null) { return true; } else { return false; }
	 * 
	 * } catch (Exception e) { return false; } }
	 */

	public boolean isElementPresent(String locator, int timeoutInSeconds) {
		try {
			//MobileElement elem =(MobileElement)driver.findElementById("com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon");
			//MobileElement elem = driver.findElement(MobileBy.AndroidUIAutomator(locator));
			MobileElement elem = (MobileElement) driver.findElementById(locator);
			if (elem != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}

	/*
	 * public WebElement findElement(By locator, int timeoutSeconds) { wait = new
	 * WebDriverWait(driver, timeoutSeconds); WebElement elem =
	 * wait.until(ExpectedConditions.presenceOfElementLocated(locator)); if (elem !=
	 * null) { return elem; } else { return null; } }
	 */

	/*
	 * public WebElement findElement(String locator, int timeoutSeconds) { wait =
	 * new WebDriverWait(driver, timeoutSeconds); WebElement elem =
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	 * if (elem != null) { return elem; } else { return null; } }
	 */

	public MobileElement findElement(String mobileBy, int timeoutInSeconds) {
		//MobileElement elem = driver.findElement(MobileBy.AndroidUIAutomator(mobileBy));
		MobileElement elem = (MobileElement) driver.findElementById(mobileBy);
		if (elem == null) {
			throw new ElementNotVisibleException(mobileBy + " :: element is not visible");
		}
		return elem;
	}

	/*
	 * public List<String> findElements(By locator, int timeoutSeconds) { wait = new
	 * WebDriverWait(driver, timeoutSeconds); List<WebElement> elem =
	 * wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	 * List<String> temp = new ArrayList<String>(); if (elem != null) { for
	 * (WebElement val : elem) { temp.add(val.getText()); } return temp; } else {
	 * return null; } }
	 */

	/*
	 * public List<WebElement> findAllWebElements(By locator, int timeoutSeconds) {
	 * wait = new WebDriverWait(driver, timeoutSeconds); List<WebElement> elem =
	 * wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	 * return elem; }
	 */

	/**
	 * To click an element using AndroidUIAutomator
	 */
	/*
	 * public boolean buttonClick(By locator, int timeoutSeconds) { try { WebElement
	 * element = findElement(locator, timeoutSeconds); element.click(); return true;
	 * } catch (Exception e) { return false; } }
	 */
	/*
	 * public boolean buttonClick(String locator, int timeoutSeconds) { try {
	 * WebElement element = findElement(locator, timeoutSeconds); element.click();
	 * return true; } catch (Exception e) { return false; } }
	 */
	/**
	 * To click an element using id locators
	 */
	public boolean buttonClick(String mobileBy, int timeoutInSeconds) {
		try {
			findElement(mobileBy, timeoutInSeconds).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * public boolean jsButtonClick(By locator) { try {
	 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement element =
	 * findElement(locator, 10); js.executeScript("arguments[0].click();", element);
	 * return true; } catch (Exception e) { return false; } }
	 */

	/*
	 * public boolean jsFunction(String function) { try {
	 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	 * JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("" +
	 * function + ""); return true; } catch (Exception e) { return false; } }
	 */

	/**
	 * This function enters values in text box
	 */

	public void sendKeys(String locator, String str, int timeoutInSeconds) {
		findElement(locator, timeoutInSeconds).clear();
		findElement(locator, timeoutInSeconds).sendKeys(str);
	}
	/*
	 * public void sendKeys(By locator, String str, int timeoutInSeconds) {
	 * findElement(locator, timeoutInSeconds).clear(); findElement(locator,
	 * timeoutInSeconds).sendKeys(str); }
	 */
	/**
	 * This function sends clickable key in keyboard
	 */
	
	public void sendKeys(String locator, Keys key, int timeoutInSeconds) {
		findElement(locator, timeoutInSeconds).sendKeys(Keys.valueOf(key.toString()));
	}


	/*
	 * public boolean MouseHover(WebElement Mhover) { try { Actions Hover = new
	 * Actions(driver); Hover.moveToElement(Mhover).build().perform();
	 * Thread.sleep(2000); return true; } catch (InterruptedException e) {
	 * e.printStackTrace(); return false; }
	 * 
	 * }
	 */

	}