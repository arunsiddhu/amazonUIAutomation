package stepdefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazon.utils.CommonFunctionLibrary;
import com.amazon.utils.ConfigManager;
import com.amazon.utils.DriverFactory;
import com.amazon.utils.ReusableStaticMethods;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AttachHooks {

	private Scenario scenario;
	public static AndroidDriver<MobileElement> driver;
	DesiredCapabilities capabilities;
	private static Logger LOGGER = LoggerFactory.getLogger(AttachHooks.class);
	CommonFunctionLibrary functionLibrary;

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Before
	public void setUp(Scenario scenario) throws IOException, InterruptedException {
		LOGGER.info("Inside set up method of before hook");
		ConfigManager.loadConfig();
		this.scenario = scenario;
		System.out.println(scenario.getName());

		/* This method is responsible for executing test cases on Native Mobile apps.*/

		if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Mobile")) {
			ReusableStaticMethods.createServerStatusFile();
			LOGGER.info("Execution Start for Scenario : " + scenario.getName());
			Date date = new Date();
			LOGGER.info(date.toString());
			//LOGGER.info(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
			if (ConfigManager.getProperty("MachineName").equalsIgnoreCase("Windows")) {
				//DriverFactory.appiumStop();
				DriverFactory.appiumStart();				
			}

			if (ConfigManager.getProperty("PlatformName").equalsIgnoreCase("Android")) {
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("emulator", true);
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigManager.getProperty("DeviceName"));
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigManager.getProperty("PlatformName"));
				capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigManager.getProperty("PlatformVersion"));
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigManager.getProperty("AutomatorVersion"));
				capabilities.setCapability(MobileCapabilityType.NO_RESET, ConfigManager.getProperty("NoReset"));
				capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+ConfigManager.getProperty("ApkPath"));
				capabilities.setCapability("appPackage", ConfigManager.getProperty("appPackage"));
				capabilities.setCapability("appActivity", ConfigManager.getProperty("appActivity"));
				capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
				try {
					if (ConfigManager.getProperty("MachineName").equalsIgnoreCase("Windows")) {
						driver = new AndroidDriver<MobileElement>(
								new URL(ConfigManager.getProperty("Protocol") +"://"+ConfigManager.getProperty("AppiumServer") +":" + ConfigManager.getProperty("AppiumPort") + "/wd/hub"),
								capabilities);
					} else
						driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				} catch (MalformedURLException e) {
					System.out.println("Exception in driver initilalization and Cause is : "+ e.getCause());
					System.out.println("\n and Message is : "+e.getMessage());
					e.printStackTrace();
				}
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@After
	public void tearDown() throws InstantiationException, IllegalAccessException, IOException {
		if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Mobile")) {
			if (scenario.isFailed()) {
				int incrementedcount = Integer.parseInt(ReusableStaticMethods.readServerFalureCountFromFile()) + 1;
				ReusableStaticMethods.writeServerFalureCountToFile(String.valueOf(incrementedcount));
			} else {
				ReusableStaticMethods.writeServerFalureCountToFile("0");
			}
			LOGGER.info("Execution Stop for scenario : " + scenario.getName());
			Date date = new Date();
			LOGGER.info(date.toString());
			//LOGGER.info(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
			//driver.close();
			//driver.quit();
			//DriverFactory.appiumStop();
		}
	}
}