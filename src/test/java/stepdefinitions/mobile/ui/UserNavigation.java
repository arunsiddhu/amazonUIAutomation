package stepdefinitions.mobile.ui;

import org.junit.Assert;
import org.apache.log4j.Logger;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.cucumber.java.en.*;

import com.amazon.main.ui.MobileHomePage;
import com.amazon.main.ui.MobileLoginPage;
import stepdefinitions.AttachHooks;

public class UserNavigation {
	MobileLoginPage mobileLoginPage;
	public MobileHomePage mobileHomePage;
	private static Logger logger = Logger.getLogger(UserNavigation.class);
	@Given("user is present on login screen")
	public void user_is_present_on_login_screen() {
		try {
			mobileLoginPage = new MobileLoginPage(AttachHooks.driver);
		} catch (Exception e) {
			logger.warn("Exception Occured:" + e);
			logger.error("User is not navigated to login page");
			Assert.fail();
		}
		MobileLoginPage.obj = mobileLoginPage;
	}
	@When("user clicks on continue")
	public void user_clicks_on_continue() {
		mobileLoginPage.clickContinue();
	}
	@When("user clicks on login")
	public void user_clicks_on_login() {
		mobileLoginPage.clickLogin();
	}
	@Then("goto cart")
	public void goto_cart() {
		System.out.println("inside goto cart");
	}	
	@Then("purchase the item")
	public void purchase_the_item() {
		System.out.println("inside purchase");
	}
}