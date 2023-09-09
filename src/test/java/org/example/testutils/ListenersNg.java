package org.example.testutils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.example.utils.AppiumUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;

import java.io.IOException;

public class ListenersNg extends AppiumUtils implements ITestListener {

    ExtentReports extentReports = ExtentReporterNG.getExtentReportObject();
    private ExtentTest extentTest;
    private AppiumDriver driver;

    @Override

    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        extentTest.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        extentTest.fail("Test Failed\n" + result.getThrowable());
//        extentTest.log(Status.FAIL, "Test Failed due to ::" + result.getThrowable());
        try {
            System.out.println("taking screenshot");
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("adding screenshotFile");
            String screenshotFile = getScreenshot(result.getMethod().getMethodName(), driver);
            extentTest.addScreenCaptureFromPath(screenshotFile, result.getMethod().getMethodName());
            String screenshotFileBase64 = getScreenshotBase64(result.getMethod().getMethodName(), driver);
            extentTest.addScreenCaptureFromBase64String(screenshotFileBase64, result.getMethod().getMethodName());

            extentTest.log(Status.INFO, "Failed Screenshot path : " + screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extentReports.flush();
    }
}
