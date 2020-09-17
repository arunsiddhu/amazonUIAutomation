package stepdefinitions.mobile.ui;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.TouchAction;
import io.cucumber.java.en.*;
import stepdefinitions.AttachHooks;

import com.amazon.main.ui.MobileHomePage;
import com.amazon.main.ui.MobileLoginPage;

public class UserValidations {
	MobileLoginPage mobileLoginPage = (MobileLoginPage) MobileLoginPage.obj;
	MobileHomePage mobileHomePage = (MobileHomePage) MobileHomePage.obj;
	
	private static Logger logger = LoggerFactory.getLogger(UserValidations.class);
	private boolean flag;
	@Then("verify if user is logged in")
	public void verify_if_user_is_logged_in() {
		try {
			mobileHomePage = new MobileHomePage(AttachHooks.driver);
			 //(new TouchAction(driver)).tap(149, 162).perform();
		} catch (Exception e) {
			logger.warn("Exception Occured:" + e);
			logger.error("User is not navigated to Home page");
			Assert.fail();
		}
		MobileHomePage.obj = mobileHomePage;
	}
}
