package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//multi level inheritance
public class AppiumUtils {
    public AppiumDriverLocalService service;


    public static double getFormattedAmount(String amountString) {
        String substring = amountString.substring(1);
        double price = Double.parseDouble(substring);
        return price;
    }

    public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(ele));

    }

    protected List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
        String fileContentInString = readFile(filePath);

        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> data = objectMapper.readValue(fileContentInString, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    private static String readFile(String filePath) throws IOException {
        //read file conent in string format
        File file = new File(filePath);
        String fileContentInString = FileUtils.readFileToString(file);
        return fileContentInString;
    }

    protected AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
        // start appium programmatically
        service = new AppiumServiceBuilder()
                .withAppiumJS(new
                        File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress(ipAddress)
                .usingPort(port)
                .withLogFile(new File(System.getProperty("user.dir") + "/src/main/resources/appiumLogs/appium.log"))
                .build();
        service.start();
        return service;
    }

    public String getScreenshot(String testcaseName, AppiumDriver driver) throws IOException {
        File src = driver.getScreenshotAs(OutputType.FILE);
        String destString = (System.getProperty("user.dir") + "//reports//" + testcaseName + new SimpleDateFormat("yyyyMMdd_hh_mm_ss").format(new Date()) + ".png");
        File dest = new File(destString);
        FileUtils.copyFile(src, dest);
        return dest.getName();
    }

    public String getScreenshotBase64(String testcaseName, AppiumDriver driver) throws IOException {
        String srcBase64 = driver.getScreenshotAs(OutputType.BASE64);
        return srcBase64;
    }
}
