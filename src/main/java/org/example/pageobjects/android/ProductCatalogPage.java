package org.example.pageobjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//GrandParent (AppiumUtils) -> AndroidActions -> ProductCatalogPage
public class ProductCatalogPage extends AndroidActions {
    AndroidDriver driver;

    public ProductCatalogPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    public void addItemToCartByIndex(int index) {
        addToCart.get(index).click();
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;

    public CartPage goToCartPage() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }

}
