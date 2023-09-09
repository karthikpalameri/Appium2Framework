package org.example.testutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports extentReports;

    public static ExtentReports getExtentReportObject() {
        String reportFilePath = System.getProperty("user.dir") + "//reports//index.html";
        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportFilePath);
        extentSparkReporter.config().setReportName("Web and Mobile Automation Report ");
        extentSparkReporter.config().setDocumentTitle("Web and Mobile Automation Report Title");
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }
}
