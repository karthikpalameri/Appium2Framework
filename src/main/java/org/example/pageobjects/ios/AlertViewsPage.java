package org.example.pageobjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.example.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewsPage extends IOSActions {
    IOSDriver driver;

    public AlertViewsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label=='Text Entry'`]")
    private WebElement textEntry;

    public void selectTextEntryMenu() {
        textEntry.click();
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textEntryPopUpTextBox;

    public void setTextEntryPopUpTextBox(String textEntryPopUpTextBoxText) {
        textEntryPopUpTextBox.sendKeys(textEntryPopUpTextBoxText);
    }

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement textEntryPopUpOKButton;

    public void clickOnTextEntryPopUpOKButton() {
        textEntryPopUpOKButton.click();
    }

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private WebElement confirmOrCancel;

    public void selectConfirmOrCancelItem() {
        confirmOrCancel.click();
    }

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private WebElement confirmOrCancelMessageText;

    public String getConfirmOrCancelMessageText() {
        return confirmOrCancelMessageText.getText();
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement selectConfirm;

    public void selectConfirm() {
        selectConfirm.click();
    }

    public void fillTextLabel(String text) {
        selectTextEntryMenu();
        setTextEntryPopUpTextBox(text);
        clickOnTextEntryPopUpOKButton();
    }

    public String getConfirmMessage() {
        selectConfirmOrCancelItem();
        return getConfirmOrCancelMessageText();

    }
}
