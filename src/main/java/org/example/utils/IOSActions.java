package org.example.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class IOSActions extends AppiumUtils {
    IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        this.driver = driver;
    }

    //    Ios Gestures Docs::
//    Docs::
//    https://github.com/appium/appium-xcuitest-driver
//    https://appium.github.io/appium-xcuitest-driver/4.35/
//    https://appium.github.io/appium-xcuitest-driver/4.35/execute-methods/#mobile-scrolltoelement
    protected void touchAndHold(WebElement incElement) {
        driver.executeScript("mobile: touchAndHold", ImmutableMap.of(
                "elementId", ((RemoteWebElement) incElement).getId(),
                "duration", "5"
        ));
    }


    protected void scroll(String direction) { //Either 'up', 'down', 'left' or 'right'
        driver.executeScript("mobile: scroll", ImmutableMap.of(
                "direction", direction
        ));
    }

    protected void scrollToElement(WebElement webViewElement) {
        driver.executeScript("mobile: scrollToElement", ImmutableMap.of(
                "elementId", ((RemoteWebElement) webViewElement).getId()
        ));
    }

    protected void swipe(String direction) {
        driver.executeScript("mobile:swipe", ImmutableMap.of("direction", direction));
    }

    protected void navigateBackIos() {
        driver.navigate().back();
    }

    protected void terminateApp(String bundleId) {
        driver.executeScript("mobile: terminateApp", ImmutableMap.of(
                "bundleId", bundleId
        ));
    }

    protected void launchApp(String bundleId) {
        driver.executeScript("mobile: launchApp", ImmutableMap.of(
                "bundleId", bundleId
        ));
    }


    //
    public void longPressAction(WebElement ele) {
        touchAndHold(ele);
    }

    protected void scrollToEndAction() {
        // enable developer settings and enable show tap mode and pointer location
        scroll("down");
    }


    protected void swipeAction(String direction) {
        swipe(direction);
    }

//
//    protected void dragDropAction(WebElement src, int x, int y) {
//
//
//    }
//
//    protected String getAndroidToastMessage() {
//
//    }

}
