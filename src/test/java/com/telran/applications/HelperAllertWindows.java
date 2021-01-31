package com.telran.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HelperAllertWindows extends HelperBase {

    public HelperAllertWindows(WebDriver wd) {
        super(wd);
    }

    public void selectItems() {
        clickByxPath("//div//h5[.='Alerts, Frame & Windows']");
    }

    public void selectBrowserWindow() {
        clickByxPath("//span[.='Browser Windows']");
    }

    public void selectAlerts() {
        clickByxPath(" //span[normalize-space()='Alerts']");
    }

    public void clickOnButton(String nameButton) {
        System.out.println(wd.getWindowHandles());
        click(By.id(nameButton));
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        System.out.println("list: " + tabs);
        wd.switchTo().window(tabs.get(1));
    }

    public String takeText() {
        //get elements from webInstrument for window= press CTRL+SHIFT+C
        return wd.findElement(By.id("sampleHeading")).getText();
    }

    public String takeText2() {
        //get elements from webInstrument for window= press CTRL+SHIFT+C
        return wd.findElement(By.xpath("/html/body")).getText();
    }

    public void testAlert(int clickNum) throws InterruptedException {
        switch (clickNum) {
            case 1:
                wd.switchTo().alert().accept();
                break;

            case 2:
                wd.switchTo().alert().dismiss();
                Assert.assertTrue(isElementPresent(By.xpath("//span[@id='confirmResult'][contains(.,'Cancel')]")));
                break;
            case 3:
                wd.switchTo().alert().sendKeys("Abb cc gY");
                wd.switchTo().alert().accept();
                Assert.assertTrue(isElementPresent(By.xpath("//span[@id='promptResult'][contains(.,'Abb cc gY')]")));
                break;
        }


    }
}
