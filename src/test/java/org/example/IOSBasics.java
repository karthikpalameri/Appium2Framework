package org.example;

import org.example.pageobjects.ios.AlertViewsPage;
import org.example.testutils.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {
    @Test
    public void iOsBasicTest() {
        AlertViewsPage alertViewsPage = homePage.selectAlertViews();

        alertViewsPage.fillTextLabel("Hello world!");


        String confirmOrCancelMessageText = alertViewsPage.getConfirmMessage();
        Assert.assertEquals(confirmOrCancelMessageText, "A message should be a short, complete sentence.");
        alertViewsPage.selectConfirm();
    }
}
