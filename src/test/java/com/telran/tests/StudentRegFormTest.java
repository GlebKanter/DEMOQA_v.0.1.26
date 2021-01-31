package com.telran.tests;

import com.telran.models.StudentRegForm;
import org.testng.annotations.Test;

public class StudentRegFormTest extends TestBase{

    @Test
    public void studentRegFormTest() throws InterruptedException {
        app.StudentForm().selectItemForms();
        app.StudentForm().selectPracticeForm();
        app.StudentForm().fillRegStudentForm(new StudentRegForm()
                .withfName("John")
                .withlName("Doe")
                .withEmail("fggf@fg.djfg")
                .withGender("Male")
                .withPhone("0536992259")
                .withbDay("27 May 1990")
                .withSubject("Maths")
                .withHobbies("Reading")
                .withAddress("Herzel 15/2 ")
                .withState("NCR")
                .withCity("Noida")
        );

app.user().pause(2000);

        app.StudentForm().submit();


    }
}
