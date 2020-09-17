package com.amazon.main.ui;

import java.io.IOException;
import java.net.URISyntaxException;
//import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.main.BasePage;
import com.amazon.main.ui.MobileHomePage;
import com.amazon.objectrepository.ElementLocators;
//import com.amazon.utils.CallingInfo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileLoginPage extends BasePage {
	private static Logger logger = LoggerFactory.getLogger(MobileLoginPage.class);
	public static MobileLoginPage obj;
	MobileElement elem;

	public MobileLoginPage(AndroidDriver<MobileElement> driver) throws InterruptedException, IOException, URISyntaxException {
		super(driver);
		logger.info("" + driver);
		Thread.sleep(1000);
		initiate();
		if (isElementPresent(ElementLocators.emailLogin, 5)) {
			logger.info("Login popup is present");
		}
		else if (isElementPresent(ElementLocators.homelogo, 5)){
			logger.info("user is logged in and present on home page");
		}
		else {
			logger.warn("Login popup could not be opened");
			throw new ElementNotVisibleException("Login popup is not visible");
		}
	}

	public void initiate() {
		if (isElementPresent(ElementLocators.useDifferentAccount, 5)) {
			logger.info("user is already logged in and present on continue page");
			buttonClick(ElementLocators.useDifferentAccount,5);
		} else if (isElementPresent(ElementLocators.signInButton, 5)) {
			logger.info("user is not logged in and present on sign in page");
			buttonClick(ElementLocators.signInButton,5);
		}
		else if (isElementPresent(ElementLocators.homelogo, 5)){
			logger.info("user is logged in and present on home page");
		}
		else {
			logger.info("user is not logged in and present on login page");
		}
	}

	public void username(String username) {
		//(new TouchAction(driver)).tap(782, 773).perform()
		sendKeys(ElementLocators.emailLogin, username, 10);
		sendKeys(ElementLocators.emailLogin, Keys.ENTER, 10);
	}

	public void password(String password) {
		sendKeys(ElementLocators.password, password, 10);
		//sendKeys(ElementLocators.password, Keys.ENTER, 10);
	}
	public MobileLoginPage clickContinue() {
		try {
			if (isElementPresent(ElementLocators.continueOnEmail, 5)) {
				buttonClick(ElementLocators.continueOnEmail, 10);
				return new MobileLoginPage(driver);
			}

		} catch (Exception e) {
			logger.error("Exception in login method : " + e);
		}
		return null;
	}
	public MobileHomePage clickLogin() {
		try {
			if (isElementPresent(ElementLocators.signIn, 5)) {
				buttonClick(ElementLocators.signIn, 10);
				return new MobileHomePage(driver);
			}

		} catch (Exception e) {
			logger.error("Exception in login method : " + e);
		}
		return null;
	}
}
