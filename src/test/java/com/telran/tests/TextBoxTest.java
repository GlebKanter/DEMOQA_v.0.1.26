package com.telran.tests;

import com.telran.models.StudentRegForm;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase{

    @Test
    public void textBoxTest(StudentRegForm model) throws InterruptedException {
        app.user().clickElementsButton();
        app.user().click(By.xpath("//span[contains(.,'Text Box')]"));
        String text = model.getfName() + model.getlName();
        app.user().type(By.id("userName"),  text);
        app.user().type(By.id("userEmail"), model.getEmail() );
        app.user().type(By.id("currentAddress"), model.getAddress() );
        app.user().type(By.id("permanentAddress"), model.getAddress()+ model.getCity() + model.getState() );
        app.user().click(By.id("submit"));



    }


}
