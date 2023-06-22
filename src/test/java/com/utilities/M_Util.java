package com.utilities;

import com.BDD.pom.Pages;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.utilities.MDriver.getMDriver;

public class M_Util extends Pages {


    public static void scrollDown() {
        int screenHeight = getMDriver().manage().window().getSize().getHeight();
        int screenWidth = getMDriver().manage().window().getSize().getWidth();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.7);
        int endY = (int) (screenHeight * 0.5);

        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    public static void scrollDown(double y1, double y2) {
        int screenHeight = getMDriver().manage().window().getSize().getHeight();
        int screenWidth = getMDriver().manage().window().getSize().getWidth();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * y1);
        int endY = (int) (screenHeight * y2);

        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    public static void scrollDown(double y1, double y2, int duration) {
        int screenHeight = getMDriver().manage().window().getSize().getHeight();
        int screenWidth = getMDriver().manage().window().getSize().getWidth();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * y1);
        int endY = (int) (screenHeight * y2);

        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }


    public static void scrollDownToElement(By element) {
        while (getMDriver().findElements(element).isEmpty()) {
            scrollDown();
        }
    }


}
