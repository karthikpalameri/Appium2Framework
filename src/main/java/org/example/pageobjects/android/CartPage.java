package org.example.pageobjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPrices;


    public double getProductSum() {
        int count = productPrices.size();
        double sum = 0;
        for (WebElement productPrice : productPrices) {
            String amountString = productPrice.getText();
            double price = getFormattedAmount(amountString);
            sum = sum + price;
        }
        return sum;
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    public double getTotalAmountDisplayed() {
        return getFormattedAmount(totalAmount.getText());
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement terms;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement acceptButton;

    public void acceptTermsConditions() {
        longPressAction(terms);
        acceptButton.click();
    }

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceed;

    public void submitOrder() {
        checkBox.click();
        proceed.click();
    }
}
