package org.example.testutils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.example.pageobjects.android.FormPage;
import org.example.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public FormPage formPage;

    @BeforeClass(alwaysRun = true) //alwaysRun should be set to true if you are running groups from .xml
    public void configureAppium() throws IOException {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//data.properties");
        properties.load(fileInputStream);
        String ipAddress = (String) properties.get("ipAddress");
        int port = Integer.parseInt((String) properties.get("port"));
        service = startAppiumServer(ipAddress, port);

        // create driver using options and url
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("AndroidDeviceName")); //emulator
        // options.setApp("/Users/karthikp/Documents/GitHub/Appium2.0.1_Selenium_Project/src/test/java/resources/ApiDemos-debug.apk");
        options.setApp(System.getProperty("user.dir") +
                "//src//main//resources//General-Store.apk");
        options.setChromedriverExecutable("/Users/karthikp/Documents/GitHub/Appium2.0.1_Selenium_Project/src/test/java/resources/chromedriver");
//        options.noReset(); // will not re-install fresh app

        driver = new AndroidDriver(service.getUrl(), options);

        System.out.println("driver.getSessionId() = " + driver.getSessionId());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait

        formPage = new FormPage(driver); //create the first form page

    }

    @AfterClass(alwaysRun = true)//alwaysRun should be set to true if you are running groups from .xml
    public void tearDown() {
        driver.quit();
        service.stop();
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

    protected void scrollToELementUsing_anroidUIAutomator(String scrollTillText) {
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
