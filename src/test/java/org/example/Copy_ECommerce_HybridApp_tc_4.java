package org.example;

import io.appium.java_client.android.Activity;
import org.example.pageobjects.android.CartPage;
import org.example.pageobjects.android.ProductCatalogPage;
import org.example.testutils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Copy_ECommerce_HybridApp_tc_4 extends AndroidBaseTest {

    @BeforeMethod
    public void preTest() {
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
        driver.startActivity(activity);
    }

    @Test
    public void test1() {
        formPage.setNameField("kk");
        formPage.setGender("female");
        formPage.setCountrySelection("Argentina");
        ProductCatalogPage productCatalogPage = formPage.submitForm(); //the submitForm is returning next page object to avoid object creation and allow chaining
        productCatalogPage.addItemToCartByIndex(0);
    }

    @Test
    public void sumAllProducts() throws InterruptedException {

        formPage.setNameField("kk");
        formPage.setGender("female");
        formPage.setCountrySelection("Argentina");
        ProductCatalogPage productCatalogPage = formPage.submitForm(); //the submitForm is returning next page object to avoid object creation and allow chaining
        productCatalogPage.addItemToCartByIndex(0);
        productCatalogPage.addItemToCartByIndex(0);
        CartPage cartPage = productCatalogPage.goToCartPage();//the productCatalog is returning next page object to avoid object creation and allow chaining


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        Thread.sleep(2000);
        double totalSum = cartPage.getProductSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(displayFormattedSum, totalSum);
        cartPage.acceptTermsConditions();
        cartPage.submitOrder();
        Thread.sleep(2000);

//        //swith to webview and nativeapp
//        Set<String> contextHandles = driver.getContextHandles();
//        for (String contextHandle : contextHandles) {
//            System.out.println("contextHandle = " + contextHandle);
//        }
//        driver.context("WEBVIEW_com.androidsample.generalstore");
//
//        driver.findElement(By.name("q")).sendKeys("test kk");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//
//        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
//
//        driver.context("NATIVE_APP");
//
//

    }
}
