package com.telran.tests;

import com.telran.models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() throws InterruptedException {

        app.user().openBookStore();

        app.user().clickLoginButton();

        app.user().fillLoginForm(new User().withuName("GlebKa").withPassword("Tglebson#13"));

        app.user().clickLoginButton();

        Assert.assertTrue(app.user().isUserLogined());

    }

}
