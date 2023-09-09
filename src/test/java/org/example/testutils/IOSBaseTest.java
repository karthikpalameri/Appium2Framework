package org.example.testutils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.example.pageobjects.ios.HomePage;
import org.example.utils.AppiumUtils;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public class IOSBaseTest extends AppiumUtils {
    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public HomePage homePage;

    @BeforeClass
    public void configureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//data.properties");
        properties.load(fileInputStream);
        //check if maven is passing properties something like -DipAddress, if yes assign it
        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : (String) properties.get("ipAddress");
        int port = Integer.parseInt((String) properties.get("port"));
        service = startAppiumServer(ipAddress, port);


        // create driver using options and url
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(properties.getProperty("IosDeviceName"));
        options.setApp(System.getProperty("user.dir") + "/src/main/resources/UIKitCatalog.app"); //simulator app
        options.setPlatformVersion("16.4");
        //Appium ->Webdriver Agent(proxy/middle-man)-> IOS Apps.
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));//sometimes middleman need time to start , will wait until 20sec
        options.setAutomationName("XCUITest");


//        // FOR REAL DEVICES
//        options.setDeviceName("iPhone 12");
//        options.setPlatformVersion("16.6");
//        options.setPlatformName("IOS");
//        options.setApp("/Users/karthikp/Documents/GitHub/Appium2.0.1_Selenium_Project/src/test/java/resources/realDevice/UIKitCatalog.app");//real device compiled app
//        options.setCapability("appium:xcodeOrgId", "");
//        options.setCapability("appium:xcodeSigningId", "");
//        options.setUdid("00008101-0003245A1445001E");
//        //bundleId created from new xcode project : io.appiumUnique123.WebDriverAgentRunner


        driver = new IOSDriver(service.getUrl(), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }

    protected void touchAndHold(RemoteWebElement incElement) {
        driver.executeScript("mobile: touchAndHold", ImmutableMap.of(
                "elementId", incElement.getId(),
                "duration", "5"
        ));
    }

    protected void scroll(RemoteWebElement webViewElement, String direction) {
        driver.executeScript("mobile: scroll", ImmutableMap.of(
                "direction", direction
        ));
    }

    protected void scrollToElement(RemoteWebElement webViewElement) {
        driver.executeScript("mobile: scrollToElement", ImmutableMap.of(
                "elementId", ((RemoteWebElement) webViewElement).getId()
        ));
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

//    Ios Gestures
//    Docs::
//    https://github.com/appium/appium-xcuitest-driver
//    https://appium.github.io/appium-xcuitest-driver/4.35/
}
