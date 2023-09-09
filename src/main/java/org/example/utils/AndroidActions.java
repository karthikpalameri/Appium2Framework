package org.example.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtils {
    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }


    //    Android Gestures Docs ::
//    https://github.com/appium/appium-uiautomator2-driver
//    https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
    public void longPressAction(WebElement ele) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration", "2000"));
    }

    protected void scrollToEndAction() {
        // enable developer settings and enable show tap mode and pointer location
        Boolean canScrollMore;
        // scroll till end using appium javascript executor
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
                    ImmutableMap.of(
                            "left", 400, "top", 1200,
                            "width", 400, "height", 400,
                            "direction", "down",
                            "percent", 36.0,
                            "speed", 500));
        } while (canScrollMore);
    }

    protected void scrollToText_usingAnroidUIAutomator(String scrollTillText) {
        // approch 1 of scrolling using androidUIAutomator
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + scrollTillText + "\"));"));
    }

    protected void swipeAction(WebElement firstImageEle, String left) {
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) firstImageEle).getId(),
                "direction", left,
                "percent", 0.75));
    }

    protected void dragDropAction(WebElement src, int x, int y) {
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) src).getId(),
                "endX", x,
                "endY", y));
    }

    protected String getAndroidToastMessage() {
        return driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
    }
}
