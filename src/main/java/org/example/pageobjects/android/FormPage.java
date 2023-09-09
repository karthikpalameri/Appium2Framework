package org.example.pageobjects.android;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends AndroidActions {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    //    driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }


    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;

    public void setGender(String gender) {
        if (gender.contains("female"))
            femaleOption.click();
        else
            maleOption.click();
    }


    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelection;

    public void setCountrySelection(String countrySelectionText) {
        countrySelection.click();
        scrollToText_usingAnroidUIAutomator(countrySelectionText);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + countrySelectionText + "']")).click();
    }


    public ProductCatalogPage submitForm() {
        shopButton.click();
        return new ProductCatalogPage(driver);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    public void setActivity() {
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.SplashActivity");
        driver.startActivity(activity);
    }
}

