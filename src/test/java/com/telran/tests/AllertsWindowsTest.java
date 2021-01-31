package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllertsWindowsTest extends TestBase {

    @Test
    public void testWindowsNewTab() throws InterruptedException {
        app.allertWindows().selectItems();
        app.allertWindows().selectBrowserWindow();
        app.allertWindows().clickOnButton("tabButton");
        app.user().pause(2000);
        Assert.assertTrue(app.allertWindows().takeText().contains("page"));

    }




    @Test
    public void testWindowsNewWidow() throws InterruptedException {
        app.allertWindows().selectItems();
        app.allertWindows().selectBrowserWindow();
        app.allertWindows().clickOnButton("windowButton");
        app.user().pause(2000);
        Assert.assertTrue(app.allertWindows().takeText().contains("page"));

    }

    @Test(enabled = false)
    public void testWindowsNewWidowMassege() throws InterruptedException {
        app.allertWindows().selectItems();
        app.allertWindows().selectBrowserWindow();
        app.allertWindows().clickOnButton("messageWindowButton");
        app.user().pause(2000);
        Assert.assertTrue(app.allertWindows().takeText2().contains("Knowledge increases"));

    }
    @Test
    public void alertTest() throws InterruptedException {
        app.allertWindows().selectItems();
        app.allertWindows().selectAlerts();
        app.allertWindows().pause(2000);
        app.allertWindows().click(By.id("alertButton"));
        app.allertWindows().testAlert(1);
        app.allertWindows().click(By.id("timerAlertButton"));    app.allertWindows().pause(5000);
        app.allertWindows().testAlert(1);
        app.allertWindows().click(By.id("confirmButton"));
        app.allertWindows().testAlert(2);
        app.allertWindows().click(By.id("promtButton"));
        app.allertWindows().testAlert(3);

    }

}
