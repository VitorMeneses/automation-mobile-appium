package br.com.mybank.appium.runner;

import cucumber.api.CucumberOptions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(

        format = {"pretty", "html:results/cucumber-report/appium"},
        glue = {"br.com.mybank.appium.steps"},
        features = "classpath:features",
       tags = { "~@ignore"})


public class AndroidRunner {

    private static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void initAppium() throws MalformedURLException {
        DriverFactory.getDriver();

    }

    @AfterClass
    public static void tearDown(){

        DriverFactory.killDriver();
    }
}
