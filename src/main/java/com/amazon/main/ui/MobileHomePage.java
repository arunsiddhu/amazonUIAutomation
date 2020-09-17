package com.amazon.main.ui;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.main.BasePage;
import com.amazon.objectrepository.ElementLocators;
import com.amazon.utils.CommonFunctionLibrary;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileHomePage extends BasePage {
	public static Object obj;
	private static Logger logger = LoggerFactory.getLogger(MobileHomePage.class);

	public MobileHomePage(AndroidDriver<MobileElement> driver) {
		super(driver);
		functionLibrary = new CommonFunctionLibrary(driver);
		if (isElementPresent(ElementLocators.userName, 5) || isElementPresent(ElementLocators.searchBox, 5)) {
			logger.info("User is navigated to Home page");
		}else {
			logger.warn("User is not navigated to Home page");
			throw new ElementNotVisibleException("User is not logged in");
		}
		/*
		 * if(isElementPresent(ElementLocators.searchBox,5)) {
		 * findElement(ElementLocators.searchBox,5).click();
		 * findElement(ElementLocators.searchBox,5).sendKeys("65-inch TV"); }
		 */
		/*	    MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView");
	    el4.click();
		 *//*	    (new TouchAction(driver)).press({x: 532, y: 1178}).moveTo({x: 507: y: 760}).release().perform();
	    (new TouchAction(driver)).press({x: 488, y: 1644}).moveTo({x: 523: y: 855}).release().perform();
	    (new TouchAction(driver)).press({x: 472, y: 1134}).moveTo({x: 491: y: 953}).release().perform();
		  */	      
		/*
		 * MobileElement el5 = (MobileElement)
		 * driver.findElementById("android:id/content"); MobileElement el6 =
		 * (MobileElement) driver.findElementById(
		 * "com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon");
		 * MobileElement el7 = (MobileElement) driver.findElementById(
		 * "com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon");
		 * MobileElement el8 = (MobileElement) driver.findElementById(
		 * "com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon");
		 * el8.click();
		 *//*
		 * (new TouchAction(driver)).tap(991, 1086).perform()(new
		 * TouchAction(driver)).press({x: 846, y: 1067}).moveTo({x: 310: y:
		 * 1083}).release().perform();
		 */		

	}
	public void search(String search) {
		//(new TouchAction(driver)).tap(782, 773).perform()
		sendKeys(ElementLocators.searchBox, search, 10);
	}
	public void press_enter() {
		sendKeys(ElementLocators.searchBox, Keys.ENTER, 10);
	}
}
