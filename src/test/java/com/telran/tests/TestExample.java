package com.telran.tests;

import com.telran.applications.DataProviders;
import com.telran.models.ModelBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestExample extends TestBase{

    @Test
    public void testForLogger(){
        logger.info("Hello DEMO QA ");

    }

    @Test
    public void testForScreenshots(){

        String screen = "src/test/screenshots/screen-"+(System.currentTimeMillis()/1000%3600)+".png";
        app.getModelBase().takeScreenshot(screen);
    }
    @Test(priority = 0,enabled = false)
    public void testForListener(){
       app.getModelBase().scrollUp(); app.getModelBase().click(By.xpath("//span[normalize-space()='Practice Form']"));
    }
    @Test(dataProvider = "valid", dataProviderClass = DataProviders.class)
    public void testForDataProvider(String fild1, String fild2, String fild3, String fild4, String fild5,
                                    String fild6, String fild7, String fild8, String fild9, String fild10,
                                    String fild11){
        ModelBase modelBase = new ModelBase();
        app.getModelBase().type(modelBase
                .withFild1(fild1)
                .withFild2(fild2)
                .withFild3(fild3)
                .withFild4(fild4)
                .withFild5(fild5)
                .withFild6(fild6)
                .withFild7(fild7)
                .withFild8(fild8)
                .withFild9(fild9)
                .withFild10(fild10)
                .withFild11(fild11)
        );
        System.out.println(modelBase.toString());
    }
    @Test(dataProvider = "validFromFile", dataProviderClass = DataProviders.class)
    public void testForDataProviderFromFile(ModelBase modelBase){
        app.getModelBase().type(modelBase);
        System.out.println(modelBase);
    }
}
