package com.telran.applications;

import com.telran.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class HelperUser extends  HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openBookStore() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,300)");
        clickByxPath("//div[6]");//class="card mt-4 top-card"  'category-cards'
    }

    public void clickLoginButton() { clickByxPath("//*[@id='login']");
    }

    public void fillLoginForm(User user) {
        type(By.id("userName"),user.getuName());
        type(By.id("password"), user.getPassword());
    }

    public boolean isUserLogined() {
        return isElementPresent(By.id("submit"));
    }
}
