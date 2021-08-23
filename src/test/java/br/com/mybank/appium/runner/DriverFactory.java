package br.com.mybank.appium.runner;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.RECREATE_CHROME_DRIVER_SESSIONS;

public class DriverFactory {

    //class responsible for managing capabilities data, for server configuration and mobile device data

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver () {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    //if you want to run on a different device, change the information contained in the deviceName variable, and if your appium server is on a different ip, change the URL variable
    private static void createDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app",new File("src/test/resources/mybank.apk"));
        desiredCapabilities.setCapability("deviceName", "Android_8");
        desiredCapabilities.setCapability(RECREATE_CHROME_DRIVER_SESSIONS, "true");
        desiredCapabilities.setCapability ( " unicodeKeyboard " , true );
        desiredCapabilities.setCapability ( " resetKeyboard " , true );

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void killDriver() {
        if (driver != null) {
            driver.resetApp();
            driver = null;
        }
    }
}
