package stepdefinitions.mobile.ui;

import com.amazon.main.ui.MobileHomePage;
import com.amazon.main.ui.MobileLoginPage;

import io.cucumber.java.en.*;

public class UserSelections {
	MobileHomePage homePage = (MobileHomePage) MobileHomePage.obj;
	MobileLoginPage mobileLoginPage = (MobileLoginPage) MobileLoginPage.obj;
	
	@When("user selects random item")
	public void user_selects_random_item() {
		System.out.println("inside random selection");
	}
	
	@When("adds item to cart")
	public void adds_item_to_cart() {
		System.out.println("inside add to cart");
	}
}
