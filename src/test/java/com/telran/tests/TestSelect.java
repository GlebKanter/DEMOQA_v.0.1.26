
package com.telran.tests;

import com.telran.tests.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSelect extends TestBase {

    @BeforeMethod
    public void precondition() throws InterruptedException {
        app.select().scrollUp();
        app.select().selectItemWidgets();
        app.select().clickSelectMenu();
        app.select().hideFooter();


    }

    @Test
    public void testMultiSelect() throws InterruptedException {
        app.select().clickMultiSelect();
        app.select().selectMr("Mr.");

    }

    @Test
    public void testSelectValue() throws InterruptedException {

        app.select().selectValue("A root option");


    }

    @Test
    public void testSelectOne() throws InterruptedException {
        app.select().selectMr("Mr.");

    }

    @Test//(enabled = false)  //this test already crash but i don't understand why
    public void testOldStyle() {
        app.select().selectOldStyle("Voilet");
    }

    @Test
    public void testStandartMultiSelect() throws InterruptedException {
        app.select().clickMultiSelect();

    }
}