package com.telran.applications;

import com.telran.models.StudentRegForm;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HelperStudentForm extends HelperBase {

    public HelperStudentForm(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        clickByxPath("//div[@class='category-cards']/div[2]");
    }

    public void selectPracticeForm() {
        clickByxPath("//span[.='Practice Form']");
    }

    public void submit() {
        click(By.id("submit"));
    }

    public void fillRegStudentForm(StudentRegForm model) throws InterruptedException {
        type(By.id("firstName"), model.getfName());
        type(By.id("lastName"), model.getlName());
        type(By.id("userEmail"), model.getEmail());
        selectGender(model.getGender());
        pause(500);
        type(By.id("userNumber"), model.getPhone());
        selectBday(model.getbDay());
        //typeBDay(model.getbDay());
        selectSubject(model.getSubject());
        pause(2000);
        selectHobbies(model.getHobbies());
        typeAddress(model.getAddress());//type(By.cssSelector("#currentAddress"), model.getAddress());
        typeState(model.getState());
        pause(2000);
        typeCity(model.getCity());
        pause(6000);

    }

    private void typeAddress(String text) {
        WebElement el = wd.findElement(By.id("currentAddress"));
//        Actions actions= new Actions(wd);
//        actions.moveToElement(el);
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,300)");
        el.click();
        el.clear();
        el.sendKeys(text);

    }

    private void typeState(String state) {
        typeWithJSE(By.id("react-select-3-input"), state);
        wd.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }

    private void typeCity(String city) {
        typeWithJSE(By.id("react-select-4-input"), city);
        wd.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }


    private void selectBday(String day) {
        String[] data = day.split(" ");
        wd.findElement(By.id("dateOfBirthInput")).click();
        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select"))).selectByVisibleText(data[1]);
        new Select((wd.findElement(By.cssSelector(".react-datepicker__year-select")))).selectByVisibleText(data[2]);

        //click(By.xpath(String.format("//div[.='%s']", data[0])));
        List<WebElement> list = wd.findElements(By.xpath(String.format("//div[.='%s']", data[0])));

        WebElement el;
        int dayP = Integer.parseInt(data[0]);
        if (list.size() > 1 && dayP > 15) {
            el = list.get(1);
        } else {
            el = list.get(0);
        }
        el.click();
    }


    private void typeBDay(String bday) {
        WebElement selectElem = wd.findElement(By.id("dateOfBirthInput"));
        selectElem.click();
        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")) {
            selectElem.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            selectElem.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        selectElem.sendKeys(bday);
        selectElem.sendKeys(Keys.ENTER);

    }

    private void selectGender(String gender) {
        if (gender.equals("Male")) {
            clickByxPath("//label[@for='gender-radio-1']");
        } else if (gender.equals("Female")) {
            clickByxPath("//label[@for='gender-radio-2']");
        } else clickByxPath("//label[@for='gender-radio-3']");
    }

    private void selectSubject(String subject) {

        type(By.xpath("//input[@id='subjectsInput']"), subject);
        wd.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys(Keys.ENTER);
    }

    private void selectHobbies(String hobbie) {
        if (hobbie.equals("Sports")) {
            clickByCss("label[for='hobbies-checkbox-1']");
        } else if (hobbie.equals("Reading")) {
            clickByCss("label[for='hobbies-checkbox-2']");
        } else clickByCss("label[for='hobbies-checkbox-3']");
    }
}
