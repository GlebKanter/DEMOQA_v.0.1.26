package com.telran.applications;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
Properties properties;
    EventFiringWebDriver wd;
    HelperForModelBase modelBase;
    HelperUser user;
    HelperStudentForm studentForm;
    String browser;
    HelperTextBox textBox;
    HelperAllertWindows allertWs;



    public HelperAllertWindows allertWindows() {
        return allertWs;
    }

    public HelperTextBox textBox() {return textBox;    }

    public HelperStudentForm StudentForm() {
        return studentForm;
    }

    public HelperUser user() {
        return user;
    }

    public HelperForModelBase getModelBase() {
        return modelBase;
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void start() throws IOException {
      String target = System.getProperty("target", "data");
      properties.load(new FileReader((new File(String.format("src/test/resources/%s.properties", target)))));

        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EventFiringWebDriver(new EdgeDriver());
        }
        modelBase = new HelperForModelBase(wd);
        user = new HelperUser(wd);
        studentForm = new HelperStudentForm(wd);
        textBox = new HelperTextBox(wd);
        allertWs = new HelperAllertWindows(wd);
        //Display logback status!
        // LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // print logback's internal status
        //StatusPrinter.print(lc);


        wd.register(new MyListener());
        wd.navigate().to(properties.getProperty("web.baseUrl")); //https://demoqa.com/
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public void stop() {
        wd.quit();
    }


}