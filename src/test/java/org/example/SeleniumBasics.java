package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumBasics {
    private WebDriver driver;
    private ExtentReports extentReports;

    @BeforeTest
    void beforeTest() {
        String reportFilePath = System.getProperty("user.dir") + "//reports//index.html";
        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportFilePath);
        extentSparkReporter.config().setReportName("Web and Mobile Automation Report ");
        extentSparkReporter.config().setDocumentTitle("Web and Mobile Automation Report Title");
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("os", "macos");

    }

    @Test
    void test1() {
        ExtentTest extentTest = extentReports.createTest("Initial Test");
//        WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/macChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.close();
//        extentTest.fail("my failure message...");
        extentReports.flush();
    }
}
