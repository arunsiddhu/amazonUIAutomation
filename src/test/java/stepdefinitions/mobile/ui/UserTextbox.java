package stepdefinitions.mobile.ui;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import stepdefinitions.AttachHooks;
import com.amazon.main.ui.MobileHomePage;
import com.amazon.main.ui.MobileLoginPage;
import com.amazon.objectrepository.ElementLocators;
import com.amazon.utils.ConfigManager;

public class UserTextbox {
	MobileHomePage mobileHomePage = (MobileHomePage) MobileHomePage.obj;
	MobileLoginPage mobileLoginPage=(MobileLoginPage) MobileLoginPage.obj;
	public static Logger logger = Logger.getLogger(UserTextbox.class);
	@When("user enters valid email id")
	public void user_enters_valid_email_id() {
		mobileLoginPage.username(ConfigManager.getProperty("Username"));
	}
	@When("user enters valid password")
	public void user_enters_valid_password() {
		mobileLoginPage.password(ConfigManager.getProperty("Password"));
	}
	@Given("^user searches for (.*)$")
	public void user_searches_for(String query) {
		mobileHomePage.search(query);
	}
	@Given("^user presses enter$")
	public void user_presses_enter(String key) {
		mobileHomePage.press_enter();
	}
}
