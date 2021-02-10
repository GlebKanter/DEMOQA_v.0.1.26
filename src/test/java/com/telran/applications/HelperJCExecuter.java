package com.telran.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelperJCExecuter extends HelperBase {
    public HelperJCExecuter(WebDriver wd) {
        super(wd);
    }

    public void selectItemElement() {
        click(By.xpath("//h5[contains(.,'Elements')]"));
    }

    public void selectTextBox() {
        click(By.xpath("//span[.='Text Box']"));
    }

    public void typeJCE(String name, String email, String currentAddress, String permanentAddress) {
        if (name != null && email != null && currentAddress != null && permanentAddress != null) {
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.getElementById('userName').value='" + name + "';");
            js.executeScript("document.getElementById('userEmail').value='" + email + "';");
            js.executeScript("document.getElementById('currentAddress').value='" + currentAddress + "';");
            js.executeScript("document.getElementById('permanentAddress').value='" + permanentAddress + "';");

        }


    }


    public void clickSubmitButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';"); //hide footer
        js.executeScript("document.getElementById('submit').click();");
        js.executeScript("document.getElementById('submit').style.backgroundColor='Red';");//change color of button

    }


}
