package com.amazon.objectrepository;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

public class ElementLocators {

	//public static By continueButton = MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\".*/sso_continue\")");
	//public static By useDifferentAccount = MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\".*/sso_use_different_account\")");

	//Login locators
	public static String signInButton = "sign_in_button";
	public static String continueButton = "sso_continue";
	public static String useDifferentAccount ="sso_use_different_account";
	public static String emailLogin = "ap_email_login";
	public static String continueOnEmail = "continue";
	public static String password = "ap_password";
	public static String signIn = "signInSubmit";
	
	//Login locators fallback to be implemented
	public static String continueButton_fallback = "new UiSelector().resourceIdMatches(\".*/sso_continue\")";
	public static String useDifferentAccount_fallback ="new UiSelector().resourceIdMatches(\".*/sso_use_different_account\")";
	public static String emailLogin_fallback = "new UiSelector().resourceIdMatches(\".*/ap_email_login\")";
	public static String continueOnEmail_fallback = "new UiSelector().resourceIdMatches(\".*/continue\")";
	public static String password_fallback = "new UiSelector().resourceIdMatches(\".*/ap_password\")";
	public static String signIn_fallback = "new UiSelector().resourceIdMatches(\".*/signInSubmit\")";
	
	//home page locators
	public static String homelogo = "action_bar_home_logo";
	public static String postloginHomelogo = "chrome_action_bar_home_logo";
	public static String sideBar = "action_bar_burger_icon";
	public static String postLoginsideBar = "chrome_action_bar_burger_icon";
	public static String userName = "chrome_action_bar_home_logo";

	//home page locators fallback to be implemented
	public static String homelogo_fallback = "new UiSelector().resourceIdMatches(\".*/action_bar_home_logo\")";
	public static String postloginHomelogo_fallback = "new UiSelector().resourceIdMatches(\".*/chrome_action_bar_home_logo\")";
	public static String sideBar_fallback = "new UiSelector().resourceIdMatches(\".*/action_bar_burger_icon\")";
	public static String postLoginsideBar_fallback = "new UiSelector().resourceIdMatches(\".*/chrome_action_bar_burger_icon\")";
	public static String userName_fallback = "new UiSelector().resourceIdMatches(\".*/chrome_action_bar_home_logo\")";

	//search locators
	public static String searchBox = "rs_search_src_text";
	public static String searchResults = "item_title";

	//search locators fallback to be implemented
	public static String searchBox_fallback = "new UiSelector().resourceIdMatches(\".*/rs_search_src_text\")";
	public static String searchResults_fallback = "new UiSelector().resourceIdMatches(\".*/item_title\")";
	
	//purchase locators
	public static String buyNow = "a-autoid-17";
	public static String addToCart = "add-to-cart-button";
	public static String cartIcon = "chrome_action_bar_cart_count";

	//purchase locators fallback to be implemented
	public static String buyNow_fallback = "new UiSelector().resourceIdMatches(\".*/a-autoid-17\")";
	public static String addToCart_fallback = "new UiSelector().resourceIdMatches(\".*/add-to-cart-button\")";
	public static String cartIcon_fallback = "new UiSelector().resourceIdMatches(\".*/chrome_action_bar_cart_count\")";

	//public static By cartIcon = MobileBy.AndroidUIAutomator("new UiSelector().resourceIdMatches(\".*/chrome_action_bar_cart_count\")");
}