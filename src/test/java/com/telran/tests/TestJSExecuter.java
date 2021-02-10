package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJSExecuter extends TestBase {


    @Test
    public void jseTest() throws InterruptedException {
        app.jce().selectItemElement();
        app.jce().selectTextBox();
        app.jce().typeJCE("Lola Bridgita", "lola@mail.com",
                "Ashdod StudentHotel5/25", "Rishon LeZion, Herzel 12/43");
        app.jce().clickSubmitButton();

    }
}
