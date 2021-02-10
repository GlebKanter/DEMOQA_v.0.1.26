package com.telran.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperSelect extends HelperBase {
    public HelperSelect(WebDriver wd) {
        super(wd);
    }

    public void selectItemWidgets() {
        click(By.xpath("//div//h5[text()='Widgets']"));
    }

    public void clickSelectMenu() {
        scroll();
        click(By.xpath("//span[.='Select Menu']"));
    }

    public void clickMultiSelect() {
        Select cars = new Select((wd.findElement(By.id("cars"))));
        if (cars.isMultiple()) {
            cars.selectByIndex(1);
            cars.selectByIndex(2);
            cars.selectByIndex(3);
        }

    }

    public void selectMr(String text) {
        WebElement element = wd.findElement(By.id("selectOne"));
        element.click();
        WebElement option = wd.findElement(By.xpath(String.format("//*[text()='%s']", text)));
        option.click();
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void selectValue(String value) {
        WebElement element = wd.findElement(By.id("withOptGroup"));
        element.click();
        WebElement option = wd.findElement(By.xpath(String.format("//*[text()='%s']", value)));
        option.click();
    }

    public void selectOldStyle(String color) {
        WebElement element = wd.findElement(By.id("oldSelectMenu"));
        element.click();
        WebElement option = wd.findElement(By.xpath(String.format("//*[text()='%s']", color)));
        option.click();
    }



}
