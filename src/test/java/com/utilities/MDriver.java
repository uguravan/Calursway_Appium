package com.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class MDriver {

    private static AppiumDriver<MobileElement> driverAppium;
    private static AndroidDriver<MobileElement> driverAndroid;

    private MDriver() {
    }

    public static AppiumDriver<MobileElement> getMDriver() {
        if (driverAppium == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6");
            desiredCapabilities.setCapability("appPackage", "com.etsy.android");
            desiredCapabilities.setCapability("appActivity", "com.etsy.android.ui.BOEActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Code_Related_Apps\\APK\\etsy.apk");
            // desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

            try {
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                driverAppium = new AndroidDriver<>(url, desiredCapabilities);
                driverAppium.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driverAppium;
    }

    public static AndroidDriver<MobileElement> getAndroidDriver() {
        if (driverAndroid == null) {
            driverAppium = getMDriver(); // Update the driverAppium reference
            driverAndroid = (AndroidDriver<MobileElement>) driverAppium;
        }
        return driverAndroid;
    }

    public static void closeDriver() {
        if (driverAppium != null) {
            driverAppium.closeApp();
            driverAppium.quit();
            driverAppium = null;
        }
        if (driverAndroid != null) {
            driverAndroid.closeApp();
            driverAndroid.quit();
            driverAndroid = null;
        }
    }

}
