package org.example;

import org.example.pageobjects.android.CartPage;
import org.example.pageobjects.android.ProductCatalogPage;
import org.example.testutils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AndroidBasics_Ecommerce extends AndroidBaseTest {

    @BeforeMethod(alwaysRun = true)
    public void preTest() {
        System.out.println("settingactivity .....");
        formPage.setActivity();
    }


    @Test(dataProvider = "myDataProviderName", groups = {"smoke1"})
    public void addItemToCartTest(HashMap<String, String> data) {
        formPage.setNameField(data.get("name"));
        formPage.setGender(data.get("gender"));
        formPage.setCountrySelection(data.get("country"));
        ProductCatalogPage productCatalogPage = formPage.submitForm(); //the submitForm is returning next page object to avoid object creation and allow chaining
        productCatalogPage.addItemToCartByIndex(0);
    }

    @Test(dataProvider = "myDataProviderName", groups = {"smoke"})
    public void addItemToCartFailTest(HashMap<String, String> data) {
        Assert.assertEquals(0, 1);
    }

    @Test
    public void sumAllProductsTest() throws InterruptedException {
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

    @DataProvider(name = "myDataProviderName2")
    Object[][] testData2() {
        return new Object[][]{
                {"kk", "male", "Argentina"},
                {"zz", "female", "Argentina"},
        };
    }

    @DataProvider(name = "myDataProviderName")
    Object[][] testData() throws IOException {
        List<HashMap<String, String>> jsonData = getJsonData(System.getProperty("user.dir") + "/src/main/java/org/example/testData/eCommerceTestData.json");
        Object[][] objects = {{jsonData.get(0)}, {jsonData.get(1)}};
        return objects;
    }

}
