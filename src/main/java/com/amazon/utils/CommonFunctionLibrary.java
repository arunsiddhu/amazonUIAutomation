package com.amazon.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import cucumber.api.Scenario;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;

public class CommonFunctionLibrary {

	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	public Dimension size;

	public CommonFunctionLibrary(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/*
	 * public void swipeHorizontal(int endNumber, double x1, double x2, int
	 * duration, int sleep) { try { for (int iCount = 1; iCount <= endNumber;
	 * iCount++) { size = driver.manage().window().getSize(); int startx = (int)
	 * (size.width * x1); int endx = (int) (size.width * x2); int starty =
	 * size.height / 2; ((AppiumDriver) driver).swipe(startx, starty, endx, starty,
	 * duration); Thread.sleep(sleep); System.out.println("Count : " + iCount); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * public void swipeVertical(int endNumber, double x1, double x2, int duration,
	 * int sleep) throws InterruptedException { Thread.sleep(300); for (int iCount =
	 * 1; iCount <= endNumber; iCount++) { // Get the size of screen. size =
	 * driver.manage().window().getSize(); System.out.println(size); int starty =
	 * (int) (size.height * x1); int endy = (int) (size.height * x2); int startx =
	 * size.width / 2; System.out.println("starty = " + starty + " ,endy = " + endy
	 * + " , startx = " + startx);
	 * 
	 * // Swipe from Bottom to Top. ((AppiumDriver) driver).swipe(startx, starty,
	 * startx, endy, duration); Thread.sleep(sleep);
	 * 
	 * System.out.println("Count : " + iCount); // Swipe from Top to Bottom. //
	 * ((AppiumDriver) driver).swipe(startx, endy, startx, starty, // 3000); }
	 * System.out.println("mee"); }
	 */
	public void switchToAlertOk() {
		Alert alert = ((WebDriver) driver).switchTo().alert();
		alert.accept();
	}

	public WebElement findElement(By locator, int timeoutSeconds) {
		wait = new WebDriverWait((WebDriver) driver, timeoutSeconds);
		WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		if (elem != null) {
			return elem;
		} else {
			return null;
		}
	}

	public void switchToAlertCancel() {
		Alert alert = ((WebDriver) driver).switchTo().alert();
		alert.dismiss();
	}

	public void mouseHover(By elem) {
		Actions action = new Actions((WebDriver) driver);
		WebElement element = driver.findElement(elem);
		action.moveToElement(element).build().perform();

	}


	public boolean isAlertPresent() {

		try {
			((WebDriver) driver).switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}

	}
}
