package com.telran.applications;

import com.google.common.io.Files;
import com.telran.models.ModelBase;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void setWd(WebDriver wd) {
        this.wd = wd;
    }


    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void typeWithJSE(By locator, String text) {
        if (text != null) {
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("window.scrollBy(0,300)");
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void click(By locator) {
        try {
            wd.findElement(locator).click();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /*
         * org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <textarea name="about" cols="30" rows="10" placeholder="About (max 500 chars)" class="has-error" style="border: 2px solid red;"></textarea> is not clickable at point (1190, 14). Other element would receive the click: <section class="container header">...</section>
         * */
//        Actions actions =new Actions(wd);
//        Actions actions1 = actions.moveToElement(wd.findElement(locator));
//        actions1.click().perform();

    }

    public void typeByElement(WebElement element, String text) {

        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void typeByCss(String cssSelector, String text) {
        clickByCss(cssSelector);
        wd.findElement(By.cssSelector(cssSelector)).clear();
        wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByxPath(String xPathSelector) {
        wd.findElement(By.xpath(xPathSelector)).click();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void takeScreenshot(String pathToFile) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new
                File(pathToFile);

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void type(ModelBase modelBase) {

        System.out.println("I can fill fild1 ->" + modelBase.getFild1());
        System.out.println("I can fill fild2 ->" + modelBase.getFild2());
        System.out.println("I can fill fild3 ->" + modelBase.getFild3());
        System.out.println("I can fill fild4 ->" + modelBase.getFild4());
        System.out.println("I can fill fild5 ->" + modelBase.getFild5());
        System.out.println("I can fill fild6 ->" + modelBase.getFild6());
        System.out.println("I can fill fild7 ->" + modelBase.getFild7());
        System.out.println("I can fill fild8 ->" + modelBase.getFild8());
        System.out.println("I can fill fild9 ->" + modelBase.getFild9());
        System.out.println("I can fill fild10 ->" + modelBase.getFild10());
        System.out.println("I can fill fild11 ->" + modelBase.getFild11());

    }
    public void clickElementsButton() throws InterruptedException {
        scroll();
        click(By.xpath("//h5[contains(.,'Elements')]"));
       pause(2000);
        Assert.assertTrue(isElementPresent(By.xpath("//div[contains(.,'Please select an item from left to start practice.')]")));
    }
}
