package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAllertsWindows extends TestBase {
    @BeforeMethod
    public void precondition() throws InterruptedException {

        app.allertWindows().pause(2000);        //which timeouts()?
        app.allertWindows().selectBrowserWindow();
    }

    @Test(priority = 1)
    public void testWindowsNewTab() throws InterruptedException {

        app.allertWindows().clickOnButton("tabButton");
//        app.user().pause(2000);
        Assert.assertTrue(app.allertWindows().takeText().contains("page"));
//        app.user().pause(2000);
    }


    @Test(priority = 2)
    public void testWindowsNewWidow() throws InterruptedException {

        app.allertWindows().clickOnButton("windowButton");
        app.allertWindows().pause(2000);//which timeouts()?

        Assert.assertTrue(app.allertWindows().takeText().contains("page"));
      // app.user().pause(2000);
    }

    @Test(enabled = false)// Taya, we talk about this test. have you a correct version?
    public void testWindowsNewWidowMassege() throws InterruptedException {

        app.allertWindows().clickOnButton("messageWindowButton");
        //app.allertWindows().pause(2000);

        Assert.assertTrue(app.allertWindows().takeText2().contains("Knowledge increases"));

    }

    @Test(priority = 3)
    public void alertTest() throws InterruptedException {

        app.allertWindows().selectAlerts();

        app.allertWindows().click(By.id("alertButton"));
        app.allertWindows().testAlert(1);
        app.allertWindows().clickWait();
        app.allertWindows().click(By.id("confirmButton"));
        app.allertWindows().testAlert(2);
        app.allertWindows().click(By.id("promtButton"));
        app.allertWindows().testAlert(3);
    }

}
